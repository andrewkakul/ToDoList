package com.example.todolist.adapters;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.todolist.R;
import com.example.todolist.ui.Task;

import java.util.List;

public class MyAdapter extends RecyclerView.Adapter<MyAdapter.ViewHolder> {

    private LayoutInflater inflater;
    private List<Task> tasks;
    private OnTaskClicked  onItemClickListener;

    public MyAdapter(Context context, List<Task> tasks, OnTaskClicked onItemClickListener) {
        this.inflater = LayoutInflater.from(context);
        this.tasks = tasks;
        this.onItemClickListener = onItemClickListener;
    }

    @NonNull
    @Override
    public MyAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = inflater.inflate(R.layout.activity_task_fragment, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MyAdapter.ViewHolder holder, final int position) {
        Task task = tasks.get(position);
        holder.titleView.setText(task.getTitle());
        holder.taskLayout.setOnClickListener(v -> onItemClickListener.onTaskClicked(position));
        holder.delTaskbtn.setOnClickListener(view -> onItemClickListener.onDeleteClicked(position));
    }

    @Override
    public int getItemCount() {
        return tasks.size();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder{
        private  TextView titleView;
        private LinearLayout taskLayout;
        private ImageButton delTaskbtn;
        public ViewHolder(@NonNull View view) {
            super(view);
            delTaskbtn = (view).findViewById(R.id.delTaskbtn);
            titleView = (view).findViewById(R.id.titleTask);
            taskLayout = (view).findViewById(R.id.taskLayout);
        }
    }

    public interface OnTaskClicked {
        void onTaskClicked(int index);
        void onDeleteClicked(int index);
    }
}
