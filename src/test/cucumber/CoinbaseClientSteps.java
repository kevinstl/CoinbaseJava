import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.containsString;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import java.math.BigDecimal;

import org.springframework.beans.factory.annotation.Autowired;

import com.github.kevinstl.coinbase.java.client.CoinbaseClient;
import com.github.kevinstl.coinbase.java.client.CoinbaseClientAuthenticatedMock;
import com.github.kevinstl.coinbase.java.domain.deserializer.ResponseDeserializer;
import com.github.kevinstl.coinbase.java.domain.request.ButtonRequest;
import com.github.kevinstl.coinbase.java.domain.request.BuyRequest;
import com.github.kevinstl.coinbase.java.domain.request.OauthApplication;
import com.github.kevinstl.coinbase.java.domain.request.TokenRequest;
import com.github.kevinstl.coinbase.java.domain.request.TransactionFromRequest;
import com.github.kevinstl.coinbase.java.domain.request.TransactionRequest;
import com.github.kevinstl.coinbase.java.domain.request.UserRequest;
import com.github.kevinstl.coinbase.java.domain.request.OauthApplication.Application;
import com.github.kevinstl.coinbase.java.domain.response.BuyResponse;
import com.github.kevinstl.coinbase.java.domain.response.SendMoneyResponse;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class CoinbaseClientSteps {

  private static final String AMOUNT_VALUE = "0.0000000001";
  
  @Autowired
  private CoinbaseClientAuthenticatedMock coinbaseClientAuthenticatedMock;
  
  @Autowired
  private CoinbaseClient coinbaseClient;
  
  @Autowired
  private ResponseDeserializer responseDeserializer;

  private String serviceResponse;
  private String notes;

  private SendMoneyResponse sendMoneyResponse;
  private BuyResponse buyResponse;

  
  @Given("^I have an instance of CoinbaseClient$")
  public void I_have_an_instance_of_CoinbaseClient() throws Throwable {
    assertNotNull(coinbaseClientAuthenticatedMock);
  }
  
  @When("^I get account changes$")
  public void I_get_account_changes() throws Throwable {
    serviceResponse = coinbaseClientAuthenticatedMock.getAccountChanges();
  }

  @Then("^I see that account changes are returned$")
  public void I_see_that_account_changes_are_returned() throws Throwable {
    assertThat(serviceResponse, containsString("current_user"));
    assertThat(serviceResponse, containsString("balance"));
    assertThat(serviceResponse, containsString("account_changes"));
    assertThat(serviceResponse, containsString("total_count"));
  }

  @When("^I get my balance of bitcoins$")
  public void I_get_my_balance_of_bitcoins() throws Throwable {
    serviceResponse = coinbaseClientAuthenticatedMock.getBalance();
  }

  @Then("^I see that a balance is returned$")
  public void I_see_that_a_balance_is_returned() throws Throwable {
    assertThat(serviceResponse, containsString("amount"));
    assertThat(serviceResponse, containsString("currency"));
  }

  @When("^I get my bitcoin recieve address$")
  public void I_get_my_bitcoin_recieve_address() throws Throwable {
    serviceResponse = coinbaseClientAuthenticatedMock.getReceiveAddress();
  }

  @Then("^I see that a receive address is returned$")
  public void I_see_that_a_receive_address_is_returned() throws Throwable {
    assertThat(serviceResponse, containsString("success"));
    assertThat(serviceResponse, containsString("address"));
  }

  @When("^I get my bitcoin addresses$")
  public void I_get_my_bitcoin_addresses() throws Throwable {
    serviceResponse = coinbaseClientAuthenticatedMock.getAddresses();
  }

  @Then("^I see that my addresses are returned$")
  public void I_see_that_my_addresses_are_returned() throws Throwable {
    assertThat(serviceResponse, containsString("addresses"));
    assertThat(serviceResponse, containsString("address"));
  }

  @When("^I get my oauth applications$")
  public void I_get_my_oauth_applications() throws Throwable {
    serviceResponse = coinbaseClientAuthenticatedMock.getOauthApplications();
  }

  @Then("^I see that my applications are returned$")
  public void I_see_that_my_applications_are_returned() throws Throwable {
    assertThat(serviceResponse, containsString("applications"));
  }
  
  @When("^I get an individual oauth application$")
  public void I_get_an_individual_oauth_application() throws Throwable {
    serviceResponse = coinbaseClientAuthenticatedMock.getOauthIndividualApplication(1);
  }

  @Then("^I see that my application is returned$")
  public void I_see_that_my_application_is_returned() throws Throwable {
    assertThat(serviceResponse, containsString("application"));
    assertThat(serviceResponse, containsString("redirect_uri"));
  }
  
  @When("^I create an oauth application$")
  public void I_create_an_oauth_application() throws Throwable {
    
    String name = "test app 1";
    String redirectUri = "http://testapp1.com";
    
    OauthApplication oauthApplication = new OauthApplication(name, redirectUri);
    
    serviceResponse = coinbaseClientAuthenticatedMock.postCreateOauthApplication(oauthApplication);
  }

  @Then("^I see that my newly created application is returned$")
  public void I_see_that_my_newly_created_application_is_returned() throws Throwable {
    assertThat(serviceResponse, containsString("success"));
    assertThat(serviceResponse, containsString("application"));
    assertThat(serviceResponse, containsString("redirect_uri"));
  }
  
  @When("^I get authorizations$")
  public void I_get_authorizations() throws Throwable {
    serviceResponse = coinbaseClientAuthenticatedMock.getAuthorization();
  }

  @Then("^I see that my authorizations are returned$")
  public void I_see_that_my_authorizations_are_returned() throws Throwable {
    assertThat(serviceResponse, containsString("success"));
  }
  
  @When("^I create a payment object$")
  public void I_create_a_payment_object() throws Throwable {
    
    ButtonRequest buttonRequest = createButtonRequest();
    
    serviceResponse = coinbaseClientAuthenticatedMock.postCreatePaymentObject(buttonRequest);
  }

  private ButtonRequest createButtonRequest() {
    String name = null;
    String type = null;
    String price_string = null;
    String price_currency_iso = null;
    String custom = null;
    String callback_url = null;
    String description = null;
    String style = null;
    Boolean include_email = null;
    
    ButtonRequest buttonRequest = new ButtonRequest(name, type, price_string, price_currency_iso, custom, callback_url, description, style, include_email);
    return buttonRequest;
  }

  @Then("^I see that my newly created payment object is returned$")
  public void I_see_that_my_newly_created_payment_object_is_returned() throws Throwable {
    assertThat(serviceResponse, containsString("success"));
    assertThat(serviceResponse, containsString("button"));
  }
  
  
  @When("^I create an order with an object id$")
  public void I_create_an_order_with_an_object_id() throws Throwable {
    String objectId = "123a";
    serviceResponse = coinbaseClientAuthenticatedMock.postCreateOrder(objectId);
  }

  @Then("^I see that my order creation is successful$")
  public void I_see_that_my_order_creation_is_successful() throws Throwable {
    assertThat(serviceResponse, containsString("success"));
    assertThat(serviceResponse, containsString("order"));
  }
  
  
  @When("^I get my contacts$")
  public void I_get_my_contacts() throws Throwable {
    serviceResponse = coinbaseClientAuthenticatedMock.getContacts();
  }

  @Then("^I see that my contacts are returned$")
  public void I_see_that_my_contacts_are_returned() throws Throwable {
    assertThat(serviceResponse, containsString("contact"));
    assertThat(serviceResponse, containsString("contacts"));
  }

  @When("^I get supported currencies$")
  public void I_get_supported_currencies() throws Throwable {
    serviceResponse = coinbaseClientAuthenticatedMock.getCurrencies();
  }

  @Then("^I see that the supported currencies are returned$")
  public void I_see_that_the_supported_currencies_are_returned() throws Throwable {
    assertThat(serviceResponse, containsString("Afghan Afghani (AFN)"));
  }

  @When("^I get exchange rates$")
  public void I_get_exchange_rates() throws Throwable {
    serviceResponse = coinbaseClientAuthenticatedMock.getExchangeRates();
  }

  @Then("^I see that exchange rates are returned$")
  public void I_see_that_exchange_rates_are_returned() throws Throwable {
    assertThat(serviceResponse, containsString("btc_to_pgk"));
  }

  @When("^I get merchant orders$")
  public void I_get_merchant_orders() throws Throwable {
    serviceResponse = coinbaseClientAuthenticatedMock.getOrders();
  }

  @Then("^I see that merchant orders are returned$")
  public void I_see_that_merchant_orders_are_returned() throws Throwable {
    assertThat(serviceResponse, containsString("orders"));
    assertThat(serviceResponse, containsString("total_count"));
  }
  
  @When("^I create a new order$")
  public void I_create_a_new_order() throws Throwable {
    ButtonRequest buttonRequest = createButtonRequest();
    serviceResponse = coinbaseClientAuthenticatedMock.postOrders(buttonRequest);
  }

  @Then("^I see that a new order is created$")
  public void I_see_that_a_new_order_is_created() throws Throwable {
    assertThat(serviceResponse, containsString("success"));
    assertThat(serviceResponse, containsString("order"));
    assertThat(serviceResponse, containsString("total_native"));
    assertThat(serviceResponse, containsString("receive_address"));
  }

  @When("^I get an individual order$")
  public void I_get_an_individual_order() throws Throwable {
    Integer orderId = 0;
    serviceResponse = coinbaseClientAuthenticatedMock.getInvidualOrder(orderId);
  }

  @Then("^I see that an individual order is returned$")
  public void I_see_that_an_individual_order_is_returned() throws Throwable {
    assertThat(serviceResponse, containsString("order"));
    assertThat(serviceResponse, containsString("created_at"));
  }
  
  @When("^I get payment methods$")
  public void I_get_payment_methods() throws Throwable {
    serviceResponse = coinbaseClientAuthenticatedMock.getPaymentMethods();
  }

  @Then("^I see that payment methods are returned$")
  public void I_see_that_payment_methods_are_returned() throws Throwable {
    assertThat(serviceResponse, containsString("payment_methods"));
  }

  @When("^I get the bitcoin buy price$")
  public void I_get_the_bitcoin_buy_price() throws Throwable {
    serviceResponse = coinbaseClientAuthenticatedMock.getPriceToBuy();
  }

  @Then("^I see that the bitcoin buy price is returned$")
  public void I_see_that_the_bitcoin_buy_price_is_returned() throws Throwable {
    assertThat(serviceResponse, containsString("subtotal"));
    assertThat(serviceResponse, containsString("fees"));
  }

  @When("^I get the bitcoin sell price$")
  public void I_get_the_bitcoin_sell_price() throws Throwable {
    serviceResponse = coinbaseClientAuthenticatedMock.getPriceToSell();
  }

  @Then("^I see that the bitcoin sell price is returned$")
  public void I_see_that_the_bitcoin_sell_price_is_returned() throws Throwable {
    assertThat(serviceResponse, containsString("amount"));
  }
  
  @When("^I get the bitcoin spot price$")
  public void I_get_the_bitcoin_spot_price() throws Throwable {
    serviceResponse = coinbaseClientAuthenticatedMock.getPricesSpotRate();
  }

  @Then("^I see that the bitcoin spot price is returned$")
  public void I_see_that_the_bitcoin_spot_price_is_returned() throws Throwable {
    assertThat(serviceResponse, containsString("amount"));
    assertThat(serviceResponse, containsString("currency"));
  }

  @When("^I get the bitcoin historical spot price$")
  public void I_get_the_bitcoin_historical_spot_price() throws Throwable {
    serviceResponse = coinbaseClientAuthenticatedMock.getPricesHistorical();
  }

  @Then("^I see that the bitcoin historical spot price is returned$")
  public void I_see_that_the_bitcoin_historical_spot_price_is_returned() throws Throwable {
    assertThat(serviceResponse, containsString(","));
  }
  
  @When("^I get my recurring payments$")
  public void I_get_my_recurring_payments() throws Throwable {
    serviceResponse = coinbaseClientAuthenticatedMock.getRecurringPayments();
  }

  @Then("^I see that my recurring payments are returned$")
  public void I_see_that_my_recurring_payments_are_returned() throws Throwable {
    assertThat(serviceResponse, containsString("recurring_payments"));
  }

  @When("^I get an individual recurring payment$")
  public void I_get_an_individual_recurring_payment() throws Throwable {
    Integer paymentId = 0;
    serviceResponse = coinbaseClientAuthenticatedMock.getIndividualRecurringPayment(paymentId);
  }

  @Then("^I see that my individual recurring payment is returned$")
  public void I_see_that_my_individual_recurring_payment_is_returned() throws Throwable {
    assertThat(serviceResponse, containsString("recurring_payment"));
  }

  @When("^I get a list of my customer subscriptions$")
  public void I_get_a_list_of_my_customer_subscriptions() throws Throwable {
    serviceResponse = coinbaseClientAuthenticatedMock.getSubscribers();
  }

  @Then("^I see that my list of my customer subscriptions are returned$")
  public void I_see_that_my_list_of_my_customer_subscriptions_are_returned() throws Throwable {
    assertThat(serviceResponse, containsString("recurring_payments"));
    assertThat(serviceResponse, containsString("recurring_payment"));
  }

  @When("^I get an individual customer subscription$")
  public void I_get_an_individual_customer_subscription() throws Throwable {
    Integer subscriberId = 0;
    serviceResponse = coinbaseClientAuthenticatedMock.getIndividualSubscriber(subscriberId);
  }

  @Then("^I see that my individual customer subscription is returned$")
  public void I_see_that_my_individual_customer_subscription_is_returned() throws Throwable {
    assertThat(serviceResponse, containsString("recurring_payment"));
    assertThat(serviceResponse, containsString("subscription"));
  }
  
  @When("^I create a token redeemable for bitcoin$")
  public void I_create_a_token_redeemable_for_bitcoin() throws Throwable {
    serviceResponse = coinbaseClientAuthenticatedMock.postTokens();
  }

  @Then("^I see that my token redeemable for bitcoin is returned$")
  public void I_see_that_my_token_redeemable_for_bitcoin_is_returned() throws Throwable {
    assertThat(serviceResponse, containsString("token"));
    assertThat(serviceResponse, containsString("token_id"));
    assertThat(serviceResponse, containsString("address"));
  }

  @When("^I redeem a token for bitcoin$")
  public void I_redeem_a_token_for_bitcoin() throws Throwable {
    String token_id = "123";
    TokenRequest tokenRequest = new TokenRequest(token_id);
    serviceResponse = coinbaseClientAuthenticatedMock.postTokensRedeem(tokenRequest);
  }

  @Then("^I see that my token is successfully redeemed$")
  public void I_see_that_my_token_is_successfully_redeemed() throws Throwable {
    assertThat(serviceResponse, containsString("success"));
  }

  @When("^I get a user's recent transactions$")
  public void I_get_a_user_s_recent_transactions() throws Throwable {
    serviceResponse = coinbaseClientAuthenticatedMock.getRecentTransactions();
  }

  @Then("^I see that a user's recent transactions are returned$")
  public void I_see_that_a_user_s_recent_transactions_are_returned() throws Throwable {
    assertThat(serviceResponse, containsString("current_user"));
    assertThat(serviceResponse, containsString("balance"));
    assertThat(serviceResponse, containsString("total_count"));
    assertThat(serviceResponse, containsString("transactions"));
  }

  @When("^I get a user's individual transaction$")
  public void I_get_a_user_s_individual_transaction() throws Throwable {
    String transactionId = "123a";
    serviceResponse = coinbaseClientAuthenticatedMock.getIndividualTransaction(transactionId);
  }

  @Then("^I see that a user's individual transaction is returned$")
  public void I_see_that_a_user_s_individual_transaction_is_returned() throws Throwable {
    assertThat(serviceResponse, containsString("transaction"));
    assertThat(serviceResponse, containsString("created_at"));
    assertThat(serviceResponse, containsString("sender"));
    assertThat(serviceResponse, containsString("recipient"));
  }

  @When("^I get a user's recent buys and sells$")
  public void I_get_a_user_s_recent_buys_and_sells() throws Throwable {
    serviceResponse = coinbaseClientAuthenticatedMock.getRecentBuysAndSells();
  }

  @Then("^I see that a user's recent buys and sells are returned$")
  public void I_see_that_a_user_s_recent_buys_and_sells_are_returned() throws Throwable {
    assertThat(serviceResponse, containsString("transfers"));
    assertThat(serviceResponse, containsString("status"));
    assertThat(serviceResponse, containsString("total_count"));
  }
  
  @When("^I create a new user with email \"([^\"]*)\" and password \"([^\"]*)\"$")
  public void I_create_a_new_user_with_email_and_password(String email, String password) throws Throwable {
    
    UserRequest userRequest = new UserRequest(email, password);
    
    serviceResponse = coinbaseClientAuthenticatedMock.postCreateUser(userRequest);
  }

  @Then("^I see that the new user is created$")
  public void I_see_that_the_new_user_is_created() throws Throwable {
    assertThat(serviceResponse, containsString("user"));
    assertThat(serviceResponse, containsString("receive_address"));
  }

  @When("^I get the current user with account settings$")
  public void I_get_the_current_user_with_account_settings() throws Throwable {
    serviceResponse = coinbaseClientAuthenticatedMock.getCurrentUser();
  }

  @Then("^I see that the current user with account settings is returned$")
  public void I_see_that_the_current_user_with_account_settings_is_returned() throws Throwable {
    assertThat(serviceResponse, containsString("users"));
    assertThat(serviceResponse, containsString("user"));
    assertThat(serviceResponse, containsString("email"));
    assertThat(serviceResponse, containsString("buy_level"));
    assertThat(serviceResponse, containsString("sell_level"));
  }
  
  @When("^I update account settings for the user with user id \"([^\"]*)\" email \"([^\"]*)\"$")
  public void I_update_account_settings_for_the_user_with_user_id_email(String userId, String email) throws Throwable {
    
    UserRequest userRequest = new UserRequest(email, null);
    
    serviceResponse = coinbaseClientAuthenticatedMock.putUserAccountSettings(userId, userRequest);
  }

  @Then("^I see that the user account settings have been updated$")
  public void I_see_that_the_user_account_settings_have_been_updated() throws Throwable {
    assertThat(serviceResponse, containsString("user"));
    assertThat(serviceResponse, containsString("name"));
    assertThat(serviceResponse, containsString("email"));
    assertThat(serviceResponse, containsString("balance"));
  }

  @When("^I send money to bitcoin address \"([^\"]*)\"$")
  public void I_send_money_to_bitcoin_address(String bitcoinAddress) throws Throwable {

    String amountValue = AMOUNT_VALUE;

    notes = "Sending " + amountValue + " test.";

    TransactionRequest transactionRequest = new TransactionRequest(bitcoinAddress, new BigDecimal(amountValue), notes);
    sendMoneyResponse = coinbaseClientAuthenticatedMock.sendMoney(transactionRequest);

  }

  @Then("^I see that the transaction is successful$")
  public void I_see_that_the_transaction_is_successful() throws Throwable {
    // assertThat(serviceResponse, containsString("\"success\":false"));
    // assertThat(serviceResponse,
    // containsString("\"errors\":[\"This transaction"));

    assertTrue(sendMoneyResponse.getSuccess());
    // assertTrue(sendMoneyResponse.getErrors() == null);

    // SendMoneyResponse sendMoneyResponse =
    // responseDeserializer.deserialize(serviceResponse);

    // assertEquals("false", sendMoneyResponse.getSuccess());
//    assertThat(sendMoneyResponse.getErrors()[0], containsString("This transaction amount is below the current minimum"));
    assertEquals("Sample transaction for you!", sendMoneyResponse.getTransaction().getNotes());
    // assertEquals("0.00000000",
    // sendMoneyResponse.getTransaction().getAmount().getAmount());
    // assertEquals(AMOUNT_VALUE,
    // sendMoneyResponse.getTransaction().getAmount().getAmount());
    assertEquals("BTC", sendMoneyResponse.getTransaction().getAmount().getCurrency());
    assertEquals(false, sendMoneyResponse.getTransaction().getRequest());
    assertEquals("pending", sendMoneyResponse.getTransaction().getStatus());

  }
  
  
  
  
  @When("^I send a money request for \"([^\"]*)\" bitcoin to email address \"([^\"]*)\"$")
  public void I_send_a_money_request_for_bitcoin_to_email_address(BigDecimal bitcoinAmount, String emailAddress) throws Throwable {
    TransactionFromRequest transactionFromRequest = new TransactionFromRequest(emailAddress, bitcoinAmount, "notes"); 
    serviceResponse = coinbaseClientAuthenticatedMock.postTransactionsRequestMoney(transactionFromRequest);
  }

  @Then("^I see that the money request is successful$")
  public void I_see_that_the_money_request_is_successful() throws Throwable {
    assertThat(serviceResponse, containsString("transaction"));
    assertThat(serviceResponse, containsString("sender"));
    assertThat(serviceResponse, containsString("recipient"));
  }

  @When("^I resend email for a money request$")
  public void I_resend_email_for_a_money_request() throws Throwable {
    String transactionId = null;
    serviceResponse = coinbaseClientAuthenticatedMock.putTransactionsResendRequest(transactionId);
  }

  @Then("^I see that the resend is successful$")
  public void I_see_that_the_resend_is_successful() throws Throwable {
    assertThat(serviceResponse, containsString("true"));
  }

  @When("^I cancel a request for transaction id \"([^\"]*)\"$")
  public void I_cancel_a_request_for_transaction_id(String transactionId) throws Throwable {
    serviceResponse = coinbaseClientAuthenticatedMock.deleteTransactionsCancelRequest(transactionId);
  }

  @Then("^I see that the request cancellation is successful$")
  public void I_see_that_the_request_cancellation_is_successful() throws Throwable {
    assertThat(serviceResponse, containsString("true"));
  }

  @When("^I complete a request for transaction id \"([^\"]*)\"$")
  public void I_complete_a_request_for_transaction_id(String transactionId) throws Throwable {
    serviceResponse = coinbaseClientAuthenticatedMock.putTransactionsCompleteRequest(transactionId);
  }

  @Then("^I see that the request completion is successful$")
  public void I_see_that_the_request_completion_is_successful() throws Throwable {
    assertThat(serviceResponse, containsString("transfers"));
  }
  
  

  @When("^I buy \"([^\"]*)\" bitcoin$")
  public void I_buy_bitcoin(BigDecimal bitcoinQty) throws Throwable {
    
    notes = "Buying " + bitcoinQty + " test.";
    
    BuyRequest buyRequest = new BuyRequest(bitcoinQty);

    buyResponse = coinbaseClientAuthenticatedMock.buy(buyRequest);
  }

  @Then("^I see that the buy is successful$")
  public void I_see_that_the_buy_is_successful() throws Throwable {
    
    assertTrue(buyResponse.getSuccess());
    assertEquals("Buy", buyResponse.getTransfer().getType());
    assertEquals("created", buyResponse.getTransfer().getStatus());
    
  }
  
  @Given("^I have a real instance of CoinbaseClient$")
  public void I_have_a_real_instance_of_CoinbaseClient() throws Throwable {
    assertNotNull(coinbaseClient);
  }

  @When("^I get my balance of bitcoins using the real client$")
  public void I_get_my_balance_of_bitcoins_using_the_real_client() throws Throwable {
    serviceResponse = coinbaseClient.getBalance();
  }

  @Then("^I see that a balance is returned using the real client$")
  public void I_see_that_a_balance_is_returned_using_the_real_client() throws Throwable {
    assertThat(serviceResponse, containsString("amount"));
    assertThat(serviceResponse, containsString("currency"));
  }
  
}
