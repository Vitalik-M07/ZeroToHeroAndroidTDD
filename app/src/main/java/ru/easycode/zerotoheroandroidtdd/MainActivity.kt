package ru.easycode.zerotoheroandroidtdd

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.PersistableBundle
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import androidx.core.view.isVisible

class MainActivity : AppCompatActivity() {

    private lateinit var rootlayout: ViewGroup
    private lateinit var textView: TextView
    private var isTextViewRemoved: Boolean = false

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        textView = findViewById(R.id.titleTextView)
        rootlayout = findViewById(R.id.rootLayout)
        val button = findViewById<Button>(R.id.removeButton)

        button.setOnClickListener {
            if (!isTextViewRemoved) {
                rootlayout.removeView(textView)
                isTextViewRemoved = true
            }
        }

        savedInstanceState?.let {
            isTextViewRemoved = it.getBoolean("isTextViewRemoved", false)
            if (isTextViewRemoved) {
                rootlayout.removeView(textView)
            }
        }
    }

    override fun onSaveInstanceState(outState: Bundle) {
        super.onSaveInstanceState(outState)
        outState.putBoolean("isTextViewRemoved", isTextViewRemoved)

    }
}
