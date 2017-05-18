package ru.mrtnv.max.happybirthdayrob

import android.app.Application
import uk.co.chrisjenx.calligraphy.CalligraphyConfig

class KyanApplication : Application() {


    override fun onCreate() {
        super.onCreate()

        CalligraphyConfig.initDefault(CalligraphyConfig.Builder()
                .setDefaultFontPath("fonts/text.ttf")
                .setFontAttrId(R.attr.fontPath)
                .build())
    }
}
