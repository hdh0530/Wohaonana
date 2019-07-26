package com.example.day_02_lxc;


import android.content.DialogInterface;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.app.AlertDialog;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.Gravity;
import android.view.LayoutInflater;


import android.view.View;
import android.view.ViewGroup;
import android.widget.PopupWindow;
import android.widget.Toast;

import com.example.day_02_lxc.presenter.Presnetermpl;
import com.example.day_02_lxc.sql.Dbutil;
import com.example.day_02_lxc.view.IView;

import java.util.List;


/**
 * A simple {@link Fragment} subclass.
 */
public class BlankFragmentA extends Fragment implements IView{

    private View view;
    /**
     * Hello blank fragment
     */
    private RecyclerView xr;
    private Myadpater mMyadpater;
    private Presnetermpl mPresnetermpl;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View inflate = inflater.inflate(R.layout.fragment_blank, container, false);
        initView(inflate);
        initData();
        return inflate;
    }

    private void initData() {
        mPresnetermpl = new Presnetermpl(this);
        mPresnetermpl.liu();
    }

    private void initView(View inflate) {
        xr = (RecyclerView) inflate.findViewById(R.id.xr);
        xr.setLayoutManager(new LinearLayoutManager(getContext()));
        mMyadpater = new Myadpater(getContext());
        xr.setAdapter(mMyadpater);

        mMyadpater.setOnlongClion(new Myadpater.onlongClion() {
            @Override
            public void onClionclik(int i, final ResultsBean resultsBean) {
                AlertDialog dialog=null;

                dialog=new AlertDialog.Builder(getActivity()).create();
                dialog.setIcon(R.mipmap.ic_launcher);
                dialog.setTitle("是否插入");
                dialog.setMessage("是否插入");
                dialog.setButton(DialogInterface.BUTTON_POSITIVE, "确定", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        Dbutil.getDb_util().insert(resultsBean);
                        Toast.makeText(getActivity(), "插入成功", Toast.LENGTH_SHORT).show();

                    }
                });
                dialog.setButton(DialogInterface.BUTTON_NEGATIVE,"取消", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {

                    }
                });
                dialog.show();
            }
        });
    }

    @Override
    public void chunok(List<ResultsBean> result) {
            mMyadpater.addData(result);
    }

    @Override
    public void chunno(String error) {
    }
}
