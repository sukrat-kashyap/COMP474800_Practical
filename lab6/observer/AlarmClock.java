
public class AlarmClock extends Subject {

    private int hours, minutes, seconds;
    private int alarmHours, alarmMinutes, alarmSeconds;

    public AlarmClock() {
        hours = 0;
        minutes = 0;
        seconds = 0;
        alarmHours = 0;
        alarmMinutes = 0;
        alarmSeconds = 0;
    }

    public void setTime(int hrs, int mins, int secs) {
        hours = hrs;
        minutes = mins;
        seconds = secs;
    }

    public void setAlarmTime(int hrs, int mins, int secs) {
        alarmHours = hrs;
        alarmMinutes = mins;
        alarmSeconds = secs;
    }

    public void tick() {
        if ((seconds += 1) == 60) {
            seconds = 0;
            if ((minutes += 1) == 60) {
                minutes = 0;
                if ((hours += 1) == 24) {
                    hours = 0;
                }
            }
        }
        // System.out.println("The time is: " + getTime());
        notifyObservers();
    }

    public String getTime() {
        return Integer.toString(hours) + ":" + Integer.toString(minutes) + ":" + Integer.toString(seconds);
    }

    public boolean alarmReached() {
        return (hours == alarmHours && minutes == alarmMinutes && seconds == alarmSeconds);
    }

    public boolean timeIs(int h, int m, int s) {
        return (hours == h && minutes == m && seconds == s);
    }
}