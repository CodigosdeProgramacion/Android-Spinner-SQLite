package com.cdp.android_spinner_sqlite.db;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import androidx.annotation.Nullable;

public class DbCategorias extends DbHelper {
    public DbCategorias(@Nullable Context context) {
        super(context);
    }

    public Cursor mostarCategorias() {
        try {
            SQLiteDatabase bd = this.getReadableDatabase();
            Cursor filas = bd.rawQuery("SELECT * FROM " + TABLE_CATEGORIAS + " ORDER BY nombre ASC", null);
            if (filas.moveToFirst()) {
                return filas;
            } else {
                return null;
            }
        } catch (Exception ex) {
            return null;
        }
    }
}
