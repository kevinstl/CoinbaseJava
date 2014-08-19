package com.github.kevinstl.coinbase.java.client;

import java.io.IOException;
import java.math.BigDecimal;

import org.apache.commons.io.FileUtils;
import org.apache.commons.lang.StringUtils;
import org.apache.http.client.ClientProtocolException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.github.kevinstl.coinbase.java.client.CoinbaseClient;
import com.github.kevinstl.coinbase.java.client.CoinbaseHttpClient;
import com.github.kevinstl.coinbase.java.client.ResponseDeserializerTest;
import com.github.kevinstl.coinbase.java.domain.request.ButtonRequest;
import com.github.kevinstl.coinbase.java.domain.request.BuyRequest;
import com.github.kevinstl.coinbase.java.domain.request.OauthApplication;
import com.github.kevinstl.coinbase.java.domain.request.TokenRequest;
import com.github.kevinstl.coinbase.java.domain.request.TransactionFromRequest;
import com.github.kevinstl.coinbase.java.domain.request.TransactionRequest;
import com.github.kevinstl.coinbase.java.domain.request.UserRequest;
import com.github.kevinstl.coinbase.java.domain.response.BuyResponse;
import com.github.kevinstl.coinbase.java.domain.response.ExchangeRatesResponse;
import com.github.kevinstl.coinbase.java.domain.response.SendMoneyResponse;
import com.github.kevinstl.coinbase.java.exception.CoinbaseException;
import com.google.gson.Gson;

@Component
public class CoinbaseClientAuthenticatedMock extends CoinbaseClient {

//  public CoinbaseClientAuthenticatedMock() {
//    super("mockApiKey");
//  }
//  
//  public CoinbaseClientAuthenticatedMock(String apiKey) {
//    super(apiKey);
//  }
  
  @Autowired
  private CoinbaseHttpClient coinbaseHttpClient;
  
  
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
  public String getOauthApplications() throws ClientProtocolException, IOException {
    try{
      return super.getOauthApplications();
    }
    catch(CoinbaseException e){
      return returnExpectedStringResponse(e, "getOauthApplications.json");
    }
  }
  
  @Override
  public String getOauthIndividualApplication(Integer applicationId) throws ClientProtocolException, IOException {
    try{
      return super.getOauthIndividualApplication(applicationId);
    }
    catch(CoinbaseException e){
      return returnExpectedStringResponse(e, "getOauthIndividualApplication.json");
    }
  }
  
  @Override
  public String postCreateOauthApplication(OauthApplication oauthApplication) throws ClientProtocolException, IOException {
    try{
      return super.postCreateOauthApplication(oauthApplication);
    }
    catch(CoinbaseException e){
      return returnExpectedStringResponse(e, "postCreateOauthApplication.json");
    }
  }
  
  @Override
  public String getAuthorization() throws ClientProtocolException, IOException {
    try{
      return super.getAuthorization();
    }
    catch(CoinbaseException e){
      return returnExpectedStringResponse(e, "getAuthorizationSuccess.json");
    }
  }
  
  @Override
  public String postCreatePaymentObject(ButtonRequest buttonRequest) throws ClientProtocolException, IOException {
    try{
      return super.postCreatePaymentObject(buttonRequest);
    }
    catch(CoinbaseException e){
      return returnExpectedStringResponse(e, "postCreatePaymentButtonSuccess.json");
    }
  }
  
