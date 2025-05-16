package com.study.spring.util;



public class CustomJWTException extends Exception {
	public CustomJWTException(String msg){
	      super(msg);
	  }
	
	 public CustomJWTException(String message, Throwable cause) {
	        super(message, cause);
	    }
}
