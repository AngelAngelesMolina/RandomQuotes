package com.example.appmvvm.domain.model

import com.example.appmvvm.data.database.entities.QuoteEntity
import com.example.appmvvm.data.model.QuoteModel

data class Quote (val quote:String, val author:String)

fun QuoteModel.toDomain() = Quote(quote, author)
fun QuoteEntity.toDomain() = Quote(quote, author)
