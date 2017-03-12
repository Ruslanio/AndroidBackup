package com.example.ruslan.fragments;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

public class MainActivity extends AppCompatActivity implements ItemAdapter.CatItemOnClickListener{
    RecyclerView mCatList;
    ItemAdapter mAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        CatsProvider.getInstance().restoreData(this);
        mAdapter = new ItemAdapter();

        mCatList = (RecyclerView) findViewById(R.id.cats_list);
        mCatList.setLayoutManager(new LinearLayoutManager(this));
        mCatList.setAdapter(mAdapter);

        mAdapter.setCats(CatsProvider.getInstance().provideCats(50));
        mAdapter.setmCatItemOnClickListener(this);
    }

    @Override
    public void onItemClick(String catName) {

    }
}
