package com.example.appmvvm.data.network

import com.example.appmvvm.core.RetrofitHelper
import com.example.appmvvm.data.model.QuoteModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import javax.inject.Inject

class QuoteService @Inject constructor(
    private val api: QuoteApiClient
) {

//    private val retrofit = RetrofitHelper.getRetrofit()

    suspend fun getQuotes(): List<QuoteModel> {
//    Ejecutar en un hilo secundario para no saturar interfaz del usuario
        return withContext(Dispatchers.IO) {
            val response = api.getAllQuotes()
//            val response = retrofit.create(QuoteApiClient::class.java).getAllQuotes()
            response.body() ?: emptyList()
        }
    }

}