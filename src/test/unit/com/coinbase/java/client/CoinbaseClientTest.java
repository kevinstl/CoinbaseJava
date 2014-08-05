package com.coinbase.java.client;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import java.io.IOException;
import java.math.BigDecimal;

import org.apache.commons.io.FileUtils;
import org.apache.http.client.ClientProtocolException;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import com.coinbase.java.domain.deserializer.ResponseDeserializer;
import com.coinbase.java.domain.types.ExchangeRateType;

import static org.mockito.Mockito.when;
import static org.mockito.Matchers.any;

public class CoinbaseClientTest {

  private CoinbaseClient testObject;
  
  private @Mock CoinbaseAuthenticatedHttpClient coinbaseAuthenticatedHttpClient;
  
  private ResponseDeserializer responseDeserializer;
  
  @Before
  public void setup() {
    MockitoAnnotations.initMocks(this);
//    testObject = new CoinbaseClient("apiKey");
    testObject = new CoinbaseClient();
    testObject.setCoinbaseAuthenticatedHttpClient(coinbaseAuthenticatedHttpClient);
    responseDeserializer = new ResponseDeserializer();
    testObject.setResponseDeserializer(responseDeserializer);
  }
  
  @Test
  public void getBalance_returnsExpectedResponse() throws ClientProtocolException, IOException {
    
    String expectedResponse = "expectedResponse";
    
    when(coinbaseAuthenticatedHttpClient.executeGet(testObject.getOperationUrl(CoinbaseClient.BALANCE))).thenReturn(expectedResponse);
    
    String actualBalance = testObject.getBalance();
    
    assertEquals(expectedResponse, actualBalance);
  }
  
  @Test
  public void getReceiveAddress_returnsExpectedResponse() throws ClientProtocolException, IOException {
    
    String expectedResponse = "expectedResponse";
    
    when(coinbaseAuthenticatedHttpClient.executeGet(testObject.getOperationUrl(CoinbaseClient.RECEIVE_ADDRESS))).thenReturn(expectedResponse);
    
    String actualResponse = testObject.getReceiveAddress();
    
    assertEquals(expectedResponse, actualResponse);
  }
  
  @Test
  public void getAddresses_returnsExpectedResponse() throws ClientProtocolException, IOException {
    
    String expectedResponse = "expectedResponse";
    
    when(coinbaseAuthenticatedHttpClient.executeGet(testObject.getOperationUrl(CoinbaseClient.ADDRESSES))).thenReturn(expectedResponse);
    
    String actualResponse = testObject.getAddresses();
    
    assertEquals(expectedResponse, actualResponse);
  }
  
  @Test
  public void getContacts_returnsExpectedResponse() throws ClientProtocolException, IOException {
    
    String expectedResponse = "expectedResponse";
    
    when(coinbaseAuthenticatedHttpClient.executeGet(testObject.getOperationUrl(CoinbaseClient.CONTACTS))).thenReturn(expectedResponse);
    
    String actualResponse = testObject.getContacts();
    
    assertEquals(expectedResponse, actualResponse);
  }
  
  @Test
  public void getCurrencies_returnsExpectedResponse() throws ClientProtocolException, IOException {
    
    String expectedResponse = "expectedResponse";
    
    when(coinbaseAuthenticatedHttpClient.executeGet(testObject.getOperationUrl(CoinbaseClient.CURRENCIES))).thenReturn(expectedResponse);
    
    String actualResponse = testObject.getCurrencies();
    
    assertEquals(expectedResponse, actualResponse);
  }
  
  @Test
  public void getExchangeRates_returnsExpectedResponse() throws ClientProtocolException, IOException {
    
    String expectedResponse = "expectedResponse";
    
    when(coinbaseAuthenticatedHttpClient.executeGet(testObject.getOperationUrl(CoinbaseClient.CURRENCIES + CoinbaseClient.EXCHANGE_RATES))).thenReturn(expectedResponse);
    
    String actualResponse = testObject.getExchangeRates();
    
    assertEquals(expectedResponse, actualResponse);
  }
  
  @Test
  public void getSpecificExchangeRate_returnsExpectedResponse() throws ClientProtocolException, IOException {
    
    BigDecimal expectedResponse = new BigDecimal("0.007499");
    
    String getExchangeRatesResponse = FileUtils.readFileToString(FileUtils.toFile(
        this.getClass().getResource(ResponseDeserializerTest.JSON_PATH + "/getExchangeRatesResponse.json")));
    
    ExchangeRateType exchangeRateType = ExchangeRateType.usd_to_btc;
    
    when(coinbaseAuthenticatedHttpClient.executeGet(testObject.getOperationUrl(CoinbaseClient.CURRENCIES + CoinbaseClient.EXCHANGE_RATES))).thenReturn(getExchangeRatesResponse);
    
//    BigDecimal actualResponse = testObject.getSpecificExchangeRate(exchangeRateType);
    BigDecimal actualResponse = testObject.getSpecificExchangeRate(exchangeRateType.toString());
    
    assertEquals(expectedResponse, actualResponse);
  }
  
