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

import com.omfgdevelop.maximtesttask.model.Emplee.EmployeeData;

import java.util.ArrayList;
import java.util.List;

public class MainRecyclerViewAdapter extends RecyclerView.Adapter<MainRecyclerViewAdapter.MainViewHolder> {

    private EmployeeData emoleeDataArrayList;

    public MainRecyclerViewAdapter(EmployeeData emoleeDataArrayList) {
        this.emoleeDataArrayList = emoleeDataArrayList;
    }

    @NonNull
    @Override
    public MainViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.list_item,parent,false);
        return new MainViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MainViewHolder holder, int position) {

        EmployeeData emoleeData = emoleeDataArrayList;
        holder.departmentTextView.setText(emoleeData.getName());
        Log.d("recycler ", emoleeDataArrayList.getName());

        int emploeeTextView = holder.linearLayout.getChildCount();
        int numberOfEmplee = emoleeData.getOffices().size();//размеры подразделений
        if(numberOfEmplee<emploeeTextView){
            for (int i = numberOfEmplee; i<emploeeTextView; i++) {
                TextView textView = (TextView) holder.linearLayout.getChildAt(i);
                textView.setVisibility(View.GONE);

            }
        }
        for (int j = 0; j < numberOfEmplee; j++) {
            TextView textView = (TextView) holder.linearLayout.getChildAt(j);
            textView.setText(emoleeData.getOffices().get(j).getName());//размеры подразделений

        }
    }

    @Override
    public int getItemCount() {
        System.out.println(emoleeDataArrayList.getOffices().size());
        return emoleeDataArrayList.getOffices().size();
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
            for (int i = 0; i < emoleeDataArrayList.getOffices().size(); i++) {
//                int t = emoleeDataArrayList.getDepartments().get(i).getDepartments().size();
//                if (t>emploees){
//                    emploees=t;
//                }

            }
            for (int i = 0; i < emploees ; i++) {
                TextView textView = new TextView(context);
                textView.setId(i);
                textView.setPadding(0,20,0,20);
                textView.setGravity(Gravity.CENTER);
                LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(LinearLayout.LayoutParams.MATCH_PARENT,LinearLayout.LayoutParams.WRAP_CONTENT);
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
