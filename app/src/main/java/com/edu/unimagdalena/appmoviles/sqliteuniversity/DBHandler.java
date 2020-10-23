package com.edu.unimagdalena.appmoviles.sqliteuniversity;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class DBHandler extends SQLiteOpenHelper {

    public DBHandler(Context context) {
        super(context,DefDB.DATABASE_NAME, null, DefDB.DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(DefDB.CREATE_STUDENTS_TABLE);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        // Drop older table if existed
        db.execSQL("DROP TABLE IF EXISTS " + DefDB.TABLE_STUDENTS);

        // Create tables again
        onCreate(db);
    }
}
