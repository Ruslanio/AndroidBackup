package com.example.ruslan.thegame.activitys;

/**
 * Created by Ruslan on 10.12.2016.
 */

public interface TaskListener {

    public void onTaskStart();
    public void onTaskFinish(boolean success);
    public void onTaskProgress();
}
