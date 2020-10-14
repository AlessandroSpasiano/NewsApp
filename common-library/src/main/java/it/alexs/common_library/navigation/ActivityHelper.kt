package it.alexs.common_library.navigation

import android.content.Intent

class ActivityHelper {
    companion object {
        const val PACKAGE_NAME = "it.alexs.newsapp.debug"

        @JvmStatic
        fun intentTo(activity: AddressableActivity): Intent {
            return Intent(Intent.ACTION_VIEW).setClassName(PACKAGE_NAME, activity.getClassName())
        }
    }
}