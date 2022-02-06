package com.example.darshanpractical

import android.app.Application
import android.content.Context
import android.content.SharedPreferences
import androidx.appcompat.app.AppCompatActivity

open class MeisterApp : Application(){

    override fun onCreate() {
        super.onCreate()
        sharedPreferences = getSharedPreferences(getString(R.string.app_name), Context.MODE_PRIVATE)

        if(instance == null){
            instance = this
        }
    }

    companion object{
        lateinit var activityFromApp: AppCompatActivity
        lateinit var sharedPreferences: SharedPreferences
        var instance: MeisterApp? = null

        open fun savePreferenceDataString(key: String?, value: String?) {
            val editor: SharedPreferences.Editor = sharedPreferences.edit()
            editor.putString(key, value)
            editor.commit()
        }

        open fun savePreferenceDataInteger(key: String?, value: Int?) {
            val editor: SharedPreferences.Editor = sharedPreferences.edit()
            editor.putInt(key, value!!)
            editor.commit()
        }

        @JvmStatic
        open fun savePreferenceDataBoolean(key: String?, value: Boolean?) {
            val editor: SharedPreferences.Editor = sharedPreferences.edit()
            editor.putBoolean(key, value!!)
            editor.commit()
        }

        open fun savePreferenceDataArray(
            key: String?,
            value: ArrayList<*>
        ) {
            val editor: SharedPreferences.Editor = sharedPreferences.edit()
            editor.putString(key, value.toString())
            editor.commit()
        }

        open fun clearPreferenceData() {
            val editor: SharedPreferences.Editor = sharedPreferences.edit()
            editor.clear()
            editor.commit()
        }


    }
}