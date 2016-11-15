package com.example.vincent.demogather.adapter;

import android.content.Context;
import android.net.Uri;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;

import com.example.vincent.demogather.R;
import com.facebook.drawee.view.SimpleDraweeView;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by VincentChen on 2016/10/31.
 */
public class FrescoImageLoadAdapter extends BaseAdapter {

    private List<String> dataList;

    private Context mContext;

    public FrescoImageLoadAdapter(Context context) {
        mContext = context;
        dataList = new ArrayList<>();
        dataList.add("http://fmn.rrfmn.com//fmn079//20161031//1650//main_GCTV_91e1000084151e83.jpg");
        dataList.add("http://fmn.xnpic.com//fmn071//20161031//1700//main_QM5Q_dce0000099711e7f.jpg");
        dataList.add("http://fmn.rrfmn.com//fmn078//20161031//1700//main_3hHm_1b0c000084321e84.jpg");
        dataList.add("http://fmn.xnpic.com//fmn072//20161031//1700//main_ARGm_91e10000843e1e83.jpg");
        dataList.add("http://fmn.rrfmn.com//fmn070//20161031//1700//main_HhEj_1b22000084651e84.jpg");
        dataList.add("http://fmn.rrimg.com//fmn075//20161031//1705//main_7R5Q_31f9000098b01e80.jpg");
        dataList.add("http://fmn.xnpic.com//fmn071//20161031//1705//main_5Hk8_dc9e000099a31e7f.jpg");
        dataList.add("http:\\/\\/fmn.rrimg.com\\/fmn074\\/20161031\\/1615\\/main_CsrY_dd220000986a1e7f.jpg");
        dataList.add("http:\\/\\/fmn.rrfmn.com\\/fmn070\\/20161031\\/1615\\/main_4doM_321a000097911e80.jpg");
        dataList.add("http:\\/\\/fmn.xnpic.com\\/fmn071\\/20161031\\/1635\\/main_VhCn_1b4e000083e61e84.jpg");
        dataList.add("http://fmn.rrfmn.com//fmn079//20161031//1815//main_DOIv_dc7700009b391e7f.jpg");
        dataList.add("http://fmn.rrimg.com//fmn079//20161031//1820//original_efzU_dc9300009b401e7f.jpg");
    }

    @Override
    public int getCount() {
        return dataList.size();
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
        ViewHolder viewHolder;
        if (convertView == null) {
            convertView = View.inflate(mContext, R.layout.fresco_image_item_layout, null);
            viewHolder = new ViewHolder();
            viewHolder.view = (SimpleDraweeView) convertView.findViewById(R.id.simple_drawee_view);
            convertView.setTag(viewHolder);
        }
        viewHolder = (ViewHolder) convertView.getTag();
        viewHolder.view.setImageURI(Uri.parse(dataList.get(position)));
        return convertView;
    }

    private class ViewHolder {
        public SimpleDraweeView view;
    }
}
