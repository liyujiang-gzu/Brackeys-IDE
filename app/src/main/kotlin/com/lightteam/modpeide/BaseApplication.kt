/*
 * Licensed to the Light Team Software (Light Team) under one or more
 * contributor license agreements.  See the NOTICE file distributed with
 * this work for additional information regarding copyright ownership.
 * The Light Team licenses this file to You under the Apache License, Version 2.0
 * (the "License"); you may not use this file except in compliance with
 * the License.  You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.lightteam.modpeide

import android.content.Context
import androidx.appcompat.app.AppCompatDelegate
import com.lightteam.modpeide.data.storage.keyvalue.ThemeStorage
import com.lightteam.modpeide.internal.di.app.DaggerAppComponent
import dagger.android.AndroidInjector
import dagger.android.support.DaggerApplication

class BaseApplication : DaggerApplication() {

    companion object Package {
        const val STANDARD = "com.KillerBLS.modpeide"
        const val ULTIMATE = "com.LightTeam.modpeidepro"
    }

    override fun attachBaseContext(base: Context) {
        val themeStorage = ThemeStorage(base)
        val darkMode = if (themeStorage.isDarkModeEnabled()) {
            AppCompatDelegate.MODE_NIGHT_YES
        } else {
            AppCompatDelegate.MODE_NIGHT_NO
        }
        AppCompatDelegate.setDefaultNightMode(darkMode)
        super.attachBaseContext(base)
    }


    override fun applicationInjector(): AndroidInjector<out DaggerApplication> {
        return DaggerAppComponent.factory().create(this)
    }
}