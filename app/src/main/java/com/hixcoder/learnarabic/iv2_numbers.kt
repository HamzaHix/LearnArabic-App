package com.hixcoder.learnarabic

import android.media.MediaPlayer
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.view.WindowManager.LayoutParams.*
import android.view.animation.AnimationUtils
import kotlinx.android.synthetic.main.iv2_numbers.*
import kotlinx.android.synthetic.main.iv3_alphabet.*

class iv2_numbers : AppCompatActivity() {

    var imagelist1 = arrayOf(
        R.drawable.n0,
        R.drawable.n1,R.drawable.n2,R.drawable.n3,
        R.drawable.n4,R.drawable.n5,R.drawable.n6,
        R.drawable.n7,R.drawable.n8,R.drawable.n9)

    var mindex:Int? = null

    var soundlist2 = arrayOf(
        R.raw.n0, R.raw.n1, R.raw.n2, R.raw.n3,
        R.raw.n4, R.raw.n5, R.raw.n6, R.raw.n7,
        R.raw.n8, R.raw.n9)

    private lateinit var mp2:MediaPlayer

    // fun: OnCreate
    override fun onCreate(savedInstanceState: Bundle?) {
        window.setFlags(FLAG_FULLSCREEN, FLAG_FULLSCREEN)
        super.onCreate(savedInstanceState)
        setContentView(R.layout.iv2_numbers)

        mindex = 0
    }

    // fun: ButtonAction
    fun ButtonAction2(view: View)
    {

        when(view)
        {
            // button back
            iv1_numbers ->
            {
                try
                {
                    mp2.pause()
                    mindex = mindex!! - 1
                    iv2_numbers.setImageResource(imagelist1[mindex!!])
                }catch (ex:Exception)
                {
                    mindex = 9
                    iv2_numbers.setImageResource(imagelist1[mindex!!])
                }
            }
            // button image view for picture
            iv2_numbers ->
            {
                mp2 = MediaPlayer.create(this,soundlist2[mindex!!])
                mp2.isLooping = false
                mp2.setVolume(0.5f,0.5f)

                if (mp2.isPlaying)
                {
                    //stop
                    mp2.pause()
                }else
                {
                    //star
                    mp2.start()
                }
            }
            // button next
            iv3_numbers ->
            {
                try
                {
                    mp2.pause()
                    mindex = mindex!! + 1
                    iv2_numbers.setImageResource(imagelist1[mindex!!])
                }catch (ex:Exception)
                {
                    mindex = 0
                    iv2_numbers.setImageResource(imagelist1[mindex!!])
                }
            }
            // button home : return to main activity
            iv4_numbers ->
            {
                mp2.pause()
                finish()
            }
        }
    }
}
