package com.qh.xuezhimin.recyclerviewmore.adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.jcodecraeer.xrecyclerview.XRecyclerView;
import com.qh.xuezhimin.recyclerviewmore.R;
import com.qh.xuezhimin.recyclerviewmore.bean.Data;
import com.qh.xuezhimin.recyclerviewmore.http.Constants;

import java.util.List;

public class DataAdapter extends XRecyclerView.Adapter<XRecyclerView.ViewHolder> {


    //设置二种类型,对应我二种不同类型的Item,数字随意生成,主要是为了区分
    private static final int FristType = 0;
    private static final int TwoType = 1;

    private Context context;
    private List<Data> list;

    public DataAdapter(Context context, List<Data> list) {
        this.context = context;
        this.list = list;
    }

    @NonNull
    @Override
    public com.jcodecraeer.xrecyclerview.XRecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        if (viewType == FristType) {
            View view = LayoutInflater.from(context).inflate(R.layout.news_item2_layout, parent, false);
            return new Type1ViewHolder(view);
        } else {
            View view2 = LayoutInflater.from(context).inflate(R.layout.news_item_layout, parent, false);
            return new Type2ViewHolder(view2);
        }
    }

    @Override
    public void onBindViewHolder(@NonNull final com.jcodecraeer.xrecyclerview.XRecyclerView.ViewHolder holder, final int position) {

        if (list.get(position).getThumbnail_pic_s02() != null && list.get(position).getThumbnail_pic_s03() != null) {
            Glide.with(context).load(list.get(position).getThumbnail_pic_s()).into(((Type2ViewHolder) holder).iv1);
            Glide.with(context).load(list.get(position).getThumbnail_pic_s02()).into(((Type2ViewHolder) holder).iv2);
            Glide.with(context).load(list.get(position).getThumbnail_pic_s03()).into(((Type2ViewHolder) holder).iv3);
            ((Type2ViewHolder) holder).title.setText(list.get(position).getTitle());
        } else {
            Glide.with(context).load(list.get(position).getThumbnail_pic_s()).into(((Type1ViewHolder) holder).image);
            ((Type1ViewHolder) holder).title.setText(list.get(position).getTitle());
        }


    }

    @Override
    public int getItemViewType(int position) {
        if (list.get(position).getThumbnail_pic_s02() != null && list.get(position).getThumbnail_pic_s03() != null) {
            return 1;
        }
        return 0;
    }


    @Override
    public int getItemCount() {
        return list.size();
    }


    //俩个内部类
    class Type1ViewHolder extends com.jcodecraeer.xrecyclerview.XRecyclerView.ViewHolder {
        private TextView title;
        private ImageView image;

        public Type1ViewHolder(View itemView) {
            super(itemView);
            title = itemView.findViewById(R.id.title1);
            image = itemView.findViewById(R.id.image1);
        }
    }

    class Type2ViewHolder extends com.jcodecraeer.xrecyclerview.XRecyclerView.ViewHolder {
        private TextView title;
        private ImageView iv1, iv2, iv3;

        public Type2ViewHolder(View itemView) {
            super(itemView);
            iv1 = itemView.findViewById(R.id.img1);
            iv2 = itemView.findViewById(R.id.img2);
            iv3 = itemView.findViewById(R.id.img3);
            title = itemView.findViewById(R.id.title3);
        }
    }


}
