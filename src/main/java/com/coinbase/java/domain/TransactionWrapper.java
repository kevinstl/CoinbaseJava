package com.coinbase.java.domain;

import com.coinbase.java.domain.AmountWrapper.Amount;

public class TransactionWrapper {
  
  private Transaction transaction;

  
  public TransactionWrapper(String to, Amount amount, String notes) {
    super();
    this.transaction = new Transaction(to, amount, notes);
  }

  public class Transaction {
    
    private String to;
    private Amount amount;
    private String notes;
    
    public Transaction(String to, Amount amount, String notes) {
      super();
      this.to = to;
      this.amount = amount;
      this.notes = notes;
    }

    public String getTo() {
      return to;
    }

    public void setTo(String to) {
      this.to = to;
    }

    public Amount getAmount() {
      return amount;
    }

    public void setAmount(Amount amount) {
      this.amount = amount;
    }

    public String getNotes() {
      return notes;
    }

    public void setNotes(String notes) {
      this.notes = notes;
    }
    
    
    
    
  }

}

