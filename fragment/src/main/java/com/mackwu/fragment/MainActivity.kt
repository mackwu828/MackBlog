package com.mackwu.fragment

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import com.mackwu.fragment.tag.TagActivity
import com.mackwu.fragment.fm.FmActivity
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // fragment
        btn_tag.setOnClickListener { startActivity(Intent(this, TagActivity::class.java)) }
        btn_fm.setOnClickListener { startActivity(Intent(this, FmActivity::class.java)) }
    }
}