package com.coinbase.java.domain.request;


public class TransactionRequest {
  
  private Transaction transaction;

  
  public TransactionRequest(String to, String amount, String notes) {
    super();
    this.transaction = new Transaction(to, amount, notes);
  }

  public class Transaction {
    
    private String to;
    private String amount;
    private String notes;
    
    public Transaction(String to, String amount, String notes) {
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

    public String getAmount() {
      return amount;
    }

    public void setAmount(String amount) {
      this.amount = amount;
    }
    
    
    
    
  }

}

