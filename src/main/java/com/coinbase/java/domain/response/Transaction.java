package com.coinbase.java.domain.response;


public class Transaction {
  
  private String id;
  private String createdAt;
  private String hsh;
  private String notes;
  private Amount amount;
  private Boolean request;
  private String status;
  private String recipientAddress;
  
  public String getId() {
    return id;
  }
  public void setId(String id) {
    this.id = id;
  }
  public String getCreatedAt() {
    return createdAt;
  }
  public void setCreatedAt(String createdAt) {
    this.createdAt = createdAt;
  }
  public String getHsh() {
    return hsh;
  }
  public void setHsh(String hsh) {
    this.hsh = hsh;
  }
  public String getNotes() {
    return notes;
  }
  public void setNotes(String notes) {
    this.notes = notes;
  }
  public Amount getAmount() {
    return amount;
  }
  public void setAmount(Amount amount) {
    this.amount = amount;
  }
  public Boolean getRequest() {
    return request;
  }
  public void setRequest(Boolean request) {
    this.request = request;
  }
  public String getStatus() {
    return status;
  }
  public void setStatus(String status) {
    this.status = status;
  }
  public String getRecipientAddress() {
    return recipientAddress;
  }
  public void setRecipientAddress(String recipientAddress) {
    this.recipientAddress = recipientAddress;
  }
  
  

}
