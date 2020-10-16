package it.alexs.newsapplistnews

import androidx.appcompat.app.AppCompatActivity

abstract class Injectable: AppCompatActivity() {

    abstract fun injectComponent()
}