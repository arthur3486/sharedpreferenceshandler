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

package com.arthurivanets.sharedpreferenceshandler.ktx

import android.content.Context
import com.arthurivanets.sharedpreferenceshandler.SharedPreferencesManager
import com.arthurivanets.sharedpreferenceshandler.SharedPreferencesManagerProvider


/**
 *  Puts the specified key-value pairs into the Shared Preferences managed by the current
 *  instance of the SharedPreferencesManager; it's worth noting that calling this method does not involve
 *  any data writing into a file.
 *
 *  @param pairs an array of key-value pairs to be put into the corresponding SharedPreferences instance.
 */
fun SharedPreferencesManager.putAll(vararg pairs : Pair<String, Any>) : SharedPreferencesManager {
    for(pair in pairs) {
        when(pair.second) {
            is Boolean -> this.put(pair.first, (pair.second as Boolean))
            is Float -> this.put(pair.first, (pair.second as Float))
            is Int -> this.put(pair.first, (pair.second as Int))
            is Long -> this.put(pair.first, (pair.second as Long))
            is String -> this.put(pair.first, (pair.second as String))
            is Set<*> -> this.put(pair.first, (pair.second as Set<String>))
            else -> this.put(pair.second)
        }
    }

    return this
}


/**
 *  Puts the specified key-value pairs into the Shared Preferences managed by the current
 *  instance of the SharedPreferencesManager, which then get written into the corresponding file synchronously.
 *
 *  @param pairs an array of key-value pairs to be put into the corresponding Shared Preferences File.
 */
fun SharedPreferencesManager.putAllAndCommit(vararg pairs : Pair<String, Any>) {
    this.putAll(*pairs)
    this.commit()
}


/**
 *  Puts the specified key-value pairs into the Shared Preferences managed by the current
 *  instance of the SharedPreferencesManager, which then get written into the corresponding file asynchronously.
 *
 *  @param pairs an array of key-value pairs to be put into the corresponding Shared Preferences File.
 */
fun SharedPreferencesManager.putAllAndApply(vararg pairs : Pair<String, Any>) {
    this.putAll(*pairs)
    this.apply()
}


/**
 *  Retrieves the existing or creates a brand-new instance of SharedPreferencesManager, that is to be
 *  used for interaction with the specified shared preferences file.
 *
 *  @param sharedPreferencesFileName the name of the file into which to store the preferences
 *  @return the <strong>SharedPreferencesManager</strong> interface used for interaction with the specified shared preferences file.
 */
fun Context.getSharedPreferencesManager(sharedPreferencesFileName : String) : SharedPreferencesManager {
    return SharedPreferencesManagerProvider.getInstance(this).get(sharedPreferencesFileName)
}


/**
 *  Map a String key to a specific Value; the mapping result will be encapsulated into a Pair.
 *
 *  @param value the value to be mapped to the current String key
 *  @return the Pair<String, T>
 */
infix fun <T> String.to(value : T) : Pair<String, T> {
    return Pair(this, value)
}