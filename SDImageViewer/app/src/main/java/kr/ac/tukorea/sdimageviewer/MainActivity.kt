package kr.ac.tukorea.sdimageviewer

import android.content.Context
import android.os.Bundle
import android.os.Environment
import android.view.View
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.core.app.ActivityCompat
import java.io.File

class MainActivity : AppCompatActivity() {
    lateinit var btnPrev : Button
    lateinit var btnNext : Button
    lateinit var myPicture : myPictureView
    lateinit var tvText : TextView
    var curNum : Int = 0
    var imageFiles : Array<File>? = null
    lateinit var imageFname : String
    var maxImagePage : Int = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        title = "간단 이미지 뷰어"
        ActivityCompat.requestPermissions(this, arrayOf(android.Manifest.permission.WRITE_EXTERNAL_STORAGE), Context.MODE_PRIVATE)

        btnPrev = findViewById<Button>(R.id.btnPrev)
        btnNext = findViewById<Button>(R.id.btnNext)
        myPicture = findViewById<myPictureView>(R.id.myPictureView1)
        tvText = findViewById<TextView>(R.id.tvPage)

        imageFiles = File(Environment.getExternalStorageDirectory().absolutePath + "/Pictures").listFiles()
        imageFname = imageFiles!![0].toString()
        myPicture.imagePath=imageFname
        myPicture.invalidate()

        maxImagePage = imageFiles!!.size
        tvText.setText("1 / $maxImagePage")


        btnPrev.setOnClickListener {
            if (curNum <= 0) {
                curNum = maxImagePage
            }
            curNum--
            imageFname = imageFiles!![curNum].toString()
            myPicture.imagePath=imageFname
            myPicture.invalidate()

            tvText.setText("${curNum+1} / $maxImagePage")
        }

        btnNext.setOnClickListener {
            if (curNum >= imageFiles!!.size - 1) {
                curNum = 0
            } else {
                curNum++
            }
            imageFname = imageFiles!![curNum].toString()
            myPicture.imagePath=imageFname
            myPicture.invalidate()
            tvText.setText("${curNum+1} / $maxImagePage")
        }
    }
}

