package ph.edu.auf.navigationdrawerlesson

import android.app.Application
import android.content.Context
import android.content.SharedPreferences
import ph.edu.auf.navigationdrawerlesson.helpers.SharedPreferenceManager

class NavigationDrawerLessonApplication : Application() {

    override fun onCreate() {
        super.onCreate()
        context = applicationContext
        SharedPreferenceManager.init(this)

    }

    companion object {
        lateinit var context: Context
            private set
    }

}