package com.happy.happyproject.adapters;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.happy.happyproject.R;
import com.happy.happyproject.model.Product;

import org.xutils.image.ImageOptions;
import org.xutils.view.annotation.ViewInject;
import org.xutils.x;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Administrator on 2016/9/23 0023.
 */
public class DesignAdapter extends RecyclerView.Adapter<DesignAdapter.ViewHolder> {

    private List<Product> data;
    private LayoutInflater inflater;
    private ImageOptions mOptions;
    public DesignAdapter(Context context,List<Product> data){
        inflater = ((LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE));
        mOptions = new ImageOptions.Builder()
                .setFadeIn(true)
                .setSquare(true)
                .setLoadingDrawableId(R.mipmap.bg_default_square)
                .setFailureDrawableId(R.mipmap.bg_default_square)
                .build();
        if (data!=null) {
            this.data = data;

        }else{
            this.data = new ArrayList<>();
        }
    }
    public Product getItem(int position){
        return data.get(position);
    }

    public void addRes(List<Product> data){
        if (data!=null) {
            this.data.addAll(data);
            notifyDataSetChanged();
        }
    }

    public void updateRes(List<Product> data){
        if (data!=null) {
            this.data.clear();
            this.data.addAll(data);
            notifyDataSetChanged();
        }
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = inflater.inflate(R.layout.smithy_recycler_item,parent,false);

        return new ViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        holder.title.setText(getItem(position).getTitle());
        holder.watchNum.setText(getItem(position).getView_count());
        holder.likeNum.setText(getItem(position).getFavs_count());
        x.image().bind(holder.img,getItem(position).getThumb(),mOptions);
        String display_tag = getItem(position).getDisplay_tag();
        if (display_tag.equals("new")) {
            holder.isNewImg.setVisibility(View.VISIBLE);
        }

    }

    @Override
    public int getItemCount() {
        return data!=null?data.size():0;
    }

    public static class ViewHolder extends RecyclerView.ViewHolder{
        @ViewInject(R.id.smithy_recycler_image)
        ImageView img;
        @ViewInject(R.id.smithy_recycler_text)
        TextView title;
        @ViewInject(R.id.smithy_watch_num)
        TextView watchNum;
        @ViewInject(R.id.smithy_like_num)
        TextView likeNum;
        @ViewInject(R.id.smithy_isnew)
        ImageView isNewImg;
        public ViewHolder(View itemView) {
            super(itemView);
            x.view().inject(this,itemView);
        }
    }
}
