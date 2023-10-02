package com.gogolook.stevenhm1_kotlin.data

import com.google.gson.annotations.SerializedName
import kotlinx.coroutines.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET
import retrofit2.http.Query


class PictureRepository:IPictureRepository{
    override fun queryImages(keyWord:String,page:Int): List<Picture> {


        val retrofit = retrofit2.Retrofit.Builder()
            .baseUrl("https://pixabay.com/")
            .addConverterFactory(GsonConverterFactory.create())
            .build()
        val service = retrofit.create(ApiQueryService::class.java)
        var temp: List<Picture> = emptyList()

        service.getPicture(keyWord, page)
            .enqueue(object : Callback<JsonResponse> {
                override fun onFailure(call: Call<JsonResponse>, t: Throwable) {

                }

                override fun onResponse(
                    call: Call<JsonResponse>,
                    response: Response<JsonResponse>
                ) {

                    temp = response.body()?.pictures!!

                }
            })
    }

}

interface IPictureRepository {
    fun queryImages(keyWord:String,page:Int): List<Picture>
}

interface ApiQueryService {
    @GET("api/?key=38378111-b28747f4843ada3a5a5370de2&per_page=200")
    fun getPicture(
        @Query("q") keyWord: String,
        @Query("page") page: Int


    ): Call<JsonResponse>

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