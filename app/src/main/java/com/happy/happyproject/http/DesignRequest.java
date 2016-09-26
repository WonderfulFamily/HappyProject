package com.happy.happyproject.http;

import org.xutils.http.RequestParams;
import org.xutils.http.annotation.HttpRequest;

/**
 * Created by Administrator on 2016/9/24 0024.
 */
@HttpRequest(host = "http://api.jiangwoo.com",path = "api/v2/products")
public class DesignRequest extends RequestParams {
    public String page;
    public String source;
}
