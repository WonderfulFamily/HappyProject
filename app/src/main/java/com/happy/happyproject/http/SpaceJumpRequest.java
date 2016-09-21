package com.happy.happyproject.http;

import org.xutils.http.RequestParams;
import org.xutils.http.annotation.HttpRequest;

/**
 * Created by Administrator on 2016/9/20.
 */
@HttpRequest(host = "http://api.jiangwoo.com",path = "api/v1/spaces/91?")
public class SpaceJumpRequest extends RequestParams {
    public int id;


}
