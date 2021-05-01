package com.example.mymonohari;

public class StaticRV_Model {
    private int image;
    private String text;

    public StaticRV_Model(int image, String text) {
        this.image = image;
        this.text = text;
    }

    public int getImage() {
        return image;
    }

    public String getText() {
        return text;
    }
}