  @Override
  public String postCreateOrder(String objectId) throws ClientProtocolException, IOException {
    try{
      return super.postCreateOrder(objectId);
    }
    catch(CoinbaseException e){
      return returnExpectedStringResponse(e, "postCreateOrderSuccess.json");
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
  public String postOrders(ButtonRequest buttonRequest) throws ClientProtocolException, IOException {
    try{
      return super.postOrders(buttonRequest);
    }
    catch(CoinbaseException e){
      return returnExpectedStringResponse(e, "postCreateOrdersSuccess.json");
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
  
  
  @Override
  public String getPaymentMethods() throws ClientProtocolException, IOException {
    try{
      return super.getPaymentMethods();
    }
    catch(CoinbaseException e){
      return returnExpectedStringResponse(e, "getPaymentMethodsSuccess.json");
    }
  }


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
  public String getIndividualTransaction(String transactionId) throws ClientProtocolException, IOException {
    try{
      return super.getIndividualTransaction(transactionId);
    }
    catch(CoinbaseException e){
      return returnExpectedStringResponse(e, "getIndividualTransactionSuccess.json");
    }
  }
  
  
  @Override
  public String getRecurringPayments() throws ClientProtocolException, IOException {
    try{
      return super.getRecurringPayments();
    }
    catch(CoinbaseException e){
      return returnExpectedStringResponse(e, "getRecurringPaymentsSuccess.json");
    }
  }
  
  
  @Override
  public String getIndividualRecurringPayment(Integer paymentId) throws ClientProtocolException, IOException {
    try{
      return super.getIndividualRecurringPayment(paymentId);
    }
    catch(CoinbaseException e){
      return returnExpectedStringResponse(e, "getIndividualRecurringPaymentSuccess.json");
    }
  }
  
  
  @Override
  public String getSubscribers() throws ClientProtocolException, IOException {
    try{
      return super.getSubscribers();
    }
    catch(CoinbaseException e){
      return returnExpectedStringResponse(e, "getSubscribersSuccess.json");
    }
  }
  
  
  @Override
  public String getIndividualSubscriber(Integer subscriberId) throws ClientProtocolException, IOException {
    try{
      return super.getIndividualSubscriber(subscriberId);
    }
    catch(CoinbaseException e){
      return returnExpectedStringResponse(e, "getIndividualSubscriberSuccess.json");
    }
  }
  
  
  @Override
  public String postTokens() throws ClientProtocolException, IOException {
    try{
      return super.postTokens();
    }
    catch(CoinbaseException e){
      return returnExpectedStringResponse(e, "postTokensSuccess.json");
    }
  }
  
  
  @Override
  public String postTokensRedeem(TokenRequest tokenRequest) throws ClientProtocolException, IOException {
    try{
      return super.postTokensRedeem(tokenRequest);
    }
    catch(CoinbaseException e){
      return returnExpectedStringResponse(e, "postTokensRedeemSuccess.json");
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
  public String putUserAccountSettings(String userId, UserRequest userRequest) throws ClientProtocolException, IOException {
    try{
      return super.putUserAccountSettings(userId, userRequest);
    }
    catch(CoinbaseException e){
      return returnExpectedStringResponse(e, "putUserAccountSettingsSuccess.json");
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
  public String postTransactionsRequestMoney(TransactionFromRequest transactionFromRequest) throws ClientProtocolException, IOException {
    try{
      return super.postTransactionsRequestMoney(transactionFromRequest);
    }
    catch(CoinbaseException e){
      return returnExpectedStringResponse(e, "postTransactionsRequestMoneySuccess.json");
    }
  }
  
  @Override
  public String putTransactionsResendRequest(String transactionId) throws ClientProtocolException, IOException {
    try{
      return super.putTransactionsResendRequest(transactionId);
    }
    catch(CoinbaseException e){
      return returnExpectedStringResponse(e, "putTransactionsResendRequestSuccess.json");
    }
  }

  @Override
  public String deleteTransactionsCancelRequest(String transactionId) throws ClientProtocolException, IOException {
    try{
      return super.deleteTransactionsCancelRequest(transactionId);
    }
    catch(CoinbaseException e){
      return returnExpectedStringResponse(e, "deleteTransactionsCancelRequestSuccess.json");
    }
  }
  
  @Override
  public String putTransactionsCompleteRequest(String transactionId) throws ClientProtocolException, IOException {
    try{
      return super.putTransactionsCompleteRequest(transactionId);
    }
    catch(CoinbaseException e){
      return returnExpectedStringResponse(e, "putTransactionsCompleteRequestSuccess.json");
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
  
  public String httpGet(String operation) throws IOException, ClientProtocolException {
    String urlString = getOperationUrl(operation);

    String responseString = coinbaseHttpClient.executeGet(urlString);
    
    checkResponseForAuthenticationError(responseString);

    // logger.info("httpResponse.toString(): " + responseString);
    return responseString;
  }
  
  protected String httpPost(String operation, String payload) throws IOException, ClientProtocolException {
    String urlString = getOperationUrl(operation);

    String responseString = coinbaseHttpClient.executePost(urlString, payload);

    checkResponseForAuthenticationError(responseString);

    // logger.info("httpResponse.toString(): " + responseString);
    return responseString;
  }

  protected String httpPut(String operation, String payload) throws IOException, ClientProtocolException {
    String urlString = getOperationUrl(operation);

    String responseString = coinbaseHttpClient.executePut(urlString, payload);

    checkResponseForAuthenticationError(responseString);

    // logger.info("httpResponse.toString(): " + responseString);
    return responseString;
  }

  protected String httpDelete(String operation) throws IOException, ClientProtocolException {
    String urlString = getOperationUrl(operation);

    String responseString = coinbaseHttpClient.executeDelete(urlString);

    checkResponseForAuthenticationError(responseString);

    // logger.info("httpResponse.toString(): " + responseString);
    return responseString;
  }

}
