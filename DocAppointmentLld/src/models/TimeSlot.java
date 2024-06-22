package models;

import java.time.LocalDateTime;

public class TimeSlot {
    // Can TimeSlot be a enum ? => No even if  Fixed set of values 9AM to 9PM => No
    // Do I need a end time as the slot size is fixed as 30 mins => Yes Need it at least to show the details on the UI
    // 30 mins slots can be changed to 15 min slots or 10 mins slots => Keep the start and end time and this class as well
    // Can we implement a system where slots are not present => Out of Scope Don;t think about it

    private LocalDateTime start;
    private LocalDateTime end;

    public TimeSlot(LocalDateTime start, LocalDateTime end) {
        this.start = start;
        this.end = end;
    }

    public LocalDateTime getStart() {
        return start;
    }

    public void setStart(LocalDateTime start) {
        this.start = start;
    }

    public LocalDateTime getEnd() {
        return end;
    }

    public void setEnd(LocalDateTime end) {
        this.end = end;
    }

}
