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

package com.arthurivanets.sharedpreferenceshandler;

import android.content.Context;
import android.content.SharedPreferences;

import com.arthurivanets.sharedpreferenceshandler.util.ObjectMappingUtil;
import com.arthurivanets.sharedpreferenceshandler.util.Preconditions;

import java.util.Set;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

/**
 * @author arthur3486
 */

final class SharedPreferencesManagerImpl implements SharedPreferencesManager {


    private SharedPreferences mSharedPreferences;
    private SharedPreferences.Editor mPreferenceEditor;




    public static SharedPreferencesManager init(@NonNull Context context, @NonNull String sharedPreferencesFileName) {
        Preconditions.nonNull(context);
        Preconditions.nonEmpty(sharedPreferencesFileName);

        return new SharedPreferencesManagerImpl(context.getApplicationContext(), sharedPreferencesFileName);
    }




    private SharedPreferencesManagerImpl(Context context, String sharedPreferencesFileName) {
        mSharedPreferences = context.getSharedPreferences(sharedPreferencesFileName, Context.MODE_PRIVATE);
        mPreferenceEditor = mSharedPreferences.edit();
    }




    @Override
    public final SharedPreferencesManager put(@NonNull String key, boolean value) {
        checkInternalState();
        Preconditions.nonEmpty(key);

        mPreferenceEditor.putBoolean(key, value);

        return this;
    }




    @Override
    public final SharedPreferencesManager putAndCommit(@NonNull String key, boolean value) {
        put(key, value);
        commit();

        return this;
    }




    @Override
    public SharedPreferencesManager putAndApply(@NonNull String key, boolean value) {
        put(key, value);
        apply();

        return this;
    }




    @Override
    public final SharedPreferencesManager put(@NonNull String key, float value) {
        checkInternalState();
        Preconditions.nonEmpty(key);

        mPreferenceEditor.putFloat(key, value);

        return this;
    }




    @Override
    public final SharedPreferencesManager putAndCommit(@NonNull String key, float value) {
        put(key, value);
        commit();

        return this;
    }




    @Override
    public SharedPreferencesManager putAndApply(@NonNull String key, float value) {
        put(key, value);
        apply();

        return this;
    }




    @Override
    public final SharedPreferencesManager put(@NonNull String key, int value) {
        checkInternalState();
        Preconditions.nonEmpty(key);

        mPreferenceEditor.putInt(key, value);

        return this;
    }




    @Override
    public final SharedPreferencesManager putAndCommit(@NonNull String key, int value) {
        put(key, value);
        commit();

        return this;
    }




    @Override
    public SharedPreferencesManager putAndApply(@NonNull String key, int value) {
        put(key, value);
        apply();

        return this;
    }




    @Override
    public final SharedPreferencesManager put(@NonNull String key, long value) {
        checkInternalState();
        Preconditions.nonEmpty(key);

        mPreferenceEditor.putLong(key, value);

        return this;
    }




    @Override
    public final SharedPreferencesManager putAndCommit(@NonNull String key, long value) {
        put(key, value);
        commit();

        return this;
    }




    @Override
    public SharedPreferencesManager putAndApply(@NonNull String key, long value) {
        put(key, value);
        apply();

        return this;
    }




    @Override
    public final SharedPreferencesManager put(@NonNull String key, @Nullable String value) {
        checkInternalState();
        Preconditions.nonEmpty(key);

        mPreferenceEditor.putString(key, value);

        return this;
    }




    @Override
    public final SharedPreferencesManager putAndCommit(@NonNull String key, @Nullable String value) {
        put(key, value);
        commit();

        return this;
    }




    @Override
    public SharedPreferencesManager putAndApply(@NonNull String key, @Nullable String value) {
        put(key, value);
        apply();

        return this;
    }




    @Override
    public final SharedPreferencesManager put(@NonNull String key, @NonNull Set<String> value) {
        checkInternalState();
        Preconditions.nonEmpty(key);
        Preconditions.nonNull(value);

        mPreferenceEditor.putStringSet(key, value);

        return this;
    }




    @Override
    public final SharedPreferencesManager putAndCommit(@NonNull String key, @NonNull Set<String> value) {
        put(key, value);
        commit();

        return this;
    }




    @Override
    public SharedPreferencesManager putAndApply(@NonNull String key, @NonNull Set<String> value) {
        put(key, value);
        apply();

        return this;
    }




    @Override
    public final SharedPreferencesManager put(@NonNull Object object) {
        checkInternalState();
        Preconditions.nonNull(object);

        ObjectMappingUtil.map(this, object);

        return this;
    }




    @Override
    public final SharedPreferencesManager putAndCommit(@NonNull Object object) {
        put(object);
        commit();

        return this;
    }




    @Override
    public SharedPreferencesManager putAndApply(@NonNull Object object) {
        put(object);
        apply();

        return this;
    }




    @Override
    public final SharedPreferencesManager remove(@NonNull String key) {
        checkInternalState();
        Preconditions.nonEmpty(key);

        mPreferenceEditor.remove(key);

        return this;
    }




    @Override
    public final SharedPreferencesManager removeAndCommit(@NonNull String key) {
        remove(key);
        commit();

        return this;
    }




    @NonNull
    @Override
    public SharedPreferencesManager removeAndApply(@NonNull String key) {
        remove(key);
        apply();

        return this;
    }




    @Override
    public final boolean getBoolean(@NonNull String key, boolean defaultValue) {
        checkInternalState();
        Preconditions.nonEmpty(key);

        return mSharedPreferences.getBoolean(key, defaultValue);
    }




    @Override
    public final float getFloat(@NonNull String key, float defaultValue) {
        checkInternalState();
        Preconditions.nonEmpty(key);

        return mSharedPreferences.getFloat(key, defaultValue);
    }




    @Override
    public final int getInt(@NonNull String key, int defaultValue) {
        checkInternalState();
        Preconditions.nonEmpty(key);

        return mSharedPreferences.getInt(key, defaultValue);
    }




    @Override
    public final long getLong(@NonNull String key, long defaultValue) {
        checkInternalState();
        Preconditions.nonEmpty(key);

        return mSharedPreferences.getLong(key, defaultValue);
    }




    @Override
    public final String getString(@NonNull String key, @Nullable String defaultValue) {
        checkInternalState();
        Preconditions.nonEmpty(key);

        return mSharedPreferences.getString(key, defaultValue);
    }




    @Override
    public final Set<String> getStringSet(@NonNull String key, @Nullable Set<String> defaultValues) {
        checkInternalState();
        Preconditions.nonEmpty(key);

        return mSharedPreferences.getStringSet(key, defaultValues);
    }




    @Override
    public final <T> T get(@NonNull Class<T> objectClass) {
        Preconditions.nonNull(objectClass);
        return ObjectMappingUtil.recover(this, objectClass);
    }




    @Override
    public final void commit() {
        checkInternalState();

        mPreferenceEditor.commit();
    }




    @Override
    public void apply() {
        checkInternalState();

        mPreferenceEditor.apply();
    }




    @Override
    public final boolean isRecycled() {
        return (mSharedPreferences == null);
    }




    @Override
    public final void recycle() {
        if(isRecycled()) {
            return;
        }

        mPreferenceEditor.commit();
        mSharedPreferences = null;
        mPreferenceEditor = null;
    }




    private void checkInternalState() {
        if(isRecycled()) {
            throw new IllegalStateException("The manager is already recycled. Please initialize a new instance of the manager.");
        }
    }




}
