package com.example.demolibrary

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView
import com.example.myfirstlibrary.features.userData.DemoLibrary

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        var txvDemo = findViewById<TextView>(R.id.txvDemo)
        DemoLibrary {
            txvDemo.text = it
        }.demo()

    }
}