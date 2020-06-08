package test;

import exception.DayHalfException;
import exception.HourException;
import exception.MinuteException;
import exception.TimeException;

public class TimeOfDay {
    private String time;

    public String getTime() {
        return time;
    }

    public void setTimeTo(String timeString) throws TimeException {
        timeString = timeString.toLowerCase();
        String[] parts = timeString.split(":");
        if (parts.length != 2)
            throw new TimeException();
        if (parts[0].matches(".*\\D+.*")) {
            throw new HourException();
        }
        int hour = Integer.parseInt(parts[0]);
        if (hour > 12 || hour < 1) {
            throw new HourException();
        }
        String minute = parts[1].substring(0, parts[1].length() - 2);
        String half = parts[1].substring(parts[1].length() - 2);
        if (minute.matches(".*\\D+.*"))
            throw new MinuteException();
        int minuteNum = 0;
        try {
            minuteNum = Integer.parseInt(minute);
        } catch (NumberFormatException ex) {
            throw new TimeException();
        }
        if (minuteNum > 59 || minuteNum < 0)
            throw new MinuteException();
        if (half.length() > 2 || (!half.matches("am") && !half.matches("pm")))
            throw new DayHalfException();
        this.time = timeString;
    }
}
