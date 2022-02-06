package com.example.darshanpractical.models.networking

import com.example.darshanpractical.models.pojo.task_list_response.TaskListResponse
import okhttp3.*
import retrofit2.Call
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.*
import java.util.concurrent.TimeUnit
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.http.Headers


object ApiClient {

    private val BASE_URL = "https://www.meistertask.com/"
    private var serviceApiInterface : ServiceApiInterface? = null
    fun build() : ServiceApiInterface?{

        var builder: Retrofit.Builder = Retrofit.Builder().baseUrl(BASE_URL)
                                        .addConverterFactory(GsonConverterFactory.create())


        val httpClient = OkHttpClient().newBuilder()
            .connectTimeout(10, TimeUnit.SECONDS)
            .readTimeout(10, TimeUnit.SECONDS)
            .writeTimeout(10, TimeUnit.SECONDS)
            .addNetworkInterceptor(HttpLoggingInterceptor().setLevel(HttpLoggingInterceptor.Level.BODY))
            .addNetworkInterceptor(HttpLoggingInterceptor().setLevel(HttpLoggingInterceptor.Level.HEADERS))
            .build()


        // retrofit object
        var retrofit: Retrofit = builder.client(httpClient).build()

        // Service API interface
        serviceApiInterface = retrofit.create(ServiceApiInterface::class.java)

        return serviceApiInterface as ServiceApiInterface

    }



    interface ServiceApiInterface{

        @Headers(
            "Accept: application/json",
            "Content-Type: application/json")
        @POST("search")
        fun doSearch(@Header("Authorization")  token : String,
                     @Query("filter") filter: String,
                     @Query("response_format") response_format: String): Call<TaskListResponse?>

    }

}