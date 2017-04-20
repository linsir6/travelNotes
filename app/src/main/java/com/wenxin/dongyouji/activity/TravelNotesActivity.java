package com.wenxin.dongyouji.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.squareup.picasso.Picasso;
import com.wenxin.dongyouji.R;
import com.wenxin.dongyouji.Url;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by linSir on 17/3/11.详情界面
 */
public class TravelNotesActivity extends AppCompatActivity {

    @BindView(R.id.background) ImageView background;
    @BindView(R.id.title) TextView title;
    @BindView(R.id.date) TextView date;
    @BindView(R.id.date2) TextView date2;
    @BindView(R.id.text1) TextView text1;
    @BindView(R.id.img1) ImageView img1;
    @BindView(R.id.text2) TextView text2;

    @Override protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_travel_notes);
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

        date.setText(intent.getExtras().getString("date"));

        date2.setText(intent.getExtras().getString("date"));

        text1.setText(intent.getExtras().getString("text1"));

        url = Url.url + "static/images/" + intent.getExtras().getString("img1");
        Picasso
                .with(this)
                .load(url)
                .fit()
                .centerCrop()
                .into(img1);

        text2.setText(intent.getExtras().getString("text2"));




    }
}
