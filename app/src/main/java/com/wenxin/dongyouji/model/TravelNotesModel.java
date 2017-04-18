package com.wenxin.dongyouji.model;

/**
 * Created by linSir on 17/3/11.游记model
 */
public class TravelNotesModel {

    private String title;
    private String date;
    private String background;
    private String text1;
    private String img1;
    private String text2;

    public TravelNotesModel(String title, String date, String background, String text1, String img1, String text2) {
        this.title = title;
        this.date = date;
        this.background = background;
        this.text1 = text1;
        this.img1 = img1;
        this.text2 = text2;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getBackground() {
        return background;
    }

    public void setBackground(String background) {
        this.background = background;
    }

    public String getText1() {
        return text1;
    }

    public void setText1(String text1) {
        this.text1 = text1;
    }

    public String getImg1() {
        return img1;
    }

    public void setImg1(String img1) {
        this.img1 = img1;
    }

    public String getText2() {
        return text2;
    }

    public void setText2(String text2) {
        this.text2 = text2;
    }
}
