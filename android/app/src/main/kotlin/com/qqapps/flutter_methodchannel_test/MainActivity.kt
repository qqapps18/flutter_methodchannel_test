package com.qqapps.flutter_methodchannel_test

import android.widget.TextView
import androidx.annotation.NonNull
import com.qqapps.flutter_methodchannel_test.HebrewDate.HebrewDate
import io.flutter.embedding.android.FlutterActivity
import io.flutter.embedding.engine.FlutterEngine
import io.flutter.plugin.common.MethodChannel
import io.flutter.plugins.GeneratedPluginRegistrant


class MainActivity : FlutterActivity() {

    private val jodesh: String? = null
    private val yom = 0
    private val shana = 0
    private val yomview: String? = null




    override fun configureFlutterEngine(@NonNull flutterEngine: FlutterEngine) {
        GeneratedPluginRegistrant.registerWith(flutterEngine);

        val date = HebrewDate()
        if (yomview != null) {
            val yomview = date.getHebrewDateAsString()
        }
        
        
        MethodChannel(flutterEngine.dartExecutor, "flutter/MethodChannelDemo").setMethodCallHandler { call, result ->
            if (call.method == "Documents") {
                val name = call.arguments as String
                result.success(sayHello(yomview.toString()))
                
            }
        }
    }
    fun sayHello(name: String): String {
        return "Hi $name from Android"
    }
}