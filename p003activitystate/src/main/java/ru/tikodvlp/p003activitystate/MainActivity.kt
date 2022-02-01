package ru.tikodvlp.p003activitystate

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView

class MainActivity : AppCompatActivity() {

    private lateinit var button: Button
    private lateinit var editText: EditText
    private lateinit var textView: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        button = findViewById(R.id.button)
        editText = findViewById(R.id.editTextTextPersonName)
        textView = findViewById(R.id.textView)

        button.setOnClickListener {
            textView.text = editText.text
        }
    }

    override fun onSaveInstanceState(outState: Bundle) {

        outState.run {
            putString("KEY", textView.text.toString())
        }
        super.onSaveInstanceState(outState)
    }

    override fun onRestoreInstanceState(savedInstanceState: Bundle) {
        super.onRestoreInstanceState(savedInstanceState)
        textView.text = savedInstanceState.getString("KEY")
    }
}