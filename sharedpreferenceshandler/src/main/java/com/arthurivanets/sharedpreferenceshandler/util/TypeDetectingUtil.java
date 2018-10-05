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

import java.lang.reflect.Field;

import androidx.annotation.NonNull;
import androidx.annotation.RestrictTo;

/**
 * Created by arthur3486
 */

@RestrictTo(RestrictTo.Scope.LIBRARY)
public final class TypeDetectingUtil {


    private static final String BOOLEAN = "boolean";
    private static final String GENERIC_BOOLEAN = "Boolean";
    private static final String INTEGER = "int";
    private static final String GENERIC_INTEGER = "Integer";
    private static final String LONG = "long";
    private static final String GENERIC_LONG = "Long";
    private static final String FLOAT = "float";
    private static final String GENERIC_FLOAT = "Float";
    private static final String STRING = "String";




    public static boolean isBoolean(Field field) {
        Preconditions.nonNull(field);

        final String typeName = field.getType().getName();

        return (typeName.equals(BOOLEAN) || typeName.equals(GENERIC_BOOLEAN));
    }




    public static boolean isInteger(Field field) {
        Preconditions.nonNull(field);

        final String typeName = field.getType().getName();

        return (typeName.equals(INTEGER) || typeName.equals(GENERIC_INTEGER));
    }




    public static boolean isLong(Field field) {
        Preconditions.nonNull(field);

        final String typeName = field.getType().getName();

        return (typeName.equals(LONG) || typeName.equals(GENERIC_LONG));
    }




    public static boolean isFloat(Field field) {
        Preconditions.nonNull(field);

        final String typeName = field.getType().getName();

        return (typeName.equals(FLOAT) || typeName.equals(GENERIC_FLOAT));
    }




    public static boolean isString(Field field) {
        Preconditions.nonNull(field);

        final String typeName = field.getType().getName();

        return typeName.endsWith(STRING);
    }




    @SuppressWarnings("unchecked")
    public static <T> T inferType(@NonNull Object object) {
        Preconditions.nonNull(object);
        return (T) object;
    }




}
