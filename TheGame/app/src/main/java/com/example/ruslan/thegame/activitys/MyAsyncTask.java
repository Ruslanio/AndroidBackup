package com.example.ruslan.thegame.activitys;

import android.os.AsyncTask;

/**
 * Created by Ruslan on 10.12.2016.
 */

public class MyAsyncTask extends AsyncTask<String/*doInBackGround*/,String/*onProgressUpdate*/,String/*doInBackGround(return) ---> onPostExecute*/> {


    private TaskListener taskListener;

    public void setTaskListener(TaskListener taskListener) {
        this.taskListener = taskListener;
    }

    @Override
    protected void onPreExecute() {
        super.onPreExecute();
        taskListener.onTaskStart();
    }

    @Override
    protected String doInBackground(String... params) {
        taskListener.onTaskProgress();
        return null;
    }

    @Override
    protected void onPostExecute(String s) {
        super.onPostExecute(s);
        taskListener.onTaskFinish(true);
    }

    @Override
    protected void onProgressUpdate(String... values) {
        super.onProgressUpdate(values);
    }
}
