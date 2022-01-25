package ru.tikodvlp.p001clicklistener

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.TextView
import android.widget.Toast

class MainActivity : AppCompatActivity() {

    private lateinit var textView: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        textView = findViewById(R.id.textView)
    }

    fun toastMe(view: View) {
        val myToast = Toast.makeText(this, "Hello, Toast", Toast.LENGTH_SHORT)
        myToast.show()
    }

    fun countMe(view: View) {
        val countString = textView.text.toString()
        var count: Int = Integer.parseInt(countString)
        count++
        textView.text = count.toString()
    }
}