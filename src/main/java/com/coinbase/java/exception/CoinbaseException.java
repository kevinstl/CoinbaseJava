package com.coinbase.java.exception;

import java.util.logging.Level;
import java.util.logging.Logger;

public class CoinbaseException extends RuntimeException {
  
  private static final long serialVersionUID = 1L;
  
  private static Logger logger = Logger.getLogger(CoinbaseException.class.getName());
  
  public CoinbaseException(String message) {
    super(message);    
    logger.log(Level.SEVERE, message);
  }

}
