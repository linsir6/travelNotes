package com.wenxin.dongyouji.fragment;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.OrientationHelper;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.squareup.okhttp.Request;
import com.wenxin.dongyouji.R;
import com.wenxin.dongyouji.Url;
import com.wenxin.dongyouji.activity.TravelNotesActivity;
import com.wenxin.dongyouji.adapter.TravelNotesAdapter;
import com.wenxin.dongyouji.listener.RecyclerItemClickListener;
import com.wenxin.dongyouji.model.TravelNotesModel;
import com.zhy.http.okhttp.OkHttpUtils;
import com.zhy.http.okhttp.callback.StringCallback;

import org.json.JSONArray;
import org.json.JSONException;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by linSir on 17/3/11.游记
 */
public class TravelNotesFragment extends Fragment {

    private RecyclerView recyclerView;
    private TravelNotesAdapter adapter;
    private LinearLayoutManager linearLayoutManager;
    private List<TravelNotesModel> mList;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_travel_notes, container, false);
        recyclerView = (RecyclerView) view.findViewById(R.id.recyclerView);
        adapter = new TravelNotesAdapter(getActivity());
        List<TravelNotesModel> lists = new ArrayList<TravelNotesModel>();

        linearLayoutManager = new LinearLayoutManager(getActivity());
        linearLayoutManager.setOrientation(OrientationHelper.VERTICAL);
        recyclerView.setLayoutManager(linearLayoutManager);
        recyclerView.setAdapter(adapter);
        recyclerView.addOnItemTouchListener(new RecyclerItemClickListener(getActivity(), onItemClickListener));
        adapter.refreshList(lists);


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


        return view;
    }

    private RecyclerItemClickListener.OnItemClickListener onItemClickListener = new RecyclerItemClickListener.OnItemClickListener() {
        @Override
        public void onItemClick(View view, int position) {
            Intent intent = new Intent(getActivity(), TravelNotesActivity.class);
            intent.putExtra("title", mList.get(position).getTitle());
            intent.putExtra("date",mList.get(position).getDate());
            intent.putExtra("background",mList.get(position).getBackground());
            intent.putExtra("text1",mList.get(position).getText1());
            intent.putExtra("img1",mList.get(position).getImg1());
            intent.putExtra("text2",mList.get(position).getText2());













            startActivity(intent);
        }
    };
}
