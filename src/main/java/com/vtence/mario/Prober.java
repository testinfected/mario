package com.vtence.mario;

@FunctionalInterface
public interface Prober {
    /**
     * Apply the given probe, which might trigger a failure if it's not satisfied.
     * @param probe The probe to apply.
     */
    void check(Probe probe);
}