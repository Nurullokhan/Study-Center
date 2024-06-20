package uz.zeeco.studycenter.profile

import retrofit2.Call
import retrofit2.http.Field
import retrofit2.http.FormUrlEncoded
import retrofit2.http.POST
import uz.zeeco.studycenter.profile.StudentData

interface ApiService {
    @FormUrlEncoded
    @POST("exec/requestType=lead")
    fun readProfile(
        @Field("login") LOGIN: String,
        @Field("password") PASSWORD:String
    ): Call<StudentData>
}