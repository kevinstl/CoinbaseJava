package com.coinbase.java.client;

import java.io.IOException;

import org.apache.http.client.ClientProtocolException;

public interface CoinbaseClient {

  String getBalance() throws ClientProtocolException, IOException;

  String getReceiveAddress() throws ClientProtocolException, IOException;

  String generateReceiveAddress() throws ClientProtocolException, IOException;

  String cancelRequest() throws ClientProtocolException, IOException;

}
