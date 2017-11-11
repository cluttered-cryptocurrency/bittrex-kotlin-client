package com.cluttered.cryptocurrency;

import com.cluttered.cryptocurrency.models.ApiResponse;
import com.cluttered.cryptocurrency.models.MarketCurrency;
import com.cluttered.cryptocurrency.services.PublicBittrexService;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import io.reactivex.Observable;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

import java.io.IOException;

public class JavaMain {

    private static final Gson API_GSON = new GsonBuilder()
            .setLenient()
            .setDateFormat("yyyy-MM-dd'T'HH:mm:ss")
            .create();
    private static final Gson GSON = new GsonBuilder()
            .setLenient()
            .setDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSSZ")
            .setPrettyPrinting()
            .create();
    private static final String BITTREX_API_URL = "https://bittrex.com/api/";

    public static void main(final String[] args) throws IOException {
        //Create retrofit, set the API base URL and GSonConverterFactory
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(BITTREX_API_URL)
                .addConverterFactory(GsonConverterFactory.create(API_GSON))
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .build();

        //Create service
        PublicBittrexService publicService = retrofit.create(PublicBittrexService.class);

        Observable<ApiResponse<MarketCurrency>> marketCurrenciesObservable = publicService.getMarketCurrencies();
        marketCurrenciesObservable
                .flatMap(response -> Observable.fromIterable(response.getResult()))
                .filter(marketCurrency -> marketCurrency.getMarketCurrency().equals("ETH"))
                .filter(marketCurrency -> marketCurrency.getBaseCurrency().equals("BTC"))
                .map(GSON::toJson)
                .subscribe(str -> System.out.println(str));
    }
}
