package com.coinbase.java.domain.response;

import java.math.BigDecimal;

public class Amount {
  
  private BigDecimal amount;
  private String currency;
  
  public BigDecimal getAmount() {
    return amount;
  }
  public void setAmount(BigDecimal amount) {
    this.amount = amount;
  }
  public String getCurrency() {
    return currency;
  }
  public void setCurrency(String currency) {
    this.currency = currency;
  }
  
}
