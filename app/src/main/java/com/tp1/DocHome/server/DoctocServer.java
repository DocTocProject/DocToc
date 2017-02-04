package com.tp1.DocHome.Server;
import com.tp1.DocHome.Models.Consultation;
import com.tp1.DocHome.Models.Patient;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.Headers;
import retrofit2.http.POST;
import retrofit2.http.PUT;
import retrofit2.http.Path;

/**
 * Created by yyou on 2017/1/5.
 */

public interface DoctocServer {

    @POST("/patients/signIn")
    @Headers({ "Content-Type: application/json;charset=UTF-8"})
    Call<Patient> createAPatient(@Body Patient patient);

    @FormUrlEncoded
    @POST("/patients/login")
    Call<Patient> login(@Field("email") String email, @Field("password") String password);

    @GET("/patients/{id}/consultations")
    Call<Consultation> getHistoric(@Path("id") Long id);


}

