package thesis.whattodo.model;

import java.util.ArrayList;
import java.util.List;

public class TodoList {

    // fields
    private Integer id;

    private String header;

    private List<TodoItem> todoItems;

    private LocationBasedReminder locationBasedReminder;

    private TimeBasedReminder timeBasedReminder;

    // constructors
    public TodoList() {
        this.todoItems = new ArrayList<>();
    }

    @SuppressWarnings("unused")
    public TodoList(Integer id, String header, List<TodoItem> todoItems, LocationBasedReminder locationBasedReminder, TimeBasedReminder timeBasedReminder) {
        this.id = id;
        this.header = header;
        this.todoItems = todoItems;
        this.locationBasedReminder = locationBasedReminder;
        this.timeBasedReminder = timeBasedReminder;
    }

    // getters
    public Integer getId() {
        return id;
    }

    // setters
    public void setId(Integer id) {
        this.id = id;
    }

    public String getHeader() {
        return header;
    }

    public void setHeader(String header) {
        this.header = header;
    }

    public List<TodoItem> getTodoItems() {
        return todoItems;
    }

    public void setTodoItems(List<TodoItem> todoItems) {
        this.todoItems = todoItems;
    }

    public LocationBasedReminder getLocationBasedReminder() {
        return locationBasedReminder;
    }

    public void setLocationBasedReminder(LocationBasedReminder locationBasedReminder) {
        this.locationBasedReminder = locationBasedReminder;
    }

    public TimeBasedReminder getTimeBasedReminder() {
        return timeBasedReminder;
    }

    public void setTimeBasedReminder(TimeBasedReminder timeBasedReminder) {
        this.timeBasedReminder = timeBasedReminder;
    }

    // to string
    @Override
    public String toString() {
        return "TodoList[id=" + id + ", header=" + header + ", todoItems=" + todoItems + ", locationBasedReminder=" + locationBasedReminder + ", timeBasedReminder=" + timeBasedReminder + "]";
    }
}
