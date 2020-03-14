package com.example.MvvmDagger.view.adapter;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.example.MvvmDagger.R;
import com.example.MvvmDagger.service.model.AlbumModel;
import com.example.MvvmDagger.view.ui.Activity.AlbumActivity;

import java.util.List;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class RecyclerAlbumAdapter extends RecyclerView.Adapter<RecyclerAlbumAdapter.RecyclerHolder>
{
    private List<AlbumModel> musicList;
    private AlbumModel musicModel;
    private LayoutInflater layoutInflater;
    private Context context;
    private ImageView pic;

    public RecyclerAlbumAdapter(List<AlbumModel> musicList, Context context)
    {
        this.musicList = musicList;
        layoutInflater = LayoutInflater.from(context);
        this.context = context;
    }

    @NonNull
    @Override
    public RecyclerHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType)
    {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.albums_item, parent, false);
        return new RecyclerHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerHolder recyclerHolder, final int position)
    {
        musicModel = musicList.get(position);

        View view = layoutInflater.inflate(R.layout.albums_item, null, false);

        Glide.with(view.getContext())
                .load(musicList.get(position).getPic())
                .into(pic);

        recyclerHolder.itemView.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                Intent intent = new Intent(context, AlbumActivity.class);

                String titlePosition = musicModel.getTitle();
                String artistPosition = musicModel.getArtist();
                String picPosition = musicList.get(position).getPic();

                intent.putExtra("titlePosition", titlePosition);
                intent.putExtra("artistPosition", artistPosition);
                intent.putExtra("picPosition", picPosition);

                intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                context.startActivity(intent);
            }
        });
    }

    @Override
    public int getItemCount()
    {
        return musicList.size();
    }

    public class RecyclerHolder extends RecyclerView.ViewHolder
    {
        public RecyclerHolder(@NonNull View itemView)
        {
            super(itemView);
            pic = itemView.findViewById(R.id.img_item);
        }
    }
}
