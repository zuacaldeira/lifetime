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
public class LifetimeEventNGTest {

    public LifetimeEventNGTest() {
    }

    /**
     * Test of start method, of class LifetimeEvent.
     */
    @Test
    public void testStart() {
        System.out.println("start");
        LifetimeEvent instance = new LifetimeEvent();
        instance.start();
        assertTrue(instance.isStarted());
    }

    /**
     * Test of finish method, of class LifetimeEvent.
     */
    @Test
    public void testFinish() {
        System.out.println("finish");
        LifetimeEvent instance = new LifetimeEvent();
        instance.finish();
        assertTrue(instance.isFinished());
    }

    /**
     * Test of pause method, of class LifetimeEvent.
     */
    @Test
    public void testPause() {
        System.out.println("pause");
        LifetimeEvent instance = new LifetimeEvent();
        instance.pause();
        assertTrue(instance.isPaused());
    }

    /**
     * Test of resume method, of class LifetimeEvent.
     */
    @Test
    public void testResume() {
        System.out.println("resume");
        LifetimeEvent instance = new LifetimeEvent();
        instance.resume();
        assertTrue(instance.isResumed());
    }

    /**
     * Test of getPauseTimes method, of class LifetimeEvent.
     */
    @Test
    public void testGetPauseTimes() {
        System.out.println("getPauseTimes");
        LifetimeEvent instance = new LifetimeEvent();
        assertTrue(instance.getPauseTimes().isEmpty());
        instance.pause();
        assertFalse(instance.getPauseTimes().isEmpty());
    }

    /**
     * Test of getResumeTimes method, of class LifetimeEvent.
     */
    @Test
    public void testGetResumeTimes() {
        System.out.println("getResumeTimes");
        LifetimeEvent instance = new LifetimeEvent();
        assertTrue(instance.getResumeTimes().isEmpty());
        instance.resume();
        assertFalse(instance.getResumeTimes().isEmpty());
    }

    /**
     * Test of isStarted method, of class LifetimeEvent.
     */
    @Test
    public void testIsStarted() {
        System.out.println("isStarted");
        LifetimeEvent instance = new LifetimeEvent();
        assertFalse(instance.isStarted());
        instance.start();
        assertTrue(instance.isStarted());
    }

    /**
     * Test of isFinished method, of class LifetimeEvent.
     */
    @Test
    public void testIsFinished() {
        System.out.println("isFinished");
        LifetimeEvent instance = new LifetimeEvent();
        assertFalse(instance.isFinished());
        instance.finish();
        assertTrue(instance.isFinished());
    }

    /**
     * Test of isPaused method, of class LifetimeEvent.
     */
    @Test
    public void testIsPaused() {
        System.out.println("isPaused");
        LifetimeEvent instance = new LifetimeEvent();
        assertFalse(instance.isPaused());
        instance.pause();
        assertTrue(instance.isPaused());
    }

    /**
     * Test of isResumed method, of class LifetimeEvent.
     */
    @Test
    public void testIsResumed() {
        System.out.println("isResumed");
        LifetimeEvent instance = new LifetimeEvent();
        assertFalse(instance.isResumed());
        instance.resume();
        assertTrue(instance.isResumed());
    }

    /**
     * Test of getLatitude method, of class LifetimeEvent.
     */
    @Test
    public void testGetLatitude() {
        System.out.println("getLatitude");
        LifetimeEvent instance = new LifetimeEvent();
        double expResult = 0.0;
        double result = instance.getLatitude();
        assertEquals(result, expResult, 0.0);
    }

    /**
     * Test of getLongitude method, of class LifetimeEvent.
     */
    @Test
    public void testGetLongitude() {
        System.out.println("getLongitude");
        LifetimeEvent instance = new LifetimeEvent();
        double expResult = 0.0;
        double result = instance.getLongitude();
        assertEquals(result, expResult, 0.0);
    }

    /**
     * Test of getAzimuth method, of class LifetimeEvent.
     */
    @Test
    public void testGetAzimuth() {
        System.out.println("getAzimuth");
        LifetimeEvent instance = new LifetimeEvent();
        double expResult = 0.0;
        double result = instance.getAzimuth();
        assertEquals(result, expResult, 0.0);
    }

    /**
     * Test of setLatitude method, of class LifetimeEvent.
     */
    @Test
    public void testSetLatitude() {
        System.out.println("setLatitude");
        double latitude = 0.0;
        LifetimeEvent instance = new LifetimeEvent();
        instance.setLatitude(latitude);
    }

    /**
     * Test of setLongitude method, of class LifetimeEvent.
     */
    @Test
    public void testSetLongitude() {
        System.out.println("setLongitude");
        double longitude = 0.0;
        LifetimeEvent instance = new LifetimeEvent();
        instance.setLongitude(longitude);
    }

    /**
     * Test of setAzimuth method, of class LifetimeEvent.
     */
    @Test
    public void testSetAzimuth() {
        System.out.println("setAzimuth");
        double latitude = 0.0;
        LifetimeEvent instance = new LifetimeEvent();
        instance.setAzimuth(latitude);
    }

    /**
     * Test of translateTo method, of class LifetimeEvent.
     */
    @Test
    public void testTranslateTo() {
        System.out.println("translateTo");
        String language = "";
        LifetimeEvent instance = new LifetimeEvent();
        assertNotNull(instance.translateTo(language));
    }

}
