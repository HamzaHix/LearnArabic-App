package com.hixcoder.learnarabic

import android.media.MediaPlayer
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.view.WindowManager.LayoutParams.*
import kotlinx.android.synthetic.main.iv9_months.*

class iv9_months : AppCompatActivity() {

    var imagelist1 = arrayOf(
        R.drawable.e1,R.drawable.e2,R.drawable.e3,
        R.drawable.e4,R.drawable.e5,R.drawable.e6,
        R.drawable.e7,R.drawable.e8,R.drawable.e9,
        R.drawable.e10,R.drawable.e11,R.drawable.e12)

    var mindex:Int? = null

    var soundlist9 = arrayOf(
        R.raw.e1,R.raw.e2,R.raw.e3,R.raw.e4,
        R.raw.e5,R.raw.e6,R.raw.e7,R.raw.e8,
        R.raw.e9,R.raw.e10,R.raw.e11,R.raw.e12)

    private lateinit var mp9:MediaPlayer

    // fun: OnCreate
    override fun onCreate(savedInstanceState: Bundle?) {
        window.setFlags(FLAG_FULLSCREEN, FLAG_FULLSCREEN)
        super.onCreate(savedInstanceState)
        setContentView(R.layout.iv9_months)

        mindex = 0
    }

    // fun: ButtonAction
    fun ButtonAction9(view: View)
    {

        when(view)
        {
            // button back
            iv1_months ->
            {
                try
                {
                    mp9.pause()
                    mindex = mindex!! - 1
                    iv2_months.setImageResource(imagelist1[mindex!!])
                }catch (ex:Exception)
                {
                    mindex = 11
                    iv2_months.setImageResource(imagelist1[mindex!!])
                }
            }
            // button image view for picture
            iv2_months ->
            {
                mp9 = MediaPlayer.create(this,soundlist9[mindex!!])
                mp9.isLooping = false
                mp9.setVolume(0.5f,0.5f)

                if (mp9.isPlaying)
                {
                    //stop
                    mp9.pause()
                }else
                {
                    //star
                    mp9.start()
                }
            }
            // button next
            iv3_months ->
            {
                try
                {
                    mp9.pause()
                    mindex = mindex!! + 1
                    iv2_months.setImageResource(imagelist1[mindex!!])
                }catch (ex:Exception)
                {
                    mindex = 0
                    iv2_months.setImageResource(imagelist1[mindex!!])
                }
            }
            // button home : return to main activity
            iv4_months ->
            {
                mp9.pause()
                finish()
            }
        }
    }
}
