package kr.ac.tukorea.activitychangestudy

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.RadioGroup

class MainActivity : AppCompatActivity() {
    lateinit var btnNewActivity: Button
    lateinit var radioGroupActivity: RadioGroup

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        radioGroupActivity = findViewById<RadioGroup>(R.id.radioGroupActivity)
        btnNewActivity = findViewById<Button>(R.id.btnNewActivity)

        radioGroupActivity.setOnCheckedChangeListener { group, checkedId ->
            when (checkedId) {
                R.id.radioSecondActivity -> intent =
                    Intent(applicationContext, SecondActivity::class.java)
                R.id.radioThirdActivity -> intent =
                    Intent(applicationContext, ThirdActivity::class.java)
            }
        }
        btnNewActivity.setOnClickListener {
            startActivity(intent)
        }
    }
}