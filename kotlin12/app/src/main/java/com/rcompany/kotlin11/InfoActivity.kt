package com.rcompany.kotlin11

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView

class InfoActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.info_activity)

        val infoText: TextView = findViewById(R.id.info_text)

        val name = intent.getStringExtra("name")
        val age = intent.getIntExtra("age", 0)
        val secondname = intent.getStringExtra("secondname")
        val surname = intent.getStringExtra("surname")
        val hobby = intent.getStringExtra("hobby")

        infoText.text = when {
            age == 18 -> {
                "Добро пожаловать, $name! Ваш возраст: $age (18 мне уже). Ваше имя: $secondname. Ваша фамилия: $surname. Ваш хобби: $hobby."
            }
            age < 18 -> {
                "Добро пожаловать, $name! Ваш возраст: $age (Младше 18). Ваше имя: $secondname. Ваша фамилия: $surname. Ваш хобби: $hobby."
            }
            else -> {
                "Добро пожаловать, $name! Ваш возраст: $age (Старше 18). Ваше имя: $secondname. Ваша фамилия: $surname. Ваш хобби: $hobby."
            }
        }
    }
}