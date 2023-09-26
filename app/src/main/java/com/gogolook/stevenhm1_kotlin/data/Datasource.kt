package com.gogolook.stevenhm1_kotlin.data

import com.google.gson.annotations.SerializedName
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET
import retrofit2.http.Query
import  kotlinx.coroutines.*

class Datasource {

    fun loadPictures(keyWord: String, page: Int): List<Picture> {

        val key = "38378111-b28747f4843ada3a5a5370de2"
        var url = "https://pixabay.com/api/?key=${key}&q=${keyWord}&page=${page}&per_page=200"



        val retrofit = retrofit2.Retrofit.Builder()
            .baseUrl("https://pixabay.com/")
            .addConverterFactory(GsonConverterFactory.create())
            .build()
        val service = retrofit.create(QueryImage::class.java)
        var temp:List<Picture> = emptyList()

        service.query(keyWord, page)
            .enqueue(object : Callback<JsonResponse> {
                override fun onFailure(call: Call<JsonResponse>, t: Throwable) {



                }

                override fun onResponse(
                    call: Call<JsonResponse>,
                    response: Response<JsonResponse>
                ) {

                    temp= response.body()?.pictures!!

                }
            })
        return temp
        //todo 使用非同步解決return時間問題
    }

    interface QueryImage {
        @GET("api/?key=38378111-b28747f4843ada3a5a5370de2&per_page=200")
        fun query(
            @Query("q") keyWord: String,
            @Query("page") page: Int


        ): Call<JsonResponse>


    }
}

data class Picture(
    var id: String,
    var downloads: Int,
    var views: Int,
    @SerializedName("previewURL")
    var url: String
)

data class JsonResponse(
    @SerializedName("hits")
    var pictures: List<Picture>
)