package com.happy.happyproject.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.happy.happyproject.R;
import com.happy.happyproject.model.SpaceJump;

import org.xutils.image.ImageOptions;
import org.xutils.view.annotation.ViewInject;
import org.xutils.x;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Administrator on 2016/9/20.
 */
public class SpaceListViewAdapter extends BaseAdapter {
    private List<SpaceJump> data;
    private LayoutInflater inflater;
    private ImageOptions options = new ImageOptions.Builder()
            .setLoadingDrawableId(R.mipmap.ic_launcher)
            .setFailureDrawableId(R.mipmap.ic_launcher)
            .setSquare(true)
            .setFadeIn(true)
            .build();

    private ImageOptions headImgOptions = new ImageOptions.Builder()
            .setLoadingDrawableId(R.mipmap.ic_launcher)
            .setFailureDrawableId(R.mipmap.ic_launcher)
            .setCircular(true)
            .setFadeIn(true)
            .build();

    public SpaceListViewAdapter(Context context,List<SpaceJump> data) {
        if (data!=null) {
            this.data=data;

        }else {
            this.data=new ArrayList<>();
        }
        inflater=LayoutInflater.from(context);
    }
public void addRes(List<SpaceJump> data){
    if (data!=null) {
        this.data.addAll(data);
        notifyDataSetChanged();
    }
}
    public void updataRes(List<SpaceJump> data){
        if (data!=null) {
            this.data.clear();
            this.data.addAll(data);
            notifyDataSetChanged();
        }
    }
    @Override
    public int getCount() {
        return data!=null?data.size():0;
    }

    @Override
    public SpaceJump getItem(int position) {
        return data.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder holder=null;
        if (convertView==null){
            convertView=inflater.inflate(R.layout.spacejump_listview,parent,false);
            holder=new ViewHolder(convertView);
            convertView.setTag(holder);
        }else {
            holder= (ViewHolder) convertView.getTag();
        }
        //加载数据
        holder.name.setText(data.get(position).getText());
        x.image().bind(holder.imageView,"http://" + data.get(position).getImage());
        return convertView;
    }
    public class ViewHolder{
        @ViewInject(R.id.spacejump_listview_image)
        ImageView imageView;
        @ViewInject(R.id.spacejump_listview_text)
        TextView name;


        public ViewHolder(View itemView){
            x.view().inject(this,itemView);
        }
    }
}
