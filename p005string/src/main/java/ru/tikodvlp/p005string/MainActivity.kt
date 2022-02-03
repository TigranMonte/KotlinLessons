package ru.tikodvlp.p005string

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView

class MainActivity : AppCompatActivity() {

    private var number:Int = 6
    private var number2:Int = 6
    private var text:String = "В магазине осталось ${getNumber()} яблок"
    private var tvText: TextView? = null


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        tvText = findViewById(R.id.tvView)
        tvText?.setText(text)

    }

    private fun getNumber():Int {
        return number + number2
    }
}