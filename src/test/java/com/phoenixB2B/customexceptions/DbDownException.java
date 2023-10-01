package com.phoenixB2B.customexceptions;

public class DbDownException extends  Exception{
    public DbDownException(String exceptionMessage){
        super(exceptionMessage);
    }
}
