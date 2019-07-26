package com.example.view;



import com.example.day_yi.bean.Home_bean;

import java.util.List;



public interface Iview {

    void getOk(List<Home_bean.RecentBean> list);

    void getNo(String result);


}
