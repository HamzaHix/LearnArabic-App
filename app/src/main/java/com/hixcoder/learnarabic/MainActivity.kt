package com.hixcoder.learnarabic

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.view.WindowManager.LayoutParams.*
import android.widget.Button
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        window.setFlags(FLAG_FULLSCREEN, FLAG_FULLSCREEN)
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }

    fun ButtonAction(view:View)
    {
        when(view)
        {
            iv1 ->
            {
                var intent1 = Intent("com.hixcoder.iv1_color")
                startActivity(intent1)
            }

            iv2 ->
            {
                var intent2 = Intent("com.hixcoder.iv2_numbers")
                startActivity(intent2)
            }

            iv3 ->
            {
                var intent3 = Intent("com.hixcoder.iv3_alphabet")
                startActivity(intent3)
            }

            iv4 ->
            {
                var intent4 = Intent("com.hixcoder.iv4_fruit")
                startActivity(intent4)
            }

            iv5 ->
            {
                var intent5 = Intent("com.hixcoder.iv5_vegetable")
                startActivity(intent5)
            }

            iv6 ->
            {
                var intent6 = Intent("com.hixcoder.iv6_animals")
                startActivity(intent6)
            }

            iv7 ->
            {
                var intent7 = Intent("com.hixcoder.iv7_searchplay")
                startActivity(intent7)
            }

            iv8 ->
            {
                var intent8 = Intent("com.hixcoder.iv8_days")
                startActivity(intent8)
            }

            iv9 ->
            {
                var intent9 = Intent("com.hixcoder.iv9_months")
                startActivity(intent9)
            }
        }
    }
}
