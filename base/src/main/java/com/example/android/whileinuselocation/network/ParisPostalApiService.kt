package com.example.android.whileinuselocation.network

import com.squareup.moshi.Moshi
import com.squareup.moshi.kotlin.reflect.KotlinJsonAdapterFactory
import org.json.JSONObject
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory
import retrofit2.http.GET
import retrofit2.http.Query

private const val BASE_URL = "https://api.geoapify.com/v1/geocode/reverse?"
private const val API_KEY = "33d09ee339e14f5681b6613a8cba93ee"

private val moshi = Moshi.Builder()
    .add(KotlinJsonAdapterFactory())
    .build()

private val retrofit = Retrofit.Builder()
    .addConverterFactory(MoshiConverterFactory.create(moshi))
    .baseUrl(BASE_URL)
    .build()

interface ParisPostalApiService {
    @GET(BASE_URL)
    suspend fun getAddressData(@Query("lat") latitude: String,
                               @Query("lon") longitude: String,
                               @Query("lat") apikey: String = API_KEY,): JSONObject
}
