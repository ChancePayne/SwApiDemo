package com.lambdaschool.swapi;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class StarshipTest {
    final double HYPERDRIVE_RATING = 2.4;

    Starship starship;

    @Before
    public void setUp() throws Exception {
        starship = new Starship("name", "model", "manufacturer", "category", 1000000000, HYPERDRIVE_RATING);
    }

    @Test public void shouldReturnHyperdriveRating() {
        // setup

        // execute
        double retrievedRating = starship.getHyperdriveRating();

        // check
        assertEquals(HYPERDRIVE_RATING, retrievedRating, .001);
    }

    @Test public void shouldProperlyCalculateMaximumSpeed() {
        // setup
        double expectedSpeed = HYPERDRIVE_RATING * 1079252848.8;

        // execute
        final long retrievedSpeed = starship.getMaxSpeed();

        // check
        assertEquals(expectedSpeed, retrievedSpeed, 1);
    }
}