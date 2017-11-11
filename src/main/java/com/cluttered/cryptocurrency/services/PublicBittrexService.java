package com.cluttered.cryptocurrency.services;

import com.cluttered.cryptocurrency.models.ApiResponse;
import com.cluttered.cryptocurrency.models.MarketCurrency;
import retrofit2.Call;
import retrofit2.http.GET;

public interface PublicBittrexService {

    @GET("v1.1/public/getmarkets")
    Call<ApiResponse<MarketCurrency>> getMarketCurrencies();


//    @Headers({ "Accept: application/json" })
//    @GET("people")
//    Call<List<Person>> getAllPeople();
//
//    @POST("v1/books")
//    Call<Book> createBook(@Body Book book);
//
//    @PUT("v1/books/{id}")
//    Call<Book> updateBook(@Path("id") Long id, @Body Book book);
//
//    @DELETE("v1/books/{id}")
//    void deleteBook(@Path("id") Long id);
}
