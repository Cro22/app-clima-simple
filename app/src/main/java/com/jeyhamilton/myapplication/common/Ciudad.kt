package com.jeyhamilton.myapplication.common

import com.jeyhamilton.myapplication.common.api.Main
import com.jeyhamilton.myapplication.common.api.Wheater

class Ciudad(name: String, weather:ArrayList<Wheater>, main: Main) {
    var name: String = ""
    var weather: ArrayList<Wheater>? = null
    var main: Main? = null

    init {
        this.name = name
        this.weather = weather
        this.main = main
    }
}