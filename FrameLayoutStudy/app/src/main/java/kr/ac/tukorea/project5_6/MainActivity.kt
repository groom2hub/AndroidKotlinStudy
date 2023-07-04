package kr.ac.tukorea.project5_6

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.ImageView

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        var index = 1
        var btnChange = findViewById<Button>(R.id.BtnChange)
        var iv1 = findViewById<ImageView>(R.id.Iv1)
        var iv2 = findViewById<ImageView>(R.id.Iv2)
        var iv3 = findViewById<ImageView>(R.id.Iv3)
        btnChange.setOnClickListener {
            if( index < 3){
                index++
            }
            else{
                index = 1
            }
            if (index == 1) {
                iv1.visibility = android.view.View.VISIBLE
                iv2.visibility = android.view.View.INVISIBLE
                iv3.visibility = android.view.View.INVISIBLE
            }
            if (index == 2) {
                iv1.visibility = android.view.View.INVISIBLE
                iv2.visibility = android.view.View.VISIBLE
                iv3.visibility = android.view.View.INVISIBLE
            } else if (index == 3) {
                iv1.visibility = android.view.View.INVISIBLE
                iv2.visibility = android.view.View.INVISIBLE
                iv3.visibility = android.view.View.VISIBLE
            }
        }
    }
}