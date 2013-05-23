package com.coinbase.java.client;

import java.io.IOException;
import java.util.logging.Logger;

import org.apache.http.client.ClientProtocolException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;


@Component
public class CoinbaseClientImpl implements CoinbaseClient {
  
  private static final String API_KEY = "?api_key=";

  private static final String HTTPS_COINBASE_COM_API_V1_ACCOUNT = "https://coinbase.com/api/v1/account";

  private static Logger logger = Logger.getLogger(CoinbaseClientImpl.class.getName());

  private CoinbaseHttpClient coinbaseHttpClient;
  private @Value("${apiKey}") String apiKey;
  
  @Autowired
  public CoinbaseClientImpl(CoinbaseHttpClient coinbaseHttpClient) {
    this.coinbaseHttpClient = coinbaseHttpClient;
  }
  
  
  @Override
  public String getBalance() throws ClientProtocolException, IOException {
    String operation = "/balance";
    
    String responseString = httpGet(operation);
    
    return responseString;
  }

  @Override
  public String getReceiveAddress() throws ClientProtocolException, IOException {
    String operation = "/receive_address";
    
    String responseString = httpGet(operation);
    
    return responseString;
  }
  

  @Override
  public String generateReceiveAddress() throws ClientProtocolException, IOException {
    String operation = "/generate_receive_address";
    
    String responseString = httpPost(operation);
    
    return responseString;
  }

  @Override
  public String cancelRequest() throws ClientProtocolException, IOException {
    String operation = "/cancel_request";
    
    String responseString = httpDelete(operation);
    
    return responseString;
  }



  private String httpGet(String operation) throws IOException,
  ClientProtocolException {
    String urlString = HTTPS_COINBASE_COM_API_V1_ACCOUNT + operation + API_KEY + apiKey;
    
    String responseString = coinbaseHttpClient.getResponseStringFromHttpGet(urlString);
    
    logger.info("httpResponse.toString(): " + responseString);
    return responseString;
  }

  private String httpPost(String operation) throws IOException,
      ClientProtocolException {
    String urlString = HTTPS_COINBASE_COM_API_V1_ACCOUNT + operation + API_KEY + apiKey; 
    
    String responseString = coinbaseHttpClient.getResponseStringFromHttpPost(urlString);
    
    logger.info("httpResponse.toString(): " + responseString);
    return responseString;
  }
  
  private String httpDelete(String operation) throws IOException,
  ClientProtocolException {
    String urlString = HTTPS_COINBASE_COM_API_V1_ACCOUNT + operation + API_KEY + apiKey; 
    
    String responseString = coinbaseHttpClient.getResponseStringFromHttpDelete(urlString);
    
    logger.info("httpResponse.toString(): " + responseString);
    return responseString;
  }




}
