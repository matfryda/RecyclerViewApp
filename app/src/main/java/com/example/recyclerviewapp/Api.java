package com.example.recyclerviewapp;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

public interface Api {
    String BASE_URL = "http://dummy.restapiexample.com/api/v1/";

    @GET("employeers")
    Call<List<EmployersAPI>> getEmployeers();
}
