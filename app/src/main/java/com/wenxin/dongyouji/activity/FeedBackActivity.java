package com.wenxin.dongyouji.activity;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import com.wenxin.dongyouji.R;

/**
 * Created by linSir
 * date at 2017/4/17.
 * describe:
 */

public class FeedBackActivity extends AppCompatActivity {

    private TextView submit;
    @Override protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_feed_back);
        submit = (TextView) findViewById(R.id.submit);

        submit.setOnClickListener(new View.OnClickListener() {
            @Override public void onClick(View view) {
                showToast("提交成功");
                finish();
            }
        });
    }

    private void showToast(String text) {
        Toast.makeText(FeedBackActivity.this, text, Toast.LENGTH_SHORT).show();
    }

}
