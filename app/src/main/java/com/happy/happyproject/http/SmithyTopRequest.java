package com.happy.happyproject.http;

import org.xutils.http.RequestParams;
import org.xutils.http.annotation.HttpRequest;

/**
 *
 * Created by Administrator on 2016/9/20 0020.
 */
@HttpRequest(host = "http://api.jiangwoo.com",path = "api/v1/headlines")
public class SmithyTopRequest extends RequestParams{
    public String page;
}
