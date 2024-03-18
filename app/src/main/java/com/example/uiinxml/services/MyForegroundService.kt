package com.example.uiinxml.services

import android.annotation.SuppressLint
import android.app.NotificationChannel
import android.app.NotificationManager
import android.app.Service
import android.content.Context
import android.content.Intent
import android.os.Build
import android.os.IBinder
import android.util.Log
import androidx.core.app.NotificationCompat
import com.example.uiinxml.R


class MyForegroundService : Service() {

    override fun onBind(intent: Intent?): IBinder? = null

    override fun onCreate() {
        super.onCreate()
        debugLog("onCreate")
    }

    @SuppressLint("ForegroundServiceType")
    override fun onStartCommand(intent: Intent?, flags: Int, startId: Int): Int {

        createNotificationChannel()

        val notification = NotificationCompat.Builder(this, CHANNEL_ID)
            .setSmallIcon(R.mipmap.ic_launcher)
            .setContentTitle("My notification")
            .setContentText("Hello World!")
            .setPriority(NotificationCompat.PRIORITY_DEFAULT)
            .build()

        // quan trong
        startForeground(  
            NOTIFICATION_ID,
            notification
        )

        val actionExtra = intent?.getStringExtra(ACTION_EXTRA_KEY)
        debugLog("onStartCommand actionExtra=$actionExtra -- intent=$intent")

        when (actionExtra) {
            "START" -> {

            }

            "STOP" -> {

            }

            null -> {}
            else -> {}
        }

        return START_NOT_STICKY
    }

    override fun onDestroy() {
        super.onDestroy()
        debugLog("onDestroy")
    }

    private fun debugLog(message: String) {
        Log.d("MyForegroundService", "${hashCode()}: $message")
    }

    private fun createNotificationChannel() {
        // Create the NotificationChannel, but only on API 26+ because
        // the NotificationChannel class is not in the Support Library.
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            val name = getString(R.string.channel_name)
            val descriptionText = getString(R.string.channel_description)
            val importance = NotificationManager.IMPORTANCE_DEFAULT
            val channel: NotificationChannel = NotificationChannel(CHANNEL_ID, name, importance).apply {
                description = descriptionText
            }

            // Register the channel with the system.
            val notificationManager: NotificationManager =
                getSystemService(Context.NOTIFICATION_SERVICE) as NotificationManager
            notificationManager.createNotificationChannel(channel)
        }
    }

    companion object {
        const val NOTIFICATION_ID = 100
        const val CHANNEL_ID = "demo_service_channel"
        const val ACTION_EXTRA_KEY = "action"
    }
}