package kr.ac.tukorea.hw_4_2

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.*

class MainActivity : AppCompatActivity() {
    lateinit var text1 : TextView
    lateinit var text2 : TextView
    lateinit var swAgree : Switch
    lateinit var rGroup1 : RadioGroup
    lateinit var rdoOreo : RadioButton
    lateinit var rdoPie : RadioButton
    lateinit var rdoQ : RadioButton
    lateinit var btnHome : Button
    lateinit var btnExit : Button
    lateinit var imgAndroid : ImageView
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        title = "안드로이드 사진 보기"
        text1 = findViewById<TextView>(R.id.Text1)
        swAgree = findViewById<Switch>(R.id.SwAgree)
        text2 = findViewById<TextView>(R.id.Text2)
        rGroup1 = findViewById<RadioGroup>(R.id.Rgroup1)
        rdoOreo = findViewById<RadioButton>(R.id.RdoOreo)
        rdoPie = findViewById<RadioButton>(R.id.RdoPie)
        rdoQ = findViewById<RadioButton>(R.id.RdoQ)
        btnHome = findViewById<Button>(R.id.BtnHome)
        btnExit = findViewById<Button>(R.id.BtnExit)
        imgAndroid = findViewById<ImageView>(R.id.ImgAndroid)

        swAgree.setOnCheckedChangeListener { compoundButton, b ->
            // 체크되면 모두 보이도록 설정
            if (swAgree.isChecked) {
                text2.visibility = android.view.View.VISIBLE
                rGroup1.visibility = android.view.View.VISIBLE
                btnHome.visibility = android.view.View.VISIBLE
                btnExit.visibility = android.view.View.VISIBLE
                imgAndroid.visibility = android.view.View.VISIBLE
            } else {
                text2.visibility = android.view.View.INVISIBLE
                rGroup1.visibility = android.view.View.INVISIBLE
                btnHome.visibility = android.view.View.INVISIBLE
                btnExit.visibility = android.view.View.INVISIBLE
                imgAndroid.visibility = android.view.View.INVISIBLE
            }
        }

        rdoOreo.setOnClickListener {
            if (rdoOreo.isChecked) {
                imgAndroid.setImageResource(R.drawable.android_oreo)
            }
        }
        rdoPie.setOnClickListener {
            if (rdoPie.isChecked) {
                imgAndroid.setImageResource(R.drawable.android_pie)
            }
        }
        rdoQ.setOnClickListener {
            if (rdoQ.isChecked) {
                imgAndroid.setImageResource(R.drawable.android_q)
            }
        }

        btnHome.setOnClickListener {
            swAgree.setChecked(false)
            rdoOreo.setChecked(false)
            rdoPie.setChecked(false)
            rdoQ.setChecked(false)
            imgAndroid.setImageResource(0)
        }

        btnExit.setOnClickListener {
            finish()
        }
    }
}