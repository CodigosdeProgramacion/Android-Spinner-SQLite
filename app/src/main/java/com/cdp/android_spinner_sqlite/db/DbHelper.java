package com.cdp.android_spinner_sqlite.db;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

public class DbHelper extends SQLiteOpenHelper {

    private static final String BASE_NOMBRE = "db_tienda.db";
    private static final int BASE_VERSION = 1;
    protected static final String TABLE_CATEGORIAS = "t_categorias";

    public DbHelper(@Nullable Context context) {
        super(context, BASE_NOMBRE, null, BASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {

        sqLiteDatabase.execSQL("CREATE TABLE " + TABLE_CATEGORIAS + "(" +
                "id INTEGER PRIMARY KEY NOT NULL," +
                "nombre TEXT NOT NULL)");
        sqLiteDatabase.execSQL("INSERT INTO " +TABLE_CATEGORIAS + " (id, nombre) VALUES" +
                "(1, 'Lacteos')," +
                "(2, 'Pan')," +
                "(3, 'Salchichoneria')," +
                "(4, 'Bebidas')," +
                "(5, 'Botanas')");
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {
        sqLiteDatabase.execSQL("DROP TABLE IF EXISTS " + TABLE_CATEGORIAS);
        onCreate(sqLiteDatabase);
    }
}
