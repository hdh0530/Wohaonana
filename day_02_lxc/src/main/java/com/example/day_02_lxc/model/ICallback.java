package com.example.day_02_lxc.model;

import com.example.day_02_lxc.ResultsBean;

import java.util.List;

/**
 * Created by DELL on 2019/7/25.
 */

public interface ICallback {
    void chunok(List<ResultsBean> result);
    void chunno(String error);
}
