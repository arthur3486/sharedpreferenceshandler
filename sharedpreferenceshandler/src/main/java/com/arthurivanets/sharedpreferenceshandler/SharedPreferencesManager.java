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

import java.util.Set;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

/**
 * @author arthur3486
 */

public interface SharedPreferencesManager {

    /**
     *  Sets the boolean value in the preferences, without writing preference changes into the corresponding preferences file.
     *  In order to write the changes into a file, you need to call one of the following methods: {@link #commit()} or {@link #apply()},
     *  after the execution of the current method.
     *
     * @param key the name of the preference to be modified
     * @param value the new value for the preference
     * @return the current instance of the {@link SharedPreferencesManager}
     */
    @NonNull
    SharedPreferencesManager put(@NonNull String key, boolean value);

    /**
     *  Sets the boolean value in the preferences and then writes the changes into the corresponding preferences file.
     *  Writing of the preference changes is performed synchronously.
     *  For asynchronous preference change writing use {@link #putAndApply(String, boolean)}.
     *
     * @param key the name of the preference to be modified
     * @param value the new value for the preference
     * @return the current instance of the {@link SharedPreferencesManager}
     */
    @NonNull
    SharedPreferencesManager putAndCommit(@NonNull String key, boolean value);

    /**
     *  Sets the boolean value in the preferences and then writes the changes into the corresponding preferences file.
     *  Writing of the preference changes is performed asynchronously.
     *  For synchronous preference change writing use {@link #putAndCommit(String, boolean)}.
     *
     * @param key the name of the preference to be modified
     * @param value the new value for the preference
     * @return the current instance of the {@link SharedPreferencesManager}
     */
    @NonNull
    SharedPreferencesManager putAndApply(@NonNull String key, boolean value);

    /**
     *  Sets the float value in the preferences, without writing preference changes into the corresponding preferences file.
     *  In order to write the changes into a file, you need to call one of the following methods: {@link #commit()} or {@link #apply()},
     *  after the execution of the current method.
     *
     * @param key the name of the preference to be modified
     * @param value the new value for the preference
     * @return the current instance of the {@link SharedPreferencesManager}
     */
    @NonNull
    SharedPreferencesManager put(@NonNull String key, float value);

    /**
     *  Sets the float value in the preferences and then writes the changes into the corresponding preferences file.
     *  Writing of the preference changes is performed synchronously.
     *  For asynchronous preference change writing use {@link #putAndApply(String, float)}.
     *
     * @param key the name of the preference to be modified
     * @param value the new value for the preference
     * @return the current instance of the {@link SharedPreferencesManager}
     */
    @NonNull
    SharedPreferencesManager putAndCommit(@NonNull String key, float value);

    /**
     *  Sets the float value in the preferences and then writes the changes into the corresponding preferences file.
     *  Writing of the preference changes is performed asynchronously.
     *  For synchronous preference change writing use {@link #putAndCommit(String, float)}.
     *
     * @param key the name of the preference to be modified
     * @param value the new value for the preference
     * @return the current instance of the {@link SharedPreferencesManager}
     */
    @NonNull
    SharedPreferencesManager putAndApply(@NonNull String key, float value);

    /**
     *  Sets the int value in the preferences, without writing preference changes into the corresponding preferences file.
     *  In order to write the changes into a file, you need to call one of the following methods: {@link #commit()} or {@link #apply()},
     *  after the execution of the current method.
     *
     * @param key the name of the preference to be modified
     * @param value the new value for the preference
     * @return the current instance of the {@link SharedPreferencesManager}
     */
    @NonNull
    SharedPreferencesManager put(@NonNull String key, int value);

    /**
     *  Sets the int value in the preferences and then writes the changes into the corresponding preferences file.
     *  Writing of the preference changes is performed synchronously.
     *  For asynchronous preference change writing use {@link #putAndApply(String, int)}.
     *
     * @param key the name of the preference to be modified
     * @param value the new value for the preference
     * @return the current instance of the {@link SharedPreferencesManager}
     */
    @NonNull
    SharedPreferencesManager putAndCommit(@NonNull String key, int value);

    /**
     *  Sets the int value in the preferences and then writes the changes into the corresponding preferences file.
     *  Writing of the preference changes is performed asynchronously.
     *  For synchronous preference change writing use {@link #putAndCommit(String, int)}.
     *
     * @param key the name of the preference to be modified
     * @param value the new value for the preference
     * @return the current instance of the {@link SharedPreferencesManager}
     */
    @NonNull
    SharedPreferencesManager putAndApply(@NonNull String key, int value);

    /**
     *  Sets the long value in the preferences, without writing preference changes into the corresponding preferences file.
     *  In order to write the changes into a file, you need to call one of the following methods: {@link #commit()} or {@link #apply()},
     *  after the execution of the current method.
     *
     * @param key the name of the preference to be modified
     * @param value the new value for the preference
     * @return the current instance of the {@link SharedPreferencesManager}
     */
    @NonNull
    SharedPreferencesManager put(@NonNull String key, long value);

