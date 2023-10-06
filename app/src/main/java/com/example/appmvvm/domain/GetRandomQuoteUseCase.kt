package com.example.appmvvm.domain

import com.example.appmvvm.data.QuoteRepository
import com.example.appmvvm.data.model.QuoteModel
import com.example.appmvvm.domain.model.Quote
import javax.inject.Inject

class GetRandomQuoteUseCase @Inject constructor(
    private val repository: QuoteRepository
)
{

    suspend operator fun invoke(): Quote? {
        val quotes = repository.getAllQuotesFromDatabase()
        if (quotes.isNotEmpty()) {
            val randomNumber = (quotes.indices).random()
//            val randomNumber = (0..quotes.size - 1).random()
            return quotes[randomNumber]
        }
        return null
    }

}