package com.omfgdevelop.maximtesttask.view.ViewHolders;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.TextView;

import com.omfgdevelop.maximtesttask.R;
import com.omfgdevelop.maximtesttask.model.Emplee.Department;
import com.omfgdevelop.maximtesttask.model.Emplee.EmployeeData;
import com.unnamed.b.atv.model.TreeNode;

public class EmployeeDaatViewHolder extends TreeNode.BaseNodeViewHolder<EmployeeData> {
    Context context;
    public EmployeeDaatViewHolder(Context context) {
        super(context);
        this.context = context;
    }

    @Override
    public View createNodeView(TreeNode node, EmployeeData value) {
        LayoutInflater layoutInflater = LayoutInflater.from(context);
        View view = layoutInflater.inflate(R.layout.offcie_layout,null,false);
        TextView idTextView = view.findViewById(R.id.office_id_textView);
        TextView nameTextView = view.findViewById(R.id.offoceNameTextView);

//        idTextView.setText(value.getID());
        nameTextView.setText(value.getName()+" оффисы");
        nameTextView.setTextSize(27);
        return view;
    }
}
