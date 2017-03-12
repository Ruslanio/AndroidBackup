package com.example.ruslan.patterns;

/**
 * Created by Ruslan on 14.02.2017.
 */

public class CountPresenter {
    private int count = 0;
    private CountViewPresenter viewPresenter;

    public CountPresenter(CountViewPresenter viewPresenter) {
        this.viewPresenter = viewPresenter;
    }

    void add(){
        count = count + 1;
    }

    void showCount(){
        viewPresenter.showCount(count);
    }
}
