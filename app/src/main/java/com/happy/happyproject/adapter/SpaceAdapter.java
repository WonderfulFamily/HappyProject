package com.happy.happyproject.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.happy.happyproject.R;
import com.happy.happyproject.model.Space;

import org.xutils.x;

import java.util.ArrayList;
import java.util.List;


/**
 * Created by Administrator on 2016/9/20.
 */
public class SpaceAdapter extends RecyclerView.Adapter<SpaceAdapter.ViewHolder> implements View.OnClickListener {
    private static final String TAG = SpaceAdapter.class.getSimpleName();
    private List<Space> data;
    private LayoutInflater inflater;
    private RecyclerView mRecyclerView;
    private OnItemClickListener listener;

    public void setListener(OnItemClickListener listener) {
        this.listener = listener;
    }

    public SpaceAdapter(Context context, List<Space> data) {
        inflater=LayoutInflater.from(context);
        if (data!=null) {
            this.data=data;
        }else {
            this.data=new ArrayList<>();
        }
    }
//刷新适配器
    public void updataRes(List<Space> data){
        if (data!=null) {
            this.data.clear();
            this.data.addAll(data);
            notifyDataSetChanged();
        }
    }
    // 上拉加载
    public void addRes(List<Space> data){
        if (data!=null) {
            this.data.addAll(data);
            notifyDataSetChanged();
        }
    }
    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = inflater.inflate(R.layout.space_item, parent, false);
        //为RecyclerView的每一个条目添加监听
        itemView.setOnClickListener(this);
        return new ViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        //加载数据
        holder.name.setText(data.get(position).getName());
        holder.num.setText(data.get(position).getFavs_count());
        x.image().bind(holder.image,data.get(position).getThumb());
    }

    @Override
    public int getItemCount() {
        return data!=null?data.size():0;
    }

    @Override
    public void onAttachedToRecyclerView(RecyclerView recyclerView) {
        super.onAttachedToRecyclerView(recyclerView);
        mRecyclerView=recyclerView;
    }


//点击事件的方法
    @Override
    public void onClick(View v) {
        int position = mRecyclerView.getChildAdapterPosition(v);
        if (listener != null) {
            listener.onItemClick(position, v.findViewById(R.id.space_recyclerview_image));
            Log.e(TAG, "onClick:---------------eererer------------------------------ "+position );
        }
    }
//定义接口
    public interface OnItemClickListener {
        //借口回调的时候想借口中的方法传递的是position 和view
        void onItemClick(int position, View v);

    }
    public static class ViewHolder extends RecyclerView.ViewHolder {


        //声明控件
        ImageView image;
        TextView name;
        //ImageView image1;
        TextView num;

        public ViewHolder(View itemView) {
            super(itemView);
            //控件的初始化
            image = ((ImageView) itemView.findViewById(R.id.space_recyclerview_image));
            name = ((TextView) itemView.findViewById(R.id.space_recyclerview_name));
           // image1 = ((ImageView) itemView.findViewById(R.id.space_recyclerview_heart));
            num = ((TextView) itemView.findViewById(R.id.space_recyclerview_heart_num));
        }


    }
}
