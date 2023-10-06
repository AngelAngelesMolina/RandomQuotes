package com.example.appmvvm.ui.view

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.core.view.isVisible
import androidx.lifecycle.ViewModelProvider
import com.example.appmvvm.databinding.ActivityMainBinding
import com.example.appmvvm.ui.viewmodel.QuoteViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {
    private lateinit var mBinding: ActivityMainBinding
    private lateinit var quoteViewModel: QuoteViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        mBinding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(mBinding.root)
        //inicializar el quoteViewModel
        quoteViewModel = ViewModelProvider(this)[QuoteViewModel::class.java]
        quoteViewModel.onCreate()
        //NOTE: empezar a observar el dato
        quoteViewModel.quoteModel.observe(this) { currentQuote ->
            mBinding.tvQuote.text = currentQuote!!.quote
            mBinding.tvAuthor.text = currentQuote.author
        }
        quoteViewModel.isLoading.observe(this) { visible ->
            mBinding.loading.isVisible = visible
        }
        //actualizar cuando se el de click al view
        mBinding.viewContainer.setOnClickListener { quoteViewModel.randomQuote() }
    }


}