package com.azim.homeworkdialog

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
                binding.root, "Test",Snackbar.LENGTH_LONG).setAction("OK"){}.show()
        }

        binding.alerButton.setOnClickListener {
            val builder = AlertDialog.Builder(this)
            builder.setTitle("Android Alert")
            builder.setMessage("We have a new message")

            // builder set positiveButton
            builder.setPositiveButton(android.R.string.yes) {dialog,which ->
                Toast.makeText(applicationContext,android.R.string.yes,Toast.LENGTH_SHORT).show()
            }
            // builder set negativeButton
            builder.setNegativeButton(android.R.string.no) {dialog,which ->
                Toast.makeText(applicationContext,android.R.string.no,Toast.LENGTH_SHORT).show()
            }
            // builder set neutralButton
            builder.setNeutralButton("Maybe") {dialog,which ->
                Toast.makeText(applicationContext,"Maybe",Toast.LENGTH_SHORT).show()
            }
            // Show AlertDialog
            builder.show()
        }

        binding.NotificationButton.setOnClickListener {
            Toast.makeText(this,"Notification Button",Toast.LENGTH_SHORT).show()
        }

        binding.webviewButton.setOnClickListener {
            Toast.makeText(this,"Webview Button",Toast.LENGTH_SHORT).show()
        }
    }
}