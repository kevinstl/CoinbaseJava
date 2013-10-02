package com.coinbase.java.domain.deserializer;

import com.coinbase.java.domain.ResponseWrapper;
import com.google.gson.Gson;

public class ResponseDeserializer {

  public ResponseWrapper deserialize(String jsonString) {
    
    Gson gson = new Gson() ;
    ResponseWrapper responseWrapper = gson.fromJson(jsonString, ResponseWrapper.class);
    
    return responseWrapper;
  }
  
  

}
