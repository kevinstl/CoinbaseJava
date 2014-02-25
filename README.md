CoinbaseJava
============

Coinbase API Java Client Library


### Usage

CoinbaseClient class contains all api calls.

```
CoinbaseClient coinbaseClient = new CoinbaseClient(apiKey);

//Buy Bitcoin
BigDecimal bitcoinToBuy = new BigDecimal(1);
BuyRequest buyRequest = new BuyRequest(bitcoinToBuy);
coinbaseClient.buy(buyRequest);


//Send Bitcoin

TransactionRequest transactionRequest = new TransactionRequest("bitcoinAddress", "0.123", "Transaction Note");
coinbaseClient.sendMoney(transactionRequest);
```
