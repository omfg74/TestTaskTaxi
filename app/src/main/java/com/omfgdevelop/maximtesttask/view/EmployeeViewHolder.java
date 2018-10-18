package com.omfgdevelop.maximtesttask.view;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.TextView;

import com.omfgdevelop.maximtesttask.R;
import com.omfgdevelop.maximtesttask.model.Emplee.Department;
import com.omfgdevelop.maximtesttask.model.Emplee.Employee;
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
        View view = layoutInflater.inflate(R.layout.employee_layout,null,false);
        TextView idTextView = view.findViewById(R.id.employeeIdTextView);
        TextView nameTextView = view.findViewById(R.id.employeeNameTextView);
        TextView titleTextView = view.findViewById(R.id.employeeTitleTextView);
        TextView emailTextView = view.findViewById(R.id.employeeEmailTextView);
        TextView phoneTextView = view.findViewById(R.id.employeePhoneTextView);

        idTextView.setText(value.getID());
        nameTextView.setText(value.getName());
       titleTextView.setText(value.getTitle());
        emailTextView.setText(value.getEmail());
        phoneTextView.setText(value.getPhone());
        return view;
    }
}
