package com.example.MvvmDagger.service.repository;

import com.example.MvvmDagger.service.model.AlbumModel;
import com.example.MvvmDagger.service.model.SongModel;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

public interface Api
{
    @GET("album.php")
    Call<List<AlbumModel>> getAlbum();

    @GET("music.php")
    Call<List<SongModel>> getMusic();
}
