package com.example.edt69;

import java.util.ArrayList;

public class Anime {
    private String animeid;
    private String name;
    private String type;
    private String description;
    private int year;
    private String imageurl;
    //private float rating;
   // ArrayList<Object> authors = new ArrayList<Object>();
    //ArrayList<Object> ratedBy = new ArrayList<Object>();

    public Anime(String animeid, String name, String type, String description, int year, String imageurl) {
        this.animeid = animeid;
        this.name = name;
        this.type = type;
        this.description = description;
        this.year = year;
        this.imageurl = imageurl;
    }

    public Anime() {
    }

    public String getAnimeid() {
        return animeid;
    }

    public void setAnimeid(String animeid) {
        this.animeid = animeid;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public String getImageurl() {
        return imageurl;
    }

    public void setImageurl(String imageurl) {
        this.imageurl = imageurl;
    }
}
