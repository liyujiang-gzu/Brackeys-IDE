package com.lightteam.modpeide.utils.theme

import androidx.appcompat.app.AppCompatDelegate

sealed class Theme(val value: String) {

    companion object {
        private const val THEME_LIGHT = "LIGHT"
        private const val THEME_DARK = "DARK"
    }

    object LIGHT : Theme(THEME_LIGHT)
    object DARK : Theme(THEME_DARK)

    fun apply() {
        val mode = when (this) {
            LIGHT -> AppCompatDelegate.MODE_NIGHT_NO
            DARK -> AppCompatDelegate.MODE_NIGHT_YES
        }
        AppCompatDelegate.setDefaultNightMode(mode)
    }
}