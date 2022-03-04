package com.Alejandro.The_Strategy;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

public class AdminSQLite extends SQLiteOpenHelper {
//tabla usuarios
    private String sqlCreate = "CREATE TABLE t_usuarios (id INTEGER PRIMARY KEY AUTOINCREMENT, usuario TEXT NOT NULL, password TEXT NOT NULL)";
//tabla registros
private String sqlCreate2 = "CREATE TABLE t_registros (id INTEGER PRIMARY KEY AUTOINCREMENT, usuario TEXT NOT NULL, password TEXT NOT NULL, aciertos INTEGER NOT NULL,fallos INTEGER NOT NULL)";

    public AdminSQLite(@Nullable Context context, @Nullable String name,
                       @Nullable SQLiteDatabase.CursorFactory factory, int version) {
        super(context, name, factory, version);
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        sqLiteDatabase.execSQL(sqlCreate);
        sqLiteDatabase.execSQL(sqlCreate2);
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int versionAnterior, int versionNueva) {

        // Se elimina la versión anterior de la tabla
        sqLiteDatabase.execSQL("DROP TABLE IF EXISTS t_usuarios");

        // Se crea la nueva versión de la tabla usuarios
        sqLiteDatabase.execSQL(sqlCreate);

        // Se elimina la versión anterior de la tabla
        sqLiteDatabase.execSQL("DROP TABLE IF EXISTS t_registros");

         // Se crea la nueva versión de la tabla registros
        sqLiteDatabase.execSQL(sqlCreate2);

    }
}
