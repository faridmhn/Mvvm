package com.example.MvvmDagger.view.adapter;

import android.content.Context;

import com.example.MvvmDagger.view.ui.Fragment.HomeFragment;
import com.example.MvvmDagger.view.ui.Fragment.Playlists;
import com.example.MvvmDagger.view.ui.Fragment.Reviews;
import com.example.MvvmDagger.view.ui.Fragment.Songs;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;

public class PagerAdapter extends FragmentPagerAdapter
{
    private Context myContext;
    int totalTabs;

    public PagerAdapter(Context context, FragmentManager fm, int totalTabs)
    {
        super(fm);
        myContext = context;
        this.totalTabs = totalTabs;
    }

    @Override
    public Fragment getItem(int position)
    {
        switch (position)
        {
            case 0:
                HomeFragment homeFragment = new HomeFragment();
                return homeFragment;
            case 1:
                Playlists playlists = new Playlists();
                return playlists;
            case 2:
                Reviews reviews = new Reviews();
                return reviews;
            case 3:
                Songs songs = new Songs();
                return songs;
            default:
                return null;
        }
    }

    @Override
    public int getCount()
    {
        return totalTabs;
    }
}
