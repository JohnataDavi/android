package com.johnatadavi.tasklist.dao;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.util.Log;

import com.johnatadavi.tasklist.helper.DbHelper;
import com.johnatadavi.tasklist.model.Task;

import java.util.ArrayList;

public class TaskDAO implements IDAO<Task> {

    private SQLiteDatabase write;
    private SQLiteDatabase read;

    public TaskDAO(Context context) {
        DbHelper db = new DbHelper(context);
        this.write = db.getWritableDatabase();
        this.read = db.getReadableDatabase();
    }

    @Override
    public boolean save(Task task) {
        ContentValues cv = new ContentValues();
        cv.put("name", task.getName());
        try {
            write.insert(DbHelper.TASK_TABLE, null, cv);
            Log.i("INFO", "Task saved!");
        } catch (Exception e) {
            Log.e("INFO", "Error saved!" + e.getMessage());
            return false;
        }
        return true;
    }

    @Override
    public boolean update(Task task) {
        ContentValues cv = new ContentValues();
        cv.put("name", task.getName());
        try {
//            String[] args = {"1", "in progress"};
//            write.update(DbHelper.TASK_TABLE, cv, "id=? AND status = ?", args );
            String[] args = {task.getId().toString()};
            write.update(DbHelper.TASK_TABLE, cv, "id=?", args);
            Log.i("INFO", "Task updated!");
        } catch (Exception e) {
            Log.e("INFO", "Error updated!" + e.getMessage());
            return false;
        }
        return true;
    }

    @Override
    public boolean delete(Task task) {
        try {
            String[] args = {task.getId().toString()};
            write.delete(DbHelper.TASK_TABLE, "id=?", args);
            Log.i("INFO", "Task deleted!");
        } catch (Exception e) {
            Log.e("INFO", "Error updated!" + e.getMessage());
            return false;
        }
        return true;
    }

    @Override
    public ArrayList<Task> list() {
        ArrayList<Task> tasks = new ArrayList<>();

        String sql = "SELECT * FROM " + DbHelper.TASK_TABLE + " ;";
        Cursor c = read.rawQuery(sql, null);

        while (c.moveToNext()) {
            Long id = c.getLong(c.getColumnIndex("id"));
            String name = c.getString(c.getColumnIndex("name"));
            tasks.add((new Task(id, name)));
        }

        return tasks;
    }
}
