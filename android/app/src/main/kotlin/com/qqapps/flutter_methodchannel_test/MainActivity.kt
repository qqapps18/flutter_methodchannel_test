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
    var listdates = Array<String> (4) {""}
    var name = Array<String> (4) {""}



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

        listdates[0] = yom.toString()
        listdates[1] = jodesh.toString()
        listdates[2] = shana.toString()
        listdates[3] = yomview.toString()

        for (element in listdates) {
            println(element)
        }




        MethodChannel(flutterEngine.dartExecutor, "flutter/MethodChannelDemo").setMethodCallHandler { call, result ->
            if (call.method == "Documents") {
                name = call.arguments as Array<String>
/*                result.success(sayHello(name))*/
                result.success(return@setMethodCallHandler)

            }
        }
    }

    private fun sayHello(name: Array<String>): Array<String> {
        name[0] = listdates[0]
        name[1] = listdates[1]
        name[2] = listdates[2]
        name[3] = listdates[3]
         for (element in name) {
            println(element)
        }
        return this.name

    }
}