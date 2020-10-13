package it.alexs.newsapp.ui

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import com.google.android.material.snackbar.Snackbar
import it.alexs.newsapp.NewsApplication
import it.alexs.newsapp.adapter.NewsAdapter
import it.alexs.newsapp.databinding.ActivityNewsBinding
import it.alexs.newsapp.model.ResultWrapper
import javax.inject.Inject

class NewsActivity : AppCompatActivity() {

    private val binding by lazy {
        ActivityNewsBinding.inflate(layoutInflater)
    }

    private val adapter by lazy { NewsAdapter() }

    @Inject lateinit var viewModel: NewsViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        (applicationContext as NewsApplication).appComponent.inject(this)
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        setRecyclerView()
    }

    override fun onResume() {
        super.onResume()
        registerObserves()
    }

    private fun setRecyclerView(){
        binding.news.layoutManager = LinearLayoutManager(this)
        binding.news.adapter = adapter
    }

    private fun registerObserves() {
        viewModel.getTopHeadlinse("it").observe(this) {
            when(it){
                is ResultWrapper.Success -> adapter.submitList(it.value.articles)
                is ResultWrapper.Error -> Snackbar.make(binding.root, it.error.message, Snackbar.LENGTH_INDEFINITE).show()
            }
        }
    }
}