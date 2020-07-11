package com.qqapps.flutter_methodchannel_test

import androidx.annotation.NonNull
import com.qqapps.flutter_methodchannel_test.HebrewDate.HebrewDate
import io.flutter.embedding.android.FlutterActivity
import io.flutter.embedding.engine.FlutterEngine
import io.flutter.plugin.common.MethodChannel
import io.flutter.plugins.GeneratedPluginRegistrant


class MainActivity : FlutterActivity() {

    private var jodesh: String? = null
    private var yom = 0
    private var shana = 0
    private var yomview: String? = null
    var listdates: MutableList<String> = mutableListOf<String>()
    var name: MutableList<String> = mutableListOf<String>()



    override fun configureFlutterEngine(@NonNull flutterEngine: FlutterEngine) {
        super.configureFlutterEngine(flutterEngine)
        GeneratedPluginRegistrant.registerWith(flutterEngine)

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

        listdates.add(yom.toString())
        listdates.add(jodesh.toString())
        listdates.add(shana.toString())
        listdates.add(yomview.toString())

        for (element in listdates) {
            println(element)
        }

        MethodChannel(flutterEngine.dartExecutor.binaryMessenger, "flutter/MethodChannelDemo").setMethodCallHandler { call, result ->
            if (call.method == "Documents") {
                result.success(listdates)
            } else {
                result.notImplemented()
            }
        }
    }

    private fun sayHello(name: MutableList<String>): MutableList<String> {
        name.add(listdates[0])
        name.add(listdates[1])
        name.add(listdates[2])
        name.add(listdates[3])
         for (element in name) {
            println(element)
        }
        return this.name

    }
}