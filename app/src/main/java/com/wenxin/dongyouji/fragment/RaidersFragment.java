package com.wenxin.dongyouji.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.wenxin.dongyouji.R;
import com.wenxin.dongyouji.adapter.RaidersAdapter;
import com.wenxin.dongyouji.model.RaidersModel;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by linSir on 17/3/11.攻略
 */
public class RaidersFragment extends Fragment {

    private RecyclerView recyclerView;
    private RaidersAdapter adapter;
    private GridLayoutManager gridLayoutManager;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_raider, container, false);
        recyclerView = (RecyclerView) view.findViewById(R.id.recyclerView);
        adapter = new RaidersAdapter();
        List<RaidersModel> lists = new ArrayList<RaidersModel>();
        RaidersModel a1 = new RaidersModel();
        a1.setTitle("日本\nJAPAN");
        a1.setCount("1010旅行地");

        RaidersModel a2 = new RaidersModel();
        a2.setTitle("日本\nJAPAN");
        a2.setCount("1010旅行地");

        RaidersModel a3 = new RaidersModel();
        a3.setTitle("日本\nJAPAN");
        a3.setCount("1010旅行地");

        lists.add(a1);
        lists.add(a2);
        lists.add(a3);
        lists.add(a1);
        lists.add(a2);
        lists.add(a3);

        gridLayoutManager = new GridLayoutManager(getActivity(), 2);
//        linearLayoutManager.setOrientation(OrientationHelper.VERTICAL);
        recyclerView.setLayoutManager(gridLayoutManager);
        recyclerView.setAdapter(adapter);
        adapter.refreshList(lists);

        return view;
    }


}
