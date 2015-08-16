/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lifetime.backend.persistence;

import java.util.Date;
import static org.testng.Assert.*;
import org.testng.annotations.Test;

/**
 *
 * @author zua
 */
public class TimedNGTest {

    public TimedNGTest() {
    }

    /**
     * Test of start method, of class Timed.
     */
    @Test
    public void testStart() {
        System.out.println("start");
        Timed instance = new Timed();
        instance.start();
        assertNotNull(instance.getStartTime());
    }

    /**
     * Test of finish method, of class Timed.
     */
    @Test
    public void testFinish() {
        System.out.println("finish");
        Timed instance = new Timed();
        instance.finish();
        assertNotNull(instance.getFinishedTime());
    }

    /**
     * Test of pause method, of class Timed.
     */
    @Test
    public void testPause() {
        System.out.println("pause");
        Timed instance = new Timed();
        instance.pause();
        assertNotNull(instance.getLastPausedAt());
    }

    /**
     * Test of resume method, of class Timed.
     */
    @Test
    public void testResume() {
        System.out.println("resume");
        Timed instance = new Timed();
        instance.resume();
        assertNotNull(instance.getLastResumedAt());
    }

    /**
     * Test of getPauseTimes method, of class Timed.
     */
    @Test
    public void testGetPauseTimes() {
        System.out.println("getPauseTimes");
        Timed instance = new Timed();
        assertTrue(instance.getPauseTimes().isEmpty());
        instance.pause();
        assertTrue(!instance.getPauseTimes().isEmpty());
    }

    /**
     * Test of getResumeTimes method, of class Timed.
     */
    @Test
    public void testGetResumeTimes() {
        System.out.println("getResumeTimes");
        Timed instance = new Timed();
        assertTrue(instance.getPauseTimes().isEmpty());
        instance.resume();
        assertFalse(instance.getResumeTimes().isEmpty());
    }

    /**
     * Test of isStarted method, of class Timed.
     */
    @Test
    public void testIsStarted() {
        System.out.println("isStarted");
        Timed instance = new Timed();
        assertFalse(instance.isStarted());
        instance.start();
        assertNotNull(instance.getStartTime());
    }

    /**
     * Test of isFinished method, of class Timed.
     */
    @Test
    public void testIsFinished() {
        System.out.println("isFinished");
        Timed instance = new Timed();
        assertFalse(instance.isFinished());
        instance.finish();
        assertNotNull(instance.getFinishedTime());
    }

    /**
     * Test of isPaused method, of class Timed.
     */
    @Test
    public void testIsPaused() {
        System.out.println("isPaused");
        Timed instance = new Timed();
        assertFalse(instance.isPaused());
        instance.pause();
        assertNotNull(instance.getLastPausedAt());
    }

    /**
     * Test of isResumed method, of class Timed.
     */
    @Test
    public void testIsResumed() {
        System.out.println("isResumed");
        Timed instance = new Timed();
        assertFalse(instance.isResumed());
        instance.resume();
        assertNotNull(instance.getLastResumedAt());
    }

}
