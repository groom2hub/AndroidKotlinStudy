package kr.ac.tukorea.calculatorwithactivity

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity

class SecondActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val inIntent = intent
        val hapOperator = inIntent.getIntExtra("Operator", 1)
        var hapValue = 0
        val hapNum1 = inIntent.getIntExtra("Num1", 0)
        val hapNum2 = inIntent.getIntExtra("Num2", 0)

        when (hapOperator) {
            1 -> hapValue = hapNum1 + hapNum2
            2 -> hapValue = hapNum1 - hapNum2
            3 -> hapValue = hapNum1 * hapNum2
            4 -> {
                if (hapNum2 != 0) {
                    hapValue = hapNum1 / hapNum2
                }
            }
        }

        var outIntent = Intent(applicationContext, MainActivity::class.java)
        outIntent.putExtra("Hap", hapValue)
        outIntent.putExtra("Hap1", hapOperator)
        setResult(Activity.RESULT_OK, outIntent)
        finish()
    }
}