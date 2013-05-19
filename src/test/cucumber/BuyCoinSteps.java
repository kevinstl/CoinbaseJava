import org.springframework.beans.factory.annotation.Autowired;

import com.coinbase.java.client.CoinbaseClient;
import com.coinbase.java.client.CoinbaseClientImpl;

import cucumber.api.java.en.Given;


public class BuyCoinSteps {
  
  @Autowired
  private CoinbaseClient coinbaseClient; 
  
//  public BuyCoinSteps(CoinbaseClient coinbaseClient) {
//    this.coinbaseClient = coinbaseClient;
//  }
  
  //private CoinbaseClient coinbaseClient = new CoinbaseClientImpl();
  
  @Given("^I get my balance of bitcoins$")
  public void I_get_my_balance_of_bitcoins() throws Throwable {
    coinbaseClient.getBalance();
  }

}
