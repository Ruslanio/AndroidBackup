package com.example.ruslan.thegame.activitys;

import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.view.animation.LinearInterpolator;
import android.widget.Button;
import android.widget.Toast;

import com.example.ruslan.thegame.R;

public class MenuActivity extends AppCompatActivity implements TaskListener {

    private Button mStart;
    private View mSquare1;
    private View mSquare2;
    private View mSquare3;
    MyFragment fragment;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu);

        setUpTheElements();
        if (savedInstanceState != null) {
            fragment = getFragment();
        }
        mStart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                fragment.startAsync();
            }
        });


    }

    private MyFragment getFragment() {
        if (getFragmentManager().findFragmentByTag(MyFragment.class.getName()) == null) {
                getFragmentManager().
                        beginTransaction().
                        add(new MyFragment(), MyFragment.class.getName()).
                        commit();
        }
        return (MyFragment) getFragmentManager().findFragmentByTag(MyFragment.class.getName());
    }

    private void setUpTheElements() {
        mStart = (Button) findViewById(R.id.btn_start);
        mSquare1 = findViewById(R.id.v_square1);
        mSquare2 = findViewById(R.id.v_square2);
        mSquare3 = findViewById(R.id.v_square3);

        mSquare1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startAnimationXML();
            }
        });
    }

    private void startAnim() {
        mSquare1.animate().
                translationX(120).
                translationY(120).
                scaleXBy(2).
                scaleYBy(2).
                start();
    }

    private void startAnimationXML() {
        Animation anim = AnimationUtils.loadAnimation(this, R.anim.animation);
        mSquare1.startAnimation(anim);
    }

    private void objectAnimator() {
        ObjectAnimator animTarget1 = ObjectAnimator.
                ofFloat(mSquare1, "translationY", 50).
                setDuration(1000);
        ObjectAnimator animTarget2 = ObjectAnimator.
                ofFloat(mSquare2, "translationY", 300).
                setDuration(1000);
        ObjectAnimator animTarget3 = ObjectAnimator.
                ofFloat(mSquare3, "translationY", 300).
                setDuration(1000);
        ObjectAnimator animTarget4 = ObjectAnimator.
                ofFloat(mSquare3, "scaleX", 0.2f).
                setDuration(1000);

        AnimatorSet set = new AnimatorSet();

        set.play(animTarget1).with(animTarget2).with(animTarget3).with(animTarget4);
        set.setInterpolator(new LinearInterpolator());
        set.start();
    }


    @Override
    public void onTaskStart() {
        //someShit
    }

    @Override
    public void onTaskFinish(boolean success) {
        Toast.makeText(this, success ? "YES" : "(((", Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onTaskProgress() {
        //someOtherShit
    }
}
