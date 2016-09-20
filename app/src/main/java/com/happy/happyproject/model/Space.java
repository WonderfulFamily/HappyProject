package com.happy.happyproject.model;

/**
 * 空间  的一级模型
 */
public class Space {
    private int id;
    private String name;
    private String thumb;
    private int favs_count;
    private int comments_count;
    private int position;
    private int shares_count;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getThumb() {
        return thumb;
    }

    public void setThumb(String thumb) {
        this.thumb = thumb;
    }

    public int getFavs_count() {
        return favs_count;
    }

    public void setFavs_count(int favs_count) {
        this.favs_count = favs_count;
    }

    public int getComments_count() {
        return comments_count;
    }

    public void setComments_count(int comments_count) {
        this.comments_count = comments_count;
    }

    public int getPosition() {
        return position;
    }

    public void setPosition(int position) {
        this.position = position;
    }

    public int getShares_count() {
        return shares_count;
    }

    public void setShares_count(int shares_count) {
        this.shares_count = shares_count;
    }
}
