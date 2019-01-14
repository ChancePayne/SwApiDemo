package com.lambdaschool.swapi;

import java.io.Serializable;

public abstract class SwApiObject implements Serializable {
    protected int imageId, drawableResourceId;
    protected String name;

    public int getDrawableResourceId() {
        return drawableResourceId;
    }

    public void setDrawableResourceId(int drawableResourceId) {
        this.drawableResourceId = drawableResourceId;
    }

    public int getImageId() {
        return imageId;
    }

    public void setImageId(int imageId) {
        this.imageId = imageId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
