package com.coinbase.java.client;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.conn.ClientConnectionManager;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import static org.junit.Assert.assertEquals;

import static org.mockito.Mockito.when;
import static org.mockito.Matchers.any;

public class CoinbaseHttpClientTest {
  
  private CoinbaseHttpClient testObject;
  
  private @Mock HttpClient httpClient;
  private @Mock HttpResponse httpResponse;
  private @Mock HttpEntity httpEntity;

  private @Mock ClientConnectionManager clientConnectionManager;
  
  @Before
  public void setup() {
    MockitoAnnotations.initMocks(this);
    
    testObject = new CoinbaseHttpClientImpl(httpClient);
  }
  
  @Test
  public void getResponseStringFromHttpGetReturnsResponse() throws ClientProtocolException, IOException {
    String urlString = "http://anyUrl.com";
    String expectedStringResponse = "expectedStringResponse";
    
    InputStream inputStream = new ByteArrayInputStream(expectedStringResponse.getBytes("UTF-8"));  
    
    when(httpClient.execute(any(HttpGet.class))).thenReturn(httpResponse);
    when(httpResponse.getEntity()).thenReturn(httpEntity);
    when(httpEntity.getContent()).thenReturn(inputStream);
    when(httpClient.getConnectionManager()).thenReturn(clientConnectionManager);
    
    String actualStringResponse = testObject.getResponseStringFromHttpGet(urlString);
    
    assertEquals(expectedStringResponse, actualStringResponse);
  }

}
