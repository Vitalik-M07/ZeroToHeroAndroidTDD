package ru.easycode.zerotoheroandroidtdd

import UiState
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.ProgressBar
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.isVisible
import androidx.core.view.postDelayed
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

class MainActivity : AppCompatActivity() {
    private lateinit var textView: TextView
    private lateinit var actionButton: Button
    private lateinit var progressBar: ProgressBar

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        textView = findViewById(R.id.titleTextView)
        actionButton = findViewById(R.id.actionButton)
        progressBar = findViewById(R.id.progressBar)

        textView.visibility = View.INVISIBLE
        actionButton.isEnabled = true
        progressBar.isVisible = false
       // decrementButton = findViewById(R.id.decrementButton)

        actionButton.setOnClickListener {

            //
            progressBar.visibility = View.VISIBLE
            actionButton.isEnabled = false


            actionButton.postDelayed({
                textView.visibility = View.VISIBLE
                actionButton.isEnabled = true
                progressBar.visibility = View.GONE
               // textView.visibility = View.VISIBLE

            },3000)



        }
    }
}

