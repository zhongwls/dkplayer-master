package com.dueeeke.dkplayer.fragment;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.dueeeke.dkplayer.R;
import com.dueeeke.dkplayer.adapter.VideoRecyclerViewAdapter;
import com.dueeeke.dkplayer.util.DataUtil;
import com.dueeeke.videoplayer.player.IjkVideoView;

/**
 * RecyclerViewFragment
 * Created by xinyu on 2018/1/3.
 */

public class RecyclerViewFragment extends Fragment{

    public static RecyclerViewFragment newInstance() {
        return new RecyclerViewFragment();
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.activity_recycler_view, container, false);
        initView(view);
        return view;
    }

    private void initView(View view) {
        RecyclerView recyclerView = view.findViewById(R.id.rv);
        recyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
        recyclerView.setAdapter(new VideoRecyclerViewAdapter(DataUtil.getVideoList(), getActivity()));
        recyclerView.addOnChildAttachStateChangeListener(new RecyclerView.OnChildAttachStateChangeListener() {
            @Override
            public void onChildViewAttachedToWindow(View view) {

            }

            @Override
            public void onChildViewDetachedFromWindow(View view) {
                IjkVideoView ijkVideoView = view.findViewById(R.id.video_player);
                if (ijkVideoView != null && !ijkVideoView.isFullScreen()) {
//                    Log.d("@@@@@@", "onChildViewDetachedFromWindow: called");
//                    int tag = (int) ijkVideoView.getTag();
//                    Log.d("@@@@@@", "onChildViewDetachedFromWindow: position: " + tag);
                    ijkVideoView.stopPlayback();
                }
            }
        });
    }
}
