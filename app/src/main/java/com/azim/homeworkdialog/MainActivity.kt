package com.azim.homeworkdialog

import android.app.Notification
import android.app.NotificationChannel
import android.app.NotificationManager
import android.graphics.Color
import android.os.Build
import android.os.Bundle
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.azim.homeworkdialog.databinding.ActivityMainBinding
import com.google.android.material.snackbar.Snackbar

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        val view =binding.root
        setContentView(view)

        binding.snackbarButton.setOnClickListener {
            Snackbar.make(
                binding.root, "Snackbar Notification, thank you",Snackbar.LENGTH_LONG).setAction("OK"){}.show()
        }

        binding.alerButton.setOnClickListener {
            val builder = AlertDialog.Builder(this)
            builder.setTitle("Android Alert")
            builder.setMessage("You have a new message")

            // builder set positiveButton
            builder.setPositiveButton(android.R.string.yes) {dialog,which ->
                Toast.makeText(applicationContext,android.R.string.yes,Toast.LENGTH_SHORT).show()
            }
            // builder set negativeButton
            builder.setNegativeButton(android.R.string.no) {dialog,which ->
                Toast.makeText(applicationContext,android.R.string.no,Toast.LENGTH_SHORT).show()
            }
            // builder set neutralButton
            builder.setNeutralButton("Remind Later") {dialog,which ->
                Toast.makeText(applicationContext,"Remind Later",Toast.LENGTH_SHORT).show()
            }
            // Show AlertDialog
            builder.show()
        }

        binding.NotificationButton.setOnClickListener {
            if(Build.VERSION.SDK_INT >= Build.VERSION_CODES.O){
                val channel_id = "Channel01"
                val channel_Name = "notification"
                val importance = NotificationManager.IMPORTANCE_DEFAULT
                val mChannel = NotificationChannel(channel_id,channel_Name,importance)

                mChannel.description = "Test Description"
                mChannel.enableLights(true)
                mChannel.lightColor = Color.RED
                mChannel.enableVibration(true)

                // Use notification.Builder to add the notification objects
                val notification:Notification = Notification.Builder(this,channel_id)
                    .setSmallIcon(R.drawable.ic_launcher_background)
                    .setContentTitle("Android Notification")
                    .setContentText("Check Android ATC New Course !!")
                    .build()

                // Register or add the channel with your Android system
                val mNotificationManager = getSystemService(NOTIFICATION_SERVICE) as NotificationManager

                if(mNotificationManager != null) {
                    mNotificationManager.createNotificationChannel(mChannel)

                    // Show the notification
                    mNotificationManager.notify(1,notification)
                }
            }


            // Toast.makeText(this,"Notification Button",Toast.LENGTH_SHORT).show()
        }

        binding.webviewButton.setOnClickListener {
            Toast.makeText(this,"Webview Button",Toast.LENGTH_SHORT).show()
        }
    }
}