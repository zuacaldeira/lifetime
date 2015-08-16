/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lifetime.backend.persistence;

import java.util.Date;
import java.util.List;

/**
 *
 * @author zua
 */
public class LifetimeEvent implements ITimed, ILocated, ITranslatable {

    private ITimed timed;
    private ILocated located;

    public LifetimeEvent() {
        this.timed = new Timed();
        this.located = new Located();
    }

    @Override
    public void start() {
        timed.start();
    }

    @Override
    public void finish() {
        timed.finish();
    }

    @Override
    public void pause() {
        timed.pause();
    }

    @Override
    public void resume() {
        timed.resume();
    }

    @Override
    public Date getStartTime() {
        return timed.getStartTime();
    }

    @Override
    public Date getFinishedTime() {
        return timed.getFinishedTime();
    }

    @Override
    public Date getLastPausedAt() {
        return timed.getLastPausedAt();
    }

    @Override
    public Date getLastResumedAt() {
        return timed.getLastResumedAt();
    }

    @Override
    public List<Date> getPauseTimes() {
        return timed.getPauseTimes();
    }

    @Override
    public List<Date> getResumeTimes() {
        return timed.getResumeTimes();
    }

    @Override
    public boolean isStarted() {
        return timed.isStarted();
    }

    @Override
    public boolean isFinished() {
        return timed.isFinished();
    }

    @Override
    public boolean isPaused() {
        return timed.isPaused();
    }

    @Override
    public boolean isResumed() {
        return timed.isResumed();
    }

    @Override
    public double getLatitude() {
        return located.getLatitude();
    }

    @Override
    public double getLongitude() {
        return located.getLongitude();
    }

    @Override
    public double getAzimuth() {
        return located.getAzimuth();
    }

    @Override
    public void setLatitude(double latitude) {
        located.setLatitude(latitude);
    }

    @Override
    public void setLongitude(double longitude) {
        located.setLongitude(longitude);
    }

    @Override
    public void setAzimuth(double latitude) {
        located.setAzimuth(latitude);
    }

    @Override
    public LifetimeEvent translateTo(String language) {
        return this;
    }

}
