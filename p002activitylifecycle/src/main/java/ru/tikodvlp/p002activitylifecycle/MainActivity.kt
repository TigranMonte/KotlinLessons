package ru.tikodvlp.p002activitylifecycle

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast

class MainActivity : AppCompatActivity() {

    lateinit var myObserver: MyObserver

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        myObserver = MyObserver()
        lifecycle.addObserver(myObserver)
    }

    private fun toastMeState(message: String) {
        Toast.makeText(this, "${lifecycle.currentState}, $message", Toast.LENGTH_LONG).show()
    }

    override fun onStart() {
        super.onStart()
        toastMeState("On_Start")
    }

    override fun onResume() {
        super.onResume()
        toastMeState("On_Resume")
    }

    override fun onPostResume() {
        super.onPostResume()
        toastMeState("On_PostResume")
    }

    override fun onPause() {
        super.onPause()
        toastMeState("On_Pause")
    }

    override fun onStop() {
        super.onStop()
        toastMeState("On_Stop")
    }

    override fun onRestart() {
        super.onRestart()
        toastMeState("On_Restart")
    }

    override fun onDestroy() {
        super.onDestroy()
        toastMeState("On_Destroy")
    }
}