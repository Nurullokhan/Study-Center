package uz.zeeco.studycenter.profile

import retrofit2.Call
import retrofit2.http.Field
import retrofit2.http.FormUrlEncoded
import retrofit2.http.POST
import retrofit2.http.Query
import uz.zeeco.studycenter.profile.StudentData

interface ApiService {
    @FormUrlEncoded
    @POST("exec/requestType=lead")
    fun post(
        @Field("requestType") requestType: String="lead",
        @Field("login") LOGIN: String,
        @Field("password") PASSWORD:String
    ): Call<StudentData>
}