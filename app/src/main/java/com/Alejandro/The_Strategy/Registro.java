package com.Alejandro.The_Strategy;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.SharedPreferences;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class Registro extends AppCompatActivity {
    private EditText user,password,rePassword;
    private Button aceptar,volver;
    private SQLiteDatabase bd;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registro);

        user=findViewById(R.id.etUser);
        password=findViewById(R.id.etPassword);
        rePassword=findViewById(R.id.etReContraseña);
        aceptar=findViewById(R.id.btAceptar);
        volver=findViewById(R.id.btVolver);

        // Aunque se está realizando en onCreate, lo ideal es hacerlo en cada uno de los métodos que vayan
        // a trabajar con la BD (igual habría que hacer con  el close).
        AdminSQLite adminSQLite = new AdminSQLite(this, "t_usuarios", null, 1);
        bd = adminSQLite.getWritableDatabase();

        aceptar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                registrar();
            }
        });
        volver.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
    }

    private void registrar() {
        String nombre,password1,password2;
        nombre=user.getText().toString();
        password1=password.getText().toString();
        password2=rePassword.getText().toString();

        //validar datos
        //comprueba que nombre no este vacio
        if (nombre.isEmpty()) {
            Toast.makeText(getApplicationContext(),
                    "Por favor, inserte un nombre",
                    Toast.LENGTH_LONG)
                    .show();
            return;
        }
        //comprueba que password1 no este vacio
        if (password1.isEmpty()) {
            Toast.makeText(getApplicationContext(),
                    "Por favor, inserte una contraseña en contraseña",
                    Toast.LENGTH_LONG)
                    .show();
            return;
        }
        //comprueba que password2 no este vacio
        if (password2.isEmpty()) {
            Toast.makeText(getApplicationContext(),
                    "Por favor, inserte una contraseña en repetir contraseña",
                    Toast.LENGTH_LONG)
                    .show();
            return;
        }
        //comprueba que password1 no sea distinto a password2
        if (!password1.equals(password2)) {
            Toast.makeText(getApplicationContext(),
                    "Las contraseñas no coinciden",
                    Toast.LENGTH_LONG)
                    .show();
            return;
        }

//        Cursor fila = bd.rawQuery(
//                "select * from t_usuarios where usuario=" + nombre +" and password="+ password1, null);
//        if (fila.getCount()>0) {
//
//            if (bd != null) {
//                String sql;
//                sql = "INSERT INTO t_usuarios VALUES (" + nombre + ", '" + password1 + ")";
//                bd.execSQL(sql);
//
//                Toast.makeText(Registro.this, "Usuario registrado", Toast.LENGTH_LONG).show();
//                limpiar();
//            }
//        }else
//            Toast.makeText(Registro.this,"No se puede registrar con ese usuario y contraseña",Toast.LENGTH_LONG).show();
//    }
        SharedPreferences preferences1= getSharedPreferences("registro", Context.MODE_PRIVATE);
        SharedPreferences.Editor editor=preferences1.edit();
        editor.putString("usuario",nombre);
        editor.putString("contraseña",password1);
        editor.commit();
        Toast.makeText(Registro.this, "Usuario registrado", Toast.LENGTH_LONG).show();
             limpiar();
             finish();
    }



    public void limpiar(){
        user.setText("");
        password.setText("");
        rePassword.setText("");
    }


}