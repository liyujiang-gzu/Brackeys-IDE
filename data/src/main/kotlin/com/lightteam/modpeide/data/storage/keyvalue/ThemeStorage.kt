package com.lightteam.modpeide.data.storage.keyvalue

import android.content.Context
import android.preference.PreferenceManager

class ThemeStorage(private val context: Context) {

    fun isDarkModeEnabled(): Boolean {
        val preferences = PreferenceManager.getDefaultSharedPreferences(context)
        return preferences.getString(PreferenceHandler.KEY_INTERFACE_THEME, "DARK") == "DARK"
    }
}