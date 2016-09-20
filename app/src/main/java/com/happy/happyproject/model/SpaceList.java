package com.happy.happyproject.model;

import com.happy.happyproject.http.JsonParser;

import org.xutils.http.annotation.HttpResponse;

import java.util.List;

/**
 * Created by Administrator on 2016/9/20.
 */
@HttpResponse(parser = JsonParser.class)
public class SpaceList {
    private List<Space>  spaces;

    public List<Space> getSpaces() {
        return spaces;
    }

    public void setSpaces(List<Space> spaces) {
        this.spaces = spaces;
    }
}
