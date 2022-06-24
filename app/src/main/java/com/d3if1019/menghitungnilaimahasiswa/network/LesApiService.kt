package com.d3if1019.menghitungnilaimahasiswa.network

import com.d3if1019.menghitungnilaimahasiswa.model.Les
import com.squareup.moshi.Moshi
import com.squareup.moshi.kotlin.reflect.KotlinJsonAdapterFactory
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory
import retrofit2.http.GET

private const val BASE_URL = "https://raw.githubusercontent.com/" +
        "Isminuraeni/Menghitung-Nilai-Mahasiswa/navigation/"

private val moshi = Moshi.Builder()
    .add(KotlinJsonAdapterFactory())
    .build()

private val retrofit = Retrofit.Builder()
    .addConverterFactory(MoshiConverterFactory.create(moshi))
    .baseUrl(BASE_URL)
    .build()

interface LesApiService {
    @GET("static-api.json")
    suspend fun getLes(): List<Les>
}
object LesApi {
    val service: LesApiService by lazy {
        retrofit.create(LesApiService::class.java)
    }

    enum class ApiStatus { LOADING, SUCCESS, FAILED }

    fun getLesUrl(nama: String): String {
        return "$BASE_URL$nama.png"
    }
}