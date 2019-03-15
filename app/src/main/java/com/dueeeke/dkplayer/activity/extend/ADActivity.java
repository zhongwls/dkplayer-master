package com.dueeeke.dkplayer.activity.extend;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.view.MenuItem;
import android.widget.Toast;

import com.dueeeke.dkplayer.R;
import com.dueeeke.dkplayer.bean.VideoModel;
import com.dueeeke.dkplayer.interf.ControllerListener;
import com.dueeeke.dkplayer.widget.controller.AdController;
import com.dueeeke.dkplayer.widget.videoview.ListIjkVideoView;
import com.dueeeke.videocontroller.StandardVideoController;

import java.util.ArrayList;
import java.util.List;

/**
 * 点播播放
 * Created by Devlin_n on 2017/4/7.
 */

public class ADActivity extends AppCompatActivity {

    private ListIjkVideoView ijkVideoView;
    private static final String URL_VOD = "http://mov.bn.netease.com/open-movie/nos/flv/2017/01/03/SC8U8K7BC_hd.flv";
//    private static final String URL_VOD = "http://baobab.wdjcdn.com/14564977406580.mp4";
    //    private static final String URL_VOD = "http://uploads.cutv.com:8088/video/data/201703/10/encode_file/515b6a95601ba6b39620358f2677a17358c2472411d53.mp4";
    private static final String URL_AD = "https://gslb.miaopai.com/stream/IR3oMYDhrON5huCmf7sHCfnU5YKEkgO2.mp4";

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ad);
        ActionBar actionBar = getSupportActionBar();
        if (actionBar != null) {
            actionBar.setTitle(R.string.str_ad);
            actionBar.setDisplayHomeAsUpEnabled(true);
        }
        ijkVideoView = findViewById(R.id.player);
//        int widthPixels = getResources().getDisplayMetrics().widthPixels;
//        ijkVideoView.setLayoutParams(new LinearLayout.LayoutParams(widthPixels, widthPixels / 16 * 9));

        List<VideoModel> videos = new ArrayList<>();
        AdController adController = new AdController(this);
        adController.setControllerListener(new ControllerListener() {
            @Override
            public void onAdClick() {
                Toast.makeText(ADActivity.this, "广告点击跳转", Toast.LENGTH_SHORT).show();
            }
        });
        videos.add(new VideoModel(URL_AD, "广告", adController, true));
        videos.add(new VideoModel(URL_VOD, "这是一个标题", new StandardVideoController(this), false));

        ijkVideoView.setVideos(videos);
        ijkVideoView.start();
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if (item.getItemId() == android.R.id.home) {
            finish();
        }
        return super.onOptionsItemSelected(item);
    }

    @Override
    protected void onPause() {
        super.onPause();
        ijkVideoView.pause();
    }

    @Override
    protected void onResume() {
        super.onResume();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        ijkVideoView.release();
    }


    @Override
    public void onBackPressed() {
        if (!ijkVideoView.onBackPressed()) {
            super.onBackPressed();
        }
    }
}
