package com.example.todolist.ui;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

import com.example.todolist.R;
import com.google.android.material.floatingactionbutton.FloatingActionButton;

public class AddTaskActivity extends AppCompatActivity implements View.OnClickListener {
    public static final String TITLE = "Title";
    private  EditText titleET;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_task);

        titleET = findViewById(R.id.EDaddNewTask);
        FloatingActionButton confirmAddTaskFAB = findViewById(R.id.confirmAddTaskFAB);
        confirmAddTaskFAB.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        Intent intent = new Intent();
        if (titleET.getText() != null) {
            intent.putExtra(TITLE, titleET.getText().toString());
            setResult(1, intent);
            finish();
        }
    }
}