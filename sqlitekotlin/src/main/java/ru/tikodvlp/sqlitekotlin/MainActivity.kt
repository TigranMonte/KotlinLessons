package ru.tikodvlp.sqlitekotlin

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.EditText
import android.widget.TextView
import ru.tikodvlp.sqlitekotlin.db.MyDbManager

class MainActivity : AppCompatActivity() {

    private lateinit var edTitle: EditText
    private lateinit var edContent: EditText
    private lateinit var tvTest: TextView

    val myDbManager = MyDbManager(this)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        edContent = findViewById(R.id.edContent)
        edTitle = findViewById(R.id.edTitle)
        tvTest = findViewById(R.id.tvTest)
    }

    fun onClickSave(view: View) {
        tvTest.text = ""
        myDbManager.insertToDb(edTitle.text.toString(), edContent.text.toString())

        val dataList = myDbManager.readDbData()
        for (item in dataList) {
            tvTest.append(item)
            tvTest.append("\n")
        }
    }

    override fun onResume() {
        super.onResume()
        myDbManager.openDb()
        val dataList = myDbManager.readDbData()
        for (item in dataList) {
            tvTest.append(item)
            tvTest.append("\n")
        }

        fun onDestroy() {
            super.onDestroy()
            myDbManager.closeDb()
        }
    }
}