package com.example.MvvmDagger.view.ui.Activity;

import android.os.Bundle;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.example.MvvmDagger.R;
import com.example.MvvmDagger.service.model.SongModel;
import com.example.MvvmDagger.view.adapter.RecyclerSongAdapter;
import com.example.MvvmDagger.viewmodel.RetrofitMusicViewModel;
import com.makeramen.roundedimageview.RoundedImageView;

import java.util.List;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

public class AlbumActivity extends AppCompatActivity
{
    private TextView title, artist;
    private RoundedImageView pic;
    private RecyclerView recyclerView;
    private RecyclerSongAdapter recyclerSongAdapter;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_album);

        initialize();

        Bundle myBundle = getIntent().getExtras();

        String titleGetExtra = myBundle.getString("titlePosition");
        String artistGetExtra = myBundle.getString("artistPosition");
        String picLink = myBundle.getString("picPosition");

        title.setText(titleGetExtra);
        artist.setText(artistGetExtra);

        Glide.with(AlbumActivity.this)
                .load(picLink)
                .into(pic);

       // recyclerView.setHasFixedSize(true);
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(AlbumActivity.this);
        recyclerView.setLayoutManager(layoutManager);

        RetrofitMusicViewModel rmvm = ViewModelProviders.of(AlbumActivity.this).get(RetrofitMusicViewModel.class);

        rmvm.getSong().observe(AlbumActivity.this, new Observer<List<SongModel>>()
        {
            @Override
            public void onChanged(List<SongModel> songModels)
            {
                recyclerSongAdapter = new RecyclerSongAdapter(songModels, AlbumActivity.this);
                recyclerView.setAdapter(recyclerSongAdapter);
            }
        });
    }

    private void initialize()
    {
        title = findViewById(R.id.title_xml);
        artist = findViewById(R.id.artist_xml);
        pic = findViewById(R.id.pic_xml);
        recyclerView = findViewById(R.id.recycler_xml);
    }
}
