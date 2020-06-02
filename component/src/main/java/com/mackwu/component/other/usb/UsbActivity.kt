package com.mackwu.component.other.usb

import android.hardware.usb.UsbManager
import android.util.Log
import com.mackwu.component.R
import com.mackwu.component.activity.base.BaseActivity
import com.mackwu.component.util.registerReceiver
import com.mackwu.component.util.usbManager
import kotlinx.android.synthetic.main.activity_test.*

/**
 * ===================================================
 * Created by MackWu on 2020/4/22 17:27
 * <a href="mailto:wumengjiao828@163.com">Contact me</a>
 * <a href="https://github.com/mackwu828">Follow me</a>
 * ===================================================
 */
class UsbActivity: BaseActivity() {

    private val usbReceiver = UsbReceiver()

    override val layoutId: Int = R.layout.activity_test

    override fun initView() {
        // register usb Receiver
        registerReceiver(usbReceiver, UsbManager.ACTION_USB_ACCESSORY_ATTACHED, UsbManager.ACTION_USB_ACCESSORY_DETACHED)

        btn_test.setOnClickListener {
            val deviceList = usbManager.deviceList
            for (entry in deviceList) {
                val device = entry.value
                Log.d("TAG", device.toString())
            }
        }
    }

    override fun onDestroy() {
        super.onDestroy()
        unregisterReceiver(usbReceiver)
    }

}