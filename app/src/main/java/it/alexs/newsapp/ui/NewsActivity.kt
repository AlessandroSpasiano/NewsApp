package it.alexs.newsapp.ui

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import it.alexs.newsapp.databinding.ActivityNewsBinding
import it.alexs.newsappcommon_library.navigation.Activities
import it.alexs.newsappcommon_library.navigation.ActivityHelper

class NewsActivity : AppCompatActivity() {

    private val binding by lazy {
        ActivityNewsBinding.inflate(layoutInflater)
    }


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)
        binding.newsGetNews.setOnClickListener {
            startActivity(ActivityHelper.intentTo(Activities.getListNewsActivity()))
        }
    }

}