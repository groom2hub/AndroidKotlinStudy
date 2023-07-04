package kr.ac.tukorea.hw_calculator

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import kotlin.math.roundToInt

class MainActivity : AppCompatActivity() {
    lateinit var edit1: EditText
    lateinit var edit2: EditText
    lateinit var btnAdd: Button
    lateinit var btnSub: Button
    lateinit var btnMul: Button
    lateinit var btnDiv: Button
    lateinit var textResult : TextView
    lateinit var num1 : String
    lateinit var num2: String
    var result: Double? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        title = "초간단 계산기"
        edit1 = findViewById<EditText>(R.id.Edit1)
        edit2 = findViewById<EditText>(R.id.Edit2)
        btnAdd = findViewById<Button>(R.id.BtnAdd)
        btnSub = findViewById<Button>(R.id.BtnSub)
        btnMul = findViewById<Button>(R.id.BtnMul)
        btnDiv = findViewById<Button>(R.id.BtnDiv)
        textResult = findViewById<TextView>(R.id.TextResult)

        btnAdd.setOnClickListener {
            num1 = edit1.text.toString()
            num2 = edit2.text.toString()
            if (edit1.text.toString().trim().isEmpty() || edit2.text.toString().trim().isEmpty() ) {
                Toast.makeText(this@MainActivity, "숫자를 입력하세요.", Toast.LENGTH_SHORT).show()
            }
            else {
                result = num1.toDouble() + num2.toDouble()
                textResult.text = "계산 결과 : " + result.toString()
            }
            false
        }

        btnSub.setOnClickListener {
            num1 = edit1.text.toString()
            num2 = edit2.text.toString()
            if (edit1.text.toString().trim().isEmpty() || edit2.text.toString().trim().isEmpty() ) {
                Toast.makeText(this@MainActivity, "숫자를 입력하세요.", Toast.LENGTH_SHORT).show()
            }
            else {
                result = num1.toDouble() - num2.toDouble()
                textResult.text = "계산 결과 : " + result.toString()
            }
            false
        }

        btnMul.setOnClickListener {
            num1 = edit1.text.toString()
            num2 = edit2.text.toString()
            if (edit1.text.toString().trim().isEmpty() || edit2.text.toString().trim().isEmpty() ) {
                Toast.makeText(this@MainActivity, "숫자를 입력하세요.", Toast.LENGTH_SHORT).show()
            }
            else {
                result = num1.toDouble() * num2.toDouble()
                textResult.text = "계산 결과 : " + result.toString()
            }
            false
        }

        btnDiv.setOnClickListener {
            num1 = edit1.text.toString()
            num2 = edit2.text.toString()
            if (edit1.text.toString().trim().isEmpty() || edit2.text.toString().trim().isEmpty() ) {
                Toast.makeText(this@MainActivity, "숫자를 입력하세요.", Toast.LENGTH_SHORT).show()
            }
            else {
                if (num2.toInt() != 0) {
                    result = num1.toDouble() / num2.toDouble()
                    textResult.text = "계산 결과 : " + result.toString()
                } else {
                    Toast.makeText(this@MainActivity, "0으로 나눌 수 없음", Toast.LENGTH_SHORT).show()
                }
            }
            false
        }
    }
}