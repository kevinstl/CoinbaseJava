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
    testObject = new CoinbaseClientImpl("apiKey");
    testObject.setCoinbaseHttpClient(coinbaseHttpClient);
  }
  
  @Test
  public void getBalance_returnsExpectedResponse() throws ClientProtocolException, IOException {
    
    String expectedResponse = "expectedResponse";
    
    when(coinbaseHttpClient.getResponseStringFromHttpGet(testObject.getOperationUrl(CoinbaseClientImpl.BALANCE))).thenReturn(expectedResponse);
    
    String actualBalance = testObject.getBalance();
    
    assertEquals(expectedResponse, actualBalance);
  }
  
  @Test
  public void getReceiveAddress_returnsExpectedResponse() throws ClientProtocolException, IOException {
    
    String expectedResponse = "expectedResponse";
    
    when(coinbaseHttpClient.getResponseStringFromHttpGet(testObject.getOperationUrl(CoinbaseClientImpl.RECEIVE_ADDRESS))).thenReturn(expectedResponse);
    
    String actualResponse = testObject.getReceiveAddress();
    
    assertEquals(expectedResponse, actualResponse);
  }
  
  @Test
  public void getAddresses_returnsExpectedResponse() throws ClientProtocolException, IOException {
    
    String expectedResponse = "expectedResponse";
    
    when(coinbaseHttpClient.getResponseStringFromHttpGet(testObject.getOperationUrl(CoinbaseClientImpl.ADDRESSES))).thenReturn(expectedResponse);
    
    String actualResponse = testObject.getAddresses();
    
    assertEquals(expectedResponse, actualResponse);
  }
  
  @Test
  public void getContacts_returnsExpectedResponse() throws ClientProtocolException, IOException {
    
    String expectedResponse = "expectedResponse";
    
    when(coinbaseHttpClient.getResponseStringFromHttpGet(testObject.getOperationUrl(CoinbaseClientImpl.CONTACTS))).thenReturn(expectedResponse);
    
    String actualResponse = testObject.getContacts();
    
    assertEquals(expectedResponse, actualResponse);
  }
  
  @Test
  public void getCurrencies_returnsExpectedResponse() throws ClientProtocolException, IOException {
    
    String expectedResponse = "expectedResponse";
    
    when(coinbaseHttpClient.getResponseStringFromHttpGet(testObject.getOperationUrl(CoinbaseClientImpl.CURRENCIES))).thenReturn(expectedResponse);
    
    String actualResponse = testObject.getCurrencies();
    
    assertEquals(expectedResponse, actualResponse);
  }
  
  @Test
  public void getExchangeRates_returnsExpectedResponse() throws ClientProtocolException, IOException {
    
    String expectedResponse = "expectedResponse";
    
    when(coinbaseHttpClient.getResponseStringFromHttpGet(testObject.getOperationUrl(CoinbaseClientImpl.CURRENCIES + CoinbaseClientImpl.EXCHANGE_RATES))).thenReturn(expectedResponse);
    
    String actualResponse = testObject.getExchangeRates();
    
    assertEquals(expectedResponse, actualResponse);
  }
  
  @Test
  public void getOrders_returnsExpectedResponse() throws ClientProtocolException, IOException {
    
    String expectedResponse = "expectedResponse";
    
    when(coinbaseHttpClient.getResponseStringFromHttpGet(testObject.getOperationUrl(CoinbaseClientImpl.ORDERS))).thenReturn(expectedResponse);
    
    String actualResponse = testObject.getOrders();
    
    assertEquals(expectedResponse, actualResponse);
  }
  
  @Test
  public void getInvidualOrder_returnsExpectedResponse() throws ClientProtocolException, IOException {
    
    String expectedResponse = "expectedResponse";
    
    Integer orderId = 1;
    
    when(coinbaseHttpClient.getResponseStringFromHttpGet(testObject.getOperationUrl(CoinbaseClientImpl.ORDERS + CoinbaseClientImpl.FORWARD_SLASH + orderId))).thenReturn(expectedResponse);
    
    String actualResponse = testObject.getInvidualOrder(orderId);
    
    assertEquals(expectedResponse, actualResponse);
  }
  
  @Test
  public void getPriceToBuy_returnsExpectedResponse() throws ClientProtocolException, IOException {
    
    String expectedResponse = "expectedResponse";
    
    when(coinbaseHttpClient.getResponseStringFromHttpGet(testObject.getOperationUrl(CoinbaseClientImpl.PRICES_BUY))).thenReturn(expectedResponse);
    
    String actualResponse = testObject.getPriceToBuy();
    
    assertEquals(expectedResponse, actualResponse);
  }
  
  @Test
  public void getPriceToSell_returnsExpectedResponse() throws ClientProtocolException, IOException {
    
    String expectedResponse = "expectedResponse";
    
    when(coinbaseHttpClient.getResponseStringFromHttpGet(testObject.getOperationUrl(CoinbaseClientImpl.PRICES_SELL))).thenReturn(expectedResponse);
    
    String actualResponse = testObject.getPriceToSell();
    
    assertEquals(expectedResponse, actualResponse);
  }
  
  @Test
  public void getRecentTransactions_returnsExpectedResponse() throws ClientProtocolException, IOException {
    
    String expectedResponse = "expectedResponse";
    
    when(coinbaseHttpClient.getResponseStringFromHttpGet(testObject.getOperationUrl(CoinbaseClientImpl.TRANSACTIONS))).thenReturn(expectedResponse);
    
    String actualResponse = testObject.getRecentTransactions();
    
    assertEquals(expectedResponse, actualResponse);
  }
  
  @Test
  public void getIndividualTransaction_returnsExpectedResponse() throws ClientProtocolException, IOException {
    
    String expectedResponse = "expectedResponse";
    
    Integer transactionId = 1;
    
    when(coinbaseHttpClient.getResponseStringFromHttpGet(testObject.getOperationUrl(CoinbaseClientImpl.TRANSACTIONS + CoinbaseClientImpl.FORWARD_SLASH + transactionId))).thenReturn(expectedResponse);
    
    String actualResponse = testObject.getIndividualTransaction(transactionId);
    
    assertEquals(expectedResponse, actualResponse);
  }
  
  @Test
  public void getRecentBuysAndSells_returnsExpectedResponse() throws ClientProtocolException, IOException {
    
    String expectedResponse = "expectedResponse";
    
    when(coinbaseHttpClient.getResponseStringFromHttpGet(testObject.getOperationUrl(CoinbaseClientImpl.TRANSFERS))).thenReturn(expectedResponse);
    
    String actualResponse = testObject.getRecentBuysAndSells();
    
    assertEquals(expectedResponse, actualResponse);
  }
  
  @Test
  public void getCurrentUser_returnsExpectedResponse() throws ClientProtocolException, IOException {
    
    String expectedResponse = "expectedResponse";
    
    when(coinbaseHttpClient.getResponseStringFromHttpGet(testObject.getOperationUrl(CoinbaseClientImpl.USERS))).thenReturn(expectedResponse);
    
    String actualResponse = testObject.getCurrentUser();
    
    assertEquals(expectedResponse, actualResponse);
  }
  
  @Test
  public void generateReceiveAddress_returnsExpectedResponse() throws ClientProtocolException, IOException{
    
    String expectedResponse = "expectedResponse";
    
    when(coinbaseHttpClient.getResponseStringFromHttpPost(any(String.class))).thenReturn(expectedResponse);
    
    String actualResponse = testObject.generateReceiveAddress();
    
    assertNotNull(actualResponse);
  }
  
  @Test
  public void cancelRequest_returnsExpectedResponse() throws ClientProtocolException, IOException{
    
    String expectedResponse = "expectedResponse";
    
    when(coinbaseHttpClient.getResponseStringFromHttpDelete(any(String.class))).thenReturn(expectedResponse);
    
    String actualResponse = testObject.cancelRequest();
    
    assertNotNull(actualResponse);
  }

}
