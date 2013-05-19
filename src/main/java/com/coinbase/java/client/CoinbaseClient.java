package com.coinbase.java.client;

import java.io.IOException;

import org.apache.http.client.ClientProtocolException;

public interface CoinbaseClient {

  String getBalance() throws ClientProtocolException, IOException;

}
