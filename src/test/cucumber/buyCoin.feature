@BUY_COIN
Feature: buyCoin - Buy a bitcoin.

Scenario: I am able to get my balance of bitcoins

Given I have an instance of CoinbaseClient
When I get my balance of bitcoins
Then I see that a balance is returned