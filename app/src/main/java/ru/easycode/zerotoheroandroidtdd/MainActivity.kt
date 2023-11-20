package ru.easycode.zerotoheroandroidtdd

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.LinearLayout
import android.widget.TextView

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
//        val linearlayout = LinearLayout(this)
//        linearlayout.id = R.id.rootLayout
//        val textView = TextView(this)
//        textView.id = R.id.titleTextView
//        textView.text = "I am an Android Developer!"
//
//        val button = Button(this)
//        button.id = R.id.changeButton
//        button.text = "change"
//
//
//        linearlayout.addView(textView)
//        linearlayout.addView(button)



        setContentView(R.layout.activity_main)
    }
}