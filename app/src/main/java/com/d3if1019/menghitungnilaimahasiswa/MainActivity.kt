package com.d3if1019.menghitungnilaimahasiswa

import android.app.NotificationChannel
import android.app.NotificationManager
import android.content.Context
import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.navigation.NavController
import androidx.navigation.findNavController
import androidx.navigation.ui.NavigationUI
import com.d3if1019.menghitungnilaimahasiswa.databinding.FragmentAboutBinding.inflate
import com.d3if1019.menghitungnilaimahasiswa.databinding.FragmentHistoriBinding.inflate

class MainActivity : AppCompatActivity() {

    companion object {
        const val CHANNEL_ID = "updater"
    }

    private lateinit var navController: NavController

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        navController = findNavController(R.id.myNavHostFragment)
        NavigationUI.setupActionBarWithNavController(this, navController)

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            val name = getString(R.string.channel_name)
            val importance = NotificationManager.IMPORTANCE_DEFAULT
            val channel = NotificationChannel(CHANNEL_ID, name, importance)
            channel.description = getString(R.string.channel_desc)
            val manager = getSystemService(Context.NOTIFICATION_SERVICE)
                    as NotificationManager
            manager.createNotificationChannel(channel)
        }

        Log.i("MainActivity", "onCreate dijalankan")
    }

    override fun onStart() {
        super.onStart()
        Log.i("MainActivity", "onStart dijalankan")
    }
    override fun onResume() {
        super.onResume()
        Log.i("MainActivity", "onResume dijalankan")
    }
    override fun onPause() {
        Log.i("MainActivity", "onPause dijalankan")
        super.onPause()
    }
    override fun onStop() {
        Log.i("MainActivity", "onStop dijalankan")
        super.onStop()
    }
    override fun onDestroy() {
        Log.i("MainActivity", "onDestroy dijalankan")
        super.onDestroy()
    }

    override fun onSupportNavigateUp(): Boolean {
        return navController.navigateUp()
    }
}