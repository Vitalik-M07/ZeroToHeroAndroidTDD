package ru.easycode.zerotoheroandroidtdd

import android.os.Build
import android.os.Bundle
import android.os.PersistableBundle
import android.widget.Button
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {
    private lateinit var textView: TextView
    private lateinit var incrementButton: Button
    private lateinit var decrementButton: Button
    private var count = Count.Base(2, 4, 0)
    private lateinit var uiState: UiState

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        textView = findViewById(R.id.countTextView)
        incrementButton = findViewById(R.id.incrementButton)
        decrementButton = findViewById(R.id.decrementButton)

        incrementButton.setOnClickListener {
            uiState = count.increment(textView.text.toString())
            uiState.apply(textView, incrementButton, decrementButton)
        }

        decrementButton.setOnClickListener {
            uiState = count.decrement(textView.text.toString())
            uiState.apply(textView, incrementButton, decrementButton)
        }

        uiState = savedInstanceState?.getSerializable(KEY) as? UiState
            ?: count.initial(textView.text.toString())
        uiState.apply(textView, incrementButton, decrementButton)
    }

    override fun onSaveInstanceState(outState: Bundle) {
        super.onSaveInstanceState(outState)
        outState.putSerializable(KEY, uiState)
    }

    override fun onRestoreInstanceState(savedInstanceState: Bundle) {
        super.onRestoreInstanceState(savedInstanceState)
        uiState = savedInstanceState.getSerializable(KEY) as UiState
        uiState.apply(textView, incrementButton, decrementButton)
    }

    companion object {
        private const val KEY = "uiStateKey"
    }
}

