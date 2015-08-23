/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lifetime.backend.persistence;

import java.util.Date;
import java.util.LinkedList;
import java.util.List;

/**
 *
 * @author zua
 */
public class Timed implements ITimed {

    private Date startTime;
    private Date finishTime;
    private List<Date> pauseTimes;
    private List<Date> resumeTimes;
    private boolean isFinished;
    private boolean isStarted;
    private boolean isPaused;
    private boolean isResumed;

    public Timed() {
        pauseTimes = new LinkedList();
        resumeTimes = new LinkedList();
    }

    @Override
    public void start() {
        startTime = new Date();
        isStarted = true;
    }

    @Override
    public void finish() {
        finishTime = new Date();
        isFinished = true;
        isResumed = false;
        isPaused = false;
        isStarted = false;
    }

    @Override
    public void pause() {
        pauseTimes.add(new Date());
        isPaused = true;
        isResumed = false;
    }

    @Override
    public void resume() {
        resumeTimes.add(new Date());
        isResumed = true;
        isPaused = false;
    }

    @Override
    public Date getStartTime() {
        return startTime;
    }

    @Override
    public Date getFinishedTime() {
        return finishTime;
    }

    @Override
    public Date getLastPausedAt() {
        if (pauseTimes.isEmpty()) {
            return null;
        }
        return pauseTimes.get(pauseTimes.size() - 1);
    }

    @Override
    public Date getLastResumedAt() {
        if (resumeTimes.isEmpty()) {
            return null;
        }
        return resumeTimes.get(resumeTimes.size() - 1);
    }

    @Override
    public List<Date> getPauseTimes() {
        return pauseTimes;
    }

    @Override
    public List<Date> getResumeTimes() {
        return resumeTimes;
    }

    @Override
    public boolean isStarted() {
        return isStarted;
    }

    @Override
    public boolean isFinished() {
        return isFinished;
    }

    @Override
    public boolean isPaused() {
        return isPaused;
    }

    @Override
    public boolean isResumed() {
        return isResumed;
    }

    public void setStartTime(Date startTime) {
        this.startTime = startTime;
        Date now = new Date();
        if (startTime.before(now)) {
            isStarted = true;
        }
    }

    public void addPauseTime(Date pause) {
        pauseTimes.add(pause);
        Date now = new Date();
        if (pause.before(now) && getLastResumedAt() != null && pause.after(getLastResumedAt())) {
            isPaused = true;
            isResumed = false;
        }
    }

    public void addResumeTime(Date resume) {
        resumeTimes.add(resume);
        Date now = new Date();
        if (resume.before(now) && getLastPausedAt() != null && resume.after(getLastPausedAt())) {
            isPaused = false;
            isResumed = true;
        }
    }

    public void setFinishTime(Date finishTime) {
        this.finishTime = finishTime;
        isFinished = true;
    }

}
