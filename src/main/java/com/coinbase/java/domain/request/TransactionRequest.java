package com.coinbase.java.domain.request;

import java.math.BigDecimal;


public class TransactionRequest {
  
  private Transaction transaction;
  
  public TransactionRequest(String to, BigDecimal amount, String notes) {
    super();
    this.transaction = new Transaction(to, amount, notes);
  }

  public class Transaction {
    
    private String to;
    private BigDecimal amount;
    private String notes;
    
    public Transaction(String to, BigDecimal amount, String notes) {
      super();
      this.to = to;
      this.setAmount(amount);
      this.notes = notes;
    }

    public String getTo() {
      return to;
    }

    public void setTo(String to) {
      this.to = to;
    }

    public String getNotes() {
      return notes;
    }

    public void setNotes(String notes) {
      this.notes = notes;
    }

    public BigDecimal getAmount() {
      return amount;
    }

    public void setAmount(BigDecimal amount) {
      this.amount = amount;
    }
    
    
    
    
  }

}

