package com.github.kevinstl.coinbase.java.domain.deserializer;

import org.springframework.stereotype.Component;

import com.github.kevinstl.coinbase.java.domain.response.BuyResponse;
import com.github.kevinstl.coinbase.java.domain.response.CurrencyExchangeRateResponse;
import com.github.kevinstl.coinbase.java.domain.response.ExchangeRatesResponse;
import com.github.kevinstl.coinbase.java.domain.response.SendMoneyResponse;
import com.google.gson.Gson;

@Component
public class ResponseDeserializer {

  public SendMoneyResponse deserializeSendMoneyResponse(String jsonString) {
    
    Gson gson = new Gson() ;
    Class<SendMoneyResponse> classOfT = SendMoneyResponse.class;
    SendMoneyResponse response = gson.fromJson(jsonString, classOfT);
    
    return response;
  }
  
  public BuyResponse deserializeBuyResponse(String jsonString) {
    
    Gson gson = new Gson() ;
    Class<BuyResponse> classOfT = BuyResponse.class;
    BuyResponse response = gson.fromJson(jsonString, classOfT);
    
    return response;
  }
  
  public CurrencyExchangeRateResponse deserializeCurrencyExchangeRateResponse(String jsonString) {
    
    Gson gson = new Gson() ;
    Class<CurrencyExchangeRateResponse> classOfT = CurrencyExchangeRateResponse.class;
    CurrencyExchangeRateResponse response = gson.fromJson(jsonString, classOfT);
    
    return response;
  }
  
  public ExchangeRatesResponse deserializeExchangeRatesResponse(String jsonString) {
    
    Gson gson = new Gson() ;
    Class<ExchangeRatesResponse> classOfT = ExchangeRatesResponse.class;
    ExchangeRatesResponse response = gson.fromJson(jsonString, classOfT);
    
    return response;
  }

}
