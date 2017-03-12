package com.example.ruslan.patterns;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import org.w3c.dom.Text;

public class MainActivity extends AppCompatActivity implements CountViewPresenter,View.OnClickListener{
    private Button btnShow;
    private Button btnCount;
    private TextView tvCount;
    private  CountPresenter presenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnCount = (Button) findViewById(R.id.btn_count);
        btnShow = (Button) findViewById(R.id.btn_show);

        btnShow.setOnClickListener(this);
        btnCount.setOnClickListener(this);

        tvCount = (TextView) findViewById(R.id.tv_count);

        presenter = new CountPresenter(this);
    }

    @Override
    public void showCount(int count) {
        tvCount.setText("count: " + count);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.btn_count:
                presenter.add();
                break;
            case R.id.btn_show:
                presenter.showCount();
                break;
        }
    }
}
