package com.wenxin.dongyouji.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;
import com.wenxin.dongyouji.R;
import com.wenxin.dongyouji.Url;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by linSir
 * date at 20/04/2017.
 * describe:
 */

public class RaidersActivity extends AppCompatActivity {


    @BindView(R.id.background) ImageView background;
    @BindView(R.id.title) TextView title;
    @BindView(R.id.description) TextView description;
    @BindView(R.id.img1) ImageView img1;
    @BindView(R.id.text1) TextView text1;
    @BindView(R.id.img2) ImageView img2;
    @BindView(R.id.text2) TextView text2;
    @BindView(R.id.img3) ImageView img3;
    @BindView(R.id.text3) TextView text3;

    @Override protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_raiders);
        ButterKnife.bind(this);
        Intent intent = getIntent();

        String url = Url.url + "static/images/" + intent.getExtras().getString("background");
        Picasso
                .with(this)
                .load(url)
                .fit()
                .centerCrop()
                .into(background);

        title.setText(intent.getExtras().getString("title"));

        description.setText(intent.getExtras().getString("description"));

        url = Url.url + "static/images/" + intent.getExtras().getString("img1");
        Picasso
                .with(this)
                .load(url)
                .fit()
                .centerCrop()
                .into(img1);

        text1.setText(intent.getExtras().getString("text1"));
        text2.setText(intent.getExtras().getString("text2"));
        text3.setText(intent.getExtras().getString("text3"));

        url = Url.url + "static/images/" + intent.getExtras().getString("img2");
        Picasso
                .with(this)
                .load(url)
                .fit()
                .centerCrop()
                .into(img2);

        url = Url.url + "static/images/" + intent.getExtras().getString("img3");
        Picasso
                .with(this)
                .load(url)
                .fit()
                .centerCrop()
                .into(img3);
    }
}
