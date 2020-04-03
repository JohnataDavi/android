package com.johnatadavi.tasklist.activity;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Toast;

import com.google.android.material.textfield.TextInputEditText;
import com.johnatadavi.tasklist.R;
import com.johnatadavi.tasklist.dao.TaskDAO;
import com.johnatadavi.tasklist.model.Task;

public class AddTaskActivity extends AppCompatActivity {

    private TextInputEditText editTask;
    private Task currentTaks;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_task);

        editTask = findViewById(R.id.textTask);

        // recover task, if it is editing - Serializable
        currentTaks = (Task) getIntent().getSerializableExtra("taskSelected");

        // configure textBox
        if (currentTaks != null) {
            editTask.setText(currentTaks.getName());
        }
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
                TaskDAO taskDAO = new TaskDAO(getApplicationContext());
                if (currentTaks != null) {
                    // Update item
                    String taskName = editTask.getText().toString();
                    if (!taskName.isEmpty()) {
                        Task task = new Task(currentTaks.getId(), taskName);

                        // Update DB
                        if (taskDAO.update(task)) {
                            finish();
                            Toast.makeText(getApplicationContext(),
                                    "Sucesso ao atualizar tarefa!",
                                    Toast.LENGTH_SHORT).show();
                        } else {
                            Toast.makeText(getApplicationContext(),
                                    "Erro ao atualizar tarefa!",
                                    Toast.LENGTH_SHORT).show();
                        }
                    }
                } else {
                    // Save item
                    String taskName = editTask.getText().toString();
                    if (!taskName.isEmpty()) {
                        if (taskDAO.save((new Task(taskName)))) {
                            finish();
                            Toast.makeText(getApplicationContext(),
                                    "Sucesso ao salvar tarefa!",
                                    Toast.LENGTH_SHORT).show();
                        } else {
                            Toast.makeText(getApplicationContext(),
                                    "Erro ao salvar tarefa!",
                                    Toast.LENGTH_SHORT).show();
                        }
                    }
                }

                break;
        }

        return super.onOptionsItemSelected(item);
    }
}
