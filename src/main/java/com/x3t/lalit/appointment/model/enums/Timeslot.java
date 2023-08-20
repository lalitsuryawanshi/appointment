package com.x3t.lalit.appointment.model.enums;

public enum Timeslot {
    AM(8, 12),
    PM(12,16),
    EV(16,20);

    final int startTime;
    final int endTime;

    Timeslot(int startTime, int endTime) {
        this.startTime = startTime;
        this.endTime = endTime;
    }
}