    /**
     *  Sets the long value in the preferences and then writes the changes into the corresponding preferences file.
     *  Writing of the preference changes is performed synchronously.
     *  For asynchronous preference change writing use {@link #putAndApply(String, long)}.
     *
     * @param key the name of the preference to be modified
     * @param value the new value for the preference
     * @return the current instance of the {@link SharedPreferencesManager}
     */
    @NonNull
    SharedPreferencesManager putAndCommit(@NonNull String key, long value);

    /**
     *  Sets the long value in the preferences and then writes the changes into the corresponding preferences file.
     *  Writing of the preference changes is performed asynchronously.
     *  For synchronous preference change writing use {@link #putAndCommit(String, long)}.
     *
     * @param key the name of the preference to be modified
     * @param value the new value for the preference
     * @return the current instance of the {@link SharedPreferencesManager}
     */
    @NonNull
    SharedPreferencesManager putAndApply(@NonNull String key, long value);

    /**
     *  Sets the String value in the preferences, without writing preference changes into the corresponding preferences file.
     *  In order to write the changes into a file, you need to call one of the following methods: {@link #commit()} or {@link #apply()},
     *  after the execution of the current method.
     *
     * @param key the name of the preference to be modified
     * @param value the new value for the preference
     * @return the current instance of the {@link SharedPreferencesManager}
     */
    @NonNull
    SharedPreferencesManager put(@NonNull String key, @Nullable String value);

    /**
     *  Sets the String value in the preferences and then writes the changes into the corresponding preferences file.
     *  Writing of the preference changes is performed synchronously.
     *  For asynchronous preference change writing use {@link #putAndApply(String, String)}.
     *
     * @param key the name of the preference to be modified
     * @param value the new value for the preference
     * @return the current instance of the {@link SharedPreferencesManager}
     */
    @NonNull
    SharedPreferencesManager putAndCommit(@NonNull String key, @Nullable String value);

    /**
     *  Sets the String value in the preferences and then writes the changes into the corresponding preferences file.
     *  Writing of the preference changes is performed asynchronously.
     *  For synchronous preference change writing use {@link #putAndCommit(String, String)}.
     *
     * @param key the name of the preference to be modified
     * @param value the new value for the preference
     * @return the current instance of the {@link SharedPreferencesManager}
     */
    @NonNull
    SharedPreferencesManager putAndApply(@NonNull String key, @Nullable String value);

    /**
     *  Sets the Set value in the preferences, without writing preference changes into the corresponding preferences file.
     *  In order to write the changes into a file, you need to call one of the following methods: {@link #commit()} or {@link #apply()},
     *  after the execution of the current method.
     *
     * @param key the name of the preference to be modified
     * @param value the new value for the preference
     * @return the current instance of the {@link SharedPreferencesManager}
     */
    @NonNull
    SharedPreferencesManager put(@NonNull String key, @NonNull Set<String> value);

    /**
     *  Sets the Set value in the preferences and then writes the changes into the corresponding preferences file.
     *  Writing of the preference changes is performed synchronously.
     *  For asynchronous preference change writing use {@link #putAndApply(String, Set)}.
     *
     * @param key the name of the preference to be modified
     * @param value the new value for the preference
     * @return the current instance of the {@link SharedPreferencesManager}
     */
    @NonNull
    SharedPreferencesManager putAndCommit(@NonNull String key, @NonNull Set<String> value);

    /**
     *  Sets the Set value in the preferences and then writes the changes into the corresponding preferences file.
     *  Writing of the preference changes is performed asynchronously.
     *  For synchronous preference change writing use {@link #putAndCommit(String, Set)}.
     *
     * @param key the name of the preference to be modified
     * @param value the new value for the preference
     * @return the current instance of the {@link SharedPreferencesManager}
     */
    @NonNull
    SharedPreferencesManager putAndApply(@NonNull String key, @NonNull Set<String> value);

    /**
     *  Extracts all fields marked as {@link com.arthurivanets.sharedpreferenceshandler.annotations.Property} and sets their corresponding
     *  values in the preferences, without writing preference changes into the corresponding preferences file.
     *  In order to write the changes into a file, you need to call one of the following methods: {@link #commit()} or {@link #apply()},
     *  after the execution of the current method.
     *
     * @param object the object specific fields of which are to be used as preferences
     * @return the current instance of the {@link SharedPreferencesManager}
     */
    @NonNull
    SharedPreferencesManager put(@NonNull Object object);

    /**
     *  Extracts all fields marked as {@link com.arthurivanets.sharedpreferenceshandler.annotations.Property} and sets their corresponding
     *  values in the preferences; thereafter the changes are written into the corresponding preferences file.
     *  Writing of the preference changes is performed synchronously.
     *  For asynchronous preference change writing use {@link #putAndApply(Object)}.
     *
     * @param object the object specific fields of which are to be used as preferences
     * @return the current instance of the {@link SharedPreferencesManager}
     */
    @NonNull
    SharedPreferencesManager putAndCommit(@NonNull Object object);

