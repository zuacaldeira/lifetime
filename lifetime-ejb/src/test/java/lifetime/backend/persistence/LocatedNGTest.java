/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lifetime.backend.persistence;

import static org.testng.Assert.*;
import org.testng.annotations.Test;

/**
 *
 * @author zua
 */
public class LocatedNGTest {

    public LocatedNGTest() {
    }

    /**
     * Test of getLatitude method, of class Located.
     */
    @Test
    public void testGetLatitude() {
        System.out.println("getLatitude");
        Located instance = new Located();
        assertEquals(instance.getLatitude(), 0.0);
    }

    /**
     * Test of getLongitude method, of class Located.
     */
    @Test
    public void testGetLongitude() {
        System.out.println("getLongitude");
        Located instance = new Located();
        assertEquals(instance.getLongitude(), 0.0);
    }

    /**
     * Test of getAzimuth method, of class Located.
     */
    @Test
    public void testGetAzimuth() {
        System.out.println("getAzimuth");
        Located instance = new Located();
        assertEquals(instance.getAzimuth(), 0.0);
    }

    /**
     * Test of setLatitude method, of class Located.
     */
    @Test
    public void testSetLatitude() {
        System.out.println("setLatitude");
        double latitude = 0.0;
        Located instance = new Located();
        instance.setLatitude(latitude);
        assertEquals(instance.getLatitude(), latitude);
    }

    /**
     * Test of setLongitude method, of class Located.
     */
    @Test
    public void testSetLongitude() {
        System.out.println("setLongitude");
        double longitude = 0.0;
        Located instance = new Located();
        instance.setLongitude(longitude);
        assertEquals(instance.getLongitude(), longitude);
    }

    /**
     * Test of setAzimuth method, of class Located.
     */
    @Test
    public void testSetAzimuth() {
        System.out.println("setAzimuth");
        double azimuth = 0.0;
        Located instance = new Located();
        instance.setAzimuth(azimuth);
        assertEquals(instance.getAzimuth(), azimuth);
    }

}
