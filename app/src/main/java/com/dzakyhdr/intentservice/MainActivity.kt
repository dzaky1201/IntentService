package com.dzakyhdr.intentservice

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        btnStartService.setOnClickListener {
            Intent(this, MyService::class.java).also {
                startService(it)
                tvServiceInfo.text = "Service berjalan"
            }
        }

        btnStopService.setOnClickListener {
            Intent(this, MyService::class.java).also {
                stopService(it)
                tvServiceInfo.text = "Service Berhenti"
            }

        }

        btnSendData.setOnClickListener {
            Intent(this, MyService::class.java).also {
                val stringData = etText.text.toString()
                it.putExtra("EXTRA_DATA", stringData)
                startService(it)

            }

        }
    }
}