package com.omfgdevelop.maximtesttask.view.ViewHolders;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.TextView;

import com.omfgdevelop.maximtesttask.R;
import com.omfgdevelop.maximtesttask.model.Employee.Employee;
import com.unnamed.b.atv.model.TreeNode;

public class EmployeeViewHolder extends TreeNode.BaseNodeViewHolder<Employee> {
    Context context;

    public EmployeeViewHolder(Context context) {
        super(context);
        this.context = context;
    }

    @Override
    public View createNodeView(TreeNode node, Employee value) {
        LayoutInflater layoutInflater = LayoutInflater.from(context);
        View view = layoutInflater.inflate(R.layout.employee_layout, null, false);
        TextView idTextView = view.findViewById(R.id.employeeIdTextView);
        TextView nameTextView = view.findViewById(R.id.employeeNameTextView);


        idTextView.setText(value.getID());
        nameTextView.setText(value.getName());

        return view;
    }
}
