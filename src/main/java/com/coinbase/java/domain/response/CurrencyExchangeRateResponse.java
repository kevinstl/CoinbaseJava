package com.coinbase.java.domain.response;

import java.math.BigDecimal;

import com.google.gson.annotations.SerializedName;

public class CurrencyExchangeRateResponse {
  
  @SerializedName("usd_to_btc")
  private BigDecimal usdToBtc;

  public BigDecimal getUsdToBtc() {
    return usdToBtc;
  }

  public void setUsdToBtc(BigDecimal usdToBtc) {
    this.usdToBtc = usdToBtc;
  }

  

}
