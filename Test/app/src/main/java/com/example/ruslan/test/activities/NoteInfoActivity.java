package com.example.ruslan.test.activities;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.example.ruslan.test.R;

public class NoteInfoActivity extends AppCompatActivity{
    private TextView tvName;
    private TextView tvText;
    private Button btnRedactor;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_note_info);

        tvName = (TextView) findViewById(R.id.tv_name);
        tvText = (TextView) findViewById(R.id.tv_text);
        btnRedactor = (Button) findViewById(R.id.btn_redactor);
        btnRedactor.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(NoteInfoActivity.this,RedactorActivity.class);
                startActivity(intent);
            }
        });

        tvName.setText(getIntent().getStringExtra("name"));
        tvText.setText(getIntent().getStringExtra("text"));

    }

}
