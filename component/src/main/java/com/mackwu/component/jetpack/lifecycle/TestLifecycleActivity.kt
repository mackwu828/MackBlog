package com.mackwu.component.jetpack.lifecycle

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.mackwu.component.R

/**
 * ===================================================
 * Created by MackWu on 2019/12/23 19:09
 * <a href="mailto:wumengjiao828@163.com">Contact me</a>
 * <a href="https://github.com/mackwu828">Follow me</a>
 * ===================================================
 * AppCompatActivity的父类SupportActivity已经实现了LifecycleOwner，创建了lifecycleRegistry
 */
class TestLifecycleActivity : AppCompatActivity(){

    private val lifecycleObserver = MyLifecycleObserver()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_test)
        lifecycle.addObserver(lifecycleObserver)
    }

}