package com.omfgdevelop.maximtesttask.view;


import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.omfgdevelop.maximtesttask.MainRecyclerViewAdapter;
import com.omfgdevelop.maximtesttask.R;
import com.omfgdevelop.maximtesttask.view.interfaces.MainRecyclerViewFragmentInterface;

import java.util.ArrayList;

public class MainRecyclerViewFragment extends AbstractFragment implements MainRecyclerViewFragmentInterface.View {

    RecyclerView recyclerView;
    MainRecyclerViewAdapter adapter;
ArrayList<Departmet> departmets;
    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        departmets = new ArrayList<>();
        for (int i = 0; i <5 ; i++) {
            ArrayList<EmploeeItem> emploeeItems = new ArrayList<>();
            Departmet departmet = new Departmet();
            departmet.setName("Name "+" "+i+1);
            departmets.add(departmet);
            for (int j = 0; j <10 ; j++) {
                EmploeeItem emploeeItem = new EmploeeItem();
                emploeeItem.setName("Emploee "+i+ " "+j+1);
                emploeeItems.add(emploeeItem);



            }
            departmet.setEmploeeItems(emploeeItems);
        }

    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
      return   super.onCreateView(inflater, container, savedInstanceState);
//    View view = inflater.inflate(R.layout.main_list_fragment,container,false);
//
//    return view;
    }

    @Override
    protected int getLayout() {
        return R.layout.main_list_fragment;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        recyclerView = view.findViewById(R.id.mainRecyclerView);
        adapter = new MainRecyclerViewAdapter(departmets);
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
        recyclerView.setAdapter(adapter);
        recyclerView.setHasFixedSize(true);

    }

}
