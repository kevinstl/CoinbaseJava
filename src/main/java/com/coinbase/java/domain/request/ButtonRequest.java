package com.coinbase.java.domain.request;

public class ButtonRequest {
  
  private Button button;
  
  public ButtonRequest(String name, String type, String price_string, String price_currency_iso, String custom, String callback_url, String description, String style,
      Boolean include_email) {
    super();
    this.button = new Button(name, type, price_string, price_currency_iso, custom, callback_url, description, style, include_email);
  }

  public class Button {

    public Button(String name, String type, String price_string, String price_currency_iso, String custom, String callback_url, String description, String style,
        Boolean include_email) {
      super();
      this.name = name;
      this.type = type;
      this.price_string = price_string;
      this.price_currency_iso = price_currency_iso;
      this.custom = custom;
      this.callback_url = callback_url;
      this.description = description;
      this.style = style;
      this.include_email = include_email;
    }

    private String name;
    private String type;
    private String price_string;
    private String price_currency_iso;
    private String custom;
    private String callback_url;
    private String description;
    private String style;
    private Boolean include_email;

    public String getName() {
      return name;
    }

    public void setName(String name) {
      this.name = name;
    }

    public String getType() {
      return type;
    }

    public void setType(String type) {
      this.type = type;
    }

    public String getPrice_string() {
      return price_string;
    }

    public void setPrice_string(String price_string) {
      this.price_string = price_string;
    }

    public String getPrice_currency_iso() {
      return price_currency_iso;
    }

    public void setPrice_currency_iso(String price_currency_iso) {
      this.price_currency_iso = price_currency_iso;
    }

    public String getCustom() {
      return custom;
    }

    public void setCustom(String custom) {
      this.custom = custom;
    }

    public String getCallback_url() {
      return callback_url;
    }

    public void setCallback_url(String callback_url) {
      this.callback_url = callback_url;
    }

    public String getDescription() {
      return description;
    }

    public void setDescription(String description) {
      this.description = description;
    }

    public String getStyle() {
      return style;
    }

    public void setStyle(String style) {
      this.style = style;
    }

    public Boolean getInclude_email() {
      return include_email;
    }

    public void setInclude_email(Boolean include_email) {
      this.include_email = include_email;
    }

  }
}
