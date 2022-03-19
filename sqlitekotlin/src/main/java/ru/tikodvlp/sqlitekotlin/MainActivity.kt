package ru.tikodvlp.sqlitekotlin

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.EditText
import android.widget.TextView
import androidx.recyclerview.widget.ItemTouchHelper
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import org.w3c.dom.Text
import ru.tikodvlp.sqlitekotlin.db.MyAdapter
import ru.tikodvlp.sqlitekotlin.db.MyDbManager

class MainActivity : AppCompatActivity() {

    lateinit var rcView: RecyclerView
    lateinit var tvNoElements: TextView

    val myDbManager = MyDbManager(this)
    val myAdapter = MyAdapter(ArrayList(), this)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        tvNoElements = findViewById(R.id.tvNoElements)
        rcView = findViewById(R.id.rcView)

        init()

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
        val swapHelper = getSwapMg()
        swapHelper.attachToRecyclerView(rcView)
        rcView.adapter = myAdapter
    }

    fun fillAdapter() {
        val list = myDbManager.readDbData()
        myAdapter.updateAdapter(list)
        if (list.size > 0) {
            tvNoElements.visibility = View.GONE
        } else {
            tvNoElements.visibility = View.VISIBLE
        }
    }

    private fun getSwapMg(): ItemTouchHelper {
        return ItemTouchHelper(object:ItemTouchHelper.SimpleCallback
            (0, ItemTouchHelper.RIGHT or ItemTouchHelper.LEFT){
            override fun onMove(
                recyclerView: RecyclerView,
                viewHolder: RecyclerView.ViewHolder,
                target: RecyclerView.ViewHolder
            ): Boolean {
                return false
            }

            override fun onSwiped(viewHolder: RecyclerView.ViewHolder, direction: Int) {
                myAdapter.removeItem(viewHolder.adapterPosition, myDbManager)
            }
        })
    }
}