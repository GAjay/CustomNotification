package com.devtantra.test.serviecs

import android.annotation.SuppressLint
import android.content.Context
import android.content.SharedPreferences

/**
 * A class for shared preference
 *
 * @author Ranosys Technologies
 */
class SavedPreferences private constructor(context: Context) {
    private val preferences: SharedPreferences

    init {
        val userPref = "demo"
        preferences = context.getSharedPreferences(userPref, MODE_PRIVATE)
    }
    var deviceToken: String
        get() = preferences.getString("deviceToken", "")
        @SuppressLint("ApplySharedPref")
        set(accessToken) {
            val editor = preferences.edit()
            editor.putString("deviceToken", accessToken)
            editor.commit()
        }

    companion object {
        private const val MODE_PRIVATE = 0
        private var savedPreference: SavedPreferences? = null

        fun getInstance(context: Context): SavedPreferences {
            return if (null == savedPreference) {
                savedPreference = SavedPreferences(context)
                savedPreference as SavedPreferences
            } else {
                savedPreference as SavedPreferences
            }
        }

    }
}