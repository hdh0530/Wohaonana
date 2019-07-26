package com.example.day_02_lxc.model;

import android.util.Log;

import com.example.day_02_lxc.Apiservice;
import com.example.day_02_lxc.FuliBean;
import com.example.day_02_lxc.ResultsBean;

import java.util.List;

import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by DELL on 2019/7/25.
 */

public class Modelmpl implements Model {
    private static final String TAG = "Modelmpl";
    @Override
    public void chun(final ICallback iCallback) {
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(Apiservice.url)
                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .build();
        retrofit.create(Apiservice.class).fuli().subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<FuliBean>() {
                    @Override
                    public void onSubscribe(Disposable d) {

                    }

                    @Override
                    public void onNext(FuliBean fuliBean) {
                        List<ResultsBean> results = fuliBean.getResults();
                        iCallback.chunok(results);
                        Log.d(TAG, "onNext: "+results.toString());
                    }

                    @Override
                    public void onError(Throwable e) {
                        iCallback.chunno(e.getMessage());
                    }

                    @Override
                    public void onComplete() {

                    }
                });
    }
}
