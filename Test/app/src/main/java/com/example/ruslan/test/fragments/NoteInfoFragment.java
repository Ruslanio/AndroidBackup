package com.example.ruslan.test.fragments;

import android.app.Fragment;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import com.example.ruslan.test.R;
import com.example.ruslan.test.activities.RedactorActivity;

/**
 * Created by Ruslan on 19.11.2016.
 */

public class NoteInfoFragment extends Fragment{

    private TextView tvName;
    private TextView tvText;
    private Button btnRedactor;

    public static NoteInfoFragment newInstance(String name, String text) {

        Bundle args = new Bundle();
        args.putString("name",name);
        args.putString("text",text);

        NoteInfoFragment fragment = new NoteInfoFragment();
        fragment.setArguments(args);
        return fragment;
    }


    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        return inflater.inflate(R.layout.note_info_fragment,container,false);


    }

    @Override
    public void onViewCreated(View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        tvName = (TextView) view.findViewById(R.id.frg_tv_name);
        tvText = (TextView) view.findViewById(R.id.frg_tv_text);
        btnRedactor = (Button) view.findViewById(R.id.frg_btn_redactor);

        btnRedactor.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getActivity(), RedactorActivity.class);
                startActivity(intent);
            }
        });

        if(getArguments() != null) {
            tvName.setText(getArguments().getString("name"));
            tvText.setText(getArguments().getString("text"));
        }



    }
}
