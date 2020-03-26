package com.hixcoder.learnarabic

import android.media.MediaPlayer
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.view.WindowManager.LayoutParams.*
import com.hixcoder.learnarabic.iv1_color
import com.hixcoder.learnarabic.iv2_numbers
import kotlinx.android.synthetic.main.iv1_color.*
import kotlinx.android.synthetic.main.iv2_numbers.*

class iv1_color : AppCompatActivity() {

    var imagelist1 = arrayOf(
        R.drawable.k1,R.drawable.k2,R.drawable.k3,
        R.drawable.k4,R.drawable.k5,R.drawable.k6,
        R.drawable.k7,R.drawable.k8,R.drawable.k9,R.drawable.k10)

    var mindex:Int? = null

    var soundlist1 = arrayOf(
        R.raw.k1,R.raw.k2,R.raw.k3,R.raw.k4,
        R.raw.k5,R.raw.k6,R.raw.k7,R.raw.k8,
        R.raw.k9,R.raw.k10)

    private lateinit var mp1:MediaPlayer

    // fun: OnCreate
    override fun onCreate(savedInstanceState: Bundle?) {
        window.setFlags(FLAG_FULLSCREEN, FLAG_FULLSCREEN)
        super.onCreate(savedInstanceState)
        setContentView(R.layout.iv1_color)

        mindex = 0

    }

    // fun: ButtonAction
    fun ButtonAction3(view: View)
    {

        when(view)
        {
            // button back
            iv1_color ->
            {
                try
                {
                    mp1.pause()
                    mindex = mindex!! - 1
                    iv2_color.setImageResource(imagelist1[mindex!!])
                }catch (ex:Exception)
                {
                    mindex = 9
                    iv2_color.setImageResource(imagelist1[mindex!!])
                }
            }
            // button image view for picture
            iv2_color ->
            {
                mp1 = MediaPlayer.create(this,soundlist1[mindex!!])
                mp1.isLooping = false
                mp1.setVolume(0.5f,0.5f)

                if (mp1.isPlaying)
                {
                    //stop
                    mp1.pause()
                }else
                {
                    //star
                    mp1.start()
                }
            }
            // button next
            iv3_color ->
            {
                try
                {
                    mp1.pause()
                    mindex = mindex!! + 1
                    iv2_color.setImageResource(imagelist1[mindex!!])
                }catch (ex:Exception)
                {
                    mindex = 0
                    iv2_color.setImageResource(imagelist1[mindex!!])
                }
            }
            // button home : return to main activity
            iv4_color ->
            {
                mp1.pause()
                finish()
            }
        }
    }
}
