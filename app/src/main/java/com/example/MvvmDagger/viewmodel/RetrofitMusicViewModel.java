package com.example.MvvmDagger.viewmodel;

import android.util.Log;

import com.example.MvvmDagger.service.model.AlbumModel;
import com.example.MvvmDagger.service.model.SongModel;

import java.util.List;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class RetrofitMusicViewModel extends androidx.lifecycle.ViewModel
{
    private MutableLiveData<List<AlbumModel>> albumListLiveData;
    private MutableLiveData<List<SongModel>> songsListLiveData;

    //Albums
    public LiveData<List<AlbumModel>> getAlbum()
    {
        if (albumListLiveData == null)
        {
            albumListLiveData = new MutableLiveData<List<AlbumModel>>();
            loadList();
        }

        return albumListLiveData;
    }

    private void loadList()
    {
        RetrofitBuilder retrofitBuilder = new RetrofitBuilder();

        Call<List<AlbumModel>> call = retrofitBuilder.retrofitConfig().getAlbum();

        call.enqueue(new Callback<List<AlbumModel>>()
        {
            @Override
            public void onResponse(Call<List<AlbumModel>> call, Response<List<AlbumModel>> response)
            {
                if (!response.isSuccessful())
                {
                    Log.e("Code: ", String.valueOf(response.code()));
                    return;
                }

                albumListLiveData.setValue(response.body());
                Log.e("onResponse", response.body().toString());
            }

            @Override
            public void onFailure(Call<List<AlbumModel>> call, Throwable t)
            {
                Log.e("onFailure", t.getMessage());
            }
        });
    }

    //Songs
    public LiveData<List<SongModel>> getSong()
    {
        if (songsListLiveData == null)
        {
            songsListLiveData = new MutableLiveData<List<SongModel>>();
            loadSongs();
        }

        return songsListLiveData;
    }

    private void loadSongs()
    {
        RetrofitBuilder retrofitBuilder = new RetrofitBuilder();

        Call<List<SongModel>> call = retrofitBuilder.retrofitConfig().getMusic();

        call.enqueue(new Callback<List<SongModel>>()
        {
            @Override
            public void onResponse(Call<List<SongModel>> call, Response<List<SongModel>> response)
            {
                if (!response.isSuccessful())
                {
                    Log.e("Code: ", String.valueOf(response.code()));
                    return;
                }

                songsListLiveData.setValue(response.body());
                Log.e("onResponse", response.body().toString());
            }

            @Override
            public void onFailure(Call<List<SongModel>> call, Throwable t)
            {
                Log.e("onFailure", t.getMessage());
            }
        });
    }

}
