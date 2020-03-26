package com.hixcoder.learnarabic

import android.content.Intent
import android.media.MediaPlayer
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.LinearLayout
import kotlinx.android.synthetic.main.iv3_alphabet.*
import android.view.WindowManager.LayoutParams.*
import android.view.animation.Animation
import android.view.animation.AnimationUtils
import android.widget.ImageView

class iv3_alphabet : AppCompatActivity() {

    var imagelist1 = arrayOf(
        R.drawable.a1,R.drawable.a2,R.drawable.a3,
        R.drawable.a4,R.drawable.a5,R.drawable.a6,
        R.drawable.a7,R.drawable.a8,R.drawable.a9,
        R.drawable.a10,R.drawable.a11,R.drawable.a12,
        R.drawable.a13,R.drawable.a14,R.drawable.a15,
        R.drawable.a16,R.drawable.a17,R.drawable.a18,
        R.drawable.a19,R.drawable.a20,R.drawable.a21,
        R.drawable.a22,R.drawable.a23,R.drawable.a24,
        R.drawable.a25,R.drawable.a26,R.drawable.a27,
        R.drawable.a28
    )
    var imagelist2 = arrayOf(
        R.drawable.alphabe_ar_1,R.drawable.alphabe_ar_2,R.drawable.alphabe_ar_3,
        R.drawable.alphabe_ar_4,R.drawable.alphabe_ar_5,R.drawable.alphabe_ar_6,
        R.drawable.alphabe_ar_7,R.drawable.alphabe_ar_8,R.drawable.alphabe_ar_9,
        R.drawable.alphabe_ar_10,R.drawable.alphabe_ar_11,R.drawable.alphabe_ar_12,
        R.drawable.alphabe_ar_13,R.drawable.alphabe_ar_14,R.drawable.alphabe_ar_15,
        R.drawable.alphabe_ar_16,R.drawable.alphabe_ar_17,R.drawable.alphabe_ar_18,
        R.drawable.alphabe_ar_19,R.drawable.alphabe_ar_20,R.drawable.alphabe_ar_21,
        R.drawable.alphabe_ar_22, R.drawable.alphabe_ar_23,R.drawable.alphabe_ar_24,
        R.drawable.alphabe_ar_25,R.drawable.alphabe_ar_26,R.drawable.alphabe_ar_27,
        R.drawable.alphabe_ar_28
    )

    var mindex:Int? = null

    var soundlist3 = arrayOf(
        R.raw.a1,R.raw.a2,R.raw.a3,R.raw.a4,R.raw.a5,R.raw.a6,
        R.raw.a7,R.raw.a8,R.raw.a9,R.raw.a10,R.raw.a11,R.raw.a12,
        R.raw.a13,R.raw.a14,R.raw.a15,R.raw.a16,R.raw.a17,R.raw.a18,
        R.raw.a19,R.raw.a20,R.raw.a21,R.raw.a22,R.raw.a23,R.raw.a24,
        R.raw.a25,R.raw.a26,R.raw.a27,R.raw.a28)

    private lateinit var mp3:MediaPlayer

    // fun: OnCreate
    override fun onCreate(savedInstanceState: Bundle?) {
        window.setFlags(FLAG_FULLSCREEN, FLAG_FULLSCREEN)
        super.onCreate(savedInstanceState)
        setContentView(R.layout.iv3_alphabet)

        mindex = 0

    }

    // fun: ButtonAction
    fun ButtonAction1(view:View)
    {

        when(view)
        {
            // button back
            iv1_alphabet ->
            {
                try
                {
                    mp3.pause()
                    mindex = mindex!! - 1
                    iv2_alphabet.setImageResource(imagelist1[mindex!!])
                    iv3_alphabet.setImageResource(imagelist2[mindex!!])
                }catch (ex:Exception)
                {
                    mindex = 27
                    iv2_alphabet.setImageResource(imagelist1[mindex!!])
                    iv3_alphabet.setImageResource(imagelist2[mindex!!])
                }
            }
            // button image view for picture
            iv2_alphabet ->
            {
                mp3 = MediaPlayer.create(this,soundlist3[mindex!!])
                mp3.isLooping = false
                mp3.setVolume(0.5f,0.5f)

                if (mp3.isPlaying)
                {
                    //stop
                    mp3.pause()
                }else
                {
                    //star
                    mp3.start()
                }

            }
            // button image view for alphabet
            iv3_alphabet ->
            {
                iv3_alphabet.animate()
                    .rotation(360f)
                    .duration = 1000
            }
            // button next
            iv4_alphabet ->
            {
                try
                {
                    mp3.pause()
                    mindex = mindex!! + 1
                    iv2_alphabet.setImageResource(imagelist1[mindex!!])
                    iv3_alphabet.setImageResource(imagelist2[mindex!!])
                }catch (ex:Exception)
                {
                    mindex = 0
                    iv2_alphabet.setImageResource(imagelist1[mindex!!])
                    iv3_alphabet.setImageResource(imagelist2[mindex!!])
                }
            }
            // button home : return to main activity
            iv5_alphabet ->
            {
                mp3.pause()
                finish()
            }
        }
    }
}
