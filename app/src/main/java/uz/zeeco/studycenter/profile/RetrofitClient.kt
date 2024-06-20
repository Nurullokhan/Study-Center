package uz.zeeco.studycenter.profile// RetrofitClient.kt
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object RetrofitClient {
    private const val BASE_URL = "https://script.google.com/macros/s/AKfycbz0xN2q8nETdDC6zUNJ79Y4oGIbQ6KJlu9N_oFHYIkRmEiK4x8kChxfnegP9qhF8XEX/exec/"  // Replace with your API base URL

    val apiService: ApiService by lazy {
        Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(ApiService::class.java)
    }
}
