package com.coinbase.java.client.authentication;

import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;

import javax.crypto.Mac;
import javax.crypto.spec.SecretKeySpec;

import org.apache.commons.codec.binary.Hex;
import org.apache.http.client.methods.HttpUriRequest;
import org.springframework.stereotype.Component;

@Component
public class AuthenticationHeaderAppender {

  public static final String ACCESS_KEY = "ACCESS_KEY";
  public static final String ACCESS_SIGNATURE = "ACCESS_SIGNATURE";
  public static final String ACCESS_NONCE = "ACCESS_NONCE";

  public void append(HttpUriRequest httpUriRequest, String url, String body) throws NoSuchAlgorithmException, InvalidKeyException {
    httpUriRequest.setHeader(ACCESS_KEY, "test_access_key");

    String nonce = "" + System.currentTimeMillis();
    httpUriRequest.setHeader(ACCESS_NONCE, nonce);

    String message = nonce + url + (body != null ? body : null);

    Mac mac = Mac.getInstance("HmacSHA256");
    mac.init(new SecretKeySpec(ACCESS_KEY.getBytes(), "HmacSHA256"));
    String signature = new String(Hex.encodeHex(mac.doFinal(message.getBytes())));

    httpUriRequest.setHeader(ACCESS_SIGNATURE, signature);
  }

}
