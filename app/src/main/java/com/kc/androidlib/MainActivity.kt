package com.kc.androidlib

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import com.kc.androidlib.toast.Toasty

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        findViewById<View>(R.id.toast_utils).setOnClickListener {
            Toasty.info(MainActivity@this, "1111").show()
        }
    }
}