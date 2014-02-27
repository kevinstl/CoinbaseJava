package com.coinbase.java.domain.request;

import java.math.BigDecimal;

public class BuyRequest {
  
  private BigDecimal qty;
  
  public BuyRequest(BigDecimal qty) {
    this.qty = qty;
  }

  public BigDecimal getQty() {
    return qty;
  }

  public void setQty(BigDecimal qty) {
    this.qty = qty;
  }

}
