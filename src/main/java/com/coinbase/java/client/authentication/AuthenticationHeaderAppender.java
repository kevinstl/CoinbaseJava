package com.coinbase.java.client.authentication;

import org.apache.http.client.methods.HttpUriRequest;
import org.springframework.stereotype.Component;

@Component
public class AuthenticationHeaderAppender  {

  public static final String ACCESS_KEY = "ACCESS_KEY";
  public static final String ACCESS_SIGNATURE = "ACCESS_SIGNATURE";
  public static final String ACCESS_NONCE = "ACCESS_NONCE";

  public void append(HttpUriRequest httpUriRequest) {
    httpUriRequest.setHeader(ACCESS_KEY, "test_access_key");
    httpUriRequest.setHeader(ACCESS_SIGNATURE, "test_access_signature");
    httpUriRequest.setHeader(ACCESS_NONCE, "test_access_nonce");
  }

}
