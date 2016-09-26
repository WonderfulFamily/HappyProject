package com.happy.happyproject.model;

import com.happy.happyproject.http.JsonParser;

import org.xutils.http.annotation.HttpResponse;

import java.util.List;

/**
 * Created by Administrator on 2016/9/23 0023.
 */
@HttpResponse(parser = JsonParser.class)
public class ProductsList {
    private List<Product> products;

    public List<Product> getProducts() {
        return products;
    }

    public void setProducts(List<Product> products) {
        this.products = products;
    }
}
