package com.example.calcapp

import android.app.ActionBar
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.TextView
import androidx.core.text.isDigitsOnly

class MainActivity : AppCompatActivity() {
    private var stringfordisplay = ""

    private lateinit var textView: TextView
    private var dotBool: Boolean = false
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        supportActionBar?.hide()
        textView = findViewById(R.id.textView)

    }

    fun onClickSetNumber(view: View) {
        stringfordisplay = textView.text.toString()
        textView.text = stringfordisplay + view.tag.toString()
        // else {textView.text = view.tag.toString()}
        if (!textView.text.isEmpty() ) {
            //textView.text = view.tag.toString()+textView.text
            if (view.tag.toString() == "16" && !dotBool && textView.text.toString().isDigitsOnly()) {
                //stringfordisplay = textView.text.toString()
                textView.text = stringfordisplay + "."
                dotBool = true
            }
        }
    }

        fun onClickSetSign(view: View) {
            when (view.tag.toString()) {
                "11" -> textView.text = "/"
                "12" -> textView.text = "*"
                "13" -> textView.text = "+"
                "14" -> textView.text = "-"
                "15" -> textView.text = "="
                else -> textView.text = ""
            }
        }
    }
