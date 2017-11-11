package com.cluttered.cryptocurrency;

import com.cluttered.cryptocurrency.models.ApiResponse;
import com.cluttered.cryptocurrency.models.MarketCurrency;
import com.cluttered.cryptocurrency.services.PublicBittrexService;
import com.google.gson.Gson;
import retrofit2.Call;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

import java.io.IOException;
import java.util.List;

public class JavaMain {

    private static final Gson GSON = new Gson();
    private static final String BITTREX_API_URL = "https://bittrex.com/api/";

    public static void main(final String[] args) throws IOException {
        //Create retrofit, set the API base URL and GSonConverterFactory
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(BITTREX_API_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        //Create service
        PublicBittrexService publicService = retrofit.create(PublicBittrexService.class);

        Call<ApiResponse<MarketCurrency>> marketCurrenciesCall = publicService.getMarketCurrencies();
        final List<MarketCurrency> marketCurrencyList = marketCurrenciesCall.execute().body().getResult();

        marketCurrencyList.stream()
                .map(GSON::toJson)
                .forEach(json -> System.out.println(json));
    }
}
