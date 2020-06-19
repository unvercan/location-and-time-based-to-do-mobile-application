package thesis.whattodo.view.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.*;
import androidx.annotation.NonNull;
import thesis.whattodo.R;
import thesis.whattodo.model.TodoItem;
import thesis.whattodo.model.TodoList;
import thesis.whattodo.util.db.DatabaseHelper;
import thesis.whattodo.view.holder.TodoItemViewHolder;

public class TodoListAdapter extends ArrayAdapter<TodoItem> {

    // context
    private final Context context;

    // layout
    private final int layout;

    // layout inflater
    private final LayoutInflater layoutInflater;

    // to-do list
    private final TodoList todoList;

    // constructors
    public TodoListAdapter(Context context, TodoList todoList) {
        super(context, R.layout.listitem_todoitem, todoList.getTodoItems());
        this.context = context;
        this.layoutInflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        this.layout = R.layout.listitem_todoitem;
        this.todoList = todoList;
    }

    // get number of to-do items in to-do list
    @Override
    public int getCount() {
        return todoList.getTodoItems().size();
    }

    // get to-do item in to-do list
    @Override
    public TodoItem getItem(int position) {
        return todoList.getTodoItems().get(position);
    }

    // get to-do item position
    @Override
    public long getItemId(int position) {
        return position;
    }

    // get to-do list view
    @NonNull
    @Override
    public View getView(int position, View todoItemView, @NonNull ViewGroup parent) {
        final TodoItemViewHolder viewHolder;
        if (todoItemView == null) {
            todoItemView = layoutInflater.inflate(layout, null);
            todoItemView.setBackground(context.getApplicationContext().getDrawable(R.drawable.todoitem_shape));
            viewHolder = new TodoItemViewHolder();
            viewHolder.setNumberTextView((TextView) todoItemView.findViewById(R.id.todoItemNumber));
            viewHolder.setTextEditText((EditText) todoItemView.findViewById(R.id.todoItemText));
            viewHolder.setIsDoneCheckBox((CheckBox) todoItemView.findViewById(R.id.todoItemIsDone));
            todoItemView.setTag(viewHolder);
        } else {
            viewHolder = (TodoItemViewHolder) todoItemView.getTag();
        }
        final TodoItem todoItem = getItem(position);
        if (todoItem != null) {
            viewHolder.getNumberTextView().setText(String.valueOf(position + 1));
            viewHolder.getTextEditText().setText(todoItem.getText());
            viewHolder.getIsDoneCheckBox().setChecked(todoItem.isDone());
            viewHolder.getTextEditText().setOnFocusChangeListener(new View.OnFocusChangeListener() {
                @Override
                public void onFocusChange(View editTextView, boolean hasFocus) {
                    DatabaseHelper databaseHelper = DatabaseHelper.getInstance(context.getApplicationContext());
                    TodoItem temp = new TodoItem();
                    temp.setId(todoItem.getId());
                    temp.setText(((EditText) editTextView).getText().toString());
                    temp.setDone(todoItem.isDone());
                    if (!hasFocus && !todoItem.equals(temp)) {
                        if (temp.getText().isEmpty()) {
                            Toast.makeText(context, "To-do item cannot be empty!", Toast.LENGTH_LONG).show();
                            viewHolder.getTextEditText().setText(todoItem.getText());
                        } else {
                            todoItem.setText(temp.getText());
                            if (todoItem.getId() == -1 && todoList.getId() == -1) {
                                Toast.makeText(context, "To-do list should be created firstly!", Toast.LENGTH_LONG).show();
                            } else if (todoItem.getId() != -1 && todoList.getId() != -1) {
                                if (!databaseHelper.updateTodoItem(todoItem)) {
                                    Toast.makeText(context, "To-do item data error!", Toast.LENGTH_LONG).show();
                                } else {
                                    Toast.makeText(context, "To-do item is updated.", Toast.LENGTH_LONG).show();
                                }
                            } else if (todoItem.getId() == -1 && todoList.getId() != -1) {
                                if (!databaseHelper.createTodoItem(todoItem, todoList.getId())) {
                                    Toast.makeText(context, "To-do item data error!", Toast.LENGTH_LONG).show();
                                } else {
                                    Toast.makeText(context, "To-do item is created.", Toast.LENGTH_LONG).show();
                                }
                            }
                        }
                    }
                }
            });
            viewHolder.getIsDoneCheckBox().setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
                @Override
                public void onCheckedChanged(CompoundButton checkBoxView, boolean isChecked) {
                    DatabaseHelper databaseHelper = DatabaseHelper.getInstance(context.getApplicationContext());
                    todoItem.setDone(isChecked);
                    if (todoItem.getId() == -1 && todoList.getId() == -1) {
                        Toast.makeText(context, "To-do list should be created firstly!", Toast.LENGTH_LONG).show();
                    } else if (todoItem.getId() != -1 && todoList.getId() != -1) {
                        if (!databaseHelper.updateTodoItem(todoItem)) {
                            Toast.makeText(context, "To-do item data error!", Toast.LENGTH_LONG).show();
                        } else if (isChecked) {
                            Toast.makeText(context, "To-do item is done.", Toast.LENGTH_LONG).show();
                        } else {
                            Toast.makeText(context, "To-do item is undone.", Toast.LENGTH_LONG).show();
                        }
                    } else if (todoItem.getId() == -1 && todoList.getId() != -1) {
                        if (!databaseHelper.createTodoItem(todoItem, todoList.getId())) {
                            Toast.makeText(context, "To-do item data error!", Toast.LENGTH_LONG).show();
                        } else if (isChecked) {
                            Toast.makeText(context, "To-do item is done.", Toast.LENGTH_LONG).show();
                        } else {
                            Toast.makeText(context, "To-do item is undone.", Toast.LENGTH_LONG).show();
                        }
                    }
                }
            });
        }
        return todoItemView;
    }
}
