package com.example.demo.utils;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.TimeUnit;

/**
 * @Author: bruceyang
 * @Description: <一句话描述该类功能/>
 * @Date: Created in 17:58 2022/4/20
 * @Modified By:
 */
public enum MyTimeUtil {

    SECONDS{
        int excessNanos(long d, long m) { return 0; }
    },
    MINUTES{
        int excessNanos(long d, long m) { return 0; }
    };

    static final long C0 = 1L;
    static final long C1 = C0 * 1000L;
    static final long C2 = C1 * 1000L;
    static final long C3 = C2 * 1000L;
    static final long C4 = C3 * 60L;
    static final long C5 = C4 * 60L;
    static final long C6 = C5 * 24L;

    static final long MAX = Long.MAX_VALUE;

    static long x(long d, long m, long over) {
        if (d >  over) return Long.MAX_VALUE;
        if (d < -over) return Long.MIN_VALUE;
        return d * m;
    }

    public long convert(long sourceDuration, TimeUnit sourceUnit) {
        throw new AbstractMethodError();
    }

    /**
     * Equivalent to
     * {@link #convert(long, TimeUnit) NANOSECONDS.convert(duration, this)}.
     * @param duration the duration
     * @return the converted duration,
     * or {@code Long.MIN_VALUE} if conversion would negatively
     * overflow, or {@code Long.MAX_VALUE} if it would positively overflow.
     */
    public long toNanos(long duration) {
        throw new AbstractMethodError();
    }

    /**
     * Equivalent to
     * {@link #convert(long, TimeUnit) MICROSECONDS.convert(duration, this)}.
     * @param duration the duration
     * @return the converted duration,
     * or {@code Long.MIN_VALUE} if conversion would negatively
     * overflow, or {@code Long.MAX_VALUE} if it would positively overflow.
     */
    public long toMicros(long duration) {
        throw new AbstractMethodError();
    }

    /**
     * Equivalent to
     * {@link #convert(long, TimeUnit) MILLISECONDS.convert(duration, this)}.
     * @param duration the duration
     * @return the converted duration,
     * or {@code Long.MIN_VALUE} if conversion would negatively
     * overflow, or {@code Long.MAX_VALUE} if it would positively overflow.
     */
    public long toMillis(long duration) {
        throw new AbstractMethodError();
    }

    /**
     * Equivalent to
     * {@link #convert(long, TimeUnit) SECONDS.convert(duration, this)}.
     * @param duration the duration
     * @return the converted duration,
     * or {@code Long.MIN_VALUE} if conversion would negatively
     * overflow, or {@code Long.MAX_VALUE} if it would positively overflow.
     */
    public long toSeconds(long duration) {
        throw new AbstractMethodError();
    }

    /**
     * Equivalent to
     * {@link #convert(long, TimeUnit) MINUTES.convert(duration, this)}.
     * @param duration the duration
     * @return the converted duration,
     * or {@code Long.MIN_VALUE} if conversion would negatively
     * overflow, or {@code Long.MAX_VALUE} if it would positively overflow.
     * @since 1.6
     */
    public long toMinutes(long duration) {
        throw new AbstractMethodError();
    }

    /**
     * Equivalent to
     * {@link #convert(long, TimeUnit) HOURS.convert(duration, this)}.
     * @param duration the duration
     * @return the converted duration,
     * or {@code Long.MIN_VALUE} if conversion would negatively
     * overflow, or {@code Long.MAX_VALUE} if it would positively overflow.
     * @since 1.6
     */
    public long toHours(long duration) {
        throw new AbstractMethodError();
    }

    /**
     * Equivalent to
     * {@link #convert(long, TimeUnit) DAYS.convert(duration, this)}.
     * @param duration the duration
     * @return the converted duration
     * @since 1.6
     */
    public long toDays(long duration) {
        throw new AbstractMethodError();
    }

    /**
     * Utility to compute the excess-nanosecond argument to wait,
     * sleep, join.
     * @param d the duration
     * @param m the number of milliseconds
     * @return the number of nanoseconds
     */
    abstract int excessNanos(long d, long m);

    /**
     * Performs a timed {@link Object#wait(long, int) Object.wait}
     * using this time unit.
     * This is a convenience method that converts timeout arguments
     * into the form required by the {@code Object.wait} method.
     *
     * <p>For example, you could implement a blocking {@code poll}
     * method (see {@link BlockingQueue#poll BlockingQueue.poll})
     * using:
     *
     *  <pre> {@code
     * public synchronized Object poll(long timeout, TimeUnit unit)
     *     throws InterruptedException {
     *   while (empty) {
     *     unit.timedWait(this, timeout);
     *     ...
     *   }
     * }}</pre>
     *
     * @param obj the object to wait on
     * @param timeout the maximum time to wait. If less than
     * or equal to zero, do not wait at all.
     * @throws InterruptedException if interrupted while waiting
     */
    public void timedWait(Object obj, long timeout)
            throws InterruptedException {
        if (timeout > 0) {
            long ms = toMillis(timeout);
            int ns = excessNanos(timeout, ms);
            obj.wait(ms, ns);
        }
    }

    /**
     * Performs a timed {@link Thread#join(long, int) Thread.join}
     * using this time unit.
     * This is a convenience method that converts time arguments into the
     * form required by the {@code Thread.join} method.
     *
     * @param thread the thread to wait for
     * @param timeout the maximum time to wait. If less than
     * or equal to zero, do not wait at all.
     * @throws InterruptedException if interrupted while waiting
     */
    public void timedJoin(Thread thread, long timeout)
            throws InterruptedException {
        if (timeout > 0) {
            long ms = toMillis(timeout);
            int ns = excessNanos(timeout, ms);
            thread.join(ms, ns);
        }
    }

    /**
     * Performs a {@link Thread#sleep(long, int) Thread.sleep} using
     * this time unit.
     * This is a convenience method that converts time arguments into the
     * form required by the {@code Thread.sleep} method.
     *
     * @param timeout the minimum time to sleep. If less than
     * or equal to zero, do not sleep at all.
     * @throws InterruptedException if interrupted while sleeping
     */
    public void sleep(long timeout) throws InterruptedException {
        if (timeout > 0) {
            long ms = toMillis(timeout);
            int ns = excessNanos(timeout, ms);
            Thread.sleep(ms, ns);
        }
    }
}
