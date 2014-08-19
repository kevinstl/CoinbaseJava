package com.github.kevinstl.coinbase.java.domain.request;

public class OauthApplication {
  
  private Application application;
  
  
  public OauthApplication(String name, String redirect_uri) {
    super();
    this.application = new Application(name, redirect_uri);
  }

  public class Application{
    
    public Application(String name, String redirect_uri) {
      super();
      this.name = name;
      this.redirect_uri = redirect_uri;
    }
    
    private String name;
    private String redirect_uri;
    
    public String getName() {
      return name;
    }
    public void setName(String name) {
      this.name = name;
    }
    public String getRedirect_uri() {
      return redirect_uri;
    }
    public void setRedirect_uri(String redirect_uri) {
      this.redirect_uri = redirect_uri;
    }
    
  }

  public Application getApplication() {
    return application;
  }

  public void setApplication(Application application) {
    this.application = application;
  }

}
