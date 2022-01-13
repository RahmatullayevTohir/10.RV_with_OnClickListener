package com.example.a10rv_with_onclicklistener.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.a10rv_with_onclicklistener.MainActivity;
import com.example.a10rv_with_onclicklistener.R;
import com.example.a10rv_with_onclicklistener.model.User;

import java.util.List;

public class CustomAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

    private MainActivity activity;
    private List<User> users;

    public CustomAdapter(MainActivity activity, List<User> users) {
        this.activity = activity;
        this.users = users;
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_layout_view,parent,false);
        return  new CustomViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
        User user = users.get(position);
        if (holder instanceof CustomViewHolder){
            LinearLayout layout = ((CustomViewHolder)holder).linearLayout;
            TextView abubakr = ((CustomViewHolder)holder).abubakr;
            TextView tohir = ((CustomViewHolder)holder).tohir;

            abubakr.setText(user.getAbubakr());
            tohir.setText(user.getTohir());
            layout.setOnClickListener((view -> {
                activity.openItemDetals(user);
            }));
        }
    }

    @Override
    public int getItemCount() {
        return users.size();
    }

    public class CustomViewHolder extends RecyclerView.ViewHolder{
        public View view;
        public TextView abubakr,tohir;
        public LinearLayout linearLayout;

        public CustomViewHolder(@NonNull View itemView) {
            super(itemView);
            view = itemView;

            abubakr = view.findViewById(R.id.abubakr);
            tohir = view.findViewById(R.id.tohir);
            linearLayout = view.findViewById(R.id.layout_click);
        }
    }
}
