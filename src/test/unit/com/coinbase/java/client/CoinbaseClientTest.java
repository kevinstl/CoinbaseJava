package com.coinbase.java.client;

import static org.junit.Assert.*;

import java.io.IOException;

import org.apache.commons.httpclient.HttpException;
import org.junit.Before;
import org.junit.Test;
import org.mockito.MockitoAnnotations;

public class CoinbaseClientTest {

  private CoinbaseClient testObject;
  
  @Before
  public void setup() {
    MockitoAnnotations.initMocks(this);
    
    testObject = new CoinbaseClientImpl();
  }
  
  @Test
  public void getBalanceReturnsBalance() throws HttpException, IOException {
    testObject.getBalance();
  }

}
