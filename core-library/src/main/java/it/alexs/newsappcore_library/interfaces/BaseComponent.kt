package it.alexs.newsappcore_library.interfaces

import android.app.Activity

interface BaseComponent<T> {
    fun inject(target: T)
}

interface BaseActivityComponent<T: Activity>: BaseComponent<T>
