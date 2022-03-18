package ru.tikodvlp.sqlitekotlin

import android.app.Activity
import android.content.Intent
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.EditText
import android.widget.ImageButton
import android.widget.ImageView
import androidx.constraintlayout.widget.ConstraintLayout
import ru.tikodvlp.sqlitekotlin.db.MyDbManager
import ru.tikodvlp.sqlitekotlin.db.MyIntentConstants

class EditActivity : AppCompatActivity() {

    val imageRequestCode = 10
    var tempImageUri = "empty"
    val myDbManager = MyDbManager(this)

    lateinit var mainImageLayout:ConstraintLayout
    lateinit var fbAddImage:ImageButton
    lateinit var imButtonDeleteImage:ImageButton
    lateinit var imButtonEditImage:ImageButton
    lateinit var imMainImage:ImageView
    lateinit var edTitle:EditText
    lateinit var edDesc:EditText

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_edit)

        getMyIntents()

        mainImageLayout = findViewById(R.id.mainImageLayout)
        fbAddImage = findViewById(R.id.fbAddImage)
        imButtonDeleteImage = findViewById(R.id.imButtonDeleteImage)
        imButtonEditImage = findViewById(R.id.imButtonEditImage)
        imMainImage = findViewById(R.id.imMainImage)
        edTitle = findViewById(R.id.edTitle)
        edDesc = findViewById(R.id.edDesc)
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        if(resultCode == Activity.RESULT_OK && requestCode == imageRequestCode) {
            imMainImage.setImageURI(data?.data)
            tempImageUri = data?.data.toString()
            contentResolver.takePersistableUriPermission(data?.data!!, Intent.FLAG_GRANT_READ_URI_PERMISSION)
        }
    }

    fun onClickAddImage(view: View) {
        mainImageLayout.visibility = View.VISIBLE
        fbAddImage.visibility = View.GONE
    }

    fun onClickDeleteImage(view: View) {
        mainImageLayout.visibility = View.GONE
        fbAddImage.visibility = View.VISIBLE
    }

    fun onClickChooseImage(view: View) {
        val intent = Intent(Intent.ACTION_OPEN_DOCUMENT)
        intent.type = "image/*"
        startActivityForResult(intent, imageRequestCode)
    }

    fun onClickSave(view: View) {
        val myTitle = edTitle.text.toString()
        val myDesc = edDesc.text.toString()

        if (myTitle != "" && myDesc != "") {
            myDbManager.insertToDb(myTitle, myDesc, tempImageUri)
            finish()
        }
    }
    override fun onResume() {
        super.onResume()
        myDbManager.openDb()

    }
    override fun onDestroy() {
        super.onDestroy()
        myDbManager.closeDb()
    }

    fun getMyIntents() {
        val i = intent

        if(i != null){
            if (i.getStringExtra(MyIntentConstants.I_TITLE_KEY) != null) {

                fbAddImage.visibility = View.GONE
                edTitle.setText(i.getStringExtra(MyIntentConstants.I_TITLE_KEY))
                edDesc.setText(i.getStringExtra(MyIntentConstants.I_DESC_KEY))

                if(i.getStringExtra(MyIntentConstants.I_URI_KEY) != "empty") {
                    mainImageLayout.visibility = View.VISIBLE
                    imMainImage.setImageURI(Uri.parse(i.getStringExtra(MyIntentConstants.I_URI_KEY)))
                    imButtonDeleteImage.visibility = View.GONE
                    imButtonEditImage.visibility = View.GONE
                }
            }
        }
    }
}