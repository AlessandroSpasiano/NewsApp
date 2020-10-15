package it.alexs.newsapplistnews

import android.app.Application
import android.content.Context
import androidx.test.runner.AndroidJUnitRunner
import it.alexs.newsapp.NewsTestApplication

class ListNewsTestRunner: AndroidJUnitRunner() {

    override fun newApplication(
        cl: ClassLoader?,
        className: String?,
        context: Context?
    ): Application {
        return super.newApplication(cl, NewsTestApplication::class.java.name, context)
    }
}