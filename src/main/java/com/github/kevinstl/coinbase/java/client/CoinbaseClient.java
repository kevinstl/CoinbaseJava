package com.github.kevinstl.coinbase.java.client;

import java.io.IOException;
import java.math.BigDecimal;
import java.util.logging.Logger;

import org.apache.http.client.ClientProtocolException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.github.kevinstl.coinbase.java.domain.deserializer.ResponseDeserializer;
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
public class CoinbaseClient {

  private static final String INVALID_TOKEN = "invalid_token";
  public static final String INVALID_API_KEY = "Invalid api_key";
  public static final String FORWARD_SLASH = "/";
  public static final String ACCOUNT_CHANGES = "/account_changes";
  public static final String GENERATE_RECEIVE_ADDRESS = "/account/generate_receive_address";

  public static final String BALANCE = "/account/balance";
  public static final String RECEIVE_ADDRESS = "/account/receive_address";
  public static final String ADDRESSES = "/addresses";

  public static final String OAUTH = "/oauth";
  public static final String OAUTH_APPLICATIONS = OAUTH + "/applications";

  public static final String AUTHORIZATION = "/authorization";

  private static final String BUTTONS = "/buttons";
  private static final String CREATE_ORDER = "/create_order";

  public static final String BUYS = "/buys";

  public static final String CONTACTS = "/contacts";

  public static final String CURRENCIES = "/currencies";
  public static final String EXCHANGE_RATES = "/exchange_rates";

  public static final String ORDERS = "/orders";

  public static final String PAYMENT_METHODS = "/payment_methods";

  public static final String PRICES_BUY = "/prices/buy";
  public static final String PRICES_SELL = "/prices/sell";
  public static final String PRICES_SPOT_RATE = "/prices/spot_rate";
  public static final String PRICES_HISTORICAL = "/prices/historical";

  private static final String RECURRING_PAYMENTS = "/recurring_payments";
  private static final String SUBSCRIBERS = "/subscribers";

  public static final String TOKENS = "/tokens";

  public static final String TRANSACTIONS = "/transactions";
  public static final String SEND_MONEY = "send_money";
  public static final String REQUEST_MONEY = "request_money";
  public static final String RESEND_REQUEST = "resend_request";
  public static final String CANCEL_REQUEST = "cancel_request";
  public static final String COMPLETE_REQUEST = "complete_request";

  public static final String TRANSFERS = "/transfers";

  public static final String USERS = "/users";

  // private static final String API_KEY = "?api_key=";

  private static final String HTTPS_COINBASE_COM_API_V1_ACCOUNT = "https://coinbase.com/api/v1";

  private static Logger logger = Logger.getLogger(CoinbaseClient.class.getName());


  @Autowired
  private CoinbaseAuthenticatedHttpClient coinbaseAuthenticatedHttpClient;

  public CoinbaseAuthenticatedHttpClient getCoinbaseAuthenticatedHttpClient() {
    return coinbaseAuthenticatedHttpClient;
  }

  public void setCoinbaseAuthenticatedHttpClient(CoinbaseAuthenticatedHttpClient coinbaseAuthenticatedHttpClient) {
    this.coinbaseAuthenticatedHttpClient = coinbaseAuthenticatedHttpClient;
  }

  @Autowired
  private ResponseDeserializer responseDeserializer;



  public ResponseDeserializer getResponseDeserializer() {
    return responseDeserializer;
  }

  public void setResponseDeserializer(ResponseDeserializer responseDeserializer) {
    this.responseDeserializer = responseDeserializer;
  }

  // private String apiKey;

  // private CoinbaseClient() {
  // }

  // public CoinbaseClient(String apiKey) {
  // this.apiKey = apiKey;
  // }

  public String getAccountChanges() throws ClientProtocolException, IOException {
    String operation = ACCOUNT_CHANGES;

    String responseString = httpGet(operation);

    return responseString;
  }

  public String getBalance() throws ClientProtocolException, IOException {
    String operation = BALANCE;

    String responseString = httpGet(operation);

    return responseString;
  }

  public String getReceiveAddress() throws ClientProtocolException, IOException {
    String operation = RECEIVE_ADDRESS;

    String responseString = httpGet(operation);

    return responseString;
  }

  public String getAddresses() throws ClientProtocolException, IOException {
    String operation = ADDRESSES;

    String responseString = httpGet(operation);

    return responseString;
  }

  public String getOauthApplications() throws ClientProtocolException, IOException {
    String operation = OAUTH_APPLICATIONS;

    String responseString = httpGet(operation);

    return responseString;
  }

  public String getOauthIndividualApplication(Integer applicationId) throws ClientProtocolException, IOException {
    String operation = OAUTH_APPLICATIONS + "/" + applicationId;

    String responseString = httpGet(operation);

    return responseString;
  }

  public String postCreateOauthApplication(OauthApplication oauthApplication) throws ClientProtocolException, IOException {
    String operation = OAUTH_APPLICATIONS;

    Gson gson = new Gson();
    String payload = gson.toJson(oauthApplication);
    String responseString = httpPost(operation, payload);

    return responseString;
  }

