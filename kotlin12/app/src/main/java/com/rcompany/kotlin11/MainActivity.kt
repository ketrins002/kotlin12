package com.rcompany.kotlin11

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.widget.Button
import android.widget.EditText
import android.widget.ImageView
import androidx.lifecycle.ViewModelProvider
import com.rcompany.kotlin11.mvvm.MainActivityViewModel
import org.json.JSONObject

class MainActivity : AppCompatActivity() {
    private lateinit var vm: MainActivityViewModel
    private lateinit var button: Button
    private lateinit var nameET: EditText
    private lateinit var ageET: EditText
    private lateinit var surnameET: EditText
    private lateinit var hobbyET: EditText
    private lateinit var secondNameET: EditText
    private lateinit var img: ImageView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.main_activity)
        vm = ViewModelProvider(this)[MainActivityViewModel::class.java]

        supportActionBar?.title = "Main Activity"

        vm.loadData(this)

        button = findViewById(R.id.btn)
        nameET = findViewById(R.id.name)
        surnameET = findViewById(R.id.surname)
        ageET = findViewById(R.id.age)
        hobbyET = findViewById(R.id.hobby)
        secondNameET = findViewById(R.id.secondname)
        img = findViewById(R.id.img)

        button.setOnClickListener {
            val name = nameET.text.toString()
            val surname = surnameET.text.toString()
            val age = ageET.text.toString().toInt()
            val hobby = hobbyET.text.toString()
            val secondName = secondNameET.text.toString()

            val intent = Intent(this, InfoActivity::class.java)
            intent.putExtra("name", name)
            intent.putExtra("surname", surname)
            intent.putExtra("age", age)
            intent.putExtra("hobby", hobby)
            intent.putExtra("secondname", secondName)
            startActivity(intent)
        }
    }

    override fun onSaveInstanceState(outState: Bundle) {
        super.onSaveInstanceState(outState)
        // Сохраняем значение каждого поля ввода
        outState.putString("KEY_SURNAME", surnameET.text.toString())
        outState.putString("KEY_NAME", nameET.text.toString())
        outState.putString("KEY_AGE", ageET.text.toString())
        outState.putString("KEY_HOBBY", hobbyET.text.toString())
        outState.putString("KEY_SECONDNAME", secondNameET.text.toString())
    }

    override fun onRestoreInstanceState(savedInstanceState: Bundle) {
        super.onRestoreInstanceState(savedInstanceState)
        // Восстановление состояния
        surnameET.setText(savedInstanceState.getString("KEY_SURNAME"))
        nameET.setText(savedInstanceState.getString("KEY_NAME"))
        ageET.setText(savedInstanceState.getString("KEY_AGE"))
        hobbyET.setText(savedInstanceState.getString("KEY_HOBBY"))
        secondNameET.setText(savedInstanceState.getString("KEY_SECONDNAME"))
    }

    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        menuInflater.inflate(R.menu.main, menu)
        return super.onCreateOptionsMenu(menu)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when (item.itemId) {
            R.id.save -> {
                val data = JSONObject().apply {
                    put("name", nameET.text.toString())
                    put("surname", surnameET.text.toString())
                    put("age", ageET.text.toString().toInt())
                    put("hobby", hobbyET.text.toString())
                    put("secondname", secondNameET.text.toString())
                }
                vm.saveData(this@MainActivity, data)
            }
            R.id.navigate -> {
                startActivity(Intent(this, NewActivity::class.java))
            }
            R.id.change -> {
                when ((0..3).random()) {
                    0 -> img.setImageResource(R.drawable.img_background_1)
                    1 -> img.setImageResource(R.drawable.img_background_2)
                    2 -> img.setImageResource(R.drawable.img_background_3)
                }
            }
        }
        return super.onOptionsItemSelected(item)
    }
}