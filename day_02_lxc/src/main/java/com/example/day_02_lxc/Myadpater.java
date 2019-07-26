package com.example.day_02_lxc;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by DELL on 2019/7/25.
 */

public class Myadpater extends RecyclerView.Adapter<Myadpater.ViewHolder> {
    private Context mContext;

    public Myadpater(Context context) {
        mContext = context;
    }

    private ArrayList<ResultsBean> shuju = new ArrayList<>();
    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View inflate = LayoutInflater.from(mContext).inflate(R.layout.item, null);
        return new ViewHolder(inflate);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder viewHolder, final int i) {
        final ResultsBean bean = shuju.get(i);
        viewHolder.tv.setText(bean.getType());
        Glide.with(mContext).load(bean.getUrl()).into(viewHolder.iv);
        viewHolder.itemView.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View v) {
                if (mOnlongClion!=null){
                    mOnlongClion.onClionclik(i,bean);
                }
                return false;
            }
        });
    }

    @Override
    public int getItemCount() {
        return shuju.size();
    }

    public void addData(List<ResultsBean> result) {
        shuju.addAll(result);
        notifyDataSetChanged();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        private final ImageView iv;
        private final TextView tv;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            iv = itemView.findViewById(R.id.iv);
            tv = itemView.findViewById(R.id.tv);
        }
    }

    public interface onlongClion{
        void onClionclik(int i,ResultsBean resultsBean);
    }
    private onlongClion mOnlongClion;

    public void setOnlongClion(onlongClion onlongClion) {
        this.mOnlongClion = onlongClion;
    }
}
