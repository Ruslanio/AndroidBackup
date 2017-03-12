package com.example.ruslan.test.fragments;

import android.app.Activity;
import android.app.Fragment;
import android.content.Context;
import android.os.AsyncTask;
import android.os.Bundle;

import com.example.ruslan.test.interfaces.AsyncCallback;

/**
 * Created by Ruslan on 19.11.2016.
 */

public class AsyncHolderFragment extends Fragment{

    private AsyncCallback callback;
    private SomeWork work;

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        if(context instanceof AsyncCallback){
            callback = (AsyncCallback) context;
        }
    }

    @Override
    public void onAttach(Activity activity) {
        super.onAttach(activity);
        if(activity instanceof AsyncCallback){
            callback = (AsyncCallback) activity;
        }
    }

    @Override
    public void onDetach() {
        super.onDetach();
        callback = null;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setRetainInstance(true);

        if(work == null){
            work = new SomeWork();
            work.execute();
        }
    }

    class SomeWork extends AsyncTask<Void,Void,Void> {

        @Override
        protected void onPreExecute() {
            super.onPreExecute();
        }

        @Override
        protected Void doInBackground(Void... params) {
            //do some work
            try {
                Thread.sleep(3000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            return null;
        }

        @Override
        protected void onPostExecute(Void aVoid) {
            super.onPostExecute(aVoid);
            callback.onResult();
            work = null;
        }
    }
}
