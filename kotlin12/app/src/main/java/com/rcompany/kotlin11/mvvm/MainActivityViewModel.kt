package com.rcompany.kotlin11.mvvm

import android.content.Context
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import org.json.JSONObject

class MainActivityViewModel : ViewModel() {


    // Функция для сохранения данных в SharedPreferences
    fun saveData(context: Context, data: JSONObject) {
        val sp = context.getSharedPreferences("data", Context.MODE_PRIVATE)
        val editor = sp.edit()
        editor.putString("surname", data["surname"] as String)
        editor.putString("name", data["name"] as String)
        editor.putString("hobby", data["hobby"] as String)
        editor.putString("secondname", data["secondname"] as String)
        editor.putInt("age", data["age"] as Int)
        editor.apply()
    }

    // Функция для загрузки данных из SharedPreferences
    fun loadData(context: Context): JSONObject {
        val sharedPreferences = context.getSharedPreferences("data", Context.MODE_PRIVATE)
        val data = JSONObject()
        data.put("surname", sharedPreferences.getString("surname", ""))
        data.put("name", sharedPreferences.getString("name", ""))
        data.put("hobby", sharedPreferences.getString("hobby", ""))
        data.put("secondname", sharedPreferences.getString("secondname", ""))
        data.put("age", sharedPreferences.getInt("age", 0))
        return data
    }
}
