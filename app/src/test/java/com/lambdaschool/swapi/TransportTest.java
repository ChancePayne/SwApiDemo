package com.lambdaschool.swapi;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class TransportTest {

    public static final String NAME         = "name";
    public static final String MODEL        = "model";
    public static final String MANUFACTURER = "manufacturer";
    public static final String CATEGORY     = "category";
    public static final int    COST         = 1000000000;
    public static final int    MAXSPEED     = 0;

    public static final String NEW_NAME         = "NAME";
    public static final String NEW_MODEL        = "MODEL";
    public static final String NEW_MANUFACTURER = "MANUFACTURER";
    public static final String NEW_CATEGORY     = "CATEGORY";
    public static final int    NEW_COST         = 10000;
    public static final int    NEW_MAXSPEED     = 1079252848;
    Transport transport;

    @Before
    public void setUp() throws Exception {
        transport = new Transport(NAME, MODEL, MANUFACTURER, CATEGORY, COST);
    }

    @Test
    public void getName() {
        // execute
        final String name = transport.getName();

        // check
        assertEquals(NAME, name);
    }

    @Test
    public void setName() {
        // setup

        // execute
        transport.setName(NEW_NAME);

        // check
        final String retrievedName = transport.getName();
        assertEquals(NEW_NAME, retrievedName);
        assertNotEquals(NAME, retrievedName);
    }

    @Test
    public void getModel() {
        assertEquals(MODEL, transport.getModel());
    }

    @Test
    public void setModel() {
                // setup

        // execute
        transport.setModel(NEW_MODEL);

        // check
        final String retrievedModel = transport.getModel();
        assertEquals(NEW_MODEL, retrievedModel);
        assertNotEquals(MODEL, retrievedModel);

    }

    @Test
    public void getManufacturer() {
        assertEquals(MANUFACTURER, transport.getManufacturer());
    }

    @Test
    public void setManufacturer() {
                // setup

        // execute
        transport.setManufacturer(NEW_MANUFACTURER);

        // check
        final String retrievedManufacturer = transport.getManufacturer();
        assertEquals(NEW_MANUFACTURER, retrievedManufacturer);
        assertNotEquals(MANUFACTURER, retrievedManufacturer);

    }

    @Test
    public void getCategory() {
        assertEquals(CATEGORY, transport.getCategory());
    }

    @Test
    public void setCategory() {
                // setup

        // execute
        transport.setCategory(NEW_CATEGORY);

        // check
        final String retrievedCategory = transport.getCategory();
        assertEquals(NEW_CATEGORY, retrievedCategory);
        assertNotEquals(CATEGORY, retrievedCategory);

    }

    @Test
    public void getCost() {
        assertEquals(COST, transport.getCost());
    }

    @Test
    public void setCost() {
                // setup

        // execute
        transport.setCost(NEW_COST);

        // check
        final long retrievedCost = transport.getCost();
        assertEquals(NEW_COST, retrievedCost);
        assertNotEquals(COST, retrievedCost);

    }

    @Test
    public void getMaxSpeed() {
        assertEquals(MAXSPEED, transport.getMaxSpeed());
    }

    @Test
    public void setMaxSpeed() {
                // setup

        // execute
        transport.setMaxSpeed(NEW_MAXSPEED);

        // check
        final long retrievedMaxSpeed = transport.getMaxSpeed();
        assertEquals(NEW_MAXSPEED, retrievedMaxSpeed);
        assertNotEquals(MAXSPEED, retrievedMaxSpeed);

    }

    /*@Test
    public void toString() {
    }*/
}