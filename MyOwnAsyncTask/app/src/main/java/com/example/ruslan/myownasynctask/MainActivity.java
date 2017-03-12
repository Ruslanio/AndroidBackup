package com.example.ruslan.myownasynctask;

import android.icu.util.TimeUnit;
import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    TextView tvThread;
    TextView tvStatus;
    Button btnStart;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        tvStatus = (TextView) findViewById(R.id.tv_status);
        tvThread = (TextView) findViewById(R.id.tv_thread);
        btnStart = (Button) findViewById(R.id.btn_start);

        btnStart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                MyAsyncTask task = new MyAsyncTask();
                task.execute();
            }
        });
    }


    class MyAsyncTask extends AsyncTask<Void,Void,Void>{


        @Override
        protected void onPreExecute() {
            super.onPreExecute();
            Log.d("myTag", "start");
            tvStatus.setText("Start");
        }

        @Override
        protected Void doInBackground(Void... params) {
            Log.d("myTag", "background");
            try{
                Thread.sleep(3000);
            }catch(InterruptedException e){
                e.printStackTrace();
            }
            Thread thread = new Thread(new Runnable() {
                @Override
                public void run() {
                    tvThread.setText("work");
                }
            });
            thread.start();

            runOnUiThread(new Runnable() {
                @Override
                public void run() {
                    tvThread.setText("work tut");
                }
            });
            return null;
        }


        @Override
        protected void onPostExecute(Void aVoid) {
            super.onPostExecute(aVoid);
            Log.d("myTag", "end");
            tvStatus.setText("End");
        }
    }
}
