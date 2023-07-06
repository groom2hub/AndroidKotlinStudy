package kr.ac.tukorea.calculatorwithactivity

import android.app.Activity
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import kr.ac.tukorea.calculatorwithactivity.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState);
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        title = "초간단 계산기"

        binding.BtnCalculate.setOnClickListener {
            if (binding.Edit1.text.toString().trim()
                    .isNotEmpty() && binding.Edit2.text.toString().trim().isNotEmpty()
            ) {
                var intent = Intent(applicationContext, SecondActivity::class.java)
                intent.putExtra("Num1", Integer.parseInt(binding.Edit1.text.toString()))
                intent.putExtra("Num2", Integer.parseInt(binding.Edit2.text.toString()))
                if (binding.BtnAdd.isChecked) {
                    intent.putExtra("Operator", 1)
                }
                else if (binding.BtnSub.isChecked) {
                    intent.putExtra("Operator", 2)
                }
                else if (binding.BtnMul.isChecked) {
                    intent.putExtra("Operator", 3)
                }
                else if (binding.BtnDiv.isChecked) {
                    if (binding.Edit2.text.toString().toInt() == 0) {
                        Toast.makeText(this@MainActivity, "0으로 나눌 수 없습니다.", Toast.LENGTH_SHORT)
                    } else {
                        intent.putExtra("Operator", 4)
                    }
                }
                startActivityForResult(intent, 0)
            } else {
                Toast.makeText(this@MainActivity, "숫자를 입력하세요.", Toast.LENGTH_SHORT)
                    .show()
            }

        }
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        if (resultCode == Activity.RESULT_OK){
            var hap = data!!.getIntExtra("Hap", 0)
            Toast.makeText(applicationContext, "결과: $hap", Toast.LENGTH_SHORT).show()
        }
    }
}