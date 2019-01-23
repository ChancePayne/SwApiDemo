package com.lambdaschool.swapi;

import org.json.JSONException;
import org.json.JSONObject;

public class Starship extends Transport {
    protected double hyperdriveRating;

    public Starship(String name, String model, String manufacturer, String category, int cost, double hyperdriveRating) {
        super(name, model, manufacturer, category, cost);
        this.hyperdriveRating = hyperdriveRating;
        super.maxSpeed = (long)calculateMaxSpeed();
    }

    public Starship(JSONObject json) {
        super(json);
        try {
            this.hyperdriveRating = json.getDouble("hyperdrive_rating");
        } catch (JSONException e) {
            e.printStackTrace();
        }
        super.maxSpeed = (long)calculateMaxSpeed();
    }

    private double calculateMaxSpeed() {
        return 1079252849 * this.hyperdriveRating;
    }

    public double getHyperdriveRating() {
        return hyperdriveRating;
    }
}
