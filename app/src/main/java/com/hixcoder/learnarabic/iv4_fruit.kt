package com.hixcoder.learnarabic

import android.media.MediaPlayer
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.view.WindowManager.LayoutParams.*
import kotlinx.android.synthetic.main.iv4_fruit.*

class iv4_fruit : AppCompatActivity() {

    var imagelist1 = arrayOf(
        R.drawable.b1,R.drawable.b2,R.drawable.b3,
        R.drawable.b4,R.drawable.b5,R.drawable.b6,
        R.drawable.b7,R.drawable.b8,R.drawable.b9,
        R.drawable.b10,R.drawable.b11,R.drawable.b12,R.drawable.b13)

    var mindex:Int? = null

    var soundlist4 = arrayOf(
        R.raw.b1, R.raw.b2, R.raw.b3, R.raw.b4,
        R.raw.b5, R.raw.b6, R.raw.b7, R.raw.b8,
        R.raw.b9, R.raw.b10, R.raw.b11, R.raw.b12,
        R.raw.b13)

    private lateinit var mp4:MediaPlayer

    // fun: OnCreate
    override fun onCreate(savedInstanceState: Bundle?) {
        window.setFlags(FLAG_FULLSCREEN, FLAG_FULLSCREEN)
        super.onCreate(savedInstanceState)
        setContentView(R.layout.iv4_fruit)

        mindex = 0
    }

    // fun: ButtonAction
    fun ButtonAction4(view: View)
    {

        when(view)
        {
            // button back
            iv1_fruit ->
            {
                try
                {
                    mp4.pause()
                    mindex = mindex!! - 1
                    iv2_fruit.setImageResource(imagelist1[mindex!!])
                }catch (ex:Exception)
                {
                    mindex = 12
                    iv2_fruit.setImageResource(imagelist1[mindex!!])
                }
            }
            // button image view for picture
            iv2_fruit ->
            {
                mp4 = MediaPlayer.create(this,soundlist4[mindex!!])
                mp4.isLooping = false
                mp4.setVolume(0.5f,0.5f)

                if (mp4.isPlaying)
                {
                    //stop
                    mp4.pause()
                }else
                {
                    //star
                    mp4.start()
                }

            }
            // button next
            iv3_fruit ->
            {
                try
                {
                    mp4.pause()
                    mindex = mindex!! + 1
                    iv2_fruit.setImageResource(imagelist1[mindex!!])
                }catch (ex:Exception)
                {
                    mindex = 0
                    iv2_fruit.setImageResource(imagelist1[mindex!!])
                }
            }
            // button home : return to main activity
            iv4_fruit ->
            {
                mp4.pause()
                finish()
            }
        }
    }
}
