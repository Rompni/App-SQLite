package com.edu.unimagdalena.appmoviles.sqliteuniversity;

import android.content.Context;
import android.database.Cursor;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.CursorAdapter;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import java.util.List;

public class StudentAdapter extends CursorAdapter {

    public StudentAdapter(Context context, Cursor c, boolean autoRequery) {
        super(context, c, autoRequery);
    }

    @Override
    public View newView(Context context, Cursor cursor, ViewGroup parent) {
        return LayoutInflater.from(context).inflate(R.layout.student_view, parent, false);
    }

    @Override
    public void bindView(View view, Context context, Cursor cursor) {
        TextView cod = view.findViewById(R.id.txtCode);
        TextView nom = view.findViewById(R.id.txtName);
        TextView prg = view.findViewById(R.id.txtCareer);
        String codigo = cursor.getString(0);
        String nombre = cursor.getString(1);
        String prog = cursor.getString(2);
        cod.setText(codigo);
        nom.setText(nombre);
        prg.setText(prog);
    }
}
