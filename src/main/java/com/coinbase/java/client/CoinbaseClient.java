package com.coinbase.java.client;

import java.io.IOException;
import java.math.BigDecimal;

import org.apache.http.client.ClientProtocolException;

import com.coinbase.java.domain.deserializer.ResponseDeserializer;
import com.coinbase.java.domain.request.BuyRequest;
import com.coinbase.java.domain.request.TransactionRequest;
import com.coinbase.java.domain.response.BuyResponse;
import com.coinbase.java.domain.response.SendMoneyResponse;
import com.coinbase.java.domain.types.ExchangeRateType;

public interface CoinbaseClient {

  String getBalance() throws ClientProtocolException, IOException;

  String getReceiveAddress() throws ClientProtocolException, IOException;

  String generateReceiveAddress() throws ClientProtocolException, IOException;

  String getAddresses() throws ClientProtocolException, IOException;

  String getPaymentButton() throws ClientProtocolException, IOException;
  
  String getContacts() throws ClientProtocolException, IOException;

  String getCurrencies() throws ClientProtocolException, IOException;

  String getExchangeRates() throws ClientProtocolException, IOException;

  String getOrders() throws ClientProtocolException, IOException;

  String getInvidualOrder(Integer orderId) throws ClientProtocolException, IOException;

  String getPriceToBuy() throws ClientProtocolException, IOException;

  String getPriceToSell() throws ClientProtocolException, IOException;

  String getRecentTransactions() throws ClientProtocolException, IOException;

  String getIndividualTransaction(Integer transactionId) throws ClientProtocolException, IOException;

  String getRecentBuysAndSells() throws ClientProtocolException, IOException;

  String getCurrentUser() throws ClientProtocolException, IOException;

  String getOperationUrl(String operation);

  String cancelRequest() throws ClientProtocolException, IOException;
  
  void setCoinbaseHttpClient(CoinbaseHttpClient coinbaseHttpClient);

  SendMoneyResponse sendMoney(TransactionRequest transactionSenderWrapper) throws ClientProtocolException, IOException;

//  BigDecimal getSpecificExchangeRate(ExchangeRateType exchangeRateType) throws ClientProtocolException, IOException;
  BigDecimal getSpecificExchangeRate(String exchangeRateType) throws ClientProtocolException, IOException;

  void setResponseDeserializer(ResponseDeserializer responseDeserializer);

  BuyResponse buy(BuyRequest buyRequest) throws ClientProtocolException, IOException;

}
