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
TransactionRequest transactionRequest = new TransactionRequest("bitcoinAddress", bitcoinToSend, "Transaction Note");
coinbaseClient.sendMoney(transactionRequest);
```

### Required Properties:

     coinbase.apiKey=yourApiKey
     coinbase.apiSecret=yourApiSecret
