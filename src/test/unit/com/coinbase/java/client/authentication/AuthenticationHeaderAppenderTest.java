package com.coinbase.java.client.authentication;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import java.io.IOException;
import java.math.BigDecimal;

import org.apache.commons.io.FileUtils;
import org.apache.http.Header;
import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpUriRequest;
import org.apache.http.conn.ClientConnectionManager;
import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import com.coinbase.java.domain.deserializer.ResponseDeserializer;
import com.coinbase.java.domain.response.BuyResponse;
import com.coinbase.java.domain.response.SendMoneyResponse;

public class AuthenticationHeaderAppenderTest {
  
  private @InjectMocks AuthenticationHeaderAppender testObject;
  
  private HttpUriRequest httpUriRequest = new HttpGet();
  
  @Before
  public void setup() {
    MockitoAnnotations.initMocks(this);
  }
  
  @Test
  public void append_appendsRequiredAuthenticationHeaders() throws ClientProtocolException, IOException {
    
    testObject.append(httpUriRequest);
    
    assertNotNull(httpUriRequest.getHeaders(AuthenticationHeaderAppender.ACCESS_KEY)[0]);
    assertNotNull(httpUriRequest.getHeaders(AuthenticationHeaderAppender.ACCESS_SIGNATURE)[0]);
    assertNotNull(httpUriRequest.getHeaders(AuthenticationHeaderAppender.ACCESS_NONCE)[0]);
  }
  
  @Test
  public void append_appendsNonceGreaterThanPrevious() throws ClientProtocolException, IOException {
    
    testObject.append(httpUriRequest);
    
    Header headerNonce1 = httpUriRequest.getHeaders(AuthenticationHeaderAppender.ACCESS_SIGNATURE)[0];
    assertNotNull(headerNonce1);
    
    testObject.append(httpUriRequest);
    
    Header headerNonce2 = httpUriRequest.getHeaders(AuthenticationHeaderAppender.ACCESS_SIGNATURE)[0];
    assertNotNull(headerNonce2);
    
  }
  

  

}
