package com.example.fushuang.kt;

import java.util.ArrayList;

import javax.crypto.spec.IvParameterSpec;

/**
 * Created by fushuang on 2018/3/21.
 */

public class MyPresenter {
    IView view;
    public void attachView(IView iView){
        view=iView;
    }
    public void getData(){


        ArrayList<Cat> cats = new ArrayList<>();
        cats.add(new Cat(1,12));
        cats.add(new Cat(2,13));


        view.showData(cats);
    }
}
