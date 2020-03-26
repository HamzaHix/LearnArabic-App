package com.hixcoder.learnarabic

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.WindowManager.LayoutParams.*

class iv7_searchplay : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        window.setFlags(FLAG_FULLSCREEN, FLAG_FULLSCREEN)
        super.onCreate(savedInstanceState)
        setContentView(R.layout.iv7_searchplay)
    }
}
