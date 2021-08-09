package com.kc.androidlib

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import com.kc.androidlib.activity.KProgressActivity
import com.kc.androidlib.activity.TextToBitmapActivity
import com.kc.androidlib.toast.Toasty

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        findViewById<View>(R.id.toast_utils).setOnClickListener {
            Toasty.info(MainActivity@this, "1111").show()
        }

        findViewById<View>(R.id.water_anim).setOnClickListener (View.OnClickListener {
            startActivity(Intent(MainActivity@this, KProgressActivity::class.java))
        })

        findViewById<View>(R.id.text_to_bitmap).setOnClickListener (View.OnClickListener {
            startActivity(Intent(MainActivity@this, TextToBitmapActivity::class.java))
        })
    }
}