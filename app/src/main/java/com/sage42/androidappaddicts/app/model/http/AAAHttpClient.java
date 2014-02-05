package com.sage42.androidappaddicts.app.model.http;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;

import org.apache.http.HttpStatus;

import com.sage42.androidappaddicts.app.model.logging.Logger;
import com.squareup.okhttp.OkHttpClient;

public enum AAAHttpClient
{
    INSTANCE;

    private static final String RESPONSE_ENCODING = "UTF-8";                            //$NON-NLS-1$

    private static final String TAG               = AAAHttpClient.class.getSimpleName();

    public static String doGet(final String uri)
    {
        final OkHttpClient client = new OkHttpClient();

        try
        {
            Logger.debug(TAG, "Request to: " + uri); //$NON-NLS-1$
            final HttpURLConnection connection = client.open(new URL(uri));

            switch (connection.getResponseCode())
            {
                case HttpStatus.SC_OK:
                    return loadResponseBody(connection.getInputStream());

                case HttpStatus.SC_NO_CONTENT:
                    // not response body, return null
                    Logger.debug(TAG, "Response was NO_CONTENT(204): " + uri); //$NON-NLS-1$
                    return null;

                default:
                    // process error body for response
                    return loadResponseBody(connection.getErrorStream());
            }
        }
        catch (final IOException e)
        {
            // log and return null
            Logger.error(TAG, e.getMessage(), e, false);
            return null;
        }
    }

    private static String loadResponseBody(final InputStream inputStream) throws IOException
    {
        // Read the response.
        final ByteArrayOutputStream out = new ByteArrayOutputStream();
        final byte[] buffer = new byte[1024];
        for (int count; (count = inputStream.read(buffer)) != -1;)
        {
            out.write(buffer, 0, count);
        }
        return new String(out.toByteArray(), RESPONSE_ENCODING);
    }

}
