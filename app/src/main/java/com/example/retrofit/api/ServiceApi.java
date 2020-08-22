package com.example.retrofit.api;

import com.example.retrofit.model.ProductList;

import java.util.List;

import retrofit.Callback;
import retrofit.client.Response;
import retrofit.http.Field;
import retrofit.http.FormUrlEncoded;
import retrofit.http.GET;
import retrofit.http.POST;

public interface ServiceApi {

    @FormUrlEncoded()
    @POST("/insert.php")
    public void addProduct(
            @Field("name") String name,
            @Field("desc") String desc,
            @Field("price") String price,
            Callback<Response> response
    );

    @GET("/restapiphp/phpcode/product.json")
    public void getproduct(
            Callback<List<ProductList>> listCallback
    );
}
