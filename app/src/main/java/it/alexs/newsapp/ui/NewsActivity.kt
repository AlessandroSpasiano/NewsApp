package it.alexs.newsapp.ui

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import it.alexs.common_library.navigation.Activities
import it.alexs.common_library.navigation.ActivityHelper
import it.alexs.newsapp.databinding.ActivityNewsBinding

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