package kr.ac.tukorea.diarysdcard

import android.content.Context
import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Environment
import android.widget.Button
import android.widget.DatePicker
import android.widget.EditText
import android.widget.Toast
import androidx.core.app.ActivityCompat
import java.io.File
import java.io.FileInputStream
import java.io.IOException
import java.util.*
import android.view.View
import java.io.FileOutputStream
import java.lang.Exception
@Suppress("deprecation")
class MainActivity : AppCompatActivity() {
    lateinit var dp: DatePicker
    lateinit var edtDiary: EditText
    lateinit var btnWrite: Button
    lateinit var fileName: String
    lateinit var myDir: File
    lateinit var strSDpath: String

    public override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        ActivityCompat.requestPermissions(this, arrayOf(android.Manifest.permission.WRITE_EXTERNAL_STORAGE), Context.MODE_PRIVATE)

        dp = findViewById<View>(R.id.datePicker1) as DatePicker
        edtDiary = findViewById<View>(R.id.edtDiary) as EditText
        btnWrite = findViewById<View>(R.id.btnWrite) as Button

        val cYear = Calendar.getInstance().get(Calendar.YEAR)
        val cMonth = Calendar.getInstance().get(Calendar.MONTH)
        val cDay = Calendar.getInstance().get(Calendar.DAY_OF_MONTH)

        // 디렉터리가 없으면 생성
        strSDpath = Environment.getExternalStorageDirectory().absolutePath
        strSDpath = "$strSDpath/myDiary/"
        var myDir =  File(strSDpath)
        if (!myDir.isDirectory)
            myDir.mkdir()

        // 처음의 실행한 날짜(오늘)를 체크하기
        fileName = (Integer.toString(cYear) + "_" + Integer.toString(cMonth + 1) + "_" + Integer.toString(cDay) + ".txt")
        val str = readDiary(strSDpath + fileName)
        edtDiary.setText(str)
        btnWrite.isEnabled = true

        dp.init(cYear, cMonth, cDay) { view, year, monthOfYear, dayOfMonth ->
            fileName = (Integer.toString(year) + "_"
                    + Integer.toString(monthOfYear + 1) + "_"
                    + Integer.toString(dayOfMonth) + ".txt")

            val str = readDiary(strSDpath + fileName)
            edtDiary.setText(str)
            btnWrite.isEnabled = true
        }

        btnWrite.setOnClickListener {
            try {
                val outFs = FileOutputStream(strSDpath + fileName)
                val str = edtDiary.text.toString()
                outFs.write(str.toByteArray())
                outFs.close()
                Toast.makeText(applicationContext,
                    "$strSDpath$fileName 이 저장됨", Toast.LENGTH_SHORT).show()
            } catch (e: Exception) {
            }
        }

    }

    fun readDiary(fName: String): String? {
        var diaryStr: String? = null

        try {
            val inFs = FileInputStream(fName)
            val txt = ByteArray(500)
            inFs.read(txt)
            inFs.close()
            diaryStr = txt.toString(Charsets.UTF_8).trim()
            btnWrite.text = "수정 하기"
        } catch (e: IOException) {
            edtDiary.hint = "일기 없음"
            btnWrite.text = "새로 저장"
        }

        return diaryStr
    }
}


