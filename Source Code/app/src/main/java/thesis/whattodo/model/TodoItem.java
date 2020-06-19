package thesis.whattodo.model;

public class TodoItem {

    // fields
    private Integer id;

    private String text;

    private Boolean isDone;

    // constructors
    public TodoItem() {
    }

    @SuppressWarnings("unused")
    public TodoItem(Integer id, String text, Boolean isDone) {
        this.id = id;
        this.text = text;
        this.isDone = isDone;
    }

    // getters
    public Integer getId() {
        return id;
    }

    // setters
    public void setId(Integer id) {
        this.id = id;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public Boolean isDone() {
        return isDone;
    }

    public void setDone(Boolean done) {
        this.isDone = done;
    }

    // to string
    @Override
    public String toString() {
        return "TodoItem[id=" + id + ", text=" + text + ", isDone=" + isDone + "]";
    }
}
