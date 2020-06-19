package thesis.whattodo.view.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.NonNull;
import thesis.whattodo.R;
import thesis.whattodo.model.Note;
import thesis.whattodo.model.TodoList;
import thesis.whattodo.view.holder.UserDataItemViewHolder;

import java.util.ArrayList;
import java.util.List;

public class UserDataItemAdapter extends ArrayAdapter<Object> {

    // context
    private final Context context;

    // layout
    private final int layout;

    // layout inflater
    private final LayoutInflater layoutInflater;

    // list of to-do lists or notes
    private final List<Object> todoListsAndNotes;

    // constructors
    public UserDataItemAdapter(Context context, ArrayList<Object> objects) {
        super(context, R.layout.listitem_userdata, objects);
        this.context = context;
        this.layoutInflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        this.layout = R.layout.listitem_userdata;
        this.todoListsAndNotes = objects;
    }

    // get number of both to-do lists and notes
    @Override
    public int getCount() {
        return todoListsAndNotes.size();
    }

    // get to-do list or note
    @Override
    public Object getItem(int position) {
        return todoListsAndNotes.get(position);
    }

    // get to-do list or note position
    @Override
    public long getItemId(int position) {
        return position;
    }

    // get both to-do lists and notes view
    @NonNull
    @Override
    public View getView(int position, View todoListOrNote, @NonNull ViewGroup parent) {
        UserDataItemViewHolder viewHolder;
        if (todoListOrNote == null) {
            todoListOrNote = layoutInflater.inflate(layout, null);
            todoListOrNote.setBackground(context.getApplicationContext().getDrawable(R.drawable.userdataitem_shape));
            viewHolder = new UserDataItemViewHolder();
            viewHolder.setTextTextView((TextView) todoListOrNote.findViewById(R.id.userDataItemText));
            viewHolder.setIconImageView((ImageView) todoListOrNote.findViewById(R.id.userDataIcon));
            todoListOrNote.setTag(viewHolder);
        } else {
            viewHolder = (UserDataItemViewHolder) todoListOrNote.getTag();
        }
        Object object = getItem(position);
        if (object instanceof TodoList) {
            TodoList todoList = (TodoList) object;
            viewHolder.getTextTextView().setText(todoList.getHeader());
            viewHolder.getIconImageView().setBackground(context.getApplicationContext().getDrawable(R.drawable.todolist_icon));
        } else if (object instanceof Note) {
            Note note = (Note) object;
            viewHolder.getTextTextView().setText(note.getHeader());
            viewHolder.getIconImageView().setBackground(context.getApplicationContext().getDrawable(R.drawable.note_icon));
        }
        return todoListOrNote;
    }
}
