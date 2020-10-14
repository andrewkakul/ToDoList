package com.example.todolist.ui;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import static com.example.todolist.R.layout.activity_main;
import com.example.todolist.R;
import com.example.todolist.adapters.MyAdapter;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity implements View.OnClickListener, MyAdapter.OnTaskClicked{

    private List<Task> tasks = new ArrayList<>();
    private MyAdapter adapter;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(activity_main);

        RecyclerView tasksRV = findViewById(R.id.tasksRV);
        tasksRV.setLayoutManager(new LinearLayoutManager(this));
        adapter = new MyAdapter(this, tasks, this);
        tasksRV.setAdapter(adapter);

        FloatingActionButton addTaskFAB = findViewById(R.id.addFAB);
        addTaskFAB.setOnClickListener(this);
    }

    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);


        if (data == null) {
            return;
        }
        switch (requestCode){
            case 1:
                String taskTitle = data.getStringExtra(AddTaskActivity.TITLE);
                tasks.add(new Task(taskTitle));
                adapter.notifyDataSetChanged();
                break;
            case 2:
                String taskEditTitle = data.getStringExtra(EditTaskActivity.EDIT_TITLE);
                int pos = data.getIntExtra("P", 0);
                tasks.set(pos, new Task(taskEditTitle));
                adapter.notifyDataSetChanged();
                break;
        }
    }
    @Override
    public void onClick(View view) {
        Intent intent = new Intent(MainActivity.this, AddTaskActivity.class);
        startActivityForResult(intent, 1);
    }
    @Override
    public void onTaskClicked(int index) {
        Intent intent = new Intent(MainActivity.this, EditTaskActivity.class);
        intent.putExtra("Position", index);
        startActivityForResult(intent, 2);
    }
    @Override
    public void onDeleteClicked(int index) {
        tasks.remove(index);
        adapter.notifyDataSetChanged();
    }
}