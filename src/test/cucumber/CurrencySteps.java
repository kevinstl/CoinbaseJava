import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.containsString;

import java.util.logging.Logger;

import org.springframework.beans.factory.annotation.Autowired;

import com.coinbase.java.client.CoinbaseClient;
import com.coinbase.java.client.CoinbaseClient;
import com.coinbase.java.client.CoinbaseClientAuthenticatedMock;
import com.coinbase.java.domain.deserializer.ResponseDeserializer;
import com.coinbase.java.domain.response.CurrencyExchangeRateResponse;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;


public class CurrencySteps {
  
  private static Logger logger = Logger.getLogger(CurrencySteps.class.getName());
  
  @Autowired
  private CoinbaseClientAuthenticatedMock coinbaseClientAuthenticatedMock;
  
  @Autowired
  private ResponseDeserializer responseDeserializer; 
  
  private String usdValue;
  private String exchangeRates;
  private String btcValue;
  
  
  @Given("^I want to find the value in BTC of \"([^\"]*)\" USD$")
  public void I_want_to_find_the_value_in_BTC_of_USD(String usdValue) throws Throwable {
    this.usdValue = usdValue;
  }

  @When("^I request the value in BTC for my USD$")
  public void I_request_the_value_in_BTC_for_my_USD() throws Throwable {
      exchangeRates = coinbaseClientAuthenticatedMock.getExchangeRates();
      
      CurrencyExchangeRateResponse currencyExchangeRateResponse = responseDeserializer.deserializeCurrencyExchangeRateResponse(exchangeRates);
      
      logger.info("exchangeRates: " + exchangeRates);
      logger.info("currencyExchangeRateResponse.getUsdToBtc(): " + currencyExchangeRateResponse.getUsdToBtc());
  }

  @Then("^I see an expected amount in BTC$")
  public void I_see_an_expected_amount_in_BTC() throws Throwable {
    
    assertThat(exchangeRates, containsString("usd_to_btc"));
    
  }

}
