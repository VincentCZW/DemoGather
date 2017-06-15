package com.example.annotation_tool.demogather.butter_knife.adapter;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.example.annotation_tool.demogather.R;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by VincentChen on 2017/6/12.
 */
public class ButterKnifeAdapter extends BaseAdapter {

    private Context context;

    public ButterKnifeAdapter(Context context) {
        this.context = context;
    }

    @Override
    public int getCount() {
        return 18;
    }

    @Override
    public Object getItem(int position) {
        return null;
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder viewHolder = null;
        if (convertView == null) {
            convertView = View.inflate(context, R.layout.adapter_butter_knife_item_layout, null);
            viewHolder = new ViewHolder(convertView);
            convertView.setTag(viewHolder);
        } else {
            viewHolder = (ViewHolder) convertView.getTag();
        }
        viewHolder.text.setText("text : " + position);
        return convertView;
    }

    static class ViewHolder {
        @BindView(R.id.text)
        TextView text;

        ViewHolder(View view) {
            ButterKnife.bind(this, view);
        }
    }
}
