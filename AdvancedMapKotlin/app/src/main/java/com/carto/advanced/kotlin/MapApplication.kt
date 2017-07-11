package com.carto.advanced.kotlin;

import android.app.Application;
import com.carto.ui.MapView;



/**
 * Entry point for an android application.
 * One-time actions, such as registering ids, licenses, starting services etc.
 * should be initialized here
 */
class MapApplication : Application() {

    companion object {
        @JvmField var navigationBarHeight: Int? = -1
        @JvmField var statusBarHeight: Int? = -1
    }

    val LICENSE = "XTUMwQ0ZHWGp4MDQ0OWpiWVBtNHE5V0Y5eXc2VkU2TFJBaFVBdTA5TFFOYTlPRG42U" +
            "ms3NFh3Kzh4djh1MERJPQoKYXBwVG9rZW49MTAyNjEyMjktOTIwNS00NGQzLWIzOWItZGY4N" +
            "TVjMmJkNDAxCnBhY2thZ2VOYW1lPWNvbS5jYXJ0by5hZHZhbmNlZC5rb3RsaW4Kb25saW5lT" +
            "GljZW5zZT0xCnByb2R1Y3RzPXNkay1hbmRyb2lkLTQuKgp3YXRlcm1hcms9Y3VzdG9tCg=="

    override fun onCreate() {
        super.onCreate()

        // TODO What's going on here? Keeps throwing methodNotFoundException
//        Log.setShowDebug(true)
//        Log.setShowError(true)
//        Log.setShowInfo(true)

        MapView.registerLicense(LICENSE, this)

        navigationBarHeight = getItemHeight("navigation_bar_height")
        statusBarHeight = getItemHeight("status_bar_height")
    }

    fun getItemHeight(id: String): Int {
        val resources = this.resources
        val resourceId = resources.getIdentifier(id, "dimen", "android")

        if (resourceId > 0) {
            return resources.getDimensionPixelSize(resourceId)
        }

        return 0
    }
}