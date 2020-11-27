package com.example.calcapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Button
import android.widget.TextView
import androidx.core.text.isDigitsOnly

class MainActivity : AppCompatActivity() {
//    private var number1: Double = 0.0
    private var operation: Int =0

    private var fisrtNum : Double = 0.0
    private lateinit var textView: TextView
    private var dotBool: Boolean = false
    private var numberBool: Boolean = false
    private var number1: Double = 0.0

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

        if (view.id == buttonDot.id && !dotBool && textView.text.toString().isDigitsOnly() && !textView.text.isEmpty()){
            textView.text = textView.text.toString() + "."
            dotBool = true
        } else if (view.id == buttonDot.id ) {
            textView.text = textView.text.toString()
        } else if (textView.text == "0") {
            if (view.id == buttonDot.id){
                textView.text = textView.text.toString() + "."
            } else if (view.id != buttonDot.id) {
                textView.text = view.tag.toString()
            }
        } else if (textView.text.toString() == "-" || textView.text.toString() == "+" || textView.text.toString() == "*" || textView.text.toString() == "/") {
            textView.text = view.tag.toString()
        }
        else textView.text = textView.text.toString() + view.tag.toString()

        Log.i("stringfordisplay "  + textView.text.toString(), "Result")
        Log.i("textview "  + textView.text, "Res")
//        if(numberBool == true){
//            fisrtNum = textView.text.toString().toDouble()
//        }

    }

    fun onClickSetSign(view: View) {
       // var number1: Double = 0.0

        if (textView.text.isDigitsOnly() && !numberBool) {
             number1 = textView.text.toString().toDouble()
            numberBool = true
        }
        Log.i("number1  " + number1, "Re")
        if (view.id == buttonDevision.id) {
            textView.text = "/"
        }else if (view.id == buttonMultiple.id) {
            textView.text = "*"
            numberBool = true
        }else if (view.id == buttonPlus.id) {
            textView.text = "+"
        }else if (view.id == buttonMinus.id) {
            textView.text = "-"
        }else if (view.id == buttonClean.id) {
            textView.text = ""
           // number1 =  0.0

        }else if (view.id == buttonEquality.id){
            if (operation == 11 && textView.text.toString() != "0") {
                textView.text = (number1/(textView.text.toString().toDouble())).toString()
            } else if (operation == 12) {
                textView.text = (number1*(textView.text.toString().toDouble())).toString()
            }else if (operation == 13) {
                textView.text = (number1 + textView.text.toString().toDouble()).toString()
            }else if (operation == 14) {
                textView.text = (number1 - textView.text.toString().toDouble()).toString()
                number1 = textView.text.toString().toDouble()
            }
            //numberBool = false

        }
        operation = view.tag.toString().toInt()
        Log.i("sign "  + textView.text.toString(), "R")
        dotBool = false
    }
}

