package com.coinbase.java.domain.request;

import java.math.BigDecimal;


public class TransactionFromRequest {
  
  private Transaction transaction;
  
  public TransactionFromRequest(String from, BigDecimal amount, String notes) {
    super();
    this.transaction = new Transaction(from, amount, notes);
  }

  public class Transaction {
    
    private String from;
    private BigDecimal amount;
    private String notes;
    
    public Transaction(String from, BigDecimal amount, String notes) {
      super();
      this.from = from;
      this.setAmount(amount);
      this.notes = notes;
    }

    public String getFrom() {
      return from;
    }

    public void setFrom(String from) {
      this.from = from;
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

