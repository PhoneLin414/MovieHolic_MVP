package com.example.pla.movieholicmvp.network;

import com.example.pla.movieholicmvp.data.MovieDetailResponse;
import com.example.pla.movieholicmvp.data.MovieListResponse;

import io.reactivex.Observable;
import retrofit2.http.GET;
import retrofit2.http.Path;
import retrofit2.http.Query;

public interface Service {

    @GET("movie/now_playing")
    Observable<MovieListResponse> getNowPlayingMovieList(@Query("api_key") String API_KEY, @Query("page") int PAGE);

    @GET("movie/popular")
    Observable<MovieListResponse> getPopularMovieList(@Query("api_key") String API_KEY, @Query("page") int PAGE);

    @GET("movie/upcoming")
    Observable<MovieListResponse> getUpComingMovieList(@Query("api_key") String API_KEY, @Query("page") int PAGE);


    @GET("movie/{movie_id}")
    Observable<MovieDetailResponse> getMovieDetail(@Path("movie_id") int id, @Query("api_key") String API_KEY);


}
