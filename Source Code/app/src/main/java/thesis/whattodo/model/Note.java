package thesis.whattodo.model;

public class Note {

    // fields
    private Integer id;

    private String header;

    private String text;

    // constructors
    public Note() {
    }

    @SuppressWarnings("unused")
    public Note(Integer id, String header, String text) {
        this.id = id;
        this.header = header;
        this.text = text;
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

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    // to string
    @Override
    public String toString() {
        return "Note[id=" + id + ", header=" + header + ", text=" + text + "]";
    }
}