  public String getAuthorization() throws ClientProtocolException, IOException {
    String operation = AUTHORIZATION;

    String responseString = httpGet(operation);

    return responseString;
  }

  public String postCreatePaymentObject(ButtonRequest buttonRequest) throws ClientProtocolException, IOException {
    String operation = BUTTONS;

    Gson gson = new Gson();
    String payload = gson.toJson(buttonRequest);
    String responseString = httpPost(operation, payload);

    return responseString;
  }

  public String postCreateOrder(String objectId) throws ClientProtocolException, IOException {
    String operation = BUTTONS + "/" + objectId + CREATE_ORDER;

    String responseString = httpPost(operation, null);

    return responseString;
  }

  public String getContacts() throws ClientProtocolException, IOException {
    String operation = CONTACTS;

    String responseString = httpGet(operation);

    return responseString;
  }

  public String getCurrencies() throws ClientProtocolException, IOException {
    String operation = CURRENCIES;

    String responseString = httpGet(operation);

    return responseString;
  }

  public String getExchangeRates() throws ClientProtocolException, IOException {
    String operation = CURRENCIES + EXCHANGE_RATES;

    String responseString = httpGet(operation);

    return responseString;
  }

  public BigDecimal getSpecificExchangeRate(String exchangeRateType) throws ClientProtocolException, IOException {
    String exchangeRates = getExchangeRates();

    ExchangeRatesResponse exchangeRatesResponse = responseDeserializer.deserializeExchangeRatesResponse(exchangeRates);

    BigDecimal specifiedExchangeRate = exchangeRatesResponse.get(exchangeRateType);

    return specifiedExchangeRate;
  }

  public String getOrders() throws ClientProtocolException, IOException {
    String operation = ORDERS;

    String responseString = httpGet(operation);

    return responseString;
  }

  public String postOrders(ButtonRequest buttonRequest) throws ClientProtocolException, IOException {
    String operation = BUTTONS;

    Gson gson = new Gson();
    String payload = gson.toJson(buttonRequest);
    String responseString = httpPost(operation, payload);

    return responseString;
  }

  public String getInvidualOrder(Integer orderId) throws ClientProtocolException, IOException {
    String operation = ORDERS + FORWARD_SLASH + orderId;

    String responseString = httpGet(operation);

    return responseString;
  }

  public String getPaymentMethods() throws ClientProtocolException, IOException {
    String operation = PAYMENT_METHODS;

    String responseString = httpGet(operation);

    return responseString;
  }

  public String getPriceToBuy() throws ClientProtocolException, IOException {
    String operation = PRICES_BUY;

    String responseString = httpGet(operation);

    return responseString;
  }

  public String getPriceToSell() throws ClientProtocolException, IOException {
    String operation = PRICES_SELL;

    String responseString = httpGet(operation);

    return responseString;
  }

  public String getPricesSpotRate() throws ClientProtocolException, IOException {
    String operation = PRICES_SPOT_RATE;

    String responseString = httpGet(operation);

    return responseString;
  }

  public String getPricesHistorical() throws ClientProtocolException, IOException {
    String operation = PRICES_HISTORICAL;

    String responseString = httpGet(operation);

    return responseString;
  }

  public String getRecurringPayments() throws ClientProtocolException, IOException {
    String operation = RECURRING_PAYMENTS;

    String responseString = httpGet(operation);

    return responseString;
  }

  public String getIndividualRecurringPayment(Integer paymentId) throws ClientProtocolException, IOException {
    String operation = RECURRING_PAYMENTS + "/" + paymentId;

    String responseString = httpGet(operation);

    return responseString;
  }

  public String getSubscribers() throws ClientProtocolException, IOException {
    String operation = SUBSCRIBERS;

    String responseString = httpGet(operation);

    return responseString;
  }

  public String getIndividualSubscriber(Integer subscriberId) throws ClientProtocolException, IOException {
    String operation = SUBSCRIBERS + "/" + subscriberId;

    String responseString = httpGet(operation);

    return responseString;
  }

  public String postTokens() throws ClientProtocolException, IOException {
    String operation = TOKENS;

    String responseString = httpPost(operation, null);

    return responseString;
  }

  public String postTokensRedeem(TokenRequest tokenRequest) throws ClientProtocolException, IOException {
    String operation = TOKENS;

    Gson gson = new Gson();
    String payload = gson.toJson(tokenRequest);

    String responseString = httpPost(operation, payload);

    return responseString;
  }

  public String getRecentTransactions() throws ClientProtocolException, IOException {
    String operation = TRANSACTIONS;

    String responseString = httpGet(operation);

    return responseString;
  }

  public String getIndividualTransaction(String transactionId) throws ClientProtocolException, IOException {
    String operation = TRANSACTIONS + FORWARD_SLASH + transactionId;

    String responseString = httpGet(operation);

    return responseString;
  }

