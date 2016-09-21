package com.happy.happyproject.model;

import com.happy.happyproject.http.JsonParser;

import org.xutils.http.annotation.HttpResponse;

import java.util.List;

/**
 * Created by Administrator on 2016/9/20.
 */

public class SpaceJumpList {
    private int id;
    private String thumb;
    private String name;
    private String favs_count;
    private String comments_count;
    private String shares_count;

    public String getFavs_count() {
        return favs_count;
    }

    public void setFavs_count(String favs_count) {
        this.favs_count = favs_count;
    }

    public String getComments_count() {
        return comments_count;
    }

    public void setComments_count(String comments_count) {
        this.comments_count = comments_count;
    }

    public String getShares_count() {
        return shares_count;
    }

    public void setShares_count(String shares_count) {
        this.shares_count = shares_count;
    }

    private List<SpaceJump> space_items;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getThumb() {
        return thumb;
    }

    public void setThumb(String thumb) {
        this.thumb = thumb;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<SpaceJump> getSpace_items() {
        return space_items;
    }

    public void setSpace_items(List<SpaceJump> space_items) {
        this.space_items = space_items;
    }
}
