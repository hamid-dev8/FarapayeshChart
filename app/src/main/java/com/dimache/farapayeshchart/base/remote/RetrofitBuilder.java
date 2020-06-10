package com.dimache.farapayeshchart.base.remote;

import com.dimache.farapayeshchart.base.remote.shared.SPManager;
import com.jakewharton.retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import okhttp3.Interceptor;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class RetrofitBuilder {

    private static final String baseUrl = "http://harajino.isatelco.com/api/v1/";
    public static RetrofitBuilder INSTANCE;
    public static WebApi webApi;


    private RetrofitBuilder() {
    }

    public static void init(){
        if (INSTANCE == null) {

            HttpLoggingInterceptor logging = new HttpLoggingInterceptor();
            logging.setLevel(HttpLoggingInterceptor.Level.BODY);

            OkHttpClient okHttpClient = new OkHttpClient().newBuilder()
                    .connectTimeout(10, TimeUnit.SECONDS)
                    .addInterceptor(new Interceptor() {
                        @Override
                        public okhttp3.Response intercept(Chain chain) throws IOException {


                            Request original = chain.request();

                            Request request = original.newBuilder()
                                    .header("uuid", SPManager.getInstance().getUuid())
                                    .header("Authorization", SPManager.getInstance().getToken())
                                    .build();

                            return chain.proceed(request);
                        }
                    })
                    .addInterceptor(logging)
                    .addNetworkInterceptor(logging)
                    .readTimeout(10, TimeUnit.SECONDS)
                    .writeTimeout(10, TimeUnit.SECONDS)
                    .build();

            Retrofit retrofit = new Retrofit.Builder()
                    .baseUrl(baseUrl)
                    .addConverterFactory(GsonConverterFactory.create())
                    .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                    .client(okHttpClient)
                    .build();

            INSTANCE = new RetrofitBuilder();
        }
    }

    public static WebApi getWebApi() {
        return webApi;
    }

}
