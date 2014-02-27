@CLIENT_OPERATIONS
Feature: clientOperations - Execute Coinbase client operations.


Scenario: I am able to get all related changes to an account

Given I have an instance of CoinbaseClient
When I get account changes
Then I see that account changes are returned


Scenario: I am able to get my balance of bitcoins

Given I have an instance of CoinbaseClient
When I get my balance of bitcoins
Then I see that a balance is returned


Scenario: I am able to get my bitcoin receive address

Given I have an instance of CoinbaseClient
When I get my bitcoin recieve address
Then I see that a receive address is returned


Scenario: I am able to get my bitcoin addresses associated with this account

Given I have an instance of CoinbaseClient
When I get my bitcoin addresses
Then I see that my addresses are returned


Scenario: I am able to get emails(contacts) previously used

Given I have an instance of CoinbaseClient
When I get my contacts
Then I see that my contacts are returned


Scenario: I am able to get supported currencies

Given I have an instance of CoinbaseClient
When I get supported currencies
Then I see that the supported currencies are returned


Scenario: I am able to get exchange rates

Given I have an instance of CoinbaseClient
When I get exchange rates
Then I see that exchange rates are returned


Scenario: I am able to get merchant orders

Given I have an instance of CoinbaseClient
When I get merchant orders
Then I see that merchant orders are returned


Scenario: I am able to get an individual order

Given I have an instance of CoinbaseClient
When I get an individual order
Then I see that an individual order is returned


Scenario: I am able to get the bitcoin buy price

Given I have an instance of CoinbaseClient
When I get the bitcoin buy price
Then I see that the bitcoin buy price is returned


Scenario: I am able to get the bitcoin sell price

Given I have an instance of CoinbaseClient
When I get the bitcoin sell price
Then I see that the bitcoin sell price is returned


Scenario: I am able to get a user's recent transactions

Given I have an instance of CoinbaseClient
When I get a user's recent transactions
Then I see that a user's recent transactions are returned


Scenario: I am able to get a user's individual transaction

Given I have an instance of CoinbaseClient
When I get a user's individual transaction
Then I see that a user's individual transaction is returned


Scenario: I am able to get a user's recent buys and sells

Given I have an instance of CoinbaseClient
When I get a user's recent buys and sells
Then I see that a user's recent buys and sells are returned


Scenario: I am able to get the current user with account settings

Given I have an instance of CoinbaseClient
When I get the current user with account settings
Then I see that the current user with account settings is returned


Scenario: I am able to send money to a bitcoin address

Given I have an instance of CoinbaseClient
When I send money to bitcoin address "awe54f4wewe4fwe4fs6f18e4"
Then I see that the transaction is successful


Scenario: I am able to buy bitcoin

Given I have an instance of CoinbaseClient
When I buy "0.0000000001" bitcoin
Then I see that the buy is successful



Scenario: I am able to find the current value in BTC for a specified amount of USD

Given I want to find the value in BTC of "10" USD
When I request the value in BTC for my USD
Then I see an expected amount in BTC

