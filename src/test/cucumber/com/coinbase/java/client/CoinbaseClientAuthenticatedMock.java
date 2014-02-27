package com.coinbase.java.client;

import java.io.IOException;
import java.math.BigDecimal;

import org.apache.commons.io.FileUtils;
import org.apache.commons.lang.StringUtils;
import org.apache.http.client.ClientProtocolException;
import org.springframework.stereotype.Component;

import com.coinbase.java.domain.request.BuyRequest;
import com.coinbase.java.domain.request.TransactionRequest;
import com.coinbase.java.domain.response.BuyResponse;
import com.coinbase.java.domain.response.ExchangeRatesResponse;
import com.coinbase.java.domain.response.SendMoneyResponse;
import com.coinbase.java.exception.CoinbaseException;
import com.google.gson.Gson;

@Component
public class CoinbaseClientAuthenticatedMock extends CoinbaseClient {

  public CoinbaseClientAuthenticatedMock() {
    super("mockApiKey");
  }
  
  public CoinbaseClientAuthenticatedMock(String apiKey) {
    super(apiKey);
  }
  
  @Override
  public String getAccountChanges() throws IOException{
    try{
      return super.getAccountChanges();
    }
    catch(CoinbaseException e){
      return returnExpectedStringResponse(e, "getAccountChangesSuccess.json");
    }
  }
  
  @Override
  public String getBalance() throws IOException{
    try{
      return super.getBalance();
    }
    catch(CoinbaseException e){
      return returnExpectedStringResponse(e, "getBalanceSuccess.json");
    }
  }

  @Override
  public String getReceiveAddress() throws ClientProtocolException, IOException {
    try{
      return super.getReceiveAddress();
    }
    catch(CoinbaseException e){
      return returnExpectedStringResponse(e, "getReceiveAddressSuccess.json");
    }
  }
  
  @Override
  public String getAddresses() throws ClientProtocolException, IOException {
    try{
      return super.getAddresses();
    }
    catch(CoinbaseException e){
      return returnExpectedStringResponse(e, "getAddressesSuccess.json");
    }
  }



  @Override
  public String getContacts() throws ClientProtocolException, IOException {
    try{
      return super.getContacts();
    }
    catch(CoinbaseException e){
      return returnExpectedStringResponse(e, "getContactsSuccess.json");
    }
  }


  @Override
  public String getCurrencies() throws ClientProtocolException, IOException {
    try{
      return super.getCurrencies();
    }
    catch(CoinbaseException e){
      return returnExpectedStringResponse(e, "getCurrenciesSuccess.json");
    }
  }


//  @Override
//  public String getExchangeRates() throws ClientProtocolException, IOException {
//    try{
//      return super.getExchangeRates();
//    }
//    catch(CoinbaseException e){
//      return returnExpectedStringResponse(e, "getExchangeRatesSuccess.json");
//    }
//  }
  

  @Override
  public String getOrders() throws ClientProtocolException, IOException {
    try{
      return super.getOrders();
    }
    catch(CoinbaseException e){
      return returnExpectedStringResponse(e, "getOrdersSuccess.json");
    }
  }


  @Override
  public String getInvidualOrder(Integer orderId) throws ClientProtocolException, IOException {
    try{
      return super.getInvidualOrder(orderId);
    }
    catch(CoinbaseException e){
      return returnExpectedStringResponse(e, "getIndividualOrderSuccess.json");
    }
  }


//  @Override
//  public String getPriceToBuy() throws ClientProtocolException, IOException {
//    try{
//      return super.getPriceToBuy();
//    }
//    catch(CoinbaseException e){
//      return returnExpectedStringResponse(e, "getBalanceSuccess.json");
//    }
//  }


//  @Override
//  public String getPriceToSell() throws ClientProtocolException, IOException {
//    try{
//      return super.getBalance();
//    }
//    catch(CoinbaseException e){
//      return returnExpectedStringResponse(e, "getBalanceSuccess.json");
//    }
//  }


  @Override
  public String getRecentTransactions() throws ClientProtocolException, IOException {
    try{
      return super.getRecentTransactions();
    }
    catch(CoinbaseException e){
      return returnExpectedStringResponse(e, "getRecentTransactionsSuccess.json");
    }
  }


  @Override
  public String getIndividualTransaction(Integer transactionId) throws ClientProtocolException, IOException {
    try{
      return super.getIndividualTransaction(transactionId);
    }
    catch(CoinbaseException e){
      return returnExpectedStringResponse(e, "getIndividualTransactionSuccess.json");
    }
  }


  @Override
  public String getRecentBuysAndSells() throws ClientProtocolException, IOException {
    try{
      return super.getRecentBuysAndSells();
    }
    catch(CoinbaseException e){
      return returnExpectedStringResponse(e, "getRecentBuysAndSellsSuccess.json");
    }
  }


  @Override
  public String getCurrentUser() throws ClientProtocolException, IOException {
    try{
      return super.getCurrentUser();
    }
    catch(CoinbaseException e){
      return returnExpectedStringResponse(e, "getCurrentUserSuccess.json");
    }
  }
  

  @Override
  public String generateReceiveAddress() throws ClientProtocolException, IOException {
    try{
      return super.getBalance();
    }
    catch(CoinbaseException e){
      return returnExpectedStringResponse(e, "getBalanceSuccess.json");
    }
  }

  @Override
  public String cancelRequest() throws ClientProtocolException, IOException {
    try{
      return super.getBalance();
    }
    catch(CoinbaseException e){
      return returnExpectedStringResponse(e, "getBalanceSuccess.json");
    }
  }


  
  @Override
  public String getPaymentButton() throws ClientProtocolException, IOException {
    try{
      return super.getPaymentButton();
    }
    catch(CoinbaseException e){
      return returnExpectedStringResponse(e, "getBalanceSuccess.json");
    }
  }
  
  @Override
  public SendMoneyResponse sendMoney(TransactionRequest transactionSenderWrapper) throws ClientProtocolException, IOException {
    try{
      return super.sendMoney(transactionSenderWrapper);
    }
    catch(CoinbaseException e){
      String responseString = returnExpectedStringResponse(e, "sendMoneyResponseSuccess.json");
      return getResponseDeserializer().deserializeSendMoneyResponse(responseString);
    }
  }
  
  @Override
  public BuyResponse buy(BuyRequest buyRequest) throws ClientProtocolException, IOException {
    try{
      return super.buy(buyRequest);
    }
    catch(CoinbaseException e){
      String responseString = returnExpectedStringResponse(e, "buyResponseSuccess.json");
      return getResponseDeserializer().deserializeBuyResponse(responseString);
    }
  }


  private String returnExpectedStringResponse(CoinbaseException e, String responseFileName) throws IOException {
    if(StringUtils.equals(CoinbaseClient.INVALID_API_KEY, e.getMessage())){
      return getResponse(responseFileName);
    }
    else{
      throw new IOException("");
    }
  }

  private String getResponse(String responseFileName) throws IOException {
    return FileUtils.readFileToString(FileUtils.toFile(
    this.getClass().getResource(ResponseDeserializerTest.JSON_PATH + "/" + responseFileName)));
  }
  


}
