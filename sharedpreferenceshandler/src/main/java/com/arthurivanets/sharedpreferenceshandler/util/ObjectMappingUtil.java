/*
 * Copyright 2017 Arthur Ivanets, arthur.ivanets.l@gmail.com
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.arthurivanets.sharedpreferenceshandler.util;

import android.text.TextUtils;

import com.arthurivanets.sharedpreferenceshandler.SharedPreferencesManager;
import com.arthurivanets.sharedpreferenceshandler.annotations.DefaultBoolean;
import com.arthurivanets.sharedpreferenceshandler.annotations.DefaultFloat;
import com.arthurivanets.sharedpreferenceshandler.annotations.DefaultInstance;
import com.arthurivanets.sharedpreferenceshandler.annotations.DefaultInt;
import com.arthurivanets.sharedpreferenceshandler.annotations.DefaultLong;
import com.arthurivanets.sharedpreferenceshandler.annotations.DefaultString;
import com.arthurivanets.sharedpreferenceshandler.annotations.Property;

import org.apache.commons.lang3.reflect.FieldUtils;

import java.lang.reflect.Field;

import androidx.annotation.NonNull;
import androidx.annotation.RestrictTo;

/**
 * Created by arthur on
 */

@RestrictTo(RestrictTo.Scope.LIBRARY)
public final class ObjectMappingUtil {




    public static void map(@NonNull SharedPreferencesManager sharedPreferencesManager, @NonNull Object object) {
        Preconditions.nonNull(sharedPreferencesManager);
        Preconditions.nonNull(object);

        try {
            mapInternal(sharedPreferencesManager, object);
        } catch(IllegalAccessException e) {
            e.printStackTrace();
        }
    }




    private static void mapInternal(@NonNull SharedPreferencesManager sharedPreferencesManager,
                                    @NonNull Object object) throws IllegalAccessException {
        Preconditions.nonNull(sharedPreferencesManager);
        Preconditions.nonNull(object);

        final Class<?> objectClass = object.getClass();
        final String className = objectClass.getName();
        final Field[] declaredFields = object.getClass().getDeclaredFields();

        Property annotation;
        String propertyName;
        String composedPropertyName;

        // mapping the Property-Object, which also happens to be a StringifiableProperty to a corresponding key in preferences
        if(objectClass.isAnnotationPresent(Property.class) && (object instanceof StringifiableProperty)) {
            annotation = objectClass.getAnnotation(Property.class);
            propertyName = (!TextUtils.isEmpty(annotation.value()) ? annotation.value() : objectClass.getName());
            composedPropertyName = composePropertyName(className, propertyName);

            // putting the stringified object into shared preferences
            sharedPreferencesManager.put(
                composedPropertyName,
                ((StringifiableProperty) object).stringify()
            );

            return;
        }

        // mapping each field individually
        for(Field field : declaredFields) {
            if(!field.isAnnotationPresent(Property.class)) {
                continue;
            }

            annotation = field.getAnnotation(Property.class);
            propertyName = (!TextUtils.isEmpty(annotation.value()) ? annotation.value() : field.getName());
            composedPropertyName = composePropertyName(className, propertyName);

            // handling the actual field according to its type
            if(TypeDetectingUtil.isBoolean(field)) {
                sharedPreferencesManager.put(
                    composedPropertyName,
                    ((Boolean) FieldUtils.readField(field, object, true))
                );
            } else if(TypeDetectingUtil.isInteger(field)) {
                sharedPreferencesManager.put(
                    composedPropertyName,
                    ((Integer) FieldUtils.readField(field, object, true))
                );
            } else if(TypeDetectingUtil.isLong(field)) {
                sharedPreferencesManager.put(
                    composedPropertyName,
                    ((Long) FieldUtils.readField(field, object, true))
                );
            } else if(TypeDetectingUtil.isFloat(field)) {
                sharedPreferencesManager.put(
                    composedPropertyName,
                    ((Float) FieldUtils.readField(field, object, true))
                );
            } else if(TypeDetectingUtil.isString(field)) {
                sharedPreferencesManager.put(
                    composedPropertyName,
                    ((String) FieldUtils.readField(field, object, true))
                );
            } else {
                final Object value = field.get(object);

                if(value instanceof StringifiableProperty) {
                    sharedPreferencesManager.put(
                        composedPropertyName,
                        ((StringifiableProperty) value).stringify()
                    );
                }
            }
        }
    }




    public static <T> T recover(@NonNull SharedPreferencesManager sharedPreferencesManager,
                                @NonNull Class<T> objectClass) {
        Preconditions.nonNull(sharedPreferencesManager);
        Preconditions.nonNull(objectClass);

        T recoveredObject = null;

        try {
            recoveredObject = recoverInternal(sharedPreferencesManager, objectClass);
        } catch(IllegalAccessException e) {
            e.printStackTrace();
        } catch(InstantiationException e) {
            e.printStackTrace();
        }

        return recoveredObject;
    }




