package com.cdp.android_spinner_sqlite;

import androidx.appcompat.app.AppCompatActivity;

import android.database.Cursor;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import com.cdp.android_spinner_sqlite.db.DbCategorias;
import com.cdp.android_spinner_sqlite.entidades.Categorias;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    Spinner spCategorias;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        spCategorias = findViewById(R.id.spCategorias);

        List<Categorias> listaCategorias = llenarCategorias();
        ArrayAdapter<Categorias> arrayAdapter = new ArrayAdapter<>(getApplicationContext(), R.layout.support_simple_spinner_dropdown_item, listaCategorias);
        spCategorias.setAdapter(arrayAdapter);

        spCategorias.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {

                ((TextView) adapterView.getChildAt(0)).setTextColor(Color.BLACK);
                ((TextView) adapterView.getChildAt(0)).setTextSize(18);

                int idCat =((Categorias) adapterView.getSelectedItem()).getId();
                String nombreCat =((Categorias) adapterView.getSelectedItem()).getNombre();

                Toast.makeText(MainActivity.this, idCat + " - " + nombreCat, Toast.LENGTH_LONG).show();
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {
            }
        });
    }

    private List<Categorias> llenarCategorias(){
        List<Categorias> listaCat = new ArrayList<>();
        DbCategorias dbCategorias = new DbCategorias(MainActivity.this);
        Cursor cursor = dbCategorias.mostarCategorias();
        if(cursor != null){
            if(cursor.moveToFirst()){
                do{
                    Categorias cat = new Categorias();
                    cat.setId(cursor.getInt(cursor.getColumnIndex("id")));
                    cat.setNombre(cursor.getString(cursor.getColumnIndex("nombre")));
                    listaCat.add(cat);
                } while (cursor.moveToNext());
            }
        }
        dbCategorias.close();

        return listaCat;
    }
}