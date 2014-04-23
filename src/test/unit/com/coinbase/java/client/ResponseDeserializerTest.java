package com.coinbase.java.client;

import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.UnsupportedEncodingException;
import java.math.BigDecimal;

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
import com.coinbase.java.domain.response.BuyResponse;
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
  public void sendMoneyResponseDeserializer_deserializesFailResponse() throws ClientProtocolException, IOException {
    
    String responseAsString = FileUtils.readFileToString(FileUtils.toFile(
        this.getClass().getResource(JSON_PATH + "/sendMoneyFailResponse.json")));
    
    SendMoneyResponse sendMoneyResponse = testObject.deserializeSendMoneyResponse(responseAsString);
    
    assertNotNull(responseAsString);
    assertNotNull(sendMoneyResponse);
    
    assertEquals(false, sendMoneyResponse.getSuccess());
  }
  
  @Test
  public void sendMoneyResponseDeserializer_deserializesSuccessResponse() throws ClientProtocolException, IOException {
    
    String responseAsString = FileUtils.readFileToString(FileUtils.toFile(
        this.getClass().getResource(JSON_PATH + "/sendMoneySuccessResponse.json")));
    
    SendMoneyResponse sendMoneyResponse = testObject.deserializeSendMoneyResponse(responseAsString);
    
    assertNotNull(responseAsString);
    assertNotNull(sendMoneyResponse);
    
    assertEquals(true, sendMoneyResponse.getSuccess());
    assertEquals("001", sendMoneyResponse.getTransaction().getId());
    assertEquals(new BigDecimal("-0.00100000"), sendMoneyResponse.getTransaction().getAmount().getAmount());
  }

  
  
  @Test
  public void buyResponseDeserializer_deserializesFailResponse() throws ClientProtocolException, IOException {
    
    String responseAsString = FileUtils.readFileToString(FileUtils.toFile(
        this.getClass().getResource(JSON_PATH + "/buyResponseFail.json")));
    
    BuyResponse buyResponse = testObject.deserializeBuyResponse(responseAsString);
    
    assertNotNull(responseAsString);
    assertNotNull(buyResponse);
    
    assertEquals(false, buyResponse.getSuccess());
  }
  
  @Test
  public void buyResponseDeserializer_deserializesSuccessResponse() throws ClientProtocolException, IOException {
    
    String responseAsString = FileUtils.readFileToString(FileUtils.toFile(
        this.getClass().getResource(JSON_PATH + "/buyResponseSuccess.json")));
    
    BuyResponse buyResponse = testObject.deserializeBuyResponse(responseAsString);
    
    assertNotNull(responseAsString);
    assertNotNull(buyResponse);
    
    assertEquals(true, buyResponse.getSuccess());
    assertEquals("Buy", buyResponse.getTransfer().getType());
    assertEquals("6H7GYLXZ", buyResponse.getTransfer().getCode());
    assertEquals("2013-01-28T16:08:58-08:00", buyResponse.getTransfer().getCreatedAt());
    assertEquals(new Integer(14), buyResponse.getTransfer().getFees().getCoinbase().getCents());
    assertEquals("USD", buyResponse.getTransfer().getFees().getCoinbase().getCurrencyIso());
    assertEquals(new Integer(15), buyResponse.getTransfer().getFees().getBank().getCents());
    assertEquals("USD", buyResponse.getTransfer().getFees().getBank().getCurrencyIso());
    assertEquals("created", buyResponse.getTransfer().getStatus());
    assertEquals("2013-02-01T18:00:00-08:00", buyResponse.getTransfer().getPayoutDate());
    assertEquals(new BigDecimal("1.00000000"), buyResponse.getTransfer().getBtc().getAmount());
    assertEquals("BTC", buyResponse.getTransfer().getBtc().getCurrency());
    assertEquals(new BigDecimal("13.55"), buyResponse.getTransfer().getSubtotal().getAmount());
    assertEquals("USD", buyResponse.getTransfer().getSubtotal().getCurrency());
    assertEquals(new BigDecimal("13.84"), buyResponse.getTransfer().getTotal().getAmount());
    assertEquals("USD", buyResponse.getTransfer().getTotal().getCurrency());
  }
  
  

}
