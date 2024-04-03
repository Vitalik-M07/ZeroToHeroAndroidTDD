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

                rootlayout.removeView(textView)

            }


//        savedInstanceState?.let {
//            isTextViewRemoved = it.getBoolean("key", false)
//            if (isTextViewRemoved) {
//                rootlayout.removeView(textView)
//            }
//        }
    }

    override fun onSaveInstanceState(outState: Bundle) {
        super.onSaveInstanceState(outState)
        //outState.putBoolean("isTextViewRemoved", isTextViewRemoved)
        val removedTextView = rootlayout.childCount ==1
        outState.putBoolean(KEY, removedTextView)

    }

    override fun onRestoreInstanceState(
        savedInstanceState: Bundle
    ) {
        super.onRestoreInstanceState(savedInstanceState)
        val removedTextView= savedInstanceState.getBoolean(KEY)
        if(removedTextView)
            rootlayout.removeView(textView)
    }
    companion object{
        private const val KEY =  "key"
    }
}
