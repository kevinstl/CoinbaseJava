package com.coinbase.java.client;

import static org.junit.Assert.assertEquals;

import java.io.IOException;

import org.apache.http.client.ClientProtocolException;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import static org.mockito.Mockito.when;
import static org.mockito.Matchers.any;

public class CoinbaseClientTest {

  private CoinbaseClient testObject;
  
  private @Mock CoinbaseHttpClient coinbaseHttpClient;
  
  @Before
  public void setup() {
    MockitoAnnotations.initMocks(this);
    
    testObject = new CoinbaseClientImpl(coinbaseHttpClient);
  }
  
  @Test
  public void getBalance_ReturnsBalance() throws ClientProtocolException, IOException {
    
    String expectedBalance = "expectedBalance";
    
    when(coinbaseHttpClient.getResponseStringFromHttpGet(any(String.class))).thenReturn(expectedBalance);
    
    String actualBalance = testObject.getBalance();
    
    assertEquals(expectedBalance, actualBalance);
  }
  
  @Test
  public void getReceiveAddress_ReturnsUsersCurrentReceiveAddress() throws ClientProtocolException, IOException {
    
    String expectedReceiveAddress = "expectedReceiveAddress";
    
    when(coinbaseHttpClient.getResponseStringFromHttpGet(any(String.class))).thenReturn(expectedReceiveAddress);
    
    String actualReceiveAddress = testObject.getReceiveAddress();
    
    assertEquals(expectedReceiveAddress, actualReceiveAddress);
  }

}
