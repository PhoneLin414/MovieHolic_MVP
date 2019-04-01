package com.example.pla.movieholicmvp.network;

import java.io.IOException;
import java.time.Duration;
import java.util.concurrent.TimeUnit;

import okhttp3.Interceptor;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

public class ServiceFactory {

    private int TIME_OUT = 60;

    private static ServiceFactory INSTANCE = null;

    public static ServiceFactory getInstance() {

        if (INSTANCE == null) {

            INSTANCE = new ServiceFactory();

        }

        return INSTANCE;
    }

    public <T> T createService(Class<T> serviceClass) {


        return getRetrofit().create(serviceClass);


    }

    private Retrofit getRetrofit() {

        Retrofit.Builder retrofitBuilder = new Retrofit.Builder();

        retrofitBuilder.baseUrl("");
        retrofitBuilder.addConverterFactory(GsonConverterFactory.create());
        retrofitBuilder.addCallAdapterFactory(RxJava2CallAdapterFactory.create());
        retrofitBuilder.client(getOkHTTPClient());

        return retrofitBuilder.build();

    }

    private OkHttpClient getOkHTTPClient() {

        OkHttpClient.Builder okHttpClientBuilder = new OkHttpClient.Builder();

        if (!okHttpClientBuilder.interceptors().isEmpty()) {
            okHttpClientBuilder.interceptors().clear();
        }


        okHttpClientBuilder.connectTimeout(TIME_OUT, TimeUnit.SECONDS);
        okHttpClientBuilder.readTimeout(TIME_OUT, TimeUnit.SECONDS);
        okHttpClientBuilder.writeTimeout(TIME_OUT, TimeUnit.SECONDS);

        okHttpClientBuilder.addInterceptor(getInterceptor());

        return okHttpClientBuilder.build();

    }


    private Interceptor getInterceptor() {

        Interceptor interceptor = new Interceptor() {
            @Override
            public Response intercept(Chain chain) throws IOException {

                Request.Builder requestBuilder = new Request.Builder();

                Request request = requestBuilder.build();

                return chain.proceed(request);

            }
        };

        return interceptor;

    }


}
