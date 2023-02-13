package com.example.app_mobile;


public class Terrain {

    String name;
    String imageId;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getImageId() {
        return imageId;
    }

    public void setImageId(String imageId) {
        this.imageId = imageId;
    }

    public Terrain(String name, String imageId) {
        this.name = name;
        this.imageId = imageId;
    }

    public Terrain() {
    }
}
