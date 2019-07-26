package com.example.day_02_lxc;

import io.reactivex.Observable;
import retrofit2.http.GET;

/**
 * Created by DELL on 2019/7/25.
 */

public interface Apiservice {
    String url = "http://gank.io/api/";

    @GET("data/%E7%A6%8F%E5%88%A9/20/4")
    Observable<FuliBean> fuli ();
}
