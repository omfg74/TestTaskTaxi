package com.omfgdevelop.maximtesttask.view.ViewHolders;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.TextView;

import com.omfgdevelop.maximtesttask.R;
import com.omfgdevelop.maximtesttask.model.Employee.Employee_;
import com.unnamed.b.atv.model.TreeNode;

public class Employee_ViewHolder extends TreeNode.BaseNodeViewHolder<Employee_> {
    Context context;
    public Employee_ViewHolder(Context context) {
        super(context);
        this.context = context;
    }

    @Override
    public View createNodeView(TreeNode node, Employee_ value) {
        LayoutInflater layoutInflater = LayoutInflater.from(context);
        View view = layoutInflater.inflate(R.layout.employee_layout,null,false);
        TextView idTextView = view.findViewById(R.id.employeeIdTextView);
        TextView nameTextView = view.findViewById(R.id.employeeNameTextView);


        System.out.println("TEST ID"+value.getID());
        System.out.println("TEST NAME"+value.getName());
        idTextView.setText(value.getID());
        nameTextView.setText(value.getName());
        return view;
    }
}
