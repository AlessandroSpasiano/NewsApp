package it.alexs.newsapp

import android.app.Application
import android.content.Context
import androidx.test.runner.AndroidJUnitRunner

class NewsApplicationTestRunner: AndroidJUnitRunner() {

    override fun newApplication(
        cl: ClassLoader?,
        className: String?,
        context: Context?
    ): Application {
        return super.newApplication(cl, NewsTestApplication::class.java.name, context)
    }
}