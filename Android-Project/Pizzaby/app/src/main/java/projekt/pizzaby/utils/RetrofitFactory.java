package projekt.pizzaby.utils;

import android.annotation.SuppressLint;

import java.net.InetSocketAddress;
import java.net.Proxy;
import java.security.SecureRandom;
import java.security.cert.CertificateException;
import java.security.cert.X509Certificate;

import javax.net.ssl.SSLContext;
import javax.net.ssl.TrustManager;
import javax.net.ssl.X509TrustManager;

import okhttp3.OkHttpClient;
import projekt.pizzaby.BuildConfig;
import projekt.pizzaby.api.Api;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava.RxJavaCallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

import static projekt.pizzaby.BuildConfig.BASE_URL;


public class RetrofitFactory {

    private static RetrofitFactory factory;
    private Retrofit retrofit;

    private RetrofitFactory() {
        OkHttpClient.Builder builder = new OkHttpClient.Builder();
        HttpDecorator.attachProxy(builder);

        OkHttpClient client = builder.build();

        retrofit = new Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(RxJavaCallAdapterFactory.create())
                .client(client)
                .build();
    }

    public static RetrofitFactory getFactory() {
        if (factory == null) {
            factory = new RetrofitFactory();
        }

        return factory;
    }

    public Api getApi() {
        return retrofit.create(Api.class);
    }

    public static class HttpDecorator {

        public static void attachProxy(OkHttpClient.Builder builder) {
            if (BuildConfig.OMIT_HTTPS_SECURITY) {
                ignoreHttpsSecurity(builder);
            }
            //noinspection ConstantConditions
            if (BuildConfig.HTTP_PROXY_INET != null) {
                builder.proxy(new Proxy(Proxy.Type.HTTP, InetSocketAddress.createUnresolved(BuildConfig.HTTP_PROXY_INET, BuildConfig.HTTP_PROXY_PORT)));
            }
        }

        private static void ignoreHttpsSecurity(OkHttpClient.Builder client) {
            TrustManager[] trustAllCerts = new TrustManager[]{
                    new X509TrustManager() {
                        @SuppressLint("TrustAllX509TrustManager")
                        public void checkClientTrusted(X509Certificate[] certs, String authType) throws CertificateException {
                        }

                        @SuppressLint("TrustAllX509TrustManager")
                        public void checkServerTrusted(X509Certificate[] certs, String authType) throws CertificateException {
                        }

                        public X509Certificate[] getAcceptedIssuers() {
                            return new X509Certificate[0];
                        }
                    }
            };
            try {
                SSLContext sc = SSLContext.getInstance("SSL");
                sc.init(null, trustAllCerts, new SecureRandom());
                client.sslSocketFactory(sc.getSocketFactory());
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
}
