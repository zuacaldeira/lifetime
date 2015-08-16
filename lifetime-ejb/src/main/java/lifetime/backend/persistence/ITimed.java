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
public interface ITimed {

    public void start();

    public void finish();

    public void pause();

    public void resume();

    public Date getStartTime();

    public Date getFinishedTime();

    public Date getLastPausedAt();

    public Date getLastResumedAt();

    public List<Date> getPauseTimes();

    public List<Date> getResumeTimes();

    public boolean isStarted();

    public boolean isFinished();

    public boolean isPaused();

    public boolean isResumed();

}
