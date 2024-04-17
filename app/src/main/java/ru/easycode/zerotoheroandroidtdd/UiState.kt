package ru.easycode.zerotoheroandroidtdd

import android.widget.Button
import android.widget.TextView
import java.io.Serializable

interface UiState : Serializable {
    fun apply(textView: TextView, actionButton: Button)

    data class Base(private val text: String) : UiState {
        override fun apply(textView: TextView, actionButton: Button) {
            textView.text = text
            actionButton.isEnabled= true
            //incrementButton.isEnabled = true
        }
    }

    data class Max(private val text: String) : UiState {
        override fun apply(textView: TextView, actionButton: Button) {
            textView.text = text
            actionButton.isEnabled = false // Disable button for Max state
            //decrementButton.isEnabled= true
        }
    }

    data class Min(private val text: String) : UiState {
        override fun apply(textView: TextView, actionButton: Button) {
            textView.text = text
            actionButton.isEnabled = false
            //incrementButton.isEnabled = true// Ensure button is enabled for Min state
        }
    }
}
