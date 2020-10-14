package com.example.todolist.ui;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

import com.example.todolist.R;
import com.google.android.material.floatingactionbutton.FloatingActionButton;

public class EditTaskActivity extends AppCompatActivity implements View.OnClickListener {
    public static final String EDIT_TITLE = "EdTitle";
    private EditText titleET;

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
            int pos = intent.getIntExtra("Position", 0);
            intent.putExtra("P", pos);
            intent.putExtra(EDIT_TITLE, titleET.getText().toString());
            setResult(2, intent);
            finish();
        }
    }
}