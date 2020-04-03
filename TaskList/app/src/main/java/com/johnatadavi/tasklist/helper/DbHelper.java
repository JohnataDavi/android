package com.johnatadavi.tasklist.helper;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.net.ConnectivityManager;
import android.util.Log;

import androidx.annotation.Nullable;

public class DbHelper extends SQLiteOpenHelper {

    public static int VERSION = 1;
    public static String DB_NAME = "tasklist";
    public static String TASK_TABLE = "task";


    public DbHelper(@Nullable Context context) {
        super(context, DB_NAME, null, VERSION);
    }

    // Assim que o user instalar o app o metodo é chamado
    @Override
    public void onCreate(SQLiteDatabase db) {
        String sql = "CREATE TABLE IF NOT EXISTS " + TASK_TABLE +
                " (id INTEGER PRIMARY KEY AUTOINCREMENT, " +
                " name TEXT NOT NULL);";

        try {
            db.execSQL(sql);
            Log.i("DB INFO", "Sucesso ao criar a table");
        } catch (Exception e) {
            Log.i("DB INFO", "Erro ao criar a table " + e.getMessage());
        }
    }

    // Quando for atualizar o app
    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
//        String sql = "ALTER TABLE " + TASK_TABLE +  " ADD COLUMS status VARCHAR(9)";
        String sql = "DROP TABLE IF EXISTS " + TASK_TABLE + " ;";

        try {
            db.execSQL(sql);
            onCreate(db);
            Log.i("DB INFO", "Sucesso ao atualizar App");
        } catch (Exception e) {
            Log.i("DB INFO", "Erro ao atualizar App " + e.getMessage());
        }
    }
}
