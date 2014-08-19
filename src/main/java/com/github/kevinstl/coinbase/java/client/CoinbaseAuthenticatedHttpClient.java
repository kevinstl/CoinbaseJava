package com.github.kevinstl.coinbase.java.client;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.util.logging.Level;
import java.util.logging.Logger;

import org.apache.commons.lang.StringUtils;
import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpDelete;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.client.methods.HttpPut;
import org.apache.http.client.methods.HttpUriRequest;
import org.apache.http.entity.StringEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.github.kevinstl.coinbase.java.client.authentication.AuthenticationHeaderAppender;
import com.github.kevinstl.coinbase.java.exception.CoinbaseException;

@Component
public class CoinbaseAuthenticatedHttpClient extends CoinbaseHttpClient{

  private static Logger logger = Logger.getLogger(CoinbaseAuthenticatedHttpClient.class.getName());

  private HttpClient coinbaseApacheHttpClient;
  private AuthenticationHeaderAppender authenticationHeaderAppender;

  @Autowired
  public CoinbaseAuthenticatedHttpClient(HttpClient coinbaseApacheHttpClient, AuthenticationHeaderAppender authenticationHeaderAppender) {
    super(coinbaseApacheHttpClient);
    this.coinbaseApacheHttpClient = coinbaseApacheHttpClient;
    this.authenticationHeaderAppender = authenticationHeaderAppender;
  }


  @Override
  protected String executeHttpUriRequest(HttpUriRequest httpUriRequest, String urlString, String payload, String contentType) throws IOException, ClientProtocolException {
    
    try {
      authenticationHeaderAppender.append(httpUriRequest, urlString, payload);
    }
    catch (InvalidKeyException e) {
      throw new CoinbaseException(e.getMessage());
    }
    catch (NoSuchAlgorithmException e) {
      throw new CoinbaseException(e.getMessage());
    }
    
    return super.executeHttpUriRequest(httpUriRequest, urlString, payload, contentType);
  }



}
