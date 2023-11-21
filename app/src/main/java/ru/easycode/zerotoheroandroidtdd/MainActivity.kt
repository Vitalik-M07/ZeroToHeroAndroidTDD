package ru.easycode.zerotoheroandroidtdd

import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {

    // Declare lateinit variables
//    private lateinit var textView: TextView
//    private lateinit var button: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main) // Fix the closing parenthesis here

        val button: Button = findViewById(R.id.changeButton)
        val textView: TextView = findViewById(R.id.titleTextView)
        //button = findViewById(R.id.changeButton)

        button.setOnClickListener {
            textView.text = "I am an Android Developer!"//
        // changeText()
        }
    }

//    private fun changeText() {
//
//        val newText = "I am an Android Developer!"
//        textView.text = newText
//    }
}
