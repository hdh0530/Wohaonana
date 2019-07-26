package com.example.day_02_lxc.presenter;

import com.example.day_02_lxc.ResultsBean;
import com.example.day_02_lxc.model.ICallback;
import com.example.day_02_lxc.model.Modelmpl;
import com.example.day_02_lxc.view.IView;

import org.greenrobot.greendao.annotation.Id;

import java.util.List;

/**
 * Created by DELL on 2019/7/25.
 */

public class Presnetermpl implements Presenter {
    private final Modelmpl mModelmpl;
    private IView ivew;

    public Presnetermpl(IView ivew) {
        this.ivew = ivew;
        mModelmpl = new Modelmpl();
    }

    @Override
    public void liu() {
        if (mModelmpl!=null){
            mModelmpl.chun(new ICallback() {
                @Override
                public void chunok(List<ResultsBean> result) {
                    ivew.chunok(result);
                }

                @Override
                public void chunno(String error) {
                    ivew.chunno(error);
                }
            });
        }
    }
}
