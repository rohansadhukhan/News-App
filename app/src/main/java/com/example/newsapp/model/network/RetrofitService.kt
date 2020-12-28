package com.example.newsapp.model.network

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class RetrofitService {

    companion object {
        private val retrofit by lazy {
            Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build()
        }

//        this api object use later in code
        val api by lazy {
            retrofit.create(APiService::class.java)
        }
    }



//    fun<T> buildRetrofitService(service : Class<T>) : T  {
//        return retrofit.create(service)
//    }

}