package ru.easycode.zerotoheroandroidtdd

import UiState
import android.os.Bundle
import android.widget.Button
import android.widget.ProgressBar
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {
    private lateinit var textView: TextView
    private lateinit var actionButton: Button
    private lateinit var progressBar: ProgressBar
   // private lateinit var decrementButton: Button
   // private var count = Count.Base(2, 8, 0)
    private lateinit var uiState: UiState

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        textView = findViewById(R.id.titleTextView)
        actionButton = findViewById(R.id.actionButton)
        progressBar = findViewById(R.id.progressBar)

        uiState = UiState.Base("Work")
        uiState.apply(textView, actionButton, progressBar )
       // decrementButton = findViewById(R.id.decrementButton)

        actionButton.setOnClickListener {
            //uiState = count.increment(textView.text.toString())
            uiState = UiState.OnClick("Work")
           uiState.apply(textView, actionButton, progressBar )
        }

//        decrementButton.setOnClickListener {
//            uiState = count.decrement(textView.text.toString())
//            uiState.apply(textView, actionButton, decrementButton)
//        }


    }

//    override fun onSaveInstanceState(outState: Bundle) {
//        super.onSaveInstanceState(outState)
//        outState.putSerializable(KEY, uiState)
//    }
//
//    override fun onRestoreInstanceState(savedInstanceState: Bundle) {
//        super.onRestoreInstanceState(savedInstanceState)
//        uiState = savedInstanceState.getSerializable(KEY) as UiState
//        uiState.apply(textView, actionButton)
//    }
//
//    companion object {
//        private const val KEY = "uiStateKey"
//    }
}

