package com.wenxin.dongyouji.activity;

import android.app.Activity;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.wenxin.dongyouji.R;

/**
 * Created by linSir
 * date at 2017/4/15.
 * describe:
 */

public class MeActivity extends AppCompatActivity {

    private TextView userName, userPhone;
    private RelativeLayout likeArticle, feedBack, aboutMe, exit;


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_me);
        userName = (TextView) findViewById(R.id.fr_me_user_name);
        userPhone = (TextView) findViewById(R.id.fr_me_user_phone);
        likeArticle = (RelativeLayout) findViewById(R.id.fr_me_like_article);
        feedBack = (RelativeLayout) findViewById(R.id.fr_me_feedback);
        aboutMe = (RelativeLayout) findViewById(R.id.fragment_me_about_me);
        exit = (RelativeLayout) findViewById(R.id.fr_me_exit);

        likeArticle.setOnClickListener(new View.OnClickListener() {
            @Override public void onClick(View view) {
                Intent intent = new Intent(MeActivity.this, LikeArticleActivity.class);
                startActivity(intent);
            }
        });

        feedBack.setOnClickListener(new View.OnClickListener() {
            @Override public void onClick(View view) {
                Intent intent = new Intent(MeActivity.this,FeedBackActivity.class);
                startActivity(intent);
            }
        });

        aboutMe.setOnClickListener(new View.OnClickListener() {
            @Override public void onClick(View view) {
                Intent intent = new Intent(MeActivity.this, AboutMeActivity.class);
                startActivity(intent);
            }
        });

        exit.setOnClickListener(new View.OnClickListener() {
            @Override public void onClick(View view) {
                SharedPreferences sharedPreferences = getSharedPreferences("user", Activity.MODE_PRIVATE);
                SharedPreferences.Editor editor = sharedPreferences.edit();
                editor.putString("user_name", "null");
                editor.putString("user_phone", "null");
                editor.putString("user_pwd", "null");
                editor.apply();

                startActivity(new Intent(MeActivity.this, LoginActivity.class));

                finish();
            }
        });


    }
}
