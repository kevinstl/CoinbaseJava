package com.coinbase.java.domain.response;

import com.google.gson.annotations.SerializedName;

public class Fee {
  
  private Integer cents;
  
  @SerializedName("currency_iso")
  private String currencyIso;
  
  public Integer getCents() {
    return cents;
  }
  public void setCents(Integer cents) {
    this.cents = cents;
  }
  public String getCurrencyIso() {
    return currencyIso;
  }
  public void setCurrencyIso(String currencyIso) {
    this.currencyIso = currencyIso;
  }

}
