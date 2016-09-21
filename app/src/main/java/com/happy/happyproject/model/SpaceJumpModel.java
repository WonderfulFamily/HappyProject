package com.happy.happyproject.model;

import com.happy.happyproject.http.JsonParser;

import org.xutils.http.annotation.HttpResponse;

/**
 * Created by Administrator on 2016/9/20.
 */
@HttpResponse(parser = JsonParser.class)
public class SpaceJumpModel {
    private SpaceJumpList space;

    public SpaceJumpList getSpace() {
        return space;
    }

    public void setSpace(SpaceJumpList space) {
        this.space = space;
    }
}
