package com.example.day_02_lxc;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.day_02_lxc.sql.Dbutil;

import java.util.List;


/**
 * A simple {@link Fragment} subclass.
 */
public class BlankFragmentB extends Fragment {


    private View view;
    private Myadpater mMyadpater;
    /**
     * Hello blank fragment
     */
    private RecyclerView xr;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View inflate = inflater.inflate(R.layout.fragment_blank_fragment_b, container, false);
        initView(inflate);
        initData();
        return inflate;
    }

    @Override
    public void setUserVisibleHint(boolean isVisibleToUser) {
        if (isVisibleToUser){
            initData();
        }
    }

    private void initData() {
        List<ResultsBean> resultsBeans = Dbutil.getDb_util().select();
        mMyadpater.addData(resultsBeans);
    }

    private void initView(View inflate) {
        xr = (RecyclerView) inflate.findViewById(R.id.xr);
        xr.setLayoutManager(new LinearLayoutManager(getContext()));
        mMyadpater = new Myadpater(getContext());
        xr.setAdapter(mMyadpater);
    }
}
