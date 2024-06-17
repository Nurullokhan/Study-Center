package uz.zeeco.studycenter

import retrofit2.Call
import retrofit2.http.Body
import retrofit2.http.Field
import retrofit2.http.FormUrlEncoded
import retrofit2.http.GET
import retrofit2.http.POST

interface ApiService {
    @FormUrlEncoded
    @POST("exec/requestType=lead")
    fun readProfile(
        @Field("login") LOGIN: String,
        @Field("password") PASSWORD:String
    ): Call<StudentData>
}