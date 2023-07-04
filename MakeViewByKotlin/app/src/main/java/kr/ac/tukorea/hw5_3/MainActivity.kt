package kr.ac.tukorea.hw5_3

import android.graphics.Color
import android.graphics.Color.MAGENTA
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.LinearLayout
import android.widget.TextView
import android.widget.Toast
import androidx.core.view.isInvisible

class MainActivity : AppCompatActivity() {
    public override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        // setContentView(R.layout.activity_main)
        var params = LinearLayout.LayoutParams(
            LinearLayout.LayoutParams.MATCH_PARENT,
            LinearLayout.LayoutParams.MATCH_PARENT
        )
        var baseLayout = LinearLayout(this)
        baseLayout.orientation = LinearLayout.VERTICAL
        baseLayout.setBackgroundColor(Color.WHITE)
        setContentView(baseLayout, params)

        var edit1 = EditText(this)
        baseLayout.addView(edit1)

        var btn1 = Button(this)
        var text1 = TextView(this)
        text1.visibility = android.view.View.INVISIBLE

        btn1.text = "버튼입니다"
        btn1.setBackgroundColor(Color.YELLOW)
        baseLayout.addView(btn1)
        btn1.setOnClickListener {
            text1.visibility = android.view.View.VISIBLE
            text1.text = edit1.text.toString()
            text1.setTextColor(MAGENTA)
        }

        baseLayout.addView(text1)
    }
}
