package thesis.whattodo.view.holder;

import android.view.View;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.TextView;
import thesis.whattodo.R;

public class TodoItemViewHolder {

    // fields
    private CheckBox isDoneCheckBox;

    private TextView numberTextView;

    private EditText textEditText;

    // constructors
    public TodoItemViewHolder() {
    }

    @SuppressWarnings("unused")
    public TodoItemViewHolder(View todoItemView) {
        this.numberTextView = (TextView) todoItemView.findViewById(R.id.todoItemNumber);
        this.textEditText = (EditText) todoItemView.findViewById(R.id.todoItemText);
        this.isDoneCheckBox = (CheckBox) todoItemView.findViewById(R.id.todoItemIsDone);
    }

    // getters
    public CheckBox getIsDoneCheckBox() {
        return isDoneCheckBox;
    }

    // setters
    public void setIsDoneCheckBox(CheckBox isDoneCheckBox) {
        this.isDoneCheckBox = isDoneCheckBox;
    }

    public TextView getNumberTextView() {
        return numberTextView;
    }

    public void setNumberTextView(TextView numberTextView) {
        this.numberTextView = numberTextView;
    }

    public EditText getTextEditText() {
        return textEditText;
    }

    public void setTextEditText(EditText textEditText) {
        this.textEditText = textEditText;
    }
}
