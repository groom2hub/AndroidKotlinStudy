package kr.ac.tukorea.tiltsensor

import android.content.Context
import android.content.pm.ActivityInfo
import android.graphics.Canvas
import android.graphics.Color
import android.graphics.Paint
import android.hardware.Sensor
import android.hardware.SensorEvent
import android.hardware.SensorEventListener
import android.hardware.SensorManager
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.WindowManager

class MainActivity : AppCompatActivity(), SensorEventListener {
    private val sensorManager by lazy {
        getSystemService(Context.SENSOR_SERVICE) as SensorManager
    }
    private lateinit var tiltView: TiltView

    override fun onCreate(savedInstanceState: Bundle?) {
        window.addFlags(WindowManager.LayoutParams.FLAG_KEEP_SCREEN_ON)
        requestedOrientation = ActivityInfo.SCREEN_ORIENTATION_LANDSCAPE
        super.onCreate(savedInstanceState)
//        setContentView(R.layout.activity_main)
        tiltView = TiltView(this)
        setContentView(tiltView)

    }

    override fun onResume() {
        super.onResume()
        sensorManager.registerListener(this,
            sensorManager.getDefaultSensor(Sensor.TYPE_ACCELEROMETER),
            SensorManager.SENSOR_DELAY_NORMAL)
    }

    override fun onAccuracyChanged(sensor: Sensor?, accuracy: Int) {
        TODO("Not yet implemented")
    }

    override fun onSensorChanged(event: SensorEvent?) {
        event?.let {
            Log.d("MainActivity", "onSensorChanged: " + "x : ${event.values[0]}, y : ${event.values[1]}, z : ${event.values[2]}")
        }
    }

    override fun onPause() {
        super.onPause()
        sensorManager.unregisterListener(this)
    }
    override fun onDraw(canvas: Canvas?){
        canvas?.drawCircle(0, 0, 100f, blackPaint)
        canvas?.drawCircle(0, 0, 100f, greenPaint)
        canvas?.drawLine(-20, 0, 20, 0, blackPaint)
        canvas?.drawLine(0, -20, 0, -20, blackPaint)
    }
    private val greenPaint: Paint = Paint()
    private val blackPaint: Paint = Paint()

    init {
        greenPaint.color = Color.GREEN
        blackPaint.style = Paint.Style.STROKE
    }

    private var cX: Float = 0f
    private var cY: Float = 0f
    override fun onSizeChanged(w: Int, h: Int, oldw: Int, oldh: Int){
        cX = w / 2f
        cY = h / 2f
    }

}
