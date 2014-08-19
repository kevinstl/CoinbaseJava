package com.github.kevinstl.coinbase.java.client;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.logging.Level;
import java.util.logging.Logger;

import org.apache.commons.lang.StringUtils;
import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.HttpStatus;
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

@Component
public class CoinbaseHttpClient {

  private static Logger logger = Logger.getLogger(CoinbaseHttpClient.class.getName());

  private HttpClient coinbaseApacheHttpClient;

  @Autowired
  public CoinbaseHttpClient(HttpClient coinbaseApacheHttpClient) {
    this.coinbaseApacheHttpClient = coinbaseApacheHttpClient;
  }

  public String executeGet(String urlString) throws IOException, ClientProtocolException {

    HttpGet httpGet = new HttpGet(urlString);

    String responseString = executeHttpUriRequest(httpGet, urlString, null, null);

    return responseString;
  }

  public String executePost(String urlString, String payload) throws IOException, ClientProtocolException {

    logger.info("payload: " + payload);

    HttpPost httpPost = new HttpPost(urlString);

    if (payload != null) {
      StringEntity stringEntity = new StringEntity(payload);
      httpPost.setEntity(stringEntity);
    }

    String responseString = executeHttpUriRequest(httpPost, urlString, payload, "application/json");

    return responseString;
  }
  
  public String executePut(String urlString, String payload) throws IOException, ClientProtocolException {
    
    logger.info("payload: " + payload);
    
    HttpPut httpPut = new HttpPut(urlString);
    
    if (payload != null) {
      StringEntity stringEntity = new StringEntity(payload);
      httpPut.setEntity(stringEntity);
    }
    
    String responseString = executeHttpUriRequest(httpPut, urlString, payload, "application/json");
    
    return responseString;
  }

  public String executeDelete(String urlString) throws IOException, ClientProtocolException {
    HttpDelete httpDelete = new HttpDelete(urlString);

    String responseString = executeHttpUriRequest(httpDelete, urlString, null, null);

    return responseString;
  }

  protected String executeHttpUriRequest(HttpUriRequest httpUriRequest, String urlString, String payload, String contentType) throws IOException, ClientProtocolException {

    if (StringUtils.isNotBlank(contentType)) {
      httpUriRequest.setHeader("content-type", contentType);
    }

    String responseString = "";

    HttpResponse httpResponse = coinbaseApacheHttpClient.execute(httpUriRequest);

    responseString = httpResponse.toString();
    
    logger.info("httpResponse.toString(): " + responseString);

    // Get hold of the response entity
    HttpEntity entity = httpResponse.getEntity();

    // If the response does not enclose an entity, there is no need
    // to worry about connection release
    if(entity != null) {
      InputStream instream = entity.getContent();
      try {

        BufferedReader reader = new BufferedReader(new InputStreamReader(instream));
        // do something useful with the response
        // responseString = reader.readLine();

        StringBuilder stringBuilder = new StringBuilder();
        String line;
        while ((line = reader.readLine()) != null) {
          stringBuilder.append(line);
        }
        
        if(HttpStatus.SC_OK == httpResponse.getStatusLine().getStatusCode()){
          responseString = stringBuilder.toString();
        }
        // System.out.println(responseString);
        logger.log(Level.FINEST, responseString);

      }
      catch (IOException ex) {

        // In case of an IOException the connection will be released
        // back to the connection manager automatically
        throw ex;

      }
      catch (RuntimeException ex) {

        // In case of an unexpected exception you may want to abort
        // the HTTP request in order to shut down the underlying
        // connection and release it back to the connection manager.
        httpUriRequest.abort();
        throw ex;

      }
      finally {

        // Closing the input stream will trigger connection release
        instream.close();

      }

      // shutdown();
    }
    return responseString;
  }

  public void shutdown() {
    // When HttpClient instance is no longer needed,
    // shut down the connection manager to ensure
    // immediate deallocation of all system resources
    coinbaseApacheHttpClient.getConnectionManager().shutdown();
  }

}
