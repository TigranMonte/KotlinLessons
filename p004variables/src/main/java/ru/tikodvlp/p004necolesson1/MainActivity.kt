package ru.tikodvlp.p004necolesson1

import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView
import androidx.constraintlayout.widget.ConstraintLayout

class MainActivity : AppCompatActivity() {

    private var number1:Byte = 0
    private var number2:Short = 123
    private var number3:Int = 34567
    private var number4:Long = 0
    private var number5:Float = 0.0f
    private var number6:Double = 0.0
    private var text:String = "Hala Madrid!"
    private var ch:Char = 'D'
    private var counter:Int = 0
    private var start:Boolean = false

    private var tvView:TextView? = null
    private var cLayout:ConstraintLayout? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        cLayout = findViewById(R.id.cLayout)
        tvView = findViewById(R.id.tvView)
        tvView?.setText(number3.toString())

        Thread {
            start = true
            while (start){
                Thread.sleep(1000)
                runOnUiThread{
                    if (counter == 5) cLayout?.setBackgroundColor(Color.BLUE)
                    tvView?.setText(counter.toString())
                    counter++
                }
            }
        }.start()
    }

    override fun onDestroy() {
        super.onDestroy()
        start = false
    }
}