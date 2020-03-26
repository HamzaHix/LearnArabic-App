package com.hixcoder.learnarabic

import android.media.MediaPlayer
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.view.WindowManager.LayoutParams.*
import kotlinx.android.synthetic.main.iv5_vegetable.*
import kotlinx.android.synthetic.main.iv8_days.*

class iv8_days : AppCompatActivity() {

    var imagelist1 = arrayOf(
        R.drawable.d1,R.drawable.d2,R.drawable.d3,
        R.drawable.d4,R.drawable.d5,R.drawable.d6,
        R.drawable.d7)

    var mindex:Int? = null

    var soundlist8 = arrayOf(
        R.raw.d1,R.raw.d2,R.raw.d3,
        R.raw.d4,R.raw.d5,R.raw.d6,
        R.raw.d7)

    private lateinit var mp8:MediaPlayer

    // fun: OnCreate
    override fun onCreate(savedInstanceState: Bundle?) {
        window.setFlags(FLAG_FULLSCREEN, FLAG_FULLSCREEN)
        super.onCreate(savedInstanceState)
        setContentView(R.layout.iv8_days)

        mindex = 0
    }

    // fun: ButtonAction
    fun ButtonAction8(view: View)
    {

        when(view)
        {
            // button back
            iv1_days ->
            {
                try
                {
                    mp8.pause()
                    mindex = mindex!! - 1
                    iv2_days.setImageResource(imagelist1[mindex!!])
                }catch (ex:Exception)
                {
                    mindex = 6
                    iv2_days.setImageResource(imagelist1[mindex!!])
                }
            }
            // button image view for picture
            iv2_days ->
            {
                mp8 = MediaPlayer.create(this,soundlist8[mindex!!])
                mp8.isLooping = false
                mp8.setVolume(0.5f,0.5f)

                if (mp8.isPlaying)
                {
                    //stop
                    mp8.pause()
                }else
                {
                    //star
                    mp8.start()
                }

            }
            // button next
            iv3_days ->
            {
                try
                {
                    mp8.pause()
                    mindex = mindex!! + 1
                    iv2_days.setImageResource(imagelist1[mindex!!])
                }catch (ex:Exception)
                {
                    mindex = 0
                    iv2_days.setImageResource(imagelist1[mindex!!])
                }
            }
            // button home : return to main activity
            iv4_days ->
            {
                mp8.pause()
                finish()
            }
        }
    }
}