  @Test
  public void getOrders_returnsExpectedResponse() throws ClientProtocolException, IOException {
    
    String expectedResponse = "expectedResponse";
    
    when(coinbaseAuthenticatedHttpClient.executeGet(testObject.getOperationUrl(CoinbaseClient.ORDERS))).thenReturn(expectedResponse);
    
    String actualResponse = testObject.getOrders();
    
    assertEquals(expectedResponse, actualResponse);
  }
  
  @Test
  public void getInvidualOrder_returnsExpectedResponse() throws ClientProtocolException, IOException {
    
    String expectedResponse = "expectedResponse";
    
    Integer orderId = 1;
    
    when(coinbaseAuthenticatedHttpClient.executeGet(testObject.getOperationUrl(CoinbaseClient.ORDERS + CoinbaseClient.FORWARD_SLASH + orderId))).thenReturn(expectedResponse);
    
    String actualResponse = testObject.getInvidualOrder(orderId);
    
    assertEquals(expectedResponse, actualResponse);
  }
  
  @Test
  public void getPriceToBuy_returnsExpectedResponse() throws ClientProtocolException, IOException {
    
    String expectedResponse = "expectedResponse";
    
    when(coinbaseAuthenticatedHttpClient.executeGet(testObject.getOperationUrl(CoinbaseClient.PRICES_BUY))).thenReturn(expectedResponse);
    
    String actualResponse = testObject.getPriceToBuy();
    
    assertEquals(expectedResponse, actualResponse);
  }
  
  @Test
  public void getPriceToSell_returnsExpectedResponse() throws ClientProtocolException, IOException {
    
    String expectedResponse = "expectedResponse";
    
    when(coinbaseAuthenticatedHttpClient.executeGet(testObject.getOperationUrl(CoinbaseClient.PRICES_SELL))).thenReturn(expectedResponse);
    
    String actualResponse = testObject.getPriceToSell();
    
    assertEquals(expectedResponse, actualResponse);
  }
  
  @Test
  public void getRecentTransactions_returnsExpectedResponse() throws ClientProtocolException, IOException {
    
    String expectedResponse = "expectedResponse";
    
    when(coinbaseAuthenticatedHttpClient.executeGet(testObject.getOperationUrl(CoinbaseClient.TRANSACTIONS))).thenReturn(expectedResponse);
    
    String actualResponse = testObject.getRecentTransactions();
    
    assertEquals(expectedResponse, actualResponse);
  }
  
  @Test
  public void getIndividualTransaction_returnsExpectedResponse() throws ClientProtocolException, IOException {
    
    String expectedResponse = "expectedResponse";
    
    String transactionId = "123a";
    
    when(coinbaseAuthenticatedHttpClient.executeGet(testObject.getOperationUrl(CoinbaseClient.TRANSACTIONS + CoinbaseClient.FORWARD_SLASH + transactionId))).thenReturn(expectedResponse);
    
    String actualResponse = testObject.getIndividualTransaction(transactionId);
    
    assertEquals(expectedResponse, actualResponse);
  }
  
  @Test
  public void getRecentBuysAndSells_returnsExpectedResponse() throws ClientProtocolException, IOException {
    
    String expectedResponse = "expectedResponse";
    
    when(coinbaseAuthenticatedHttpClient.executeGet(testObject.getOperationUrl(CoinbaseClient.TRANSFERS))).thenReturn(expectedResponse);
    
    String actualResponse = testObject.getRecentBuysAndSells();
    
    assertEquals(expectedResponse, actualResponse);
  }
  
  @Test
  public void getCurrentUser_returnsExpectedResponse() throws ClientProtocolException, IOException {
    
    String expectedResponse = "expectedResponse";
    
    when(coinbaseAuthenticatedHttpClient.executeGet(testObject.getOperationUrl(CoinbaseClient.USERS))).thenReturn(expectedResponse);
    
    String actualResponse = testObject.getCurrentUser();
    
    assertEquals(expectedResponse, actualResponse);
  }
  
  @Test
  public void generateReceiveAddress_returnsExpectedResponse() throws ClientProtocolException, IOException{
    
    String expectedResponse = "expectedResponse";
    
    when(coinbaseAuthenticatedHttpClient.executePost(any(String.class), any(String.class))).thenReturn(expectedResponse);
    
    String actualResponse = testObject.generateReceiveAddress();
    
    assertNotNull(actualResponse);
  }
  
  @Test
  public void cancelRequest_returnsExpectedResponse() throws ClientProtocolException, IOException{
    
    String expectedResponse = "expectedResponse";
    
    when(coinbaseAuthenticatedHttpClient.executeDelete(any(String.class))).thenReturn(expectedResponse);
    
    String transactionId = "123a";
    
    String actualResponse = testObject.deleteTransactionsCancelRequest(transactionId);
    
    assertNotNull(actualResponse);
  }

}
