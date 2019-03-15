package com.dueeeke.dkplayer.bean;

import com.dueeeke.videoplayer.controller.BaseVideoController;

/**
 * Created by Devlin_n on 2017/4/11.
 */

public class VideoModel {

    public String url;
    public String title;

    public VideoModel(String url, String title, BaseVideoController controller, boolean isCache) {
        this.url = url;
        this.title = title;
        this.controller = controller;
        this.isCache = isCache;
    }

    public BaseVideoController controller;
    public boolean isCache;
}
