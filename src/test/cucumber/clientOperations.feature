@BUY_COIN
Feature: clientOperations - Execute Coinbase client operations.


Scenario: I am able to get my balance of bitcoins

Given I have an instance of CoinbaseClient
When I get my balance of bitcoins
Then I see that a balance is returned


Scenario: I am able to get my bitcoin receive address

Given I have an instance of CoinbaseClient
When I get my bitcoin recieve address
Then I see that a receive address is returned