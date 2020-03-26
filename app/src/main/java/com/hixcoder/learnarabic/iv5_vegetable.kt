package com.hixcoder.learnarabic

import android.media.MediaPlayer
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.view.WindowManager.LayoutParams.*
import kotlinx.android.synthetic.main.iv5_vegetable.*

class iv5_vegetable : AppCompatActivity() {

    var imagelist1 = arrayOf(
        R.drawable.c1,R.drawable.c2,R.drawable.c3,
        R.drawable.c4,R.drawable.c5,R.drawable.c6,
        R.drawable.c7,R.drawable.c8,R.drawable.c9,
        R.drawable.c10,R.drawable.c11)

    var mindex:Int? = null

    var soundlist5 = arrayOf(
        R.raw.c1,R.raw.c2,R.raw.c3,R.raw.c4,
        R.raw.c5,R.raw.c6,R.raw.c7,R.raw.c8,
        R.raw.c9,R.raw.c10,R.raw.c11)

    private lateinit var mp5:MediaPlayer

    // fun: OnCreate
    override fun onCreate(savedInstanceState: Bundle?) {
        window.setFlags(FLAG_FULLSCREEN, FLAG_FULLSCREEN)
        super.onCreate(savedInstanceState)
        setContentView(R.layout.iv5_vegetable)

        mindex = 0
    }

    // fun: ButtonAction
    fun ButtonAction5(view: View)
    {

        when(view)
        {
            // button back
            iv1_vegetable ->
            {
                try
                {
                    mp5.pause()
                    mindex = mindex!! - 1
                    iv2_vegetable.setImageResource(imagelist1[mindex!!])
                }catch (ex:Exception)
                {
                    mindex = 10
                    iv2_vegetable.setImageResource(imagelist1[mindex!!])
                }
            }
            // button image view for picture
            iv2_vegetable ->
            {
                mp5 = MediaPlayer.create(this,soundlist5[mindex!!])
                mp5.isLooping = false
                mp5.setVolume(0.5f,0.5f)

                if (mp5.isPlaying)
                {
                    //stop
                    mp5.pause()
                }else
                {
                    //star
                    mp5.start()
                }

            }
            // button next
            iv3_vegetable ->
            {
                try
                {
                    mp5.pause()
                    mindex = mindex!! + 1
                    iv2_vegetable.setImageResource(imagelist1[mindex!!])
                }catch (ex:Exception)
                {
                    mindex = 0
                    iv2_vegetable.setImageResource(imagelist1[mindex!!])
                }
            }
            // button home : return to main activity
            iv4_vegetable ->
            {
                mp5.pause()
                finish()
            }
        }
    }
}
