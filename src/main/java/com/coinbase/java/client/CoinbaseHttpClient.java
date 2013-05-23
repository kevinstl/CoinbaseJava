package com.coinbase.java.client;

import java.io.IOException;

import org.apache.http.client.ClientProtocolException;

public interface CoinbaseHttpClient {

  String getResponseStringFromHttpGet(String urlString) throws IOException,  ClientProtocolException;

  void shutdown();

  String getResponseStringFromHttpPost(String urlString) throws IOException, ClientProtocolException;

  String getResponseStringFromHttpDelete(String urlString) throws IOException, ClientProtocolException;

}
