package com.happy.happyproject.model;

/**
 * Created by Administrator on 2016/9/23 0023.
 */
public class Product {
    private int id;
    private String title;
    private String thumb;
    private String favs_count;
    private String view_count;
    private String source;
    private String display_tag;

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

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getFavs_count() {
        return favs_count;
    }

    public void setFavs_count(String favs_count) {
        this.favs_count = favs_count;
    }

    public String getView_count() {
        return view_count;
    }

    public void setView_count(String view_count) {
        this.view_count = view_count;
    }

    public String getSource() {
        return source;
    }

    public void setSource(String source) {
        this.source = source;
    }

    public String getDisplay_tag() {
        return display_tag;
    }

    public void setDisplay_tag(String display_tag) {
        this.display_tag = display_tag;
    }
}
