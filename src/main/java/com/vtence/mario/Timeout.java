package com.vtence.mario;

public class Timeout {
    private final long duration;
    private final long start;

    public Timeout(long durationMillis) {
        this.duration = durationMillis;
        this.start = System.currentTimeMillis();
    }

    public boolean hasElapsed() {
        final long now = System.currentTimeMillis();
        return (now - start) > duration;
    }
}