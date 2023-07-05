package kr.ac.tukorea.dialogstudy

import androidx.appcompat.app.AppCompatActivity
import android.app.AlertDialog
import android.content.Context
import android.content.DialogInterface
import android.os.Bundle
import android.view.Display
import android.view.Gravity
import android.view.View
import android.view.WindowManager
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast

class MainActivity : AppCompatActivity() {

    lateinit var tvName : TextView
    lateinit var tvEmail : TextView
    lateinit var button1 : Button
    lateinit var dlgEdtName : EditText
    lateinit var dlgEdtEmail : EditText
    lateinit var toastText : TextView
    lateinit var dialogView : View
    lateinit var toastView : View

    public override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        supportActionBar!!.setDisplayShowHomeEnabled(true)
        supportActionBar!!.setIcon(R.drawable.ic_launcher)
        title = "사용자 정보 입력 (수정)"

        tvName = findViewById<View>(R.id.tvName) as TextView
        tvEmail = findViewById<View>(R.id.tvEmail) as TextView
        button1 = findViewById<View>(R.id.button1) as Button

        button1.setOnClickListener {
            dialogView = View.inflate(this@MainActivity, R.layout.dialog1, null) as View

            val dlg = AlertDialog.Builder(this@MainActivity)
            dlg.setTitle("사용자 정보 입력")
            dlg.setIcon(R.drawable.ic_launcher)
            dlg.setView(dialogView)
            dlgEdtName = dialogView.findViewById<View>(R.id.dlgEdt1) as EditText
            dlgEdtEmail = dialogView.findViewById<View>(R.id.dlgEdt2) as EditText
            dlgEdtName.setText(tvName.text.toString())
            dlgEdtEmail.setText(tvEmail.text.toString())
            dlg.setPositiveButton("확인") { dialog, which ->
                tvName.text = dlgEdtName.text.toString()
                tvEmail.text = dlgEdtEmail.text.toString()
            }

            dlg.setNegativeButton("취소") { dialog, which ->
                val toast = Toast(this@MainActivity)

                val display = (getSystemService(Context.WINDOW_SERVICE) as WindowManager).defaultDisplay
                val xOffset = (Math.random() * display.width).toInt()
                val yOffset = (Math.random() * display.height).toInt()

                toast.setGravity(Gravity.TOP or Gravity.LEFT, xOffset, yOffset)

                toastView = View.inflate(this@MainActivity, R.layout.toast1, null) as View
                toastText = toastView.findViewById<View>(R.id.toastText1) as TextView
                toastText.text = "취소했습니다"
                toast.view = toastView
                toast.show()
            }
            dlg.show()
        }

    }

}
