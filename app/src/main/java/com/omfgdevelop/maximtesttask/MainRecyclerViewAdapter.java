package com.omfgdevelop.maximtesttask;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.omfgdevelop.maximtesttask.model.Emplee.Department;
import com.omfgdevelop.maximtesttask.model.Emplee.EmployeeData;
import com.omfgdevelop.maximtesttask.model.Emplee.Office;

import java.util.List;

public class MainRecyclerViewAdapter extends RecyclerView.Adapter<MainRecyclerViewAdapter.MainViewHolder> {

    private EmployeeData employeeData;

    public MainRecyclerViewAdapter(EmployeeData employeeData) {
        this.employeeData = employeeData;
    }

    @NonNull
    @Override
    public MainViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.list_item,parent,false);
        return new MainViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MainViewHolder holder, int position) {

        //if not null?
        holder.departmentTextView.setText(employeeData.getOffices().get(position).getName());
        Log.d("recycler ", employeeData.getOffices().get(position).getName());

        List<Office> officeList = employeeData.getOffices();//достаем оффсы
        if(employeeData.getOffices().get(position).getDepartments()!=null){
        List<Department> departmentList  = employeeData.getOffices().get(position).getDepartments();

        int emploeeTextView = holder.linearLayout.getChildCount();
        int numberOfEmplee = officeList.get(position).getDepartments().size();//размеры подразделений
        if(numberOfEmplee<emploeeTextView){
            for (int i = numberOfEmplee; i<emploeeTextView; i++) {
                TextView textView = (TextView) holder.linearLayout.getChildAt(i);
                textView.setVisibility(View.GONE);

            }
        }
        for (int j = 0; j < numberOfEmplee; j++) {
            TextView textView = (TextView) holder.linearLayout.getChildAt(j);
            if(officeList.get(j).getDepartments()!=null) {
                textView.setText(officeList.get(j).getDepartments().get(position).getName());//размеры подразделений
            }
        }
        }else {
            Log.d("Department ","Nulled department "+employeeData.getOffices().get(position).getDepartments());
        }
    }

    @Override
    public int getItemCount() {
        return employeeData.getOffices().size();
        }

    class MainViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener{

        private Context context;
        private TextView departmentTextView;
        private LinearLayout linearLayout;

        public MainViewHolder(View itemView) {
            super(itemView);
            context = itemView.getContext();
            departmentTextView = itemView.findViewById(R.id.departmentNametextView);
            linearLayout  =itemView.findViewById(R.id.emploee_item);
            linearLayout.setVisibility(View.GONE);
            int emploees = 0;

            for (int i = 0; i < employeeData.getOffices().size(); i++) {
                if(employeeData.getOffices().get(i).getDepartments()!=null){
                int t = employeeData.getOffices().get(i).getDepartments().size();
                if (t>emploees){
                    emploees=t;
                }
                }else {
                    Log.d("Office ", "Null Office "+employeeData.getOffices().get(i).getName());
                }

            }
            for (int i = 0; i < emploees ; i++) {
                TextView textView = new TextView(context);
                textView.setId(i);
                textView.setPadding(0,20,0,20);
                textView.setGravity(Gravity.CENTER_HORIZONTAL);
                LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(LinearLayout.LayoutParams.WRAP_CONTENT,LinearLayout.LayoutParams.WRAP_CONTENT);
                textView.setOnClickListener(this);
                linearLayout.addView(textView, layoutParams);

            }
            departmentTextView.setOnClickListener(this);
        }

        @Override
        public void onClick(View view) {

            if(view.getId()==R.id.departmentNametextView) {
                if(linearLayout.getVisibility()==View.VISIBLE){
                    linearLayout.setVisibility(View.GONE);

                }else {
                    linearLayout.setVisibility(View.VISIBLE);

                }

            }else {
                TextView textView = (TextView)view;
                Toast.makeText(context,""+textView.getText().toString(), Toast.LENGTH_SHORT).show();
            }
        }
    }
}
