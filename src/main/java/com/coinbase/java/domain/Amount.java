package com.coinbase.java.domain;

public class Amount {
  public String amount;
  public String currency;

  public Amount(String amount, String currency) {
    super();
    this.amount = amount;
    this.currency = currency;
  }

  

  public String getAmount() {
    return amount;
  }



  public void setAmount(String amount) {
    this.amount = amount;
  }



  public String getCurrency() {
    return currency;
  }

  public void setCurrency(String currency) {
    this.currency = currency;
  }
  
  public class AmountWrapper {
    
    private Amount amount;
    
    public AmountWrapper(String amount, String currency) {
      super();
      this.amount = new Amount(amount, currency);
    }
    
    public Amount getAmount() {
      return amount;
    }

    public void setAmount(Amount amount) {
      this.amount = amount;
    }

  }
  
}

