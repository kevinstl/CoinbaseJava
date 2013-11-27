package com.coinbase.java.client;

import java.io.IOException;
import java.math.BigDecimal;
import java.util.logging.Logger;

import org.apache.http.client.ClientProtocolException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import com.coinbase.java.domain.deserializer.ResponseDeserializer;
import com.coinbase.java.domain.request.BuyRequest;
import com.coinbase.java.domain.request.TransactionRequest;
import com.coinbase.java.domain.response.BuyResponse;
import com.coinbase.java.domain.response.ExchangeRatesResponse;
import com.coinbase.java.domain.response.SendMoneyResponse;
import com.coinbase.java.domain.types.ExchangeRateType;
import com.google.gson.Gson;


@Component
public class CoinbaseClientImpl implements CoinbaseClient {
  
  public static final String FORWARD_SLASH = "/";
  public static final String CANCEL_REQUEST = "/cancel_request";
  public static final String GENERATE_RECEIVE_ADDRESS = "/account/generate_receive_address";
  public static final String USERS = "/users";
  public static final String TRANSFERS = "/transfers";
  public static final String TRANSACTIONS = "/transactions";
  public static final String PRICES_SELL = "/prices/sell";
  public static final String PRICES_BUY = "/prices/buy";
  public static final String ORDERS = "/orders";
  public static final String EXCHANGE_RATES = "/exchange_rates";
  public static final String CURRENCIES = "/currencies";
  public static final String CONTACTS = "/contacts";
  public static final String ADDRESSES = "/addresses";
  public static final String RECEIVE_ADDRESS = "/account/receive_address";
  public static final String BALANCE = "/account/balance";
  public static final String BUYS = "/buys";

  private static final String API_KEY = "?api_key=";

  private static final String HTTPS_COINBASE_COM_API_V1_ACCOUNT = "https://coinbase.com/api/v1";

  private static Logger logger = Logger.getLogger(CoinbaseClientImpl.class.getName());

  @Autowired
  private CoinbaseHttpClient coinbaseHttpClient;
  
  @Autowired
  private ResponseDeserializer responseDeserializer;
  
  public CoinbaseHttpClient getCoinbaseHttpClient() {
    return coinbaseHttpClient;
  }

  @Override
  public void setCoinbaseHttpClient(CoinbaseHttpClient coinbaseHttpClient) {
    this.coinbaseHttpClient = coinbaseHttpClient;
  }
  
  

  public ResponseDeserializer getResponseDeserializer() {
    return responseDeserializer;
  }

  @Override
  public void setResponseDeserializer(ResponseDeserializer responseDeserializer) {
    this.responseDeserializer = responseDeserializer;
  }



  private String apiKey;
  
  private CoinbaseClientImpl() {
  }
  
  public CoinbaseClientImpl(String apiKey) {
    this.apiKey = apiKey;
  }
  
  
  @Override
  public String getBalance() throws ClientProtocolException, IOException {
    String operation = BALANCE;
    
    String responseString = httpGet(operation);
    
    return responseString;
  }

  @Override
  public String getReceiveAddress() throws ClientProtocolException, IOException {
    String operation = RECEIVE_ADDRESS;
    
    String responseString = httpGet(operation);
    
    return responseString;
  }
  
  @Override
  public String getAddresses() throws ClientProtocolException, IOException {
    String operation = ADDRESSES;
    
    String responseString = httpGet(operation);
    
    return responseString;
  }
  
  @Override
  public String getPaymentButton() throws ClientProtocolException, IOException {
    String operation = ADDRESSES;
    
    String payload = null;
    String responseString = httpPost(operation, payload);
    
    return responseString;
  }



  @Override
  public String getContacts() throws ClientProtocolException, IOException {
    String operation = CONTACTS;
    
    String responseString = httpGet(operation);
    
    return responseString;
  }


  @Override
  public String getCurrencies() throws ClientProtocolException, IOException {
    String operation = CURRENCIES;
    
    String responseString = httpGet(operation);
    
    return responseString;
  }


  @Override
  public String getExchangeRates() throws ClientProtocolException, IOException {
    String operation = CURRENCIES + EXCHANGE_RATES;
    
    String responseString = httpGet(operation);
    
    return responseString;
  }
  
  

