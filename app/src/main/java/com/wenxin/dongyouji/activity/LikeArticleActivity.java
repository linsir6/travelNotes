package com.wenxin.dongyouji.activity;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.wenxin.dongyouji.R;

/**
 * Created by linSir
 * date at 2017/4/17.
 * describe:
 */

public class LikeArticleActivity extends AppCompatActivity {

    private RecyclerView recyclerView;
    //// TODO: 2017/4/17
    @Override protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_like_article);
        recyclerView = (RecyclerView) findViewById(R.id.ac_like_article_recycleview);
        LinearLayoutManager manager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(manager);


    }
}
