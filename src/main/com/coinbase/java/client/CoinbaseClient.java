package com.coinbase.java.client;

import java.io.IOException;

import org.apache.commons.httpclient.HttpException;

public interface CoinbaseClient {

  void getBalance() throws HttpException, IOException;

}
