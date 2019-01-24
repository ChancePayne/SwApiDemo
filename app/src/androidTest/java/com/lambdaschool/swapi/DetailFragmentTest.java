package com.lambdaschool.swapi;

import android.content.Intent;

import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;

import androidx.test.rule.ActivityTestRule;

import static androidx.test.espresso.Espresso.onView;
import static androidx.test.espresso.assertion.ViewAssertions.matches;
import static androidx.test.espresso.matcher.ViewMatchers.withId;
import static androidx.test.espresso.matcher.ViewMatchers.withResourceName;
import static androidx.test.espresso.matcher.ViewMatchers.withText;
import static org.junit.Assert.*;

public class DetailFragmentTest {

    Intent intent;
    SwApiObject swApiObject;

    @Rule
    public ActivityTestRule<PhoneDetailActivity> activityTestRule = new ActivityTestRule<>(PhoneDetailActivity.class, false, false);

    @Before public void setUp() {
        swApiObject = new Planet("edited", "terrain", "diameter", new String[] { "films" }, "https://swapi.co/api/planets/3/", "surface_water", "orbital_period", "created", "rotation_period", "climate", "gravity", "population", new String[] { "residents" }, "Planet Name");

        intent = new Intent();
        intent.putExtra(SwApiObject.SWAPI_ITEM_INTENT_TAG, swApiObject);

        activityTestRule.launchActivity(intent);
    }

    @Test public void shouldDisplayObjectName() {
        // setup

        // execute

        // check
        onView(withId(R.id.detail_text_name)).check(matches(withText(swApiObject.getName())));
    }

    @Test public void shouldDisplayObjectCategory() {
        // setup

        // execute

        // check
        onView(withId(R.id.detail_text_category)).check(matches(withText(swApiObject.getCategory())));
    }

    @Test public void shouldDisplayCorrectImage() {
        // setup

        // execute

        // check
        onView(withId(R.id.detail_image)).check(matches(EspressoTestMatchers.withDrawable(swApiObject.getDrawableResourceId())));
    }
}