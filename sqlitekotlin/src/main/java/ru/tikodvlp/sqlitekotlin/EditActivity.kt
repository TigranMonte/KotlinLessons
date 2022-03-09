package ru.tikodvlp.sqlitekotlin

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.ImageButton
import androidx.constraintlayout.widget.ConstraintLayout

class EditActivity : AppCompatActivity() {

    lateinit var mainImageLayout:ConstraintLayout
    lateinit var fbAddImage:ImageButton
    lateinit var imButtonDeleteImage:ImageButton

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_edit)

        mainImageLayout = findViewById(R.id.mainImageLayout)
        fbAddImage = findViewById(R.id.fbAddImage)
        imButtonDeleteImage = findViewById(R.id.imButtonDeleteImage)
    }

    fun onClickAddImage(view: View) {
        mainImageLayout.visibility = View.VISIBLE
        fbAddImage.visibility = View.GONE
    }

    fun onClickDeleteImage(view: View) {
        mainImageLayout.visibility = View.GONE
        fbAddImage.visibility = View.VISIBLE
    }
}