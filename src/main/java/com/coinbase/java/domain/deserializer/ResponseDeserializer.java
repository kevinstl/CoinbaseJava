package com.coinbase.java.domain.deserializer;

import org.springframework.stereotype.Component;

import com.coinbase.java.domain.response.SendMoneyResponse;
import com.google.gson.Gson;

@Component
public class ResponseDeserializer {

  public SendMoneyResponse deserialize(String jsonString) {
    
    Gson gson = new Gson() ;
    Class<SendMoneyResponse> classOfT = SendMoneyResponse.class;
    SendMoneyResponse response = gson.fromJson(jsonString, classOfT);
    
    return response;
  }
  
  

}
