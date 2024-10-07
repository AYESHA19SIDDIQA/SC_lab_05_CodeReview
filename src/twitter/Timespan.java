package twitter;

import java.time.Instant;

public class Timespan {
    private final Instant start;
    private final Instant end;

    /**
     * Construct a Timespan.
     * 
     * @param start the start time of the timespan
     * @param end the end time of the timespan
     */
    public Timespan(Instant start, Instant end) {
        this.start = start;
        this.end = end;
    }

    /**
     * @return the start time of the timespan
     */
    public Instant getStart() {
        return start;
    }

    /**
     * @return the end time of the timespan
     */
    public Instant getEnd() {
        return end;
    }

    /**
     * Check if the given time is within this timespan.
     * 
     * @param time the time to check
     * @return true if the time is within the timespan (inclusive), false otherwise
     */
    public boolean contains(Instant time) {
        return !time.isBefore(start) && !time.isAfter(end);
    }
}
