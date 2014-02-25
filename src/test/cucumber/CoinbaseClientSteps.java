import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.containsString;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import java.math.BigDecimal;

import org.springframework.beans.factory.annotation.Autowired;

import com.coinbase.java.client.CoinbaseClient;
import com.coinbase.java.client.CoinbaseClientAuthenticatedMock;
import com.coinbase.java.domain.deserializer.ResponseDeserializer;
import com.coinbase.java.domain.request.BuyRequest;
import com.coinbase.java.domain.request.TransactionRequest;
import com.coinbase.java.domain.response.BuyResponse;
import com.coinbase.java.domain.response.SendMoneyResponse;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class CoinbaseClientSteps {

  private static final String AMOUNT_VALUE = "0.0000000001";
  
  @Autowired
  private CoinbaseClientAuthenticatedMock coinbaseClientAuthenticatedMock;
  
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
    Integer transactionId = 0;
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

  @When("^I send money to bitcoin address \"([^\"]*)\"$")
  public void I_send_money_to_bitcoin_address(String bitcoinAddress) throws Throwable {

    String amountValue = AMOUNT_VALUE;

    notes = "Sending " + amountValue + " test.";

    TransactionRequest transactionRequest = new TransactionRequest(bitcoinAddress, amountValue, notes);
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

}
