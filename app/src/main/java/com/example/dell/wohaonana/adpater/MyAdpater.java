package com.example.dell.wohaonana.adpater;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.example.dell.wohaonana.R;
import com.example.dell.wohaonana.bean.ResultsBean;
import com.youth.banner.Banner;
import com.youth.banner.loader.ImageLoader;

import java.util.ArrayList;
import java.util.List;

import javax.xml.transform.Result;

import retrofit2.http.POST;

/**
 * Created by DELL on 2019/7/23.
 */

public class MyAdpater extends RecyclerView.Adapter<RecyclerView.ViewHolder> {
    private Context mContext;

    public MyAdpater(Context context) {
        mContext = context;
    }

    private ArrayList<ResultsBean> shuju = new ArrayList<>();

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        if (i==0){
            View inflate = LayoutInflater.from(mContext).inflate(R.layout.itembanner, null);
            return new ViewHolderA(inflate);
        } else {
            View inflate = LayoutInflater.from(mContext).inflate(R.layout.itemgan, null);
            return new ViewHolderB(inflate);
        }
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder viewHolder, final int i) {
        ResultsBean resultsBean = shuju.get(i);
        int type = getItemViewType(i);
        switch (type){
            case 0:
                ViewHolderA holderA = (ViewHolderA) viewHolder;
                holderA.bar.setImages(shuju).setImageLoader(new ImageLoader() {
                    @Override
                    public void displayImage(Context context, Object path, ImageView imageView) {
                            ResultsBean a = (ResultsBean) path;
                        Glide.with(mContext).load(a.getUrl()).into(imageView);
                    }
                }).start();
                break;
            case 1:
                ViewHolderB holderB = (ViewHolderB) viewHolder;
                holderB.tv.setText(resultsBean.getType());
                Glide.with(mContext).load(resultsBean.getUrl()).into(holderB.iv);
                break;
        }
    }

    @Override
    public int getItemCount() {
        return shuju.size();
    }

    @Override
    public int getItemViewType(int position) {
        if (position==0){
            return 0;
        }
        else {
            return 1;
        }
    }

    public void addData(List<ResultsBean> mei) {
        shuju.addAll(mei);
        notifyDataSetChanged();
    }

    private class ViewHolderA extends RecyclerView.ViewHolder {

        private final Banner bar;

        public ViewHolderA(View inflate) {
            super(inflate);
            bar = inflate.findViewById(R.id.bar);
        }
    }

    private class ViewHolderB extends RecyclerView.ViewHolder {

        private final ImageView iv;
        private final TextView tv;

        public ViewHolderB(View inflate) {
            super(inflate);
            iv = inflate.findViewById(R.id.iv);
            tv = inflate.findViewById(R.id.tv);
        }
    }
}
