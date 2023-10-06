package com.example.appmvvm.di

import com.example.appmvvm.data.network.QuoteApiClient
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.create
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class) //Desde donde se podrá llamar
object NetworkModule {
    //Nos proveera dependencias que no sean tan faciles de proveer como retrofit
    @Singleton //unica instancía de retrofit, sino se crearian n instancias
    @Provides
    //Cada que se necesite un objeto de tipo retrofit - Dagger lo inyectará
    fun provideRetrofit(): Retrofit {
        return Retrofit.Builder()
            .baseUrl("https://drawsomething-59328-default-rtdb.europe-west1.firebasedatabase.app/")
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }

    @Singleton
    @Provides
    fun provideApiClient(retrofit: Retrofit): QuoteApiClient {
        return retrofit.create(QuoteApiClient::class.java)
    }
}
