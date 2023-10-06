package com.example.appmvvm.data

import com.example.appmvvm.data.database.dao.QuoteDao
import com.example.appmvvm.data.database.entities.QuoteEntity
import com.example.appmvvm.data.network.QuoteService
import com.example.appmvvm.domain.model.Quote
import com.example.appmvvm.domain.model.toDomain
import javax.inject.Inject

class QuoteRepository @Inject constructor(
//    private val quoteProvider:QuoteProvider,
    private val api: QuoteService,
    private val quoteDao: QuoteDao
) {

    suspend fun getAllQuotesFromApi(): List<Quote> {
        val response = api.getQuotes()
        return response.map { it.toDomain() }
    }

    suspend fun getAllQuotesFromDatabase(): List<Quote> {
        val response = quoteDao.getAllQuotes()
        return response.map { it.toDomain() }
    }
    suspend fun insertQuotes(quotes:List<QuoteEntity>){
        quoteDao.insertAll(quotes)
    }
    suspend fun clearQuotes(){
        quoteDao.deleteAllQuotes()
    }


}