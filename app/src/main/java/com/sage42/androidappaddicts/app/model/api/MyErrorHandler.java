package com.sage42.androidappaddicts.app.model.api;

import org.apache.http.HttpStatus;

import retrofit.ErrorHandler;
import retrofit.RetrofitError;
import retrofit.client.Response;

public class MyErrorHandler implements ErrorHandler
{
    @Override
    public Throwable handleError(final RetrofitError cause)
    {
        final Response response = cause.getResponse();
        if (response != null)
        {
            switch (response.getStatus())
            {
                case HttpStatus.SC_UNAUTHORIZED:
                default:
                    // TODO: push errors into the UI
                    break;
            }
        }
        return cause;
    }

}