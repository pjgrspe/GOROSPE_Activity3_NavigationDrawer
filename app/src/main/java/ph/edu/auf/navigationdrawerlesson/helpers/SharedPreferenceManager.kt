package ph.edu.auf.navigationdrawerlesson.helpers

import android.content.Context
import android.app.Application
import android.content.SharedPreferences
import ph.edu.auf.navigationdrawerlesson.NavigationDrawerLessonApplication

object SharedPreferenceManager {
    private const val PREFERENCE_NAME = "MyAppPreference"
    private lateinit var preferences: SharedPreferences

    private val sharedPreferences : SharedPreferences by lazy {
        NavigationDrawerLessonApplication.context.getSharedPreferences(PREFERENCE_NAME, Context.MODE_PRIVATE)
    }

    fun init(context: Context) {
        preferences = context.getSharedPreferences(PREFERENCE_NAME, Context.MODE_PRIVATE)
    }

    fun putStringSet(key: String, value: Set<String>) {
        preferences.edit().putStringSet(key, value).apply()
    }

    fun getStringSet(key: String, defaultValue: Set<String>): Set<String> {
        val value = preferences.all[key]
        return if (value is Set<*>) {
            @Suppress("UNCHECKED_CAST")
            value as Set<String>
        } else {
            defaultValue
        }
    }

}