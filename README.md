=======
CoinbaseJava
============

Coinbase API Java Client Library


### Usage

CoinbaseClient class contains all api calls.

```java
@Autowired
private CoinbaseClient coinbaseClient;

//Buy Bitcoin
BigDecimal bitcoinToBuy = new BigDecimal(0.123);
BuyRequest buyRequest = new BuyRequest(bitcoinToBuy);
coinbaseClient.buy(buyRequest);


//Send Bitcoin
BigDecimal bitcoinToSend = new BigDecimal(0.123);
TransactionRequest transactionRequest = 
  new TransactionRequest("bitcoinAddress", bitcoinToSend, "Transaction Note");
coinbaseClient.sendMoney(transactionRequest);
```

### Required Properties:

    coinbase.apiKey=yourApiKey
    coinbase.apiSecret=yourApiSecret

### Maven

If you are using Maven add this dependency to your `pom.xml`:

    <dependency>
      <groupId>com.github.kevinstl</groupId>
      <artifactId>CoinbaseJava</artifactId>
      <version>0.1.1</version>
    </dependency>
    
### Gradle

If you are using Gradle add this dependency to your `build.gradle`:

    compile 'com.github.kevinstl:CoinbaseJava:0.1.1'
