package com.example.ruslan.povorotsassyntaskom;

import android.app.Fragment;
import android.os.AsyncTask;
import android.os.Bundle;

/**
 * Created by Ruslan on 12.11.2016.
 */

public class AsyncTaskHolderFragment extends Fragment {

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    public class MyAsyncTask extends AsyncTask<Void,Void,Void>{

        @Override
        protected Void doInBackground(Void... params) {
            try{
                Thread.sleep(200);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            return null;
        }
    }
}
