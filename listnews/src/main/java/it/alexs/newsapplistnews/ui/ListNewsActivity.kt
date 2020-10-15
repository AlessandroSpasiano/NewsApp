package it.alexs.newsapplistnews.ui

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.google.android.material.snackbar.Snackbar
import it.alexs.newsapp.NewsApplication
import it.alexs.newsappcommon_library.model.ResultWrapper
import it.alexs.newsapplistnews.adapter.NewsAdapter
import it.alexs.newsapplistnews.databinding.ActivityListNewsBinding
import it.alexs.newsapplistnews.di.DaggerListNewsComponent
import it.alexs.newsappmvvm_library.ViewModelFactory
import javax.inject.Inject

class ListNewsActivity : AppCompatActivity() {
    private val adapter by lazy { NewsAdapter() }

    private val binding by lazy { ActivityListNewsBinding.inflate(layoutInflater) }

    private val viewModel by lazy {
        ViewModelProvider(this, appViewModelFactory).get(ListNewsViewModel::class.java)
    }

    @Inject lateinit var appViewModelFactory: ViewModelFactory

    override fun onCreate(savedInstanceState: Bundle?) {
        DaggerListNewsComponent.factory()
            .create((applicationContext as NewsApplication).appComponent)
            .inject(this)
        super.onCreate(savedInstanceState)
        setContentView(binding.root)
        setRecyclerView()
    }

    override fun onResume() {
        super.onResume()
        registerObserves()
    }

    private fun setRecyclerView() {
        binding.listNews.layoutManager = LinearLayoutManager(this)
        binding.listNews.adapter = adapter
    }

    private fun registerObserves() {
        viewModel.getTopHeadlines("it").observe(this) {
            when(it){
                is ResultWrapper.Success -> adapter.submitList(it.value.articles)
                is ResultWrapper.Error -> Snackbar.make(binding.root, it.error.message, Snackbar.LENGTH_INDEFINITE).show()
            }
        }
    }
}