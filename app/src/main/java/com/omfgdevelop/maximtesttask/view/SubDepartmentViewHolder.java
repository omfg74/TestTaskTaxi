package com.omfgdevelop.maximtesttask.view;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.TextView;

import com.omfgdevelop.maximtesttask.R;
import com.omfgdevelop.maximtesttask.model.Emplee.Department;
import com.omfgdevelop.maximtesttask.model.Emplee.SubDepartment;
import com.unnamed.b.atv.model.TreeNode;

public class SubDepartmentViewHolder extends TreeNode.BaseNodeViewHolder<SubDepartment> {
    Context context;
    public SubDepartmentViewHolder(Context context) {
        super(context);
        this.context = context;
    }

    @Override
    public View createNodeView(TreeNode node, SubDepartment value) {
        LayoutInflater layoutInflater = LayoutInflater.from(context);
        View view = layoutInflater.inflate(R.layout.offcie_layout,null,false);
        TextView idTextView = view.findViewById(R.id.office_id_textView);
        TextView nameTextView = view.findViewById(R.id.offoceNameTextView);

        idTextView.setText(value.getID());
        nameTextView.setText(value.getName());
        return view;
    }
}
