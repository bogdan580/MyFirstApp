package com.mbohdan.apps.myFirstApp.utils

import android.R.id.edit
import android.content.Context
import android.content.SharedPreferences
import android.preference.PreferenceManager
import com.mbohdan.apps.myFirstApp.UserBean
import com.mbohdan.apps.myFirstApp.utils.PreferencesUtility.LOGGED_IN_PREF
import com.mbohdan.apps.myFirstApp.utils.PreferencesUtility.PASSWORD
import com.mbohdan.apps.myFirstApp.utils.PreferencesUtility.USERNAME


/**
 * Created by anuragdhunna on 13/2/18.
 */

object SaveSharedPreference {

    internal fun getPreferences(context: Context): SharedPreferences {
        return PreferenceManager.getDefaultSharedPreferences(context)
    }

    /**
     * Set the Login Status
     * @param context
     * @param loggedIn
     */
    fun setLoggedIn(context: Context, loggedIn: Boolean) {
        val editor = getPreferences(context).edit()
        editor.putBoolean(LOGGED_IN_PREF, loggedIn)
        editor.apply()
    }

    /**
     * Get the Login Status
     * @param context
     * @return boolean: login status
     */
    fun getLoggedStatus(context: Context): Boolean {
        return getPreferences(context).getBoolean(LOGGED_IN_PREF, false)
    }

    fun logout(context: Context) {
        val editor = getPreferences(context).edit()
        editor.putBoolean(LOGGED_IN_PREF, false)
        editor.apply()
    }

    fun setLoginData(context: Context, username: String, password: String, save: Boolean) {
        val editor = getPreferences(context).edit()
        if(save) {
            editor.putString(USERNAME, username)
            editor.putString(PASSWORD, password)
        } else {
            editor.remove(USERNAME).remove(PASSWORD)
        }
        editor.apply()
    }

    fun getLoginData(context: Context): String {
            return getPreferences(context).getString(USERNAME, "")+":"+
                    getPreferences(context).getString(PASSWORD, "")

    }
}