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

import com.coinbase.java.domain.ResponseWrapper;
import com.coinbase.java.domain.deserializer.ResponseDeserializer;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import static org.mockito.Mockito.when;
import static org.mockito.Matchers.any;

public class ResponseDeserializerTest {
  
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
        this.getClass().getResource("/json/response.json")));
    
    ResponseWrapper actualResponse = testObject.deserialize(responseAsString);
    
    assertNotNull(responseAsString);
    assertNotNull(actualResponse);
    
    assertEquals("false", actualResponse.getResponse().getSuccess());
  }

  


}
