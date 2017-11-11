package com.cluttered.cryptocurrency.models;

import com.google.gson.annotations.SerializedName;

import java.util.Optional;

public class MarketCurrency {

    @SerializedName("MarketCurrency")
    private String marketCurrency;
    @SerializedName("BaseCurrency")
    private String baseCurrency;

    @SerializedName("MarketCurrencyLong")
    private String marketCurrencyLong;
    @SerializedName("BaseCurrencyLong")
    private String baseCurrencyLong;

    @SerializedName("MinTradeSize")
    private double minTradeSize;

    @SerializedName("MarketName")
    private String marketName;

    @SerializedName("IsActive")
    private boolean isActive;

//    @SerializedName("Created")
//    private Date created;

    @SerializedName("LogoUrl")
    private String logoUrl;

    public String getMarketCurrency() {
        return marketCurrency;
    }

    public String getBaseCurrency() {
        return baseCurrency;
    }

    public String getMarketCurrencyLong() {
        return marketCurrencyLong;
    }

    public String getBaseCurrencyLong() {
        return baseCurrencyLong;
    }

    public double getMinTradeSize() {
        return minTradeSize;
    }

    public String getMarketName() {
        return marketName;
    }

    public boolean isActive() {
        return isActive;
    }

//    public Date getCreated() {
//        return created;
//    }

    public Optional<String> getLogoUrl() {
        return Optional.ofNullable(logoUrl);
    }
}
