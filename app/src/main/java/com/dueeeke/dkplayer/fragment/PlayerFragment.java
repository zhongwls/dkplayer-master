package com.dueeeke.dkplayer.fragment;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.dueeeke.dkplayer.R;
import com.dueeeke.videocontroller.StandardVideoController;
import com.dueeeke.videoplayer.player.IjkVideoView;

public class PlayerFragment extends Fragment {

    private IjkVideoView mIjkVideoView;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.activity_player, container, false);
        mIjkVideoView = view.findViewById(R.id.player);
        return view;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        //播放raw
        String url = "android.resource://" + getContext().getPackageName() + "/" + R.raw.movie;
        mIjkVideoView.setUrl(url);

        mIjkVideoView.setVideoController(new StandardVideoController(getContext()));
        mIjkVideoView.start();
    }
}
