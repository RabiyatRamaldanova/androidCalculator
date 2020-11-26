package com.example.calcapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Button
import android.widget.TextView
import androidx.core.text.isDigitsOnly

class MainActivity : AppCompatActivity() {
    private lateinit var stringfordisplay: String
//    private var number1: Double = 0.0
    private var operation: Int =0

    private lateinit var textView: TextView
    private var dotBool: Boolean = false

    private lateinit var button0: Button
    private lateinit var button1: Button
    private lateinit var button2: Button
    private lateinit var button3: Button
    private lateinit var button4: Button
    private lateinit var button5: Button
    private lateinit var button6: Button
    private lateinit var button7: Button
    private lateinit var button8: Button
    private lateinit var button9: Button
    private lateinit var buttonDot: Button
    private lateinit var buttonMultiple: Button
    private lateinit var buttonDevision: Button
    private lateinit var buttonMinus: Button
    private lateinit var buttonPlus: Button
    private lateinit var buttonEquality: Button
    private lateinit var buttonClean: Button
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        supportActionBar?.hide()
        textView = findViewById(R.id.textView)
        buttonDot = findViewById(R.id.button27)
        button0 = findViewById(R.id.button0)
        button1 = findViewById(R.id.button1)
        button2 = findViewById(R.id.button2)
        button3 = findViewById(R.id.button3)
        button4 = findViewById(R.id.button4)
        button5 = findViewById(R.id.button5)
        button6 = findViewById(R.id.button6)
        button7 = findViewById(R.id.button7)
        button8 = findViewById(R.id.button8)
        button9 = findViewById(R.id.button9)
        buttonMultiple = findViewById(R.id.buttonMultiple)
        buttonMinus = findViewById(R.id.buttonMinus)
        buttonDevision = findViewById(R.id.buttonDevision)
        buttonPlus = findViewById(R.id.buttonPlus)
        buttonEquality = findViewById(R.id.buttonEquality)
        buttonClean = findViewById(R.id.buttonClean)
        var dotBool: Boolean = false
    }

    fun onClickSetNumber(view: View) {
        stringfordisplay = textView.text.toString()

        if (view.id == buttonDot.id && !dotBool && stringfordisplay.isDigitsOnly() && !textView.text.isEmpty()){
            textView.text = stringfordisplay + "."
            dotBool = true
        } else if (view.id == buttonDot.id ) {
            textView.text = stringfordisplay
        } else if (textView.text == "0") {
            if (view.id == buttonDot.id){
                textView.text = stringfordisplay + "."
            } else {
                textView.text == "0"
            }
        } else if (stringfordisplay == "-" || stringfordisplay == "+" || stringfordisplay == "*" || stringfordisplay == "/") {
            textView.text = view.tag.toString()
        }
        else textView.text = stringfordisplay + view.tag.toString()

    }

    fun onClickSetSign(view: View) {

        var number1: Double = 0.0

        if (view.id == buttonDevision.id) {
            textView.text = "/"
        }else if (view.id == buttonMultiple.id) {
            textView.text = "*"
        }else if (view.id == buttonPlus.id) {
            textView.text = "+"
        }else if (view.id == buttonMinus.id) {
            textView.text = "-"
        }else if (view.id == buttonClean.id) {
            textView.text = ""
        }else if (view.id == buttonEquality.id){
            if (operation == 11 && stringfordisplay != "0") {
                textView.text = (number1/(stringfordisplay.toDouble())).toString()
            } else if (operation == 12) {
                textView.text = (number1*(stringfordisplay.toDouble())).toString()
            }else if (operation == 13) {
                textView.text = (number1 + stringfordisplay.toDouble()).toString()
            }else if (operation == 14) {
                textView.text = (number1 - stringfordisplay.toDouble()).toString()
            }

        }
        operation == view.tag
        Log.i("otvet" + " " +  operation.toString() + " " + "bla","MyResult")

        dotBool = false
    }
}

