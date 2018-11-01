package com.example.admin.frameworkdemo.Picasso;

public class News {

    private String title;
    private String contents;
    private String PicUrl;

    public News() {
    }

    public News(String title, String contents, String picUrl) {
        this.title = title;
        this.contents = contents;
        PicUrl = picUrl;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getContents() {
        return contents;
    }

    public void setContents(String contents) {
        this.contents = contents;
    }

    public String getPicUrl() {
        return PicUrl;
    }

    public void setPicUrl(String picUrl) {
        PicUrl = picUrl;
    }
}
