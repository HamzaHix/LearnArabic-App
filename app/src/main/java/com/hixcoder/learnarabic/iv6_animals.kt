package com.hixcoder.learnarabic

import android.media.MediaPlayer
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.view.WindowManager.LayoutParams.*
import kotlinx.android.synthetic.main.iv6_animals.*

class iv6_animals : AppCompatActivity() {

    var imagelist1 = arrayOf(
        R.drawable.g1,R.drawable.g2,R.drawable.g3,
        R.drawable.g4,R.drawable.g5,R.drawable.g6,
        R.drawable.g7,R.drawable.g8,R.drawable.g9,
        R.drawable.g10,R.drawable.g11,R.drawable.g12,
        R.drawable.g13,R.drawable.g14,R.drawable.g15,
        R.drawable.g16,R.drawable.g17,R.drawable.g18,
        R.drawable.g19,R.drawable.g20,R.drawable.g21,
        R.drawable.g22,R.drawable.g23)

    var mindex:Int? = null

    var soundlist6 = arrayOf(
        R.raw.g1,R.raw.g2,R.raw.g3,R.raw.g4,R.raw.g5,
        R.raw.g6,R.raw.g7,R.raw.g8,R.raw.g9,R.raw.g10,
        R.raw.g11,R.raw.g12,R.raw.g13,R.raw.g14,R.raw.g15,
        R.raw.g16,R.raw.g17,R.raw.g18,R.raw.g19,R.raw.g20,
        R.raw.g21,R.raw.g22,R.raw.g23)

    private lateinit var mp6:MediaPlayer

    // fun: OnCreate
    override fun onCreate(savedInstanceState: Bundle?) {
        window.setFlags(FLAG_FULLSCREEN, FLAG_FULLSCREEN)
        super.onCreate(savedInstanceState)
        setContentView(R.layout.iv6_animals)

        mindex = 0

    }

    // fun: ButtonAction
    fun ButtonAction6(view: View)
    {

        when(view)
        {
            // button back
            iv1_animals ->
            {
                try
                {
                    mp6.pause()
                    mindex = mindex!! - 1
                    iv2_animals.setImageResource(imagelist1[mindex!!])
                }catch (ex:Exception)
                {
                    mindex = 22
                    iv2_animals.setImageResource(imagelist1[mindex!!])
                }
            }
            // button image view for picture
            iv2_animals ->
            {
                mp6 = MediaPlayer.create(this,soundlist6[mindex!!])
                mp6.isLooping = false
                mp6.setVolume(0.5f,0.5f)

                if (mp6.isPlaying)
                {
                    //stop
                    mp6.pause()
                }else
                {
                    //star
                    mp6.start()
                }
            }
            // button next
            iv3_animals ->
            {
                try
                {
                    mp6.pause()
                    mindex = mindex!! + 1
                    iv2_animals.setImageResource(imagelist1[mindex!!])
                }catch (ex:Exception)
                {
                    mindex = 0
                    iv2_animals.setImageResource(imagelist1[mindex!!])
                }
            }
            // button home : return to main activity
            iv4_animals ->
            {
                mp6.pause()
                finish()
            }
        }
    }
}
