package com.wenxin.dongyouji.model;

/**
 * Created by linSir on 17/3/11.raiders model
 */
public class RaidersModel {

    private String title;
    private String description;
    private String details_description;
    private String background;
    private String text1;
    private String img1;
    private String text2;
    private String img2;
    private String text3;
    private String img3;

    public RaidersModel(String title, String description, String details_description, String background, String text1, String img1, String text2, String img2, String text3, String img3) {
        this.title = title;
        this.description = description;
        this.details_description = details_description;
        this.background = background;
        this.text1 = text1;
        this.img1 = img1;
        this.text2 = text2;
        this.img2 = img2;
        this.text3 = text3;
        this.img3 = img3;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getDetails_description() {
        return details_description;
    }

    public void setDetails_description(String details_description) {
        this.details_description = details_description;
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

    public String getImg2() {
        return img2;
    }

    public void setImg2(String img2) {
        this.img2 = img2;
    }

    public String getText3() {
        return text3;
    }

    public void setText3(String text3) {
        this.text3 = text3;
    }

    public String getImg3() {
        return img3;
    }

    public void setImg3(String img3) {
        this.img3 = img3;
    }
}
