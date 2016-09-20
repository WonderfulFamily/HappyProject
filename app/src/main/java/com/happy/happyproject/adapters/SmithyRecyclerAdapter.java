package com.happy.happyproject.adapters;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.happy.happyproject.R;
import com.happy.happyproject.model.SmithyNavigation;

import org.xutils.image.ImageOptions;
import org.xutils.view.annotation.ViewInject;
import org.xutils.x;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Administrator on 2016/9/20 0020.
 */
public class SmithyRecyclerAdapter extends RecyclerView.Adapter<SmithyRecyclerAdapter.ViewHolder> {

    private List<SmithyNavigation> data;
    private LayoutInflater inflater;
    private ImageOptions mOptions;
    public SmithyRecyclerAdapter(Context context,List<SmithyNavigation> data){
        inflater = LayoutInflater.from(context);
        if (data!=null) {
            this.data = data;
        }else{
            this.data = new ArrayList<>();
        }
        mOptions = new ImageOptions.Builder()
                .setFadeIn(true)
                .setSquare(true)
                .setLoadingDrawableId(R.mipmap.loading)
                .setFailureDrawableId(R.mipmap.mine_launcher)
                .build();
    }

    public SmithyNavigation getItem(int position){
        return data.get(position);
    }
    public void addRes(List<SmithyNavigation> data){
        if (data!=null) {
            this.data.addAll(data);
            notifyDataSetChanged();
        }
    }
    public void updateRes(List<SmithyNavigation> data){
        if (data!=null) {
            this.data.clear();
            this.data.addAll(data);
            notifyDataSetChanged();
        }
    }


    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = inflater.inflate(R.layout.smithy_item, parent, false);

        return new ViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        holder.title.setText(getItem(position).getTitle());
        x.image().bind(holder.img,getItem(position).getImage_black(),mOptions);
    }

    @Override
    public int getItemCount() {
        return data!=null?data.size():0;
    }



    public static class ViewHolder extends RecyclerView.ViewHolder{
        @ViewInject(R.id.smithy_item_image)
        ImageView img;
        @ViewInject(R.id.smithy_item_title)
        TextView title;
        public ViewHolder(View itemView) {
            super(itemView);
            x.view().inject(this,itemView);
        }
    }
}
