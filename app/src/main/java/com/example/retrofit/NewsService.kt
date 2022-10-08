package com.example.retrofit

import retrofit2.Call
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.create
import retrofit2.http.GET
import retrofit2.http.Query

const val BASE_URL= "https://newsapi.org/"
const val API_KEY="e46b0cca55554b6da1d4b810bdd1b6c1"

interface NewsInterface{
    @GET("v2/top-headlines?apiKey=$API_KEY")
    fun getHeadLine(@Query("country")country:String,@Query("page") page:Int):Call<News>
}

object NewsService{
    val newsInstance:NewsInterface
    init {
        val retrofit =Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
        newsInstance=retrofit.create(NewsInterface::class.java)
    }
}