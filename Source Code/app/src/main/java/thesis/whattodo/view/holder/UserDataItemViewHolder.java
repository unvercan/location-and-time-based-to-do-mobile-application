package thesis.whattodo.view.holder;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import thesis.whattodo.R;

public class UserDataItemViewHolder {

    // fields
    private ImageView iconImageView;

    private TextView textTextView;

    // constructors
    public UserDataItemViewHolder() {
    }

    @SuppressWarnings("unused")
    public UserDataItemViewHolder(View userDataItemView) {
        this.textTextView = (TextView) userDataItemView.findViewById(R.id.userDataItemText);
        this.iconImageView = (ImageView) userDataItemView.findViewById(R.id.userDataIcon);
    }

    // getters
    public ImageView getIconImageView() {
        return iconImageView;
    }

    // setters
    public void setIconImageView(ImageView iconImageView) {
        this.iconImageView = iconImageView;
    }

    public TextView getTextTextView() {
        return textTextView;
    }

    public void setTextTextView(TextView textTextView) {
        this.textTextView = textTextView;
    }
}
