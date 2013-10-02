package com.coinbase.java.domain;

import com.coinbase.java.domain.TransactionWrapper.Transaction;

public class ResponseWrapper {
  
  private Response response;

  
  public ResponseWrapper(String success) {
    super();
    this.setResponse(new Response(success));
  }

  public Response getResponse() {
    return response;
  }

  public void setResponse(Response response) {
    this.response = response;
  }

  public class Response {
    
    private String success;
    private Transaction transaction;
    
    public Response(String success) {
      super();
      this.setSuccess(success);
    }

    public String getSuccess() {
      return success;
    }

    public void setSuccess(String success) {
      this.success = success;
    }

    public Transaction getTransaction() {
      return transaction;
    }

    public void setTransaction(Transaction transaction) {
      this.transaction = transaction;
    }
    
    
  }

}

