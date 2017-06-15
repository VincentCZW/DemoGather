package com.example.annotation_tool.demogather.butter_knife;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

import com.example.annotation_tool.demogather.R;
import com.example.annotation_tool.demogather.butter_knife.adapter.ButterKnifeAdapter;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;

/**
 * Created by VincentChen on 2017/6/12.
 */
public class ButterKnifeFragment extends Fragment {

    Unbinder unbinder;
    @BindView(R.id.list_view)
    ListView listView;
    private View mContentView;

    public ButterKnifeFragment() {

    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        mContentView = View.inflate(getActivity(), R.layout.fragment_butter_knife_main_layout, null);
        unbinder = ButterKnife.bind(this, mContentView);
        ButterKnifeAdapter adapter = new ButterKnifeAdapter(getActivity());
        listView.setAdapter(adapter);
        return mContentView;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        unbinder.unbind();
    }
}
