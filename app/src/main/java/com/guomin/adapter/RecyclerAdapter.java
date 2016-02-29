package com.guomin.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Administrator on 2015/8/5.
 */
public abstract class RecyclerAdapter<E> extends RecyclerView.Adapter<RecyclerHolder> {

    protected Context context;
    public List<E> list;
    private int[] layout;

    public RecyclerAdapter(Context context, int... layout) {
        this(context, new ArrayList<E>(), layout);
    }

    public RecyclerAdapter(Context context, List<E> list, int... layout) {
        this.list = list;
        this.context = context;
        this.layout = layout;
    }

    public RecyclerHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        //根据getItemViewType 来确定layout
        View view = LayoutInflater.from(context).inflate(layout[viewType], null);
        return new RecyclerHolder(view);
    }

    public void onBindViewHolder(final RecyclerHolder holder, final int position) {
        try {
            onBindViewHolder(holder.getViewHolder(), position, list.get(position));
        } catch (Exception e) {
            Log.v("view", "onBind:" + e.getMessage());
        }
        if (listener != null) {
            holder.itemView.setOnClickListener(new View.OnClickListener() {
                public void onClick(View v) {
                    listener.onItemClick(null, v, position, holder.getItemId());
                }
            });
        }
    }

    public abstract void onBindViewHolder(ViewHolder holder, int position, E bean);

    public int getItemCount() {
        return list.size();
    }

    private AdapterView.OnItemClickListener listener;

    public void setOnItemClickListener(AdapterView.OnItemClickListener listener) {
        this.listener = listener;
    }

}
