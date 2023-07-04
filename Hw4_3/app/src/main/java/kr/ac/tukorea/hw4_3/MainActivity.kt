package kr.ac.tukorea.hw4_3

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.KeyEvent
import android.widget.EditText
import android.widget.Toast

class MainActivity : AppCompatActivity() {
    lateinit var editText: EditText
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        editText = findViewById<EditText>(R.id.Edit1)
        editText.inputType = 0

        editText.setOnKeyListener { v, keyCode, event ->
            if (event.action == KeyEvent.ACTION_UP) {
                Toast.makeText(this@MainActivity, editText.text.toString(), Toast.LENGTH_SHORT).show()
            }
            false
        }
    }
}