package ru.tikodvlp.sqlitekotlin

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.EditText
import android.widget.TextView
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import ru.tikodvlp.sqlitekotlin.db.MyAdapter
import ru.tikodvlp.sqlitekotlin.db.MyDbManager

class MainActivity : AppCompatActivity() {

    lateinit var rcView: RecyclerView

    val myDbManager = MyDbManager(this)
    val myAdapter = MyAdapter(ArrayList())

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        init()

        rcView = findViewById(R.id.rcView)

    }

    fun onClickNew(view: View) {
        val i = Intent(this, EditActivity::class.java)
        startActivity(i)
    }

    override fun onResume() {
        super.onResume()
        myDbManager.openDb()
        fillAdapter()
    }

    override fun onDestroy() {
        super.onDestroy()
        myDbManager.closeDb()
    }

    fun init() {
        rcView.layoutManager = LinearLayoutManager(this)
        rcView.adapter = myAdapter
    }

    fun fillAdapter() {
        myAdapter.updateAdapter(myDbManager.readDbData())
    }
}