  @Override
//  public BigDecimal getSpecificExchangeRate(ExchangeRateType exchangeRateType) throws ClientProtocolException, IOException {
    public BigDecimal getSpecificExchangeRate(String exchangeRateType) throws ClientProtocolException, IOException {
    String exchangeRates = getExchangeRates();
    
    ExchangeRatesResponse exchangeRatesResponse = responseDeserializer.deserializeExchangeRatesResponse(exchangeRates);
    
//    return exchangeRatesResponse.getExchangeRateValueMap().get(exchangeRateType.toString()).toString();
    
    BigDecimal specifiedExchangeRate = exchangeRatesResponse.get(exchangeRateType);
    
    return specifiedExchangeRate;
  }


  @Override
  public String getOrders() throws ClientProtocolException, IOException {
    String operation = ORDERS;
    
    String responseString = httpGet(operation);
    
    return responseString;
  }


  @Override
  public String getInvidualOrder(Integer orderId) throws ClientProtocolException, IOException {
    String operation = ORDERS + FORWARD_SLASH + orderId;
    
    String responseString = httpGet(operation);
    
    return responseString;
  }


  @Override
  public String getPriceToBuy() throws ClientProtocolException, IOException {
    String operation = PRICES_BUY;
    
    String responseString = httpGet(operation);
    
    return responseString;
  }


  @Override
  public String getPriceToSell() throws ClientProtocolException, IOException {
    String operation = PRICES_SELL;
    
    String responseString = httpGet(operation);
    
    return responseString;
  }


  @Override
  public String getRecentTransactions() throws ClientProtocolException, IOException {
    String operation = TRANSACTIONS;
    
    String responseString = httpGet(operation);
    
    return responseString;
  }


  @Override
  public String getIndividualTransaction(Integer transactionId) throws ClientProtocolException, IOException {
    String operation = TRANSACTIONS + FORWARD_SLASH + transactionId;
    
    String responseString = httpGet(operation);
    
    return responseString;
  }


  @Override
  public String getRecentBuysAndSells() throws ClientProtocolException, IOException {
    String operation = TRANSFERS;
    
    String responseString = httpGet(operation);
    
    return responseString;
  }


  @Override
  public String getCurrentUser() throws ClientProtocolException, IOException {
    String operation = USERS;
    
    String responseString = httpGet(operation);
    
    return responseString;
  }
  

  @Override
  public String generateReceiveAddress() throws ClientProtocolException, IOException {
    String operation = GENERATE_RECEIVE_ADDRESS;
    
    String payload = null;
    String responseString = httpPost(operation, payload);
    
    return responseString;
  }

  @Override
  public String cancelRequest() throws ClientProtocolException, IOException {
    String operation = CANCEL_REQUEST;
    
    String responseString = httpDelete(operation);
    
    return responseString;
  }


  
  @Override
  public SendMoneyResponse sendMoney(TransactionRequest transactionSenderWrapper) throws ClientProtocolException, IOException {
    String operation = TRANSACTIONS + FORWARD_SLASH + "send_money";
    
    Gson gson = new Gson(); 
    String payload = gson.toJson(transactionSenderWrapper);
    
    String responseString = httpPost(operation, payload);
    
    SendMoneyResponse sendMoneyResponse = responseDeserializer.deserializeSendMoneyResponse(responseString);
    
    return sendMoneyResponse;
  }
  
  @Override
  public BuyResponse buy(BuyRequest buyRequest) throws ClientProtocolException, IOException {
    String operation = BUYS;
    
    Gson gson = new Gson(); 
    String payload = gson.toJson(buyRequest);
    
    String responseString = httpPost(operation, payload);
    
    BuyResponse buyResponse = responseDeserializer.deserializeBuyResponse(responseString);
    
    return buyResponse;
  }

  

  private String httpGet(String operation) throws IOException,
  ClientProtocolException {
    String urlString = getOperationUrl(operation);
    
    String responseString = coinbaseHttpClient.getResponseStringFromHttpGet(urlString);
    
    //logger.info("httpResponse.toString(): " + responseString);
    return responseString;
  }


  @Override
  public String getOperationUrl(String operation) {
    return HTTPS_COINBASE_COM_API_V1_ACCOUNT + operation + API_KEY + apiKey;
  }

  private String httpPost(String operation, String payload) throws IOException,
      ClientProtocolException {
    String urlString = getOperationUrl(operation); 
    
    String responseString = coinbaseHttpClient.getResponseStringFromHttpPost(urlString, payload);
    
    //logger.info("httpResponse.toString(): " + responseString);
    return responseString;
  }
  
  private String httpDelete(String operation) throws IOException,
  ClientProtocolException {
    String urlString = getOperationUrl(operation); 
    
    String responseString = coinbaseHttpClient.getResponseStringFromHttpDelete(urlString);
    
    //logger.info("httpResponse.toString(): " + responseString);
    return responseString;
  }



}
