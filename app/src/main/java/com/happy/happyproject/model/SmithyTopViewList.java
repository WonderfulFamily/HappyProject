package com.happy.happyproject.model;

import com.happy.happyproject.http.JsonParser;

import org.xutils.http.annotation.HttpResponse;

import java.util.List;

/**
 * 匠铺顶部轮播外层model
 * Created by Administrator on 2016/9/20 0020.
 */
@HttpResponse(parser = JsonParser.class)
public class SmithyTopViewList {
    private List<SmithyTopView> headlines;

    public List<SmithyTopView> getHeadlines() {
        return headlines;
    }

    public void setHeadlines(List<SmithyTopView> headlines) {
        this.headlines = headlines;
    }
}
