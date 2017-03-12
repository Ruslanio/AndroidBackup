package com.example.ruslan.povorotsassyntaskom;

import android.content.DialogInterface;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity implements AsyncCallback,View.OnClickListener {

    Button btnPress;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnPress = (Button) findViewById(R.id.btn_press);
        btnPress.setOnClickListener(this);

    }

    @Override
    public void showYourSelf() {

    }

    @Override
    public void onClick(View v) {
        showYourSelf();
    }
}
