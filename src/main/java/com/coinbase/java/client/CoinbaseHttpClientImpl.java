package com.coinbase.java.client;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.logging.Level;
import java.util.logging.Logger;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.DefaultHttpClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class CoinbaseHttpClientImpl implements CoinbaseHttpClient{
  
  private static Logger logger = Logger.getLogger(CoinbaseHttpClientImpl.class.getName());

  private HttpClient httpClient;
  
  @Autowired
  public CoinbaseHttpClientImpl(HttpClient httpClient) {
    this.httpClient = httpClient;
  }
  
  @Override
  public String getResponseStringFromHttpGet(String urlString)
      throws IOException, ClientProtocolException {
    String responseString = "";
    
//    HttpClient httpClient = new DefaultHttpClient();
        
    HttpGet httpGet = new HttpGet(urlString);

    HttpResponse httpResponse = httpClient.execute(httpGet);

    logger.info("httpResponse.toString(): " + httpResponse.toString());
    
    // Get hold of the response entity
    HttpEntity entity = httpResponse.getEntity();

    // If the response does not enclose an entity, there is no need
    // to worry about connection release
    if (entity != null) {
        InputStream instream = entity.getContent();
        try {

            BufferedReader reader = new BufferedReader(
                    new InputStreamReader(instream));
            // do something useful with the response
            responseString = reader.readLine();
            System.out.println(responseString);
            logger.log(Level.FINEST, responseString);

        } catch (IOException ex) {

            // In case of an IOException the connection will be released
            // back to the connection manager automatically
            throw ex;

        } catch (RuntimeException ex) {

            // In case of an unexpected exception you may want to abort
            // the HTTP request in order to shut down the underlying
            // connection and release it back to the connection manager.
          httpGet.abort();
            throw ex;

        } finally {

            // Closing the input stream will trigger connection release
            instream.close();

        }

        // When HttpClient instance is no longer needed,
        // shut down the connection manager to ensure
        // immediate deallocation of all system resources
        httpClient.getConnectionManager().shutdown();
    }
    
    return responseString;
  }
  
}
