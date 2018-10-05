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

import androidx.annotation.NonNull;

/**
 *  {@link StringifiableProperty} is a helper interface used
 *  to mark objects which are to be represented in a form of strings.
 *  Provides several basic methods used for the actual stringification/state recovery
 *  of the object property.
 *
 *  @author arthur3486
 */

public interface StringifiableProperty {

    /**
     * Recovers the state of the property from the specified stringified form.
     *
     * @param stringifiedProperty the property represented in a form of a {@link String}
     */
    void fromString(@NonNull String stringifiedProperty);

    /**
     * Packs the state of the current property into a single {@link String}.
     *
     * @return the property represented in a form of a {@link String}
     */
    String stringify();

}
