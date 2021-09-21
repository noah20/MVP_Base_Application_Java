package com.foxcoders.mvpbaseapplication_java.utils.rx;


import io.reactivex.Scheduler;

public interface ScheduleProvider {
   Scheduler ui();
    Scheduler computation();
    Scheduler io();
}
