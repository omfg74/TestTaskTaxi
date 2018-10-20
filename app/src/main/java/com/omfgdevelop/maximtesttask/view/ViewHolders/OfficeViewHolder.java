package com.omfgdevelop.maximtesttask.view.ViewHolders;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.TextView;

import com.omfgdevelop.maximtesttask.R;
import com.omfgdevelop.maximtesttask.model.Emplee.Office;
import com.unnamed.b.atv.model.TreeNode;

public class OfficeViewHolder extends TreeNode.BaseNodeViewHolder<Office> {
    Context context;
    public OfficeViewHolder(Context context) {
        super(context);
        this.context = context;
    }

    @Override
    public View createNodeView(TreeNode node, Office value) {
        LayoutInflater layoutInflater = LayoutInflater.from(context);
        View view = layoutInflater.inflate(R.layout.offcie_layout,null,false);
        TextView idTextView = view.findViewById(R.id.office_id_textView);
        TextView nameTextView = view.findViewById(R.id.offoceNameTextView);

        idTextView.setText("ID "+value.getID());
        nameTextView.setText("Name "+value.getName());
        nameTextView.setTextSize(20);
        return view;
    }


}
