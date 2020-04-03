package com.johnatadavi.tasklist.activity;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;

import com.google.android.material.textfield.TextInputEditText;
import com.johnatadavi.tasklist.R;
import com.johnatadavi.tasklist.dao.TaskDAO;
import com.johnatadavi.tasklist.model.Task;

public class AddTaskActivity extends AppCompatActivity {

    private TextInputEditText editTask;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_task);

        editTask = findViewById(R.id.textTask);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_add_task, menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {

        switch (item.getItemId()) {
            case R.id.itemSave:
                // Save item
                String taskName = editTask.getText().toString();
                if (!taskName.isEmpty()) {
                    TaskDAO taskDAO = new TaskDAO(getApplicationContext());
                    taskDAO.save((new Task(taskName)));
                    finish();
                }

                break;
        }

        return super.onOptionsItemSelected(item);
    }
}
