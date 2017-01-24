package com.tp1.DocHome.Server;
import com.tp1.DocHome.Models.Patient;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.POST;

/**
 * Created by yyou on 2017/1/5.
 */

public interface DoctocServer {

    @POST("/patients/signIn")
    Call<Patient> createAPatient(@Body Patient patient);

    @FormUrlEncoded
    @POST("/patients/login")
    Call<Patient> login(@Field("email") String email, @Field("password") String password);

    @FormUrlEncoded
    @POST("/patients/:id")
    Call<Patient>  register(
            //@Field("id") int id,
            @Field("password") String password
            ,@Field("last_name") String last_name
            ,@Field("first_name")String  first_name
            ,@Field("sex") String  sex
            ,@Field("telephone")  int telephone
            ,@Field("email")  String  email
            //,@Field("address") String  address
            );
}

