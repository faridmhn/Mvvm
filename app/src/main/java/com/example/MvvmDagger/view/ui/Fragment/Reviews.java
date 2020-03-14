package com.example.MvvmDagger.view.ui.Fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.MvvmDagger.R;

import androidx.fragment.app.Fragment;

public class Reviews extends Fragment
{
    public Reviews()
    {

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState)
    {
        return inflater.inflate(R.layout.fragment_reviews, container, false);
    }
}
