package com.wenxin.dongyouji.activity;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ImageView;

import com.wenxin.dongyouji.R;

/**
 * Created by linSir
 * date at 2017/4/17.
 * describe:
 */

public class AboutMeActivity extends AppCompatActivity {

    private ImageView back;

    @Override protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_about_me);
        back = (ImageView) findViewById(R.id.back_me_about);

        back.setOnClickListener(new View.OnClickListener() {
            @Override public void onClick(View view) {
                finish();
            }
        });
    }
}