    private static <T> T recoverInternal(@NonNull SharedPreferencesManager sharedPreferencesManager,
                                         @NonNull Class<T> objectClass) throws IllegalAccessException, InstantiationException {
        Preconditions.nonNull(sharedPreferencesManager);
        Preconditions.nonNull(objectClass);
        Preconditions.isTrue(!objectClass.equals(void.class));

        final T instantiatedObject = objectClass.newInstance();
        final String className = objectClass.getName();
        final Field[] declaredFields = objectClass.getDeclaredFields();

        Property annotation;
        String propertyName;
        String fieldName;
        String composedPropertyName;

        // recovering the data from the raw string representation into an Object marked as Property, that also happens to be a StringifiableProperty
        if(objectClass.isAnnotationPresent(Property.class) && (instantiatedObject instanceof StringifiableProperty)) {
            annotation = objectClass.getAnnotation(Property.class);
            propertyName = (!TextUtils.isEmpty(annotation.value()) ? annotation.value() : objectClass.getName());
            composedPropertyName = composePropertyName(className, propertyName);

            // recovering the raw string representation
            final String stringifiedObject = sharedPreferencesManager.getString(composedPropertyName, "");

            // initializing the object out of the recovered raw string
            ((StringifiableProperty) instantiatedObject).fromString(stringifiedObject);

            return instantiatedObject;
        }

        // recovering the data, that corresponds to each individual field, from the preferences
        for(Field field : declaredFields) {
            if(!field.isAnnotationPresent(Property.class)) {
                continue;
            }

            annotation = field.getAnnotation(Property.class);
            propertyName = (!TextUtils.isEmpty(annotation.value()) ? annotation.value() : field.getName());
            fieldName = field.getName();
            composedPropertyName = composePropertyName(className, propertyName);

            // handling the actual field according to its type
            if(TypeDetectingUtil.isBoolean(field)) {
                final boolean defaultBoolean = (field.isAnnotationPresent(DefaultBoolean.class) && field.getAnnotation(DefaultBoolean.class).value());

                FieldUtils.writeField(
                    instantiatedObject,
                    fieldName,
                    sharedPreferencesManager.getBoolean(composedPropertyName, defaultBoolean),
                    true
                );
            } else if(TypeDetectingUtil.isInteger(field)) {
                final int defaultInt = (field.isAnnotationPresent(DefaultInt.class) ? field.getAnnotation(DefaultInt.class).value() : 0);

                FieldUtils.writeField(
                    instantiatedObject,
                    fieldName,
                    sharedPreferencesManager.getInt(composedPropertyName, defaultInt),
                    true
                );
            } else if(TypeDetectingUtil.isLong(field)) {
                final long defaultLong = (field.isAnnotationPresent(DefaultLong.class) ? field.getAnnotation(DefaultLong.class).value() : 0L);

                FieldUtils.writeField(
                    instantiatedObject,
                    fieldName,
                    sharedPreferencesManager.getLong(composedPropertyName, defaultLong),
                    true
                );
            } else if(TypeDetectingUtil.isFloat(field)) {
                final float defaultFloat = (field.isAnnotationPresent(DefaultFloat.class) ? field.getAnnotation(DefaultFloat.class).value() : 0f);

                FieldUtils.writeField(
                    instantiatedObject,
                    fieldName,
                    sharedPreferencesManager.getFloat(composedPropertyName, defaultFloat),
                    true
                );
            } else if(TypeDetectingUtil.isString(field)) {
                final String defaultString = (field.isAnnotationPresent(DefaultString.class) ? field.getAnnotation(DefaultString.class).value() : "");

                FieldUtils.writeField(
                    instantiatedObject,
                    fieldName,
                    sharedPreferencesManager.getString(composedPropertyName, defaultString),
                    true
                );
            } else {
                final String stringifiedProperty = sharedPreferencesManager.getString(composedPropertyName, "");
                final Object recoveredInstance = field.getDeclaringClass().newInstance();

                if(!(recoveredInstance instanceof StringifiableProperty)) {
                    continue;
                }

                // initializing the object from the recovered raw string representation of itself
                ((StringifiableProperty) recoveredInstance).fromString(stringifiedProperty);

                // assigning the recovered object to the corresponding Field
                if(!TextUtils.isEmpty(stringifiedProperty) || !field.isAnnotationPresent(DefaultInstance.class)) {
                    FieldUtils.writeField(
                        instantiatedObject,
                        fieldName,
                        recoveredInstance,
                        true
                    );
                } else {
                    final Class<?> defaultInstanceClass = field.getAnnotation(DefaultInstance.class).value();
                    final Object defaultObject = (!defaultInstanceClass.equals(void.class) ? defaultInstanceClass.newInstance() : null);

                    FieldUtils.writeField(
                        instantiatedObject,
                        fieldName,
                        defaultObject,
                        true
                    );
                }
            }
        }

        return instantiatedObject;
    }




    private static String composePropertyName(String className, String propertyName) {
        return (className + "." + propertyName);
    }




}
