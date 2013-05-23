package com.coinbase.java.client;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

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
    
    String expectedResponse = "expectedResponse";
    
    when(coinbaseHttpClient.getResponseStringFromHttpGet(any(String.class))).thenReturn(expectedResponse);
    
    String actualBalance = testObject.getBalance();
    
    assertEquals(expectedResponse, actualBalance);
  }
  
  @Test
  public void getReceiveAddress_ReturnsUsersCurrentReceiveAddress() throws ClientProtocolException, IOException {
    
    String expectedResponse = "expectedResponse";
    
    when(coinbaseHttpClient.getResponseStringFromHttpGet(any(String.class))).thenReturn(expectedResponse);
    
    String actualReceiveAddress = testObject.getReceiveAddress();
    
    assertEquals(expectedResponse, actualReceiveAddress);
  }
  
  @Test
  public void generateReceiveAddress_generatesNewReceiveAddress() throws ClientProtocolException, IOException{
    
    String expectedResponse = "expectedResponse";
    
    when(coinbaseHttpClient.getResponseStringFromHttpPost(any(String.class))).thenReturn(expectedResponse);
    
    String actualResponse = testObject.generateReceiveAddress();
    
    assertNotNull(actualResponse);
  }
  
  @Test
  public void cancelRequest_cancelsRequest() throws ClientProtocolException, IOException{
    
    String expectedResponse = "expectedResponse";
    
    when(coinbaseHttpClient.getResponseStringFromHttpDelete(any(String.class))).thenReturn(expectedResponse);
    
    String actualResponse = testObject.cancelRequest();
    
    assertNotNull(actualResponse);
  }

}
