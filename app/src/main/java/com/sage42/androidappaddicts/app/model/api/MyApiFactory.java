package com.sage42.androidappaddicts.app.model.api;

/**
 * Factory wrapper around the API calls so that we can mock them for testing.
 */
public enum MyApiFactory
{
    INSTANCE;

    private static MyApi sApiInstance;

    /**
     * @return the sApiInstance
     */
    public static MyApi getApiInstance()
    {
        return sApiInstance;
    }

    /**
     * @param sApiInstance
     *            the sApiInstance to set
     */
    public static void setApiInstance(MyApi sApiInstance)
    {
        MyApiFactory.sApiInstance = sApiInstance;
    }

}