    /**
     *  Extracts all fields marked as {@link com.arthurivanets.sharedpreferenceshandler.annotations.Property} and sets their corresponding
     *  values in the preferences; thereafter the changes are written into the corresponding preferences file.
     *  Writing of the preference changes is performed asynchronously.
     *  For synchronous preference change writing use {@link #putAndCommit(Object)}.
     *
     * @param object the object specific fields of which are to be used as preferences
     * @return the current instance of the {@link SharedPreferencesManager}
     */
    @NonNull
    SharedPreferencesManager putAndApply(@NonNull Object object);

    /**
     *  Removes the preference with the specified key from the Shared Preferences,
     *  without writing preference changes into the corresponding preferences file.
     *  In order to write the changes into a file, you need to call one of the following methods: {@link #commit()} or {@link #apply()},
     *  after the execution of the current method.
     *
     * @param key the name of the preference to remove
     * @return the current instance of the {@link SharedPreferencesManager}
     */
    @NonNull
    SharedPreferencesManager remove(@NonNull String key);

    /**
     *  Removes the preference with the specified key from the Shared Preferences;
     *  thereafter the changes are written into the corresponding preferences file.
     *  Writing of the preference changes is performed synchronously.
     *  For asynchronous preference change writing use {@link #removeAndApply(String)}.
     *
     * @param key the name of the preference to remove
     * @return the current instance of the {@link SharedPreferencesManager}
     */
    @NonNull
    SharedPreferencesManager removeAndCommit(@NonNull String key);

    /**
     *  Removes the preference with the specified key from the Shared Preferences;
     *  thereafter the changes are written into the corresponding preferences file.
     *  Writing of the preference changes is performed asynchronously.
     *  For synchronous preference change writing use {@link #removeAndCommit(String)}.
     *
     * @param key the name of the preference to remove
     * @return the current instance of the {@link SharedPreferencesManager}
     */
    @NonNull
    SharedPreferencesManager removeAndApply(@NonNull String key);

    /**
     *  Retrieves a boolean value from the preferences that corresponds to the specified key.
     *
     * @param key the key for which to retrieve the value
     * @param defaultValue the value to be used if no value was previously associated with the specified key
     * @return the retrieved boolean value
     */
    boolean getBoolean(@NonNull String key, boolean defaultValue);

    /**
     *  Retrieves a float value from the preferences that corresponds to the specified key.
     *
     * @param key the key for which to retrieve the value
     * @param defaultValue the value to be used if no value was previously associated with the specified key
     * @return the retrieved float value
     */
    float getFloat(@NonNull String key, float defaultValue);

    /**
     *  Retrieves an int value from the preferences that corresponds to the specified key.
     *
     * @param key the key for which to retrieve the value
     * @param defaultValue the value to be used if no value was previously associated with the specified key
     * @return the retrieved int value
     */
    int getInt(@NonNull String key, int defaultValue);

    /**
     *  Retrieves a long value from the preferences that corresponds to the specified key.
     *
     * @param key the key for which to retrieve the value
     * @param defaultValue the value to be used if no value was previously associated with the specified key
     * @return the retrieved long value
     */
    long getLong(@NonNull String key, long defaultValue);

    /**
     *  Retrieves a String value from the preferences that corresponds to the specified key.
     *
     * @param key the key for which to retrieve the value
     * @param defaultValue the value to be used if no value was previously associated with the specified key
     * @return the retrieved String value
     */
    @Nullable
    String getString(@NonNull String key, @Nullable String defaultValue);

    /**
     *  Retrieves a Set of values from the preferences that corresponds to the specified key.
     *
     * @param key the key for which to retrieve the value
     * @param defaultValues the values to be used if no values were previously associated with the specified key
     * @return the retrieved Set of values
     */
    @Nullable
    Set<String> getStringSet(@NonNull String key, @Nullable Set<String> defaultValues);

    /**
     *  Recovers a preferences Object of the specified Class from the shared preferences.
     *
     * @param objectClass the class object of which to be recovered from the shared preferences
     * @param <T>
     * @return the recovered Object of class T
     */
    @Nullable
    <T> T get(@NonNull Class<T> objectClass);

    /**
     *  Commits (Writes) the not yet committed (written) preferences to the appropriate preferences file synchronously.
     */
    void commit();

    /**
     *  Commits (Writes) the not yet committed (written) preferences to the appropriate preferences file asynchronously.
     */
    void apply();

    /**
     *  Checks whether the current instance of the {@link SharedPreferencesManager} is recycled.
     *
     * @return true if it is, false otherwise
     */
    boolean isRecycled();

    /**
     *  Releases the resources.
     */
    void recycle();

}
