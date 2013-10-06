package com.coinbase.java.domain.response;

public class SendMoneyResponse {
  
  private String success;
  private String[] errors;
  private Transaction transaction;
  
  public String getSuccess() {
    return success;
  }
  public void setSuccess(String success) {
    this.success = success;
  }
  public String[] getErrors() {
    return errors;
  }
  public void setErrors(String[] errors) {
    this.errors = errors;
  }
  public Transaction getTransaction() {
    return transaction;
  }
  public void setTransaction(Transaction transaction) {
    this.transaction = transaction;
  }
  
  

}

