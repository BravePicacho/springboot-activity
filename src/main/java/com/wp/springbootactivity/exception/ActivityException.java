package com.wp.springbootactivity.exception;

public class ActivityException extends RuntimeException{

    public ActivityException(){
        super();
    }

    public ActivityException(String message){
        super(message);
    }

    public ActivityException(String message,Throwable throwable){
        super(message,throwable);
    }

    public ActivityException(Throwable throwable){
        super(throwable);
    }
}
