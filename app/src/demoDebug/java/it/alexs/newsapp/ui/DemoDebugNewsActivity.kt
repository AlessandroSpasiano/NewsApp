package it.alexs.newsapp.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import it.alexs.newsapp.databinding.ActivityDemoDebugNewsBinding

class DemoDebugNewsActivity : AppCompatActivity() {

    private val binding by lazy { ActivityDemoDebugNewsBinding.inflate(layoutInflater) }

    private val viewModel by lazy { NewsActivityViewModel() }

    private val adapter by lazy { NewsAdapter() }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        setRecyclerView()
    }

    override fun onResume() {
        super.onResume()
        registerObserves()
    }

    private fun registerObserves() {
        viewModel.getNews().observe(this) {
            adapter.submitList(it.articles)
        }
    }

    private fun setRecyclerView() {
        binding.news.layoutManager = LinearLayoutManager(this)
        binding.news.adapter = adapter
    }
}