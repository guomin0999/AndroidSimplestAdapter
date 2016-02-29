package com.guomin.adapter;

import android.util.SparseArray;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

/**
 * Created by Administrator on 2015/8/5.
 */
public class ViewHolder {
    private SparseArray<View> viewHolder;
    private View view;

    public static ViewHolder getViewHolder(View view) {
        ViewHolder viewHolder = (ViewHolder) view.getTag();
        if (viewHolder == null) {
            viewHolder = new ViewHolder(view);
            view.setTag(viewHolder);
        }
        return viewHolder;
    }

    private ViewHolder(View view) {
        this.view = view;
        viewHolder = new SparseArray();
        view.setTag(viewHolder);
    }

    public <T extends View> T get(int id) {
        View childView = viewHolder.get(id);
        if (childView == null) {
            childView = view.findViewById(id);
            viewHolder.put(id, childView);
        }
        return (T) childView;
    }

    public View itemView() {
        return view;
    }

    public TextView text(int id) {
        return get(id);
    }

    public TextView text(int id, CharSequence charSequence) {
        TextView text = text(id);
        text(id).setText(charSequence);
        return text;
    }

    public Button button(int id) {
        return get(id);
    }

    public ImageView image(int id) {
        return get(id);
    }


}
