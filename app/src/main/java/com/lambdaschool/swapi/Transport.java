package com.lambdaschool.swapi;

import org.json.JSONException;
import org.json.JSONObject;

public class Transport extends SwApiObject {
    protected String model, manufacturer, category, url;
    protected long cost, maxSpeed;

    public Transport(String name, String model, String manufacturer, String category, int cost) {
        super.name = name;
        this.model = model;
        this.manufacturer = manufacturer;
        this.category = category;
        this.cost = cost;
    }

    public Transport(JSONObject json) {
        try {
            super.name = json.getString("name");
        } catch (JSONException e) {
            e.printStackTrace();
        }
        try {
            this.model = json.getString("model");
        } catch (JSONException e) {
            e.printStackTrace();
        }
        try {
            this.manufacturer = json.getString("manufacturer");
        } catch (JSONException e) {
            e.printStackTrace();
        }
        try {
            this.url = json.getString("url");
        } catch (JSONException e) {
            e.printStackTrace();
        }
        try {
            this.cost = json.getLong("cost_in_credits");
        } catch (JSONException e) {
            e.printStackTrace();
            this.cost = -1;
        }
//        this.category will be added by the child class
        super.parseUrlForId(this.url);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        super.name = name;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public String getManufacturer() {
        return manufacturer;
    }

    public void setManufacturer(String manufacturer) {
        this.manufacturer = manufacturer;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public long getCost() {
        return cost;
    }

    public void setCost(long cost) {
        this.cost = cost;
    }

    public long getMaxSpeed() {
        return maxSpeed;
    }

    public void setMaxSpeed(long maxSpeed) {
        this.maxSpeed = maxSpeed;
    }

    @Override
    public String toString() {
        return String.format("%s - %d kph", super.name, this.maxSpeed);
    }
}
