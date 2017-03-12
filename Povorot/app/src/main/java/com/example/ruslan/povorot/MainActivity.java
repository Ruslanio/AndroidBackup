package com.example.ruslan.povorot;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    TextView tv1;
    TextView tv2;
    TextView tv3;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        tv1 = (TextView) findViewById(R.id.tv_number_1);
        tv2 = (TextView) findViewById(R.id.tv_number_2);
        tv3 = (TextView) findViewById(R.id.tv_number_3);

        tv1.setText("example1");
        tv1.setText("example2");
        tv1.setText("example3");

    }
}
