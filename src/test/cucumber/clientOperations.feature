@CLIENT_OPERATIONS @WIP
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



Scenario: I am able to get oauth applications on this account

Given I have an instance of CoinbaseClient
When I get my oauth applications
Then I see that my applications are returned


Scenario: I am able to get an individual oauth application on this account

Given I have an instance of CoinbaseClient
When I get an individual oauth application
Then I see that my application is returned


Scenario: I am able to create an oauth application

Given I have an instance of CoinbaseClient
When I create an oauth application
Then I see that my newly created application is returned


Scenario: I am able to create a payment object

Given I have an instance of CoinbaseClient
When I create a payment object
Then I see that my newly created payment object is returned


Scenario: I am able to create an order with an object id

Given I have an instance of CoinbaseClient
When I create an order with an object id
Then I see that my order creation is successful


Scenario: I am able to create a new payment

Given I have an instance of CoinbaseClient
When I get authorizations
Then I see that my authorizations are returned


Scenario: I am able to get information on your application's access to the user's Coinbase account

Given I have an instance of CoinbaseClient
When I get authorizations
Then I see that my authorizations are returned


Scenario: I am able to get emails, contacts, previously used

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


Scenario: I am able to create a new order

Given I have an instance of CoinbaseClient
When I create a new order
Then I see that a new order is created


Scenario: I am able to get an individual order

Given I have an instance of CoinbaseClient
When I get an individual order
Then I see that an individual order is returned


Scenario: I am able to get payment methods associated with an account

Given I have an instance of CoinbaseClient
When I get payment methods
Then I see that payment methods are returned


Scenario: I am able to get the bitcoin buy price

Given I have an instance of CoinbaseClient
When I get the bitcoin buy price
Then I see that the bitcoin buy price is returned


Scenario: I am able to get the bitcoin sell price

Given I have an instance of CoinbaseClient
When I get the bitcoin sell price
Then I see that the bitcoin sell price is returned


Scenario: I am able to get the bitcoin spot price

Given I have an instance of CoinbaseClient
When I get the bitcoin spot price
Then I see that the bitcoin spot price is returned


Scenario: I am able to get the bitcoin historical spot price

Given I have an instance of CoinbaseClient
When I get the bitcoin historical spot price
Then I see that the bitcoin historical spot price is returned


Scenario: I am able to get a list of my recurring payments

Given I have an instance of CoinbaseClient
When I get my recurring payments
Then I see that my recurring payments are returned


Scenario: I am able to get an individual recurring payment

Given I have an instance of CoinbaseClient
When I get an individual recurring payment
Then I see that my individual recurring payment is returned


Scenario: I am able to get a list of my customer subscriptions

Given I have an instance of CoinbaseClient
When I get a list of my customer subscriptions
Then I see that my list of my customer subscriptions are returned


Scenario: I am able to get an individual customer subscription

Given I have an instance of CoinbaseClient
When I get an individual customer subscription
Then I see that my individual customer subscription is returned


Scenario: I am able to create a token which can be redeemed for bitcoin

Given I have an instance of CoinbaseClient
When I create a token redeemable for bitcoin
Then I see that my token redeemable for bitcoin is returned


Scenario: I am able to redeem a token, claiming its address and all its bitcoins

Given I have an instance of CoinbaseClient
When I redeem a token for bitcoin
Then I see that my token is successfully redeemed


Scenario: I am able to get a user's recent transactions

Given I have an instance of CoinbaseClient
When I get a user's recent transactions
Then I see that a user's recent transactions are returned


Scenario: I am able to get a user's individual transaction

Given I have an instance of CoinbaseClient
When I get a user's individual transaction
Then I see that a user's individual transaction is returned


Scenario: I am able to send money to a bitcoin address

Given I have an instance of CoinbaseClient
When I send money to bitcoin address "awe54f4wewe4fwe4fs6f18e4"
Then I see that the transaction is successful





Scenario: I am able to send a money request to an email address

Given I have an instance of CoinbaseClient
When I send a money request for "1.234" bitcoin to email address "test@hotmail.com"
Then I see that the money request is successful


Scenario: I am able to resend emails for a money request

Given I have an instance of CoinbaseClient
When I resend email for a money request
Then I see that the resend is successful


Scenario: I am able to cancel a money request

Given I have an instance of CoinbaseClient
When I cancel a request for transaction id "123a"
Then I see that the request cancellation is successful


Scenario: I am able to complete a money request

Given I have an instance of CoinbaseClient
When I complete a request for transaction id "123a"
Then I see that the request completion is successful





Scenario: I am able to get a user's recent buys and sells

Given I have an instance of CoinbaseClient
When I get a user's recent buys and sells
Then I see that a user's recent buys and sells are returned


Scenario: I am able to get the current user with account settings

Given I have an instance of CoinbaseClient
When I get the current user with account settings
Then I see that the current user with account settings is returned


Scenario: I am able to buy bitcoin

Given I have an instance of CoinbaseClient
When I buy "0.0000000001" bitcoin
Then I see that the buy is successful



Scenario: I am able to find the current value in BTC for a specified amount of USD

Given I want to find the value in BTC of "10" USD
When I request the value in BTC for my USD
Then I see an expected amount in BTC

