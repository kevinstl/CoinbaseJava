package com.coinbase.java.client;

import java.io.IOException;
import java.util.logging.Logger;

import org.apache.http.client.ClientProtocolException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;


@Component
public class CoinbaseClientImpl implements CoinbaseClient {
  
  private static Logger logger = Logger.getLogger(CoinbaseClientImpl.class.getName());

  private CoinbaseHttpClient coinbaseHttpClient;
  private @Value("${apiKey}") String apiKey;
  
  @Autowired
  public CoinbaseClientImpl(CoinbaseHttpClient coinbaseHttpClient) {
    this.coinbaseHttpClient = coinbaseHttpClient;
  }
  
  
  @Override
  public String getBalance() throws ClientProtocolException, IOException {
    String urlString = "https://coinbase.com/api/v1/account/balance?api_key=" + apiKey;
    
    String responseString = coinbaseHttpClient.getResponseStringFromHttpGet(urlString);
    
    logger.info("httpResponse.toString(): " + responseString);
    
    return responseString;
  }



}
