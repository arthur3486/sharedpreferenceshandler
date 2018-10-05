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

import com.arthurivanets.sharedpreferenceshandler.util.Preconditions;

import java.util.HashMap;
import java.util.Map;

import androidx.annotation.NonNull;

/**
 *  {@link SharedPreferencesManagerProvider} is a central point for creation and accessing
 *  of the {@link SharedPreferencesManager} instances, which are responsible for the
 *  direct interaction with the shared preferences.
 *
 * @author arthur3486
 */

public final class SharedPreferencesManagerProvider {


    @SuppressWarnings("StaticFieldLeak")
    private static volatile SharedPreferencesManagerProvider sInstance;

    private Context mContext;

    private Map<String, SharedPreferencesManager> mFileSharedPreferencesMap;




    /**
     *  Retrieves a global instance of the {@link SharedPreferencesManagerProvider}.
     *
     * @param context
     * @return an instance of the {@link SharedPreferencesManagerProvider}
     */
    public static SharedPreferencesManagerProvider getInstance(@NonNull Context context) {
        Preconditions.nonNull(context);

        if(sInstance == null) {
            synchronized(SharedPreferencesManagerProvider.class) {
                if(sInstance == null) {
                    sInstance = new SharedPreferencesManagerProvider(context.getApplicationContext());
                }
            }
        }

        return sInstance;
    }




    private SharedPreferencesManagerProvider(Context context) {
        mContext = context;
        mFileSharedPreferencesMap = new HashMap<>();
    }




    /**
     *  Creates or retrieves an existing instance of the {@link SharedPreferencesManager}
     *  associated with the specified preferences file name.
     *
     * @param sharedPreferencesFileName the name of the preferences file
     * @return the corresponding instance of {@link SharedPreferencesManager}
     */
    @NonNull
    public final SharedPreferencesManager get(@NonNull String sharedPreferencesFileName) {
        Preconditions.nonEmpty(sharedPreferencesFileName);

        SharedPreferencesManager sharedPreferencesManager = mFileSharedPreferencesMap.get(sharedPreferencesFileName);

        if((sharedPreferencesManager == null) || sharedPreferencesManager.isRecycled()) {
            sharedPreferencesManager = SharedPreferencesManagerImpl.init(mContext, sharedPreferencesFileName);
        }

        mFileSharedPreferencesMap.put(sharedPreferencesFileName, sharedPreferencesManager);

        return sharedPreferencesManager;
    }




    /**
     *  Releases all the cached instances of the {@link SharedPreferencesManager}.
     */
    public final void recycle() {
        for(SharedPreferencesManager sharedPreferencesManager : mFileSharedPreferencesMap.values()) {
            if(!sharedPreferencesManager.isRecycled()) {
                sharedPreferencesManager.recycle();
            }
        }

        mFileSharedPreferencesMap.clear();
    }




}
