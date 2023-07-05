package kr.ac.tukorea.optionmenujeju

import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.widget.Button
import android.widget.EditText
import android.widget.ImageView
import android.widget.RelativeLayout

class MainActivity : AppCompatActivity() {
    lateinit var baseLayout: RelativeLayout
    lateinit var edtDegree: EditText
    lateinit var iv1: ImageView
    lateinit var btnReset: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        title = "배경색 바꾸기"
        baseLayout = findViewById<RelativeLayout>(R.id.baseLayout)
        edtDegree = findViewById<EditText>(R.id.EdtDegree)
        iv1 = findViewById<ImageView>(R.id.Iv)
        btnReset = findViewById<Button>(R.id.BtnReset)

        btnReset.setOnClickListener {
            edtDegree.setText("")
            iv1.setRotation(0f)
        }

    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        super.onCreateOptionsMenu(menu)
        var mInflater = menuInflater
        mInflater.inflate(R.menu.menu1, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when (item.itemId){
            R.id.item1 -> {
                iv1.setImageResource(R.drawable.mt_hanlla)
                item.setChecked(true)
                return true
            }
            R.id.item2 -> {
                iv1.setImageResource(R.drawable.chuja_island)
                item.setChecked(true)
                return true
            }
            R.id.item3 -> {
                iv1.setImageResource(R.drawable.bunseom_island)
                item.setChecked(true)
                return true
            }
            R.id.btnRotate -> {
                iv1.setRotation(edtDegree.text.toString().toFloat())
            }
        }
        return false
    }
}