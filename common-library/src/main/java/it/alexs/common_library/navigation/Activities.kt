package it.alexs.common_library.navigation

class Activities {
    companion object {

        fun getListNewsActivity(): AddressableActivity = object : AddressableActivity{
            override fun getClassName(): String = "it.alexs.newsapplistnews.ui.ListNewsActivity"
        }
    }
}