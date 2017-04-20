package com.wenxin.dongyouji.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.squareup.okhttp.Request;
import com.wenxin.dongyouji.R;
import com.wenxin.dongyouji.Url;
import com.wenxin.dongyouji.adapter.RaidersAdapter;
import com.wenxin.dongyouji.model.RaidersModel;
import com.wenxin.dongyouji.model.TravelNotesModel;
import com.zhy.http.okhttp.OkHttpUtils;
import com.zhy.http.okhttp.callback.StringCallback;

import org.json.JSONArray;
import org.json.JSONException;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by linSir on 17/3/11.攻略
 */
public class RaidersFragment extends Fragment {

    private RecyclerView recyclerView;
    private RaidersAdapter adapter;
    private LinearLayoutManager linearLayoutManager;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_raider, container, false);
        recyclerView = (RecyclerView) view.findViewById(R.id.recyclerView);
        adapter = new RaidersAdapter();
        List<RaidersModel> lists = new ArrayList<RaidersModel>();


        String url = Url.url + "get_all_travel_notes";
        OkHttpUtils
                .get()
                .url(url)
                .addParams("null", "null")
                .build()
                .execute(new StringCallback() {
                    @Override
                    public void onError(Request request, Exception e) {
                        Toast.makeText(getActivity(), "获取游记失败", Toast.LENGTH_SHORT).show();
                    }

                    @Override
                    public void onResponse(String response) {

                        List<TravelNotesModel> list = new ArrayList<TravelNotesModel>();

                        try {
                            JSONArray jsonArray = new JSONArray(response);
                            for (int i = 0; i < jsonArray.length(); i++) {

                                TravelNotesModel travelNotesModel = new TravelNotesModel(
                                        jsonArray.getJSONObject(i).optString("title"),
                                        jsonArray.getJSONObject(i).optString("date"),
                                        jsonArray.getJSONObject(i).optString("background"),
                                        jsonArray.getJSONObject(i).optString("text1"),
                                        jsonArray.getJSONObject(i).optString("img1"),
                                        jsonArray.getJSONObject(i).optString("text2")
                                );

                                list.add(travelNotesModel);

                            }

                            adapter.refreshList(list);
                            mList = list;
                        } catch (JSONException e) {
                            e.printStackTrace();
                        }


                    }
                });


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

        linearLayoutManager = new LinearLayoutManager(getActivity());

        recyclerView.setLayoutManager(linearLayoutManager);
        recyclerView.setAdapter(adapter);
        adapter.refreshList(lists);

        return view;
    }


}
