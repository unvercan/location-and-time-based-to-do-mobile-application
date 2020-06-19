package thesis.whattodo.model;

public class TimeBasedReminder {

    // fields
    private Integer id;

    private Integer minute;

    private Integer hour;

    private Integer dayOfMonth;

    private Integer month;

    private Integer year;

    // constructors
    public TimeBasedReminder() {
    }

    @SuppressWarnings("unused")
    public TimeBasedReminder(Integer id, Integer minute, Integer hour, Integer dayOfMonth, Integer month, Integer year) {
        this.id = id;
        this.minute = minute;
        this.hour = hour;
        this.dayOfMonth = dayOfMonth;
        this.month = month;
        this.year = year;
    }

    // getters
    public Integer getId() {
        return id;
    }

    // setters
    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getMinute() {
        return minute;
    }

    public void setMinute(Integer minute) {
        this.minute = minute;
    }

    public Integer getHour() {
        return hour;
    }

    public void setHour(Integer hour) {
        this.hour = hour;
    }

    public Integer getDayOfMonth() {
        return dayOfMonth;
    }

    public void setDayOfMonth(Integer dayOfMonth) {
        this.dayOfMonth = dayOfMonth;
    }

    public Integer getMonth() {
        return month;
    }

    public void setMonth(Integer month) {
        this.month = month;
    }

    public Integer getYear() {
        return year;
    }

    public void setYear(Integer year) {
        this.year = year;
    }

    // to string
    @Override
    public String toString() {
        return "TimeBasedReminder[id=" + id + ", minute=" + minute + ", hour=" + hour + ", dayOfMonth=" + dayOfMonth + ", month=" + month + ", year=" + year + "]";
    }
}
