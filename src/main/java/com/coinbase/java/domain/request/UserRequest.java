package com.coinbase.java.domain.request;

public class UserRequest {
  
  private User user;
  
  public UserRequest(String email, String password) {
    super();
    this.user = new User(email, password);
  }
  
  public class User {
    
    private String email;
    private String password;
    
    public User(String email, String password) {
      super();
      this.email = email;
      this.password = password;
    }
    
    public String getEmail() {
      return email;
    }
    public void setEmail(String email) {
      this.email = email;
    }
    public String getPassword() {
      return password;
    }
    public void setPassword(String password) {
      this.password = password;
    }
    
  }

  public User getUser() {
    return user;
  }

  public void setUser(User user) {
    this.user = user;
  }

}
