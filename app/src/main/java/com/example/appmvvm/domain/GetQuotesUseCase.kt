package com.example.appmvvm.domain

import com.example.appmvvm.data.QuoteRepository
import com.example.appmvvm.data.database.entities.toDatabase
import com.example.appmvvm.data.model.QuoteModel
import com.example.appmvvm.domain.model.Quote
import javax.inject.Inject

class GetQuotesUseCase @Inject constructor(
    private val repository :  QuoteRepository
) {

    suspend operator fun invoke():List<Quote> {
        val quotes = repository.getAllQuotesFromApi()
        return if(quotes.isNotEmpty()){
            repository.clearQuotes()
            //insertar la consulta en la bd
            repository.insertQuotes(quotes.map{it.toDatabase()})
            quotes
        }else{ //error en la peticion
            repository.getAllQuotesFromDatabase()
        }
    }
}