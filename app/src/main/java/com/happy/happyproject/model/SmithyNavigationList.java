package com.happy.happyproject.model;

import com.happy.happyproject.http.JsonParser;

import org.xutils.http.annotation.HttpResponse;

import java.util.List;

/**
 * 匠铺中间导航外层model
 * Created by Administrator on 2016/9/20 0020.
 */
@HttpResponse(parser = JsonParser.class)
public class SmithyNavigationList {
    private List<SmithyNavigation> categories;

    public List<SmithyNavigation> getCategories() {
        return categories;
    }

    public void setCategories(List<SmithyNavigation> categories) {
        this.categories = categories;
    }
}
