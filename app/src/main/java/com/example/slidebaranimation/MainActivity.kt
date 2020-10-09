package com.example.slidebaranimation

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.SeekBar
import android.widget.TextView
import android.widget.Toast

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val tv1 = findViewById<TextView>(R.id.tv1)
        val tv2 = findViewById<TextView>(R.id.tv1)
        val sb = findViewById<SeekBar>(R.id.sbb)
        sb.setOnSeekBarChangeListener(object : SeekBar.OnSeekBarChangeListener {

            override fun onStopTrackingTouch(seekBar: SeekBar) {
                if (seekBar.progress < 100) {
                    Toast.makeText(applicationContext,"Try Again",Toast.LENGTH_SHORT).show()
                    seekBar.progress = 0
                }
            }

            override fun onProgressChanged(seekBar: SeekBar, progress: Int,
                                           fromUser: Boolean) {
                if(progress < 100){
                    tv1.text = "Progress : $progress"
                }
                if(progress == 100){
                    startActivity(Intent(applicationContext,MainActivity2::class.java))
                }
            }

            override fun onStartTrackingTouch(p0: SeekBar?) {
                TODO("Not yet implemented")
            }
        })
    }
}