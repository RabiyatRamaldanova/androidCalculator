package com.example.calcapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Button
import android.widget.TextView
import androidx.core.text.isDigitsOnly

class MainActivity : AppCompatActivity() {
    private var operation: String = ""

    private lateinit var textView: TextView
    private var dotBool: Boolean = false
    private var numberBool: Boolean = false
    private var number1: Double = 0.0
    private var number2: Double = 0.0
    private var checkLastSign: Boolean = false
    private var  equality: Boolean = false
    private var sign: Boolean = false
    private var najalaNaChisli: Boolean = false

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
    private lateinit var buttonRoot: Button
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
        buttonRoot = findViewById(R.id.buttonRoot)

    }

    fun onClickSetNumber(view: View) {

        if (view.id == buttonDot.id && dotBool == false && textView.text.toString()
                .isDigitsOnly() && !textView.text.isEmpty() && checkLastSign == false) {
            textView.text = textView.text.toString() + "."
            dotBool = true
        } else if (view.id == buttonDot.id && (textView.text.isEmpty() || textView.text.toString() == "+" || textView.text.toString() == "-" || textView.text.toString() == "*" || textView.text.toString() == "/")) {
            textView.text = "0."
        }

        if (checkLastSign == false) {


            if (textView.text != "0") {
                when (view.tag.toString().toInt()) {
                    1, 2, 3, 4, 5, 6, 7, 8, 9 -> textView.text =
                        textView.text.toString() + view.tag.toString()
                }
                buttonMinus.isClickable = true
                buttonMultiple.isClickable = true
                buttonDevision.isClickable = true
                buttonEquality.isClickable = true
                buttonPlus.isClickable = true
                najalaNaChisli = true
            }
            else {
                when (view.tag.toString().toInt()) {
                    1, 2, 3, 4, 5, 6, 7, 8, 9 -> textView.text =  view.tag.toString()
                }
                buttonMinus.isClickable = true
                buttonMultiple.isClickable = true
                buttonDevision.isClickable = true
                buttonEquality.isClickable = true
                buttonPlus.isClickable = true
                najalaNaChisli = true
            }
            if (view.tag.toString() == "0") {
                if (textView.text.toString() == "0") {
                    textView.text = "0"
                } else if (!textView.text.toString().isEmpty()) {
                    textView.text = textView.text.toString() + view.tag.toString()
                } else if (textView.text.toString().isEmpty()) {
                    textView.text = view.tag.toString()
                }
                buttonMinus.isClickable = true
                buttonMultiple.isClickable = true
                buttonDevision.isClickable = true
                buttonEquality.isClickable = true
                buttonPlus.isClickable = true
                najalaNaChisli = true
            }
        }
        else if (checkLastSign == true && view.id != buttonDot.id){
            textView.text = view.tag.toString()
            checkLastSign = false
            buttonMinus.isClickable = true
            buttonMultiple.isClickable = true
            buttonDevision.isClickable = true
            buttonEquality.isClickable = true
            buttonPlus.isClickable = true

            najalaNaChisli = true
        }
            number2 = textView.text.toString().toDouble()


        findDot()
    }

    fun findDot() {
        for (char in textView.text.toString()) {
            if (char.toString() == ".") {
                dotBool = true
            }
        }
    }

    fun checkForDoubleOrInt() {
        var ostatok = textView.text.toString().toDouble() % 1
        if (ostatok == 0.0) {
            textView.text = (textView.text.toString().toDouble().toInt()).toString()
        }
        dotBool = false
    }

    fun onClickSetSign(view: View) {
        if (!textView.text.toString().isEmpty() && view.tag.toString() != "10"  && view.tag.toString() != "15") {

            if (textView.text.toString() != "+"&& textView.text.toString() != "-"&& textView.text.toString() != "*"&&textView.text.toString() != "/"){
                number1 = textView.text.toString().toDouble()}


            if (view.id == buttonDevision.id ) {
                textView.text = "/"
                checkLastSign = true
                equality = false
                najalaNaChisli = false
            }
            else if (view.id == buttonRoot.id) {
                if (textView.text.toString() != "-" && textView.text.toString() != "+" && textView.text.toString() != "/" && textView.text.toString() != "*" && !textView.text.toString().isEmpty()) {
                    textView.text = ("%.6f".format(Math.sqrt(textView.text.toString().toDouble())).toDouble()).toString()
                    checkForDoubleOrInt()
                }
            }
            else if (view.id == buttonMultiple.id ) {
                textView.text = "*"
                numberBool = true
                checkLastSign = true
                equality = false
                najalaNaChisli = false
            } else if (view.id == buttonPlus.id ) {
                textView.text = "+"
                checkLastSign = true
                equality = false
                najalaNaChisli = false
            } else if (view.id == buttonMinus.id ) {
                textView.text = "-"
                checkLastSign = true
                equality = false
                najalaNaChisli = false
            }else if (view.tag.toString().toInt() == 44) {
                textView.text =
                    textView.text.substring(0, textView.text.length - 1)
            }
            operation = view.tag.toString()
            dotBool = false
        } else if (view.tag.toString() == "15" && equality == false && !textView.text.isEmpty() && najalaNaChisli == true) {
            if (operation == "11" && textView.text.toString() != "0") {
                textView.text = (("%.6f".format(number1/number2)).toDouble()).toString()
            } else if (operation == "12") {
                textView.text = (("%.6f".format(number1*number2)).toDouble()).toString()
            } else if (operation == "13") {
                textView.text = (("%.6f".format(number1+number2)).toDouble()).toString()
            } else if (operation == "14") {
                textView.text = (("%.6f".format(number1-number2)).toDouble()).toString()
            }
            equality = true
            checkForDoubleOrInt()
            sign = false
        } else if (view.tag.toString() == "10") {
            textView.text = ""
            number1 = 0.0
            number2 = 0.0
            checkLastSign = false
            dotBool= false
            buttonMinus.isClickable = false
            buttonMultiple.isClickable = false
            buttonDevision.isClickable = false
            buttonEquality.isClickable = false
            buttonPlus.isClickable = false
        }
    }
}


