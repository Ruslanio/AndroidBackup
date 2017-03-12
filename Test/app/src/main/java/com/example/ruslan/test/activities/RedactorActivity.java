package com.example.ruslan.test.activities;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;

import com.example.ruslan.test.R;

public class RedactorActivity extends AppCompatActivity {
    private EditText edName;
    private EditText edText;
    private Button btnSave;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_redactor);

        edName = (EditText) findViewById(R.id.ed_name);
        edText = (EditText) findViewById(R.id.ed_text);
        btnSave = (Button) findViewById(R.id.btn_save);
    }
}
