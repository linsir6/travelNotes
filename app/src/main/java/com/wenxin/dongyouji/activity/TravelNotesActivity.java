package com.wenxin.dongyouji.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.widget.Toast;

import com.wenxin.dongyouji.R;

/**
 * Created by linSir on 17/3/11.详情界面
 */
public class TravelNotesActivity extends AppCompatActivity {

    @Override protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_travel_notes);
        Intent intent = getIntent();
        int i = intent.getExtras().getInt("id");
        Toast.makeText(TravelNotesActivity.this, "您点击的是" + i, Toast.LENGTH_SHORT).show();



    }
}
