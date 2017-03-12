package com.example.ruslan.fragments;

import android.app.Fragment;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

/**
 * Created by Ruslan on 15.10.2016.
 */

public class MyFragment extends Fragment {
    ImageView mPhoto;
    TextView mName;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.frg_detail,container,false);
        return view;
    }

    @Override
    public void onViewCreated(View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        mName = (TextView) view.findViewById(R.id.tv_name);
        mPhoto = (ImageView) view.findViewById(R.id.iv_photo);
    }
}
