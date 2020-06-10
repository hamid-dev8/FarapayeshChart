package com.dimache.farapayeshchart.base.remote.util;

public class ServerErrorException extends RuntimeException
{
    public ServerErrorException(){}
    public ServerErrorException(String errorMessage){super(errorMessage);}
}
