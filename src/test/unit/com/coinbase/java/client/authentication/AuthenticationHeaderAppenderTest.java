package com.coinbase.java.client.authentication;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import java.io.IOException;
import java.math.BigDecimal;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;

import org.apache.commons.io.FileUtils;
import org.apache.commons.lang.StringUtils;
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
  public void append_appendsRequiredAuthenticationHeaders() throws ClientProtocolException, IOException, InvalidKeyException, NoSuchAlgorithmException {
    
    testObject.append(httpUriRequest, "", "");
    
    assertNotNull(httpUriRequest.getHeaders(AuthenticationHeaderAppender.ACCESS_KEY)[0]);
    assertNotNull(httpUriRequest.getHeaders(AuthenticationHeaderAppender.ACCESS_SIGNATURE)[0]);
    assertNotNull(httpUriRequest.getHeaders(AuthenticationHeaderAppender.ACCESS_NONCE)[0]);
  }
  
  @Test
  public void append_appendsNonceGreaterThanPrevious() throws ClientProtocolException, IOException, InterruptedException, InvalidKeyException, NoSuchAlgorithmException {
    
    testObject.append(httpUriRequest, "", "");
    
    Header headerNonce1 = httpUriRequest.getHeaders(AuthenticationHeaderAppender.ACCESS_NONCE)[0];
    assertNotNull(headerNonce1);
    assertNotNull(headerNonce1.getValue());
    Long nonce1 = new Long(headerNonce1.getValue());
    assertNotNull(nonce1);
    
    Thread.sleep(1);
    
    testObject.append(httpUriRequest, "", "");
    
    Header headerNonce2 = httpUriRequest.getHeaders(AuthenticationHeaderAppender.ACCESS_NONCE)[0];
    assertNotNull(headerNonce2);
    assertNotNull(headerNonce2.getValue());
    Long nonce2 = new Long(headerNonce2.getValue());
    assertNotNull(nonce2);
    
    assertTrue("Nonce from second append is greater than first.", nonce1 < nonce2);
    
  }
  
  @Test
  public void append_appendsSignature() throws InvalidKeyException, NoSuchAlgorithmException{
	  
	    testObject.append(httpUriRequest, "", "");
	    
	    Header headerSignature = httpUriRequest.getHeaders(AuthenticationHeaderAppender.ACCESS_SIGNATURE)[0];
	    assertNotNull(headerSignature);
	    String signature = headerSignature.getValue();
	    assertNotNull(signature);
	    assertTrue("Signature length greater than zero.", StringUtils.length(signature) > 0);
  }
  

}
