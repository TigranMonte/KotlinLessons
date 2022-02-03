package ru.tikodvlp.p005string

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView

class MainActivity : AppCompatActivity() {

    private var number:Int = 6
    private var number2:Int = 6
    private var text:String = "В магазине <осталось> 123 яблок или больше"
    private var tvText: TextView? = null


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        tvText = findViewById(R.id.tvView)
        var subText:String = text.substringAfter('<')
        var subText2:String = subText.substringBefore('>')
        tvText?.setText(subText2)

    }
}