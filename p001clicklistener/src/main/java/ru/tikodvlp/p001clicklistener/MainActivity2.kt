package ru.tikodvlp.p001clicklistener

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView
import java.util.*

class MainActivity2 : AppCompatActivity() {
    private lateinit var textRandom: TextView
    private lateinit var textViewLabel: TextView

    companion object {
        const val TOTAL_COUNT = "total_count"
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main2)
        textRandom = findViewById(R.id.textRandom)
        textViewLabel = findViewById(R.id.textViewLabel)

        showRandomNumber()
    }

    fun showRandomNumber() {
        val count = intent.getIntExtra(TOTAL_COUNT, 0);
        val random = Random()

        var randomInt = 0

        if (count>0) {
            randomInt = random.nextInt(count + 1)
        }
        textRandom.text = Integer.toString(randomInt)

         textViewLabel.text = getString(R.string.random_heading, count)
    }
}