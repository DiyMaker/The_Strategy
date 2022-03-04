package com.Alejandro.The_Strategy;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class Login extends AppCompatActivity {
    //private SQLiteDatabase bd;
    private Button registro,login,invitado;
    private EditText usuario,contraseña;
    private String us,pass,spaUS,spPass;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        registro=findViewById(R.id.btRegistro);
        login=findViewById(R.id.btEntrar);
        usuario=findViewById(R.id.etNombre);
        us=usuario.getText().toString();
        contraseña=findViewById(R.id.etContraseña);
        pass=contraseña.getText().toString();
        invitado=findViewById(R.id.btInvitado);

        // Aunque se está realizando en onCreate, lo ideal es hacerlo en cada uno de los métodos que vayan
        // a trabajar con la BD (igual habría que hacer con  el close).
//        AdminSQLite adminSQLite = new AdminSQLite(this, "t_usuarios", null, 1);
//        bd = adminSQLite.getWritableDatabase();

        registro.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent goToRegister = new Intent(Login.this, Registro.class);
                startActivity(goToRegister);

            }
        });
        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
//                Cursor fila = bd.rawQuery(
//                        "select id,usuario,password from t_usuarios where usuario=" + us +" and password="+pass, null);
//                if (fila.getCount()>0) {
//                    Intent goToMain = new Intent(Login.this, MainActivity.class);
//                    goToMain.putExtra("usuario",us);
//                    goToMain.putExtra("contraseña",pass);
//                    startActivity(goToMain);
//                } else
//                    Toast.makeText(Login.this,"No se puede logear con ese usuario y contraseña",Toast.LENGTH_LONG).show();
                SharedPreferences preferences1= getSharedPreferences("registro", Context.MODE_PRIVATE);
                spaUS=preferences1.getString("usuario","no exite");
                spPass=preferences1.getString("contraseña","no exite");
                if(us.equals(spaUS) && pass.equals(spPass)){
                    Intent goToMain = new Intent(Login.this, MainActivity.class);
                    goToMain.putExtra("usuario",us);
                    goToMain.putExtra("contraseña",pass);
                    startActivity(goToMain);
                }
                else{Toast.makeText(Login.this,"No se puede logear con ese usuario y contraseña",Toast.LENGTH_LONG).show();}
            }



        });
        invitado.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent goToMain1 = new Intent(Login.this, MainActivity.class);

                startActivity(goToMain1);

            }
        });


    }
}