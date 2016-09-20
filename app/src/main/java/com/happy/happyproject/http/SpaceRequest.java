package com.happy.happyproject.http;

import org.xutils.http.RequestParams;
import org.xutils.http.annotation.HttpRequest;

/**
 * Created by Administrator on 2016/9/20.
 */
@HttpRequest(host = "http://api.jiangwoo.com",path = "api/v2/spaces")
public class SpaceRequest extends RequestParams {
    private int page;
    private int per_page;

    public int getPage() {
        return page;
    }

    public void setPage(int page) {
        this.page = page;
    }

    public int getPer_page() {
        return per_page;
    }

    public void setPer_page(int per_page) {
        this.per_page = per_page;
    }
}
