package com.example.MvvmDagger.view.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.MvvmDagger.R;
import com.example.MvvmDagger.service.model.SongModel;

import java.util.List;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class RecyclerSongAdapter extends RecyclerView.Adapter<RecyclerSongAdapter.RecyclerHolder>
{
    private List<SongModel> songList;
    private SongModel songModel;
    private LayoutInflater layoutInflater;
    private Context context;

    public RecyclerSongAdapter(List<SongModel> songList, Context context)
    {
        this.songList = songList;
        layoutInflater = LayoutInflater.from(context);
        this.context = context;
    }

    @NonNull
    @Override
    public RecyclerSongAdapter.RecyclerHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType)
    {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.songs_item, parent, false);
        return new RecyclerHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerSongAdapter.RecyclerHolder recyclerHolder, final int position)
    {
        songModel = songList.get(position);

        recyclerHolder.title.setText(songModel.getSong());
    }

    @Override
    public int getItemCount()
    {
        return songList.size();
    }

    public class RecyclerHolder extends RecyclerView.ViewHolder
    {
        TextView title;

        public RecyclerHolder(@NonNull View itemView)
        {
            super(itemView);
            title = itemView.findViewById(R.id.title_xml);
        }
    }

}
