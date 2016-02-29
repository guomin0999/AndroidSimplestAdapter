package com.guomin.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;

import java.util.ArrayList;
import java.util.List;

/**
 * 适配器模板,支持多类型
 *
 * @author 郭敏
 */
public abstract class BeanAdapter<E> extends BaseAdapter {

    protected Context context;
    public List<E> list;
    private int[] layout;

    public BeanAdapter(Context context, int... layout) {
        this(context, new ArrayList<E>(), layout);
    }

    public BeanAdapter(Context context, List<E> list, int... layout) {
        this.context = context;
        this.layout = layout;
        this.list = list;
    }

    public int getCount() {
        return list.size();
    }

    public Object getItem(int position) {
        return list.get(position);
    }

    public long getItemId(int position) {
        return position;
    }

    public View getView(final int position, View convertView, final ViewGroup parent) {
        if (convertView == null) {
            convertView = LayoutInflater.from(context).inflate(layout[getItemViewType(position)], null);
        }
        getView(position, ViewHolder.getViewHolder(convertView), list.get(position));
        return convertView;
    }

    public int getViewTypeCount() {
        return layout.length;
    }

    public abstract void getView(int position, ViewHolder holder, E bean);

}
