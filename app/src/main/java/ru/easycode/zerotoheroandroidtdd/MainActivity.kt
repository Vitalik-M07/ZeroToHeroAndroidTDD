package ru.easycode.zerotoheroandroidtdd

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.TextView

class MainActivity : AppCompatActivity() {
    private lateinit var textView: TextView
    private var isTextViewVisible: Boolean = true

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        textView = findViewById<TextView>(R.id.titleTextView)
        val button = findViewById<Button>(R.id.hideButton)

        button.setOnClickListener {
            isTextViewVisible = !isTextViewVisible
            updateTextViewVisibility()
        }

        // Восстановление состояния из Bundle, если Bundle не пустой
        savedInstanceState?.let {
            isTextViewVisible = it.getBoolean("isTextViewVisible", true)
            updateTextViewVisibility()
        }
    }

    override fun onSaveInstanceState(outState: Bundle) {
        super.onSaveInstanceState(outState)
        // Сохранение состояния видимости в Bundle
        outState.putBoolean("isTextViewVisible", isTextViewVisible)
    }

    private fun updateTextViewVisibility() {
        textView.visibility = if (isTextViewVisible) View.VISIBLE else View.INVISIBLE
    }
}
