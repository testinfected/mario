package com.vtence.mario;

/**
 * The default Prober. Just applies a probe without any further synchronization.
 */
public class UnsynchronizedProber extends PollingProber {
    public UnsynchronizedProber(long timeoutMillis, long pollDelayMillis) {
        super(timeoutMillis, pollDelayMillis, Probe::probe);
    }
}
