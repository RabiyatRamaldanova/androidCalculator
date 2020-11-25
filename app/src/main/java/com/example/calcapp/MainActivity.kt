package com.example.calcapp

import android.app.ActionBar
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.TextView

class MainActivity : AppCompatActivity() {

    private lateinit var textView: TextView
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        supportActionBar?.hide()
        textView = findViewById(R.id.textView)
    }

    fun onClickSetNumber(view: View) {
        //val textView: TextView = findViewById(R.id.textView)
        textView.text = view.tag.toString()
    }

    fun onClickSetSign(view: View) {
        //if (view.tag == 10){
            //textView.text = view.tag.toString()
        //}
        when(view.tag.toString()){
            "10" -> textView.text = view.tag.toString()
            else -> textView.text = ""
        }
        //textView.text = view.tag.toString()
    }
}