package com.coinbase.java.client;

import java.io.IOException;

import org.apache.commons.httpclient.HttpClient;
import org.apache.commons.httpclient.HttpException;
import org.apache.commons.httpclient.methods.GetMethod;

public class CoinbaseClientImpl implements CoinbaseClient {

  //TODO: Inject this.
  private HttpClient httpClient = new HttpClient();
  
  @Override
  public void getBalance() throws HttpException, IOException {
    String urlString = "https://coinbase.com/api/v1/account/balance";
    GetMethod method = new GetMethod(urlString);
    httpClient.executeMethod(method);
  }

}
