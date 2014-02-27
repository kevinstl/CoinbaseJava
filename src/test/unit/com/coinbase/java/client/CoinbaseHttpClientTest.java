package com.coinbase.java.client;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.UnsupportedEncodingException;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpDelete;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
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
    
    testObject = new CoinbaseHttpClient(httpClient);
  }
  
  @Test
  public void getResponseStringFromHttpGetReturnsResponse() throws ClientProtocolException, IOException {
    when(httpClient.execute(any(HttpGet.class))).thenReturn(httpResponse);
    
    String urlString = "http://anyUrl.com";
    String expectedStringResponse = setupHttpRequest();
    
    String actualStringResponse = testObject.executeGet(urlString);
    
    assertEquals(expectedStringResponse, actualStringResponse);
  }

  
  @Test
  public void getResponseStringFromHttpPostReturnsResponse() throws ClientProtocolException, IOException {
    when(httpClient.execute(any(HttpPost.class))).thenReturn(httpResponse);
    
    String urlString = "http://anyUrl.com";
    String expectedStringResponse = setupHttpRequest();
    String payload = "";
    
    String actualStringResponse = testObject.executePost(urlString, payload);
    
    assertEquals(expectedStringResponse, actualStringResponse);
  }
  
  @Test
  public void getResponseStringFromHttpDeleteReturnsResponse() throws ClientProtocolException, IOException {
    when(httpClient.execute(any(HttpDelete.class))).thenReturn(httpResponse);
    
    String urlString = "http://anyUrl.com";
    String expectedStringResponse = setupHttpRequest();
    
    String actualStringResponse = testObject.executeDelete(urlString);
    
    assertEquals(expectedStringResponse, actualStringResponse);
  }
  

  private String setupHttpRequest() throws UnsupportedEncodingException,
      IOException {
    String expectedStringResponse = "expectedStringResponse";
    
    InputStream inputStream = new ByteArrayInputStream(expectedStringResponse.getBytes("UTF-8"));  
    
    when(httpResponse.getEntity()).thenReturn(httpEntity);
    when(httpEntity.getContent()).thenReturn(inputStream);
    when(httpClient.getConnectionManager()).thenReturn(clientConnectionManager);
    return expectedStringResponse;
  }

}
