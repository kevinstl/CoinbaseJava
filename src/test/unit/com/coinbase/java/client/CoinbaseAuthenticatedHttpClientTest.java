package com.coinbase.java.client;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.UnsupportedEncodingException;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.HttpStatus;
import org.apache.http.StatusLine;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpDelete;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.client.methods.HttpUriRequest;
import org.apache.http.conn.ClientConnectionManager;
import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import com.coinbase.java.client.authentication.AuthenticationHeaderAppender;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import static org.mockito.Mockito.when;
import static org.mockito.Mockito.verify;
import static org.mockito.Matchers.any;
import static org.mockito.Matchers.eq;

public class CoinbaseAuthenticatedHttpClientTest {
  
  private @InjectMocks CoinbaseAuthenticatedHttpClient testObject;
  
  private @Mock HttpClient httpClient;
  private @Mock HttpResponse httpResponse;
  private @Mock StatusLine statusLine;
  private @Mock HttpEntity httpEntity;

  private @Mock ClientConnectionManager clientConnectionManager;
  
  private @Mock AuthenticationHeaderAppender authenticationHeaderAppender;
  
  @Before
  public void setup() {
    MockitoAnnotations.initMocks(this);
    
    when(httpResponse.getStatusLine()).thenReturn(statusLine);
    when(statusLine.getStatusCode()).thenReturn(HttpStatus.SC_OK);
  }
  

  @Test
  public void getResponseStringFromHttpGetReturnsResponse() throws ClientProtocolException, IOException, InvalidKeyException, NoSuchAlgorithmException {
    when(httpClient.execute(any(HttpGet.class))).thenReturn(httpResponse);
    
    String urlString = "http://anyUrl.com";
    String expectedStringResponse = setupHttpRequest();
    
    String actualStringResponse = testObject.executeGet(urlString);
    
    assertEquals(expectedStringResponse, actualStringResponse);
    
    verify(authenticationHeaderAppender).append(any(HttpUriRequest.class), eq(urlString), any(String.class));
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
