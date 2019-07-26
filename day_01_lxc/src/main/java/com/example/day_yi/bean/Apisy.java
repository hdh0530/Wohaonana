package com.example.day_yi.bean;

import io.reactivex.Observable;
import retrofit2.http.GET;


public interface Apisy {
    String url = "http://news-at.zhihu.com/";

    @GET("api/4/news/hot")
    Observable<Home_bean> getData();

}
