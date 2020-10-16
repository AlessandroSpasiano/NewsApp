package it.alexs.newsapplistnews.ui

import it.alexs.newsapplistnews.di.DaggerFakeListNewsComponent

class TestListNewsActivity: ListNewsActivity() {

    override fun injectComponent() {
        DaggerFakeListNewsComponent.create()
            .inject(this)
    }

}