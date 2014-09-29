package no.lynogtorden.hjerter.restservice;

import com.squareup.okhttp.OkHttpClient;

import java.util.concurrent.TimeUnit;

import retrofit.RestAdapter;
import retrofit.client.OkClient;

public class RestService {

    private static final String BASE_URL = "http://reis.ruter.no";

    public static RestAdapter getRestAdapter() {
        final OkHttpClient okHttpClient = new OkHttpClient();
        okHttpClient.setReadTimeout(60, TimeUnit.SECONDS);
        okHttpClient.setConnectTimeout(60, TimeUnit.SECONDS);

        return new RestAdapter.Builder()
                .setEndpoint(BASE_URL)
                .setClient(new OkClient(okHttpClient))
                .build();
    }
}
