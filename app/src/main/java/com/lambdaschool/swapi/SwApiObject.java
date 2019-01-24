package com.lambdaschool.swapi;

import java.io.Serializable;

public abstract class SwApiObject implements Serializable {
    public static final String SWAPI_ITEM_INTENT_TAG = "swapi_item";
    protected int imageId, drawableResourceId;
    protected String name, category;

    public int getDrawableResourceId() {
        return drawableResourceId;
    }

    public void setDrawableResourceId(int drawableResourceId) {
        this.drawableResourceId = drawableResourceId;
    }

    protected void parseUrlForId(String url) {
        // "https://swapi.co/api/planets/2/"
        final String[] urlComponents = url.split("/");
        if(urlComponents.length >= 4) {
            setImageId(Integer.parseInt(urlComponents[5]));
        }
        if(urlComponents.length >= 3) {
            setCategory(urlComponents[4]);
            setDrawableResourceId(DrawableResolver.getDrawableId(this.category, this.imageId));
        }
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
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
