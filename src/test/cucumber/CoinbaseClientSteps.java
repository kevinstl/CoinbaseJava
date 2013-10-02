import org.springframework.beans.factory.annotation.Autowired;

import com.coinbase.java.client.CoinbaseClient;
import com.coinbase.java.client.CoinbaseClientImpl;
import com.coinbase.java.domain.AmountWrapper.Amount;
import com.coinbase.java.domain.TransactionWrapper;
import com.google.gson.JsonObject;

import cucumber.api.PendingException;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;


public class CoinbaseClientSteps {
  
  @Autowired
  private CoinbaseClient coinbaseClient; 
  
  private String serviceResponse;
  

  @Given("^I have an instance of CoinbaseClient$")
  public void I_have_an_instance_of_CoinbaseClient() throws Throwable {
      assertNotNull(coinbaseClient);
  }
  
  @When("^I get my balance of bitcoins$")
  public void I_get_my_balance_of_bitcoins() throws Throwable {
    serviceResponse = coinbaseClient.getBalance();
  }

  @Then("^I see that a balance is returned$")
  public void I_see_that_a_balance_is_returned() throws Throwable {
    assertThat(serviceResponse, containsString("amount"));
    assertThat(serviceResponse, containsString("currency"));
  }
  
  @When("^I get my bitcoin recieve address$")
  public void I_get_my_bitcoin_recieve_address() throws Throwable {
    serviceResponse = coinbaseClient.getReceiveAddress();
  }

  @Then("^I see that a receive address is returned$")
  public void I_see_that_a_receive_address_is_returned() throws Throwable {
    assertThat(serviceResponse, containsString("\"success\":true"));
    assertThat(serviceResponse, containsString("address"));
  }
  
  @When("^I get my bitcoin addresses$")
  public void I_get_my_bitcoin_addresses() throws Throwable {
    serviceResponse = coinbaseClient.getAddresses();
  }

  @Then("^I see that my addresses are returned$")
  public void I_see_that_my_addresses_are_returned() throws Throwable {
    assertThat(serviceResponse, containsString("addresses"));
    assertThat(serviceResponse, containsString("address"));
  }
  
  @When("^I get my contacts$")
  public void I_get_my_contacts() throws Throwable {
    serviceResponse = coinbaseClient.getContacts();
  }

  @Then("^I see that my contacts are returned$")
  public void I_see_that_my_contacts_are_returned() throws Throwable {
    assertThat(serviceResponse, containsString("contact"));
    assertThat(serviceResponse, containsString("contacts"));
  }

  @When("^I get supported currencies$")
  public void I_get_supported_currencies() throws Throwable {
    serviceResponse = coinbaseClient.getCurrencies();
  }

  @Then("^I see that the supported currencies are returned$")
  public void I_see_that_the_supported_currencies_are_returned() throws Throwable {
    assertThat(serviceResponse, containsString("Afghan Afghani (AFN)"));
  }

  @When("^I get exchange rates$")
  public void I_get_exchange_rates() throws Throwable {
    serviceResponse = coinbaseClient.getExchangeRates();
  }

  @Then("^I see that exchange rates are returned$")
  public void I_see_that_exchange_rates_are_returned() throws Throwable {
    assertThat(serviceResponse, containsString("btc_to_pgk"));
  }

  @When("^I get merchant orders$")
  public void I_get_merchant_orders() throws Throwable {
    serviceResponse = coinbaseClient.getOrders();
  }

  @Then("^I see that merchant orders are returned$")
  public void I_see_that_merchant_orders_are_returned() throws Throwable {
    assertThat(serviceResponse, containsString("orders"));
    assertThat(serviceResponse, containsString("total_count"));
  }
  
  @When("^I get an individual order$")
  public void I_get_an_individual_order() throws Throwable {
    Integer orderId = 0;
    serviceResponse = coinbaseClient.getInvidualOrder(orderId);
  }

  @Then("^I see that an individual order is returned$")
  public void I_see_that_an_individual_order_is_returned() throws Throwable {
    assertThat(serviceResponse, containsString("Order not found with that id"));
  }

  @When("^I get the bitcoin buy price$")
  public void I_get_the_bitcoin_buy_price() throws Throwable {
    serviceResponse = coinbaseClient.getPriceToBuy();
  }

  @Then("^I see that the bitcoin buy price is returned$")
  public void I_see_that_the_bitcoin_buy_price_is_returned() throws Throwable {
    assertThat(serviceResponse, containsString("amount"));
  }

  @When("^I get the bitcoin sell price$")
  public void I_get_the_bitcoin_sell_price() throws Throwable {
    serviceResponse = coinbaseClient.getPriceToSell();
  }

  @Then("^I see that the bitcoin sell price is returned$")
  public void I_see_that_the_bitcoin_sell_price_is_returned() throws Throwable {
    assertThat(serviceResponse, containsString("amount"));
  }

  @When("^I get a user's recent transactions$")
  public void I_get_a_user_s_recent_transactions() throws Throwable {
    serviceResponse = coinbaseClient.getRecentTransactions();
  }

  @Then("^I see that a user's recent transactions are returned$")
  public void I_see_that_a_user_s_recent_transactions_are_returned() throws Throwable {
    assertThat(serviceResponse, containsString("amount"));
  }

  @When("^I get a user's individual transaction$")
  public void I_get_a_user_s_individual_transaction() throws Throwable {
    Integer transactionId = 0;
    serviceResponse = coinbaseClient.getIndividualTransaction(transactionId);
  }

  @Then("^I see that a user's individual transaction is returned$")
  public void I_see_that_a_user_s_individual_transaction_is_returned() throws Throwable {
    assertThat(serviceResponse, containsString("Transaction not found with that id"));
  }

  @When("^I get a user's recent buys and sells$")
  public void I_get_a_user_s_recent_buys_and_sells() throws Throwable {
    serviceResponse = coinbaseClient.getRecentBuysAndSells();
  }

  @Then("^I see that a user's recent buys and sells are returned$")
  public void I_see_that_a_user_s_recent_buys_and_sells_are_returned() throws Throwable {
    assertThat(serviceResponse, containsString("amount"));
  }

  @When("^I get the current user with account settings$")
  public void I_get_the_current_user_with_account_settings() throws Throwable {
    serviceResponse = coinbaseClient.getCurrentUser();
  }

  @Then("^I see that the current user with account settings is returned$")
  public void I_see_that_the_current_user_with_account_settings_is_returned() throws Throwable {
    assertThat(serviceResponse, containsString("amount"));
  }
  
  @When("^I send money to bitcoin address \"([^\"]*)\"$")
  public void I_send_money_to_bitcoin_address(String bitcoinAddress) throws Throwable {
    
    String amountValue = "0.0000001";
    String currency = "USD";
    
//    Amount amount = new Amount(amountValue, currency);
//    String notes = "Sending " + amount + " test.";
    
//    TransactionWrapper transactionWrapper = new TransactionWrapper(bitcoinAddress, amount, notes);
//    serviceResponse = coinbaseClient.sendMoney(transactionWrapper);
    
// //    JsonObject jsonObject = serviceResponse.getAsJsonObject();
// //    Result result = gson.fromJson(<YOUR OBJECT IN JSON>, Result.class);
    
  }

  @Then("^I see that the transaction is successful$")
  public void I_see_that_the_transaction_is_successful() throws Throwable {
    assertTrue(serviceResponse.contains("\"success\": true"));
  }
  
}
