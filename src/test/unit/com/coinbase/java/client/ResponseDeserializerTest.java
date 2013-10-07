package com.coinbase.java.client;

import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.UnsupportedEncodingException;

import org.apache.commons.io.FileUtils;
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

import com.coinbase.java.domain.deserializer.ResponseDeserializer;
import com.coinbase.java.domain.response.SendMoneyResponse;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import static org.mockito.Mockito.when;
import static org.mockito.Matchers.any;

public class ResponseDeserializerTest {
  
  public static final String JSON_PATH = "/json";

  private ResponseDeserializer testObject;
  
  private @Mock HttpClient httpClient;
  private @Mock HttpResponse httpResponse;
  private @Mock HttpEntity httpEntity;

  private @Mock ClientConnectionManager clientConnectionManager;
  
  @Before
  public void setup() {
    MockitoAnnotations.initMocks(this);
    
    testObject = new ResponseDeserializer();
  }
  
  @Test
  public void responseDeserializer_deserializes() throws ClientProtocolException, IOException {
    
    String responseAsString = FileUtils.readFileToString(FileUtils.toFile(
        this.getClass().getResource(JSON_PATH + "/sendMoneyFailResponse.json")));
    
    SendMoneyResponse sendMoneyResponse = testObject.deserialize(responseAsString);
    
    assertNotNull(responseAsString);
    assertNotNull(sendMoneyResponse);
    
    assertEquals("false", sendMoneyResponse.getSuccess());
  }
  
  @Test
  public void responseDeserializer_deserializesSuccessResponse() throws ClientProtocolException, IOException {
    
    String responseAsString = FileUtils.readFileToString(FileUtils.toFile(
        this.getClass().getResource(JSON_PATH + "/sendMoneySuccessResponse.json")));
    
    SendMoneyResponse sendMoneyResponse = testObject.deserialize(responseAsString);
    
    assertNotNull(responseAsString);
    assertNotNull(sendMoneyResponse);
    
    assertEquals("true", sendMoneyResponse.getSuccess());
    assertEquals("001", sendMoneyResponse.getTransaction().getId());
    assertEquals("-0.00100000", sendMoneyResponse.getTransaction().getAmount().getAmount());
  }

  


}
