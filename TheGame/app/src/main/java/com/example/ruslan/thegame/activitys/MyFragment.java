package com.example.ruslan.thegame.activitys;

import android.app.Activity;
import android.app.Fragment;
import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

/**
 * Created by Ruslan on 10.12.2016.
 */

public class MyFragment extends Fragment {

    private TaskListener listener;
    MyAsyncTask asyncTask;

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        listener = (TaskListener) context;
    }

    @Override
    public void onAttach(Activity activity) {
        super.onAttach(activity);
        listener = (TaskListener) activity;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setRetainInstance(true);//ignore the life cycle
    }

    public void startAsync() {
        asyncTask = new MyAsyncTask();
        asyncTask.setTaskListener(listener);
        asyncTask.execute();
    }
}
