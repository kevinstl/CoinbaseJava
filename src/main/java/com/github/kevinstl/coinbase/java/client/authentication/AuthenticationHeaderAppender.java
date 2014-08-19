package com.github.kevinstl.coinbase.java.client.authentication;

import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;

import javax.crypto.Mac;
import javax.crypto.spec.SecretKeySpec;

import org.apache.commons.codec.binary.Hex;
import org.apache.commons.lang.StringUtils;
import org.apache.http.client.methods.HttpUriRequest;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.DependsOn;
import org.springframework.stereotype.Component;

@Component
public class AuthenticationHeaderAppender {

  @Value("${coinbase.apiKey}") 
  private String coinbaseApiKey;
  
  @Value("${coinbase.apiSecret}") 
  private String coinbaseApiSecret;
  
  public static final String ACCESS_KEY = "ACCESS_KEY";
  public static final String ACCESS_SIGNATURE = "ACCESS_SIGNATURE";
  public static final String ACCESS_NONCE = "ACCESS_NONCE";

  public void append(HttpUriRequest httpUriRequest, String url, String body) throws NoSuchAlgorithmException, InvalidKeyException {
    httpUriRequest.setHeader(ACCESS_KEY, coinbaseApiKey);

    String nonce = "" + System.currentTimeMillis();
    httpUriRequest.setHeader(ACCESS_NONCE, nonce);

    String message = nonce + url + StringUtils.defaultString(body);

    Mac mac = Mac.getInstance("HmacSHA256");
    mac.init(new SecretKeySpec(coinbaseApiSecret.getBytes(), "HmacSHA256"));
    String signature = new String(Hex.encodeHex(mac.doFinal(message.getBytes())));


    httpUriRequest.setHeader(ACCESS_SIGNATURE, signature);
  }

}
