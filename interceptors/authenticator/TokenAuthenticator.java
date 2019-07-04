package com.martin.retrofitwrapper.retrofit.interceptors.authenticator;

import android.support.annotation.NonNull;
import android.support.annotation.Nullable;

import java.io.IOException;

import okhttp3.Authenticator;
import okhttp3.Request;
import okhttp3.Response;
import okhttp3.Route;

/**
 * Created by martin on 2/19/18.
 */
public class TokenAuthenticator implements Authenticator {

    private static final int UNAUTHORIZED = 401;

    @Nullable
    @Override
    public Request authenticate(@NonNull Route route, @NonNull Response response) throws IOException {
        if (response.code() == UNAUTHORIZED) {
            throw new AuthException();
        }
        return response.request();
    }
}
