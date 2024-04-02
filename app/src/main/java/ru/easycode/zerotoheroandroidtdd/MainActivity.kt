package ru.easycode.zerotoheroandroidtdd

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView

class MainActivity : AppCompatActivity() {
    private lateinit var titleTextView: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        titleTextView = findViewById(R.id.titleTextView)
        val changeButton: Button = findViewById(R.id.changeButton)

        changeButton.setOnClickListener {
            titleTextView.text = "I am an Android Developer!"
        }

        savedInstanceState?.let {
            titleTextView.text = it.getString("vitalik")
        }
    }

    override fun onSaveInstanceState(outState: Bundle) {
        super.onSaveInstanceState(outState)
        outState.putString("vitalik", titleTextView.text.toString())
    }
}
