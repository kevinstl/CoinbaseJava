package com.coinbase.java.domain;

public class RecipientWrapper {
  
  private Recipient recipient;

  
  public RecipientWrapper(String id, String name, String email) {
    super();
    this.recipient = new Recipient(id, name, email);
  }

  private class Recipient {
    private String id;
    private String name;
    private String email;
    
    public Recipient(String id, String name, String email) {
      super();
      this.setId(id);
      this.setName(name);
      this.setEmail(email);
    }

    public String getId() {
      return id;
    }

    public void setId(String id) {
      this.id = id;
    }

    public String getName() {
      return name;
    }

    public void setName(String name) {
      this.name = name;
    }

    public String getEmail() {
      return email;
    }

    public void setEmail(String email) {
      this.email = email;
    }
    
  }
}

