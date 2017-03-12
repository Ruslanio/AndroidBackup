package com.example.ruslan.test.activities;

import android.app.FragmentManager;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.example.ruslan.test.interfaces.AsyncCallback;
import com.example.ruslan.test.R;
import com.example.ruslan.test.fragments.AsyncHolderFragment;

public class SplashActivity extends AppCompatActivity implements AsyncCallback{

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);

        FragmentManager manager = getFragmentManager();
        AsyncHolderFragment fragment = (AsyncHolderFragment) manager.findFragmentByTag(AsyncHolderFragment.class.getName());


        if(fragment == null) {
            fragment = new AsyncHolderFragment();
            manager
                    .beginTransaction()
                    .add(fragment, AsyncHolderFragment.class.getName())
                    .commit();
        }
    }

    @Override
    public void onResult() {
        Intent intent = new Intent(SplashActivity.this,NoteListActivity.class);
        startActivity(intent);
        finish();
    }

}
