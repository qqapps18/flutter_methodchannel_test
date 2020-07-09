package com.qqapps.flutter_methodchannel_test

import androidx.annotation.NonNull
import com.qqapps.flutter_methodchannel_test.HebrewDate.HebrewDate
import io.flutter.embedding.android.FlutterActivity
import io.flutter.embedding.engine.FlutterEngine
import io.flutter.plugin.common.MethodChannel
import io.flutter.plugins.GeneratedPluginRegistrant
import java.text.DateFormat

import java.text.SimpleDateFormat

import java.util.Calendar

import java.util.Date


class MainActivity : FlutterActivity() {

    private var jodesh: String? = null
    private var yom = 0
    private var shana = 0
    private var yomview: String? = null


    override fun configureFlutterEngine(@NonNull flutterEngine: FlutterEngine) {
        GeneratedPluginRegistrant.registerWith(flutterEngine);

        val date = HebrewDate()
        yomview = date.getHebrewDateAsString()
        yom = HebrewDate.CURRENT_HDAY
        jodesh = HebrewDate.CURRENT_HMONTH
        shana = HebrewDate.CURRENT_HYEAR
        println("esto deberia ser la fecha")
        println(date)
        println(yom)
        println(jodesh)
        println(shana)
        println(yomview)
        println("*************************")


        MethodChannel(flutterEngine.dartExecutor, "flutter/MethodChannelDemo").setMethodCallHandler { call, result ->
            if (call.method == "Documents") {
                val name = call.arguments as String
                result.success(sayHello(date.toString()))

            }
        }
    }

    fun sayHello(name: String): String {
        return "The date $name came from Android"
    }
}