package com.github.kevinstl.coinbase.java.domain.response;

import com.google.gson.annotations.SerializedName;

public class BuyResponse {
  
  private Boolean success;
  private String[] errors;
  private Transfer transfer;
  
  
  public Boolean getSuccess() {
    return success;
  }

  public void setSuccess(Boolean success) {
    this.success = success;
  }

  public Transfer getTransfer() {
    return transfer;
  }

  public void setTransfer(Transfer transfer) {
    this.transfer = transfer;
  }

  public String[] getErrors() {
    return errors;
  }

  public void setErrors(String[] errors) {
    this.errors = errors;
  }

  public class Transfer{
    
    private String type;
    private String code;
    
    @SerializedName("created_at")
    private String createdAt;
    
    private Fees fees;
    
    private String status;
    
    @SerializedName("payout_date")
    private String payoutDate;
    
    private Amount btc;
    private Amount subtotal;
    private Amount total;
    
    public String getType() {
      return type;
    }
    public void setType(String type) {
      this.type = type;
    }
    public String getCode() {
      return code;
    }
    public void setCode(String code) {
      this.code = code;
    }
    public String getCreatedAt() {
      return createdAt;
    }
    public void setCreatedAt(String createdAt) {
      this.createdAt = createdAt;
    }
    public Fees getFees() {
      return fees;
    }
    public void setFees(Fees fees) {
      this.fees = fees;
    }
    public String getStatus() {
      return status;
    }
    public void setStatus(String status) {
      this.status = status;
    }
    public String getPayoutDate() {
      return payoutDate;
    }
    public void setPayoutDate(String payoutDate) {
      this.payoutDate = payoutDate;
    }
    public Amount getBtc() {
      return btc;
    }
    public void setBtc(Amount btc) {
      this.btc = btc;
    }
    public Amount getSubtotal() {
      return subtotal;
    }
    public void setSubtotal(Amount subtotal) {
      this.subtotal = subtotal;
    }
    public Amount getTotal() {
      return total;
    }
    public void setTotal(Amount total) {
      this.total = total;
    }
    
    
  }

  public class Fees{
    
    private Fee coinbase;
    private Fee bank;
    
    public Fee getCoinbase() {
      return coinbase;
    }
    public void setCoinbase(Fee coinbase) {
      this.coinbase = coinbase;
    }
    public Fee getBank() {
      return bank;
    }
    public void setBank(Fee bank) {
      this.bank = bank;
    }
    
    
  }
  
  
  
}
