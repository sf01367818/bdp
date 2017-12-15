package com.sf.bdp.marathon;

import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

/**
 * Created by 01369308 on 2017/12/15.
 */
public final class SchedulerTaskExecutor {
    private SchedulerTaskExecutor() {}
    private static final SchedulerTaskExecutor instance = new SchedulerTaskExecutor();
    public static SchedulerTaskExecutor getInstance() {
        return instance;
    }

    private ScheduledExecutorService threadPool = Executors.newScheduledThreadPool(1);

    public void execute(Runnable command, long initialDelay, long period, TimeUnit unit) {
        threadPool.scheduleAtFixedRate(command, initialDelay, period, unit);
    }
}
