package com.johnatadavi.tasklist.adapter;

import android.text.method.MultiTapKeyListener;
import android.util.SparseArray;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.johnatadavi.tasklist.R;
import com.johnatadavi.tasklist.model.Task;

import java.util.ArrayList;

import androidx.annotation.NonNull;
import androidx.collection.SparseArrayCompat;
import androidx.recyclerview.widget.RecyclerView;

public class TaskAdapter extends RecyclerView.Adapter<TaskAdapter.MyViewHolder> {

    private ArrayList<Task> taskList;

    public TaskAdapter(ArrayList<Task> list) {
        this.taskList = list;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new MyViewHolder(LayoutInflater.from(parent.getContext())
                .inflate(R.layout.task_list_adapter, parent, false));
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
        Task task = taskList.get(position);
        holder.task.setText(task.getName());
    }

    @Override
    public int getItemCount() {
        return this.taskList.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {

        TextView task;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);

            task = itemView.findViewById(R.id.textTask);
        }
    }

}
