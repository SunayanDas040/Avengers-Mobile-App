package com.internshala.avengers

import android.content.Context
import android.content.Intent
import android.content.SharedPreferences
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button

class AvengersActivity : AppCompatActivity() {

    var titleName:String? = "Avengers"
    lateinit var sharedPreferences: SharedPreferences
    lateinit var btnLogOut: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        sharedPreferences = getSharedPreferences(getString(R.string.preference_file_name),Context.MODE_PRIVATE)

        setContentView(R.layout.scrollview_example)

        titleName = sharedPreferences.getString("Title","The Avengers")

        title = titleName

        btnLogOut = findViewById(R.id.btnLogOut)

        btnLogOut.setOnClickListener {
            intent = Intent(this@AvengersActivity,LoginActivity::class.java)
            startActivity(intent)
            sharedPreferences.edit().clear().apply()
            setContentView(R.layout.activity_login)
        }
    }

}