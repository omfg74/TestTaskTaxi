package com.omfgdevelop.maximtesttask.view.ViewHolders;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;

import com.omfgdevelop.maximtesttask.R;
import com.unnamed.b.atv.model.TreeNode;

public class RootViewHolder extends TreeNode.BaseNodeViewHolder {
    Context context;
    public RootViewHolder(Context context) {
        super(context);
        this.context = context;
    }

    @Override
    public View createNodeView(TreeNode node, Object value) {
        LayoutInflater layoutInflater = LayoutInflater.from(context);
        View view = layoutInflater.inflate(R.layout.root_view,null,false);
        return view;
    }
}
