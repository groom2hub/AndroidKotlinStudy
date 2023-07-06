package kr.ac.tukorea.diary

import android.content.Context
import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.DatePicker
import android.widget.EditText
import android.widget.Toast
import androidx.annotation.RequiresApi
import java.io.FileInputStream
import java.io.IOException
import java.time.LocalDate
import java.time.LocalDateTime
import java.util.*

class MainActivity : AppCompatActivity() {
    lateinit var dp : DatePicker
    lateinit var edtDiary : EditText
    lateinit var btnWrite : Button
    lateinit var fileName : String

    @RequiresApi(Build.VERSION_CODES.O)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        title = "간단 일기장"

        dp = findViewById<DatePicker>(R.id.datePicker1)
        edtDiary = findViewById<EditText>(R.id.edtDiary)
        btnWrite = findViewById<Button>(R.id.btnWrite)

        edtDiary.inputType=0

        var cal = Calendar.getInstance()
        var cYear = cal.get(Calendar.YEAR)
        var cMonth = cal.get(Calendar.MONTH)
        var cDay = cal.get(Calendar.DAY_OF_MONTH)

        fileName = (LocalDate.now().year.toString() + "_"
                + LocalDate.now().month.toString() + "_"
                + LocalDate.now().dayOfMonth.toString() + ".txt")
        var str = readDiary(fileName)
        edtDiary.setHint(str)

        dp.init(cYear, cMonth, cDay) { view, year, monthOfYear, dayOfMonth ->
            fileName = (Integer.toString(year) + "_"
                    + Integer.toString(monthOfYear + 1) + "_"
                    + Integer.toString(dayOfMonth) + ".txt")
            var str = readDiary(fileName)
            edtDiary.setText(str)
            btnWrite.isEnabled = true
        }

        btnWrite.setOnClickListener {
            var outFs = openFileOutput(fileName, Context.MODE_PRIVATE)
            var str = edtDiary.text.toString()
            outFs.write(str.toByteArray())
            outFs.close()
            Toast.makeText(applicationContext, "$fileName 이 저장됨", Toast.LENGTH_SHORT).show()
        }
    }

    fun readDiary(fName: String) : String? {
        var diaryStr : String? = null
        var inFs : FileInputStream
        try {
            inFs = openFileInput(fName)
            var txt = ByteArray(500)
            inFs.read(txt)
            inFs.close()
            diaryStr = txt.toString(Charsets.UTF_8).trim()
            btnWrite.text = "수정 하기"
        } catch (e : IOException) {
            edtDiary.hint = "일기 없음"
            btnWrite.text = "새로 저장"
        }
        return diaryStr
    }
}

