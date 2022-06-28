package com.mirzahansuslu.moviebook;

import android.content.Context;
import android.util.Log;
import android.widget.Toast;

import com.mirzahansuslu.moviebook.Listeners.OnDetailsListener;
import com.mirzahansuslu.moviebook.Listeners.OnSearchApiListener;

import Models.DetailApi;
import Models.SearchApi;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
import retrofit2.http.GET;
import retrofit2.http.Headers;
import retrofit2.http.Path;
import retrofit2.http.Query;

public class RequestManager {
    Context context;
    Retrofit retrofit = new Retrofit.Builder()
            .baseUrl("https://movie-database-alternative.p.rapidapi.com/")
            .addConverterFactory(GsonConverterFactory.create())
            .build();

    public RequestManager(Context context) {
        this.context = context;
    }
    public void searchMovies(OnSearchApiListener listener,String movie_name) {
        getMovies getMovies = retrofit.create(RequestManager.getMovies.class);
        Call<SearchApi> call = getMovies.callMovies(movie_name);
        call.enqueue(new Callback<SearchApi>() {
            @Override
            public void onResponse(Call<SearchApi> call, Response<SearchApi> response) {
                Log.d("Response:", response.toString());
                if(!response.isSuccessful()) {
                    Toast.makeText(context, "Failed to fetch data", Toast.LENGTH_SHORT).show();
                    return;
                }
                listener.onResponse(response.body());
            }

            @Override
            public void onFailure(Call<SearchApi> call, Throwable t) {
                listener.onError(t.getMessage());
            }
        });
    }
    public void searchDetails(OnDetailsListener listener, String movie_id) {
        getDetails getDetails = retrofit.create(RequestManager.getDetails.class);
        Call<DetailApi> call = getDetails.callDetails(movie_id);
        call.enqueue(new Callback<DetailApi>() {
            @Override
            public void onResponse(Call<DetailApi> call, Response<DetailApi> response) {
                Log.d("Response:", response.toString());
                if(!response.isSuccessful()) {
                    Toast.makeText(context, "Failed to fetch data", Toast.LENGTH_SHORT).show();
                    return;
                }
                listener.onResponse(response.body());
            }

            @Override
            public void onFailure(Call<DetailApi> call, Throwable t) {
                listener.onError(t.getMessage());
            }
        });
    }
    public interface getMovies {
        @Headers({
               "Accept: application/json",
                "X-RapidAPI-Host: movie-database-alternative.p.rapidapi.com",
                "X-RapidAPI-Key: yourAPIkey"


        })
        @GET("https://movie-database-alternative.p.rapidapi.com/")

        Call<SearchApi> callMovies(
                @Query("s") String movie_name
        );

    }
    public interface getDetails {
        @Headers({
                "Accept: application/json",
                "X-RapidAPI-Host: movie-database-alternative.p.rapidapi.com",
                "X-RapidAPI-Key: yourAPIkey"


        })
        @GET("https://movie-database-alternative.p.rapidapi.com/")

        Call<DetailApi> callDetails(
                @Query("i") String movie_id
        );

    }
}