  public SendMoneyResponse sendMoney(TransactionRequest transactionSenderWrapper) throws ClientProtocolException, IOException {
    String operation = TRANSACTIONS + FORWARD_SLASH + SEND_MONEY;

    Gson gson = new Gson();
    String payload = gson.toJson(transactionSenderWrapper);

    String responseString = httpPost(operation, payload);

    SendMoneyResponse sendMoneyResponse = responseDeserializer.deserializeSendMoneyResponse(responseString);

    return sendMoneyResponse;
  }

  public String postTransactionsRequestMoney(TransactionFromRequest transactionFromRequest) throws ClientProtocolException, IOException {
    String operation = TRANSACTIONS + FORWARD_SLASH + REQUEST_MONEY;

    Gson gson = new Gson();
    String payload = gson.toJson(transactionFromRequest);

    String responseString = httpPost(operation, payload);

    return responseString;
  }

  public String putTransactionsResendRequest(String transactionId) throws ClientProtocolException, IOException {
    String operation = TRANSACTIONS + FORWARD_SLASH + transactionId + FORWARD_SLASH + RESEND_REQUEST;

    String responseString = httpPut(operation, null);

    return responseString;
  }

  public String deleteTransactionsCancelRequest(String transactionId) throws ClientProtocolException, IOException {
    String operation = TRANSACTIONS + FORWARD_SLASH + transactionId + FORWARD_SLASH + CANCEL_REQUEST;

    String responseString = httpDelete(operation);

    return responseString;
  }

  public String putTransactionsCompleteRequest(String transactionId) throws ClientProtocolException, IOException {
    String operation = TRANSACTIONS + FORWARD_SLASH + transactionId + FORWARD_SLASH + COMPLETE_REQUEST;

    String responseString = httpPut(operation, null);

    return responseString;
  }

  public String getRecentBuysAndSells() throws ClientProtocolException, IOException {
    String operation = TRANSFERS;

    String responseString = httpGet(operation);

    return responseString;
  }

  public String postCreateUser(UserRequest userRequest) throws ClientProtocolException, IOException {
    String operation = USERS;

    Gson gson = new Gson();
    String payload = gson.toJson(userRequest);
    String responseString = httpPost(operation, payload);

    return responseString;
  }

  public String getCurrentUser() throws ClientProtocolException, IOException {
    String operation = USERS;

    String responseString = httpGet(operation);

    return responseString;
  }

  public String putUserAccountSettings(String userId, UserRequest userRequest) throws ClientProtocolException, IOException {
    String operation = USERS + FORWARD_SLASH + userId;

    Gson gson = new Gson();
    String payload = gson.toJson(userRequest);
    String responseString = httpPut(operation, payload);

    return responseString;
  }

  public String generateReceiveAddress() throws ClientProtocolException, IOException {
    String operation = GENERATE_RECEIVE_ADDRESS;

    String payload = null;
    String responseString = httpPost(operation, payload);

    return responseString;
  }

  public BuyResponse buy(BuyRequest buyRequest) throws ClientProtocolException, IOException {
    String operation = BUYS;

    Gson gson = new Gson();
    String payload = gson.toJson(buyRequest);

    String responseString = httpPost(operation, payload);

    BuyResponse buyResponse = responseDeserializer.deserializeBuyResponse(responseString);

    return buyResponse;
  }

  public String getOperationUrl(String operation) {
    // return HTTPS_COINBASE_COM_API_V1_ACCOUNT + operation + API_KEY + apiKey;
    return HTTPS_COINBASE_COM_API_V1_ACCOUNT + operation;
  }

  protected String httpGet(String operation) throws IOException, ClientProtocolException {
    String urlString = getOperationUrl(operation);

    String responseString = coinbaseAuthenticatedHttpClient.executeGet(urlString);

    checkResponseForAuthenticationError(responseString);

    // logger.info("httpResponse.toString(): " + responseString);
    return responseString;
  }

  protected String httpPost(String operation, String payload) throws IOException, ClientProtocolException {
    String urlString = getOperationUrl(operation);

    String responseString = coinbaseAuthenticatedHttpClient.executePost(urlString, payload);

    checkResponseForAuthenticationError(responseString);

    // logger.info("httpResponse.toString(): " + responseString);
    return responseString;
  }

  protected String httpPut(String operation, String payload) throws IOException, ClientProtocolException {
    String urlString = getOperationUrl(operation);

    String responseString = coinbaseAuthenticatedHttpClient.executePut(urlString, payload);

    checkResponseForAuthenticationError(responseString);

    // logger.info("httpResponse.toString(): " + responseString);
    return responseString;
  }

  protected String httpDelete(String operation) throws IOException, ClientProtocolException {
    String urlString = getOperationUrl(operation);

    String responseString = coinbaseAuthenticatedHttpClient.executeDelete(urlString);

    checkResponseForAuthenticationError(responseString);

    // logger.info("httpResponse.toString(): " + responseString);
    return responseString;
  }

  protected void checkResponseForAuthenticationError(String responseString) {
    if (responseString.contains(INVALID_TOKEN) || responseString.contains(INVALID_API_KEY)) {
      throw new CoinbaseException(INVALID_API_KEY);
    }
  }
}
