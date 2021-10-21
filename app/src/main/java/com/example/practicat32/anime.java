package com.example.practicat32;

public class anime {
    int id;
    String title, descrition, image;
    boolean state;

    public anime() {
    }

    public anime(int id, String title, String descrition, String image, boolean state) {
        this.id = id;
        this.title = title;
        this.descrition = descrition;
        this.image = image;
        this.state = state;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescrition() {
        return descrition;
    }

    public void setDescrition(String descrition) {
        this.descrition = descrition;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public boolean isState() {
        return state;
    }

    public void setState(boolean state) {
        this.state = state;
    }
}