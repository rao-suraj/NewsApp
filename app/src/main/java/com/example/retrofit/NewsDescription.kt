package com.example.retrofit

import android.media.audiofx.AudioEffect
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_news_discription.*

class NewsDescription : AppCompatActivity() {
    companion object{
        const val NAME_EXTRA="name_extra"
    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_news_discription)

        val Desc = intent.getStringExtra(NAME_EXTRA)
        tvNewsDescription.text=Desc
    }
}