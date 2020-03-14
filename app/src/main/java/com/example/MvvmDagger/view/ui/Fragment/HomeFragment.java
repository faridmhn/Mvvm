package com.example.MvvmDagger.view.ui.Fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.MvvmDagger.R;
import com.example.MvvmDagger.service.model.AlbumModel;
import com.example.MvvmDagger.view.adapter.RecyclerAlbumAdapter;
import com.example.MvvmDagger.viewmodel.RetrofitMusicViewModel;

import java.util.List;

import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

public class HomeFragment extends Fragment
{
    private RecyclerView recyclerView;
    private RecyclerAlbumAdapter recyclerAlbumAdapter;

    public HomeFragment()
    {

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState)
    {
        View view = inflater.inflate(R.layout.fragment_home, container, false);

        recyclerView = view.findViewById(R.id.recycler_xml);

        recyclerView.setHasFixedSize(true);
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(getActivity(), LinearLayoutManager.HORIZONTAL, false);
        recyclerView.setLayoutManager(layoutManager);

        RetrofitMusicViewModel rmvm = ViewModelProviders.of(getActivity()).get(RetrofitMusicViewModel.class);

        rmvm.getAlbum().observe(getActivity(), new Observer<List<AlbumModel>>()
        {
            @Override
            public void onChanged(List<AlbumModel> musicModels)
            {
                recyclerAlbumAdapter = new RecyclerAlbumAdapter(musicModels, getActivity());
                recyclerView.setAdapter(recyclerAlbumAdapter);
            }
        });

        return view;
    }
}
