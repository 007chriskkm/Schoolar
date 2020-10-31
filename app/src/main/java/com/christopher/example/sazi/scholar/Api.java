package com.christopher.example.sazi.scholar;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

public interface Api {

    //This is just a sample url from internet
    //I used retrofit library to get the data
    String Base_URL = "https://gadsapi.herokuapp.com/";

    @GET("api/hours")
    Call<List<learner>> getlearner();



}
