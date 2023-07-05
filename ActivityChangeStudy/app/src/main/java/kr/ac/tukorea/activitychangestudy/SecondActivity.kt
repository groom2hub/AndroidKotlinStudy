package kr.ac.tukorea.activitychangestudy;

import android.app.Activity
import android.os.Bundle
import android.widget.Button

public class SecondActivity : Activity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.second)

        var btnReturn = findViewById<Button>(R.id.btnReturn)
        btnReturn.setOnClickListener {
            finish()
        }

    }
}
