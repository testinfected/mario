package com.vtence.mario;

import org.hamcrest.StringDescription;

/**
 * Supporting class for Probers that repeatedly apply a probe until it succeeds or times out.
 */
public class PollingProber implements Prober {
    @FunctionalInterface
    public interface ProbeRunner {
        /**
         * Apply the given probe within the polling loop.
         * @param probe The probe to apply.
         */
        void run(Probe probe);
    }

    private final long timeoutMillis;
    private final long pollDelayMillis;
    private final ProbeRunner runner;

    public PollingProber(long timeoutMillis, long pollDelayMillis, ProbeRunner runner) {
        this.timeoutMillis = timeoutMillis;
        this.pollDelayMillis = pollDelayMillis;
        this.runner = runner;
    }

    public void check(Probe probe) {
        if (!poll(probe)) {
            throw new AssertionError(failureDescriptionOf(probe));
        }
    }

    private boolean poll(Probe probe) {
        final Timeout timeout = new Timeout(timeoutMillis);

        while (true) {
            runner.run(probe);

            if (probe.isSatisfied()) {
                return true;
            }
            if (timeout.hasElapsed()) {
                return false;
            }
            waitFor(pollDelayMillis);
        }
    }

    private void waitFor(long duration) {
        try {
            Thread.sleep(duration);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
            throw new IllegalStateException("Prober interrupted", e);
        }
    }

    private static String failureDescriptionOf(Probe probe) {
        final StringDescription description = new StringDescription();

        description.appendText("\nTried to:\n    ")
                   .appendDescriptionOf(probe)
                   .appendText("\nbut:\n    ");
        probe.describeFailureTo(description);

        return description.toString();
    }
}