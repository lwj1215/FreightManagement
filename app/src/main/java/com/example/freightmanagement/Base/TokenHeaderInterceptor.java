package com.example.freightmanagement.Base;

import com.example.freightmanagement.Utils.PrefUtilsData;

import java.io.IOException;

import okhttp3.Interceptor;
import okhttp3.Request;
import okhttp3.Response;

/**
 * Created by songdechuan on 2020/8/17.
 */

public class TokenHeaderInterceptor implements Interceptor {

    @Override
    public Response intercept(Chain chain) throws IOException {
        // get token
        String token = PrefUtilsData.getToken();
        Request originalRequest = chain.request();
        // get new request, add request header
        Request updateRequest = originalRequest.newBuilder()
                .header("token", token)
                .build();
        return chain.proceed(updateRequest);

    }
}
