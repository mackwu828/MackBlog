package com.mackwu.http.jetpack.lifecycle

import android.app.Activity
import android.arch.lifecycle.Lifecycle
import android.arch.lifecycle.LifecycleOwner
import android.arch.lifecycle.LifecycleRegistry
import android.os.Bundle
import com.mackwu.http.R

/**
 * ===================================================
 * Created by MackWu on 2019/12/23 19:26
 * <a href="mailto:wumengjiao828@163.com">Contact me</a>
 * <a href="https://github.com/mackwu828">Follow me</a>
 * ===================================================
 */
class LifecycleActivity : Activity(), LifecycleOwner {

    private val lifecycleRegistry = LifecycleRegistry(this)
    private val myLifecycleObserver = MyLifecycleObserver()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        lifecycleRegistry.markState(Lifecycle.State.CREATED)
        lifecycleRegistry.addObserver(myLifecycleObserver)
    }

    override fun onStart() {
        super.onStart()
        lifecycleRegistry.markState(Lifecycle.State.STARTED)
    }

    override fun onDestroy() {
        super.onDestroy()
        lifecycleRegistry.removeObserver(myLifecycleObserver)
    }

    override fun getLifecycle(): Lifecycle {
        return lifecycleRegistry
    }
}