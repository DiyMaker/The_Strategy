package com.Alejandro.The_Strategy;

import android.app.AlertDialog;
import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.Toast;


public class SettingsFragment extends Fragment {

    private Button guardPref;
    private ImageButton GS,S,HP,HC;
    private EditText etMinGS,etMaxGS,etMinS,etMaxS,etMinHP,etMaxHP,etMinHC,etMaxHC;
    private int minGS,minS,minHP,minHC,maxGS,maxS,maxHP,maxHC;



    public SettingsFragment() {
        // Required empty public constructor
    }




    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view=inflater.inflate(R.layout.fragment_settings, container, false);

        //UI
        guardPref=view.findViewById(R.id.btGPref);

        GS=view.findViewById(R.id.ibGS);
        S=view.findViewById(R.id.ibS);
        HP=view.findViewById(R.id.ibHP);
        HC=view.findViewById(R.id.ibHC);

        etMinGS=view.findViewById(R.id.etMinGS);
        etMaxGS=view.findViewById(R.id.etMaxGS);
        etMinS=view.findViewById(R.id.etMinS);
        etMaxS=view.findViewById(R.id.etMaxS);
        etMinHP=view.findViewById(R.id.etMinHP);
        etMaxHP=view.findViewById(R.id.etMaxHP);
        etMinHC=view.findViewById(R.id.etMinHC);
        etMaxHC=view.findViewById(R.id.etMaxHC);

        // los AlertDialogo
        GS.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                final AlertDialog d = new AlertDialog.Builder(getActivity())
                        .setTitle("Gran Serie")
                        .setMessage("Se recomineda: \n" +
                                "Minimo 3.\n" +
                                "Maximo 6")
                        .create();

                d.show();

            }
        });
        S.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                final AlertDialog a = new AlertDialog.Builder(getActivity())
                        .setTitle("Serie")
                        .setMessage("Se recomineda: \n" +
                                "Minimo 4.\n" +
                                "Maximo 7")
                        .create();

                a.show();
            }
        });
        HP.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                final AlertDialog p = new AlertDialog.Builder(getActivity())
                        .setTitle("Huérfanos a Pleno ")
                        .setMessage("Se recomineda: \n" +
                                "Minimo 5.\n" +
                                "Maximo 8")
                        .create();

                p.show();
            }
        });
        HC.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                final AlertDialog c = new AlertDialog.Builder(getActivity())
                        .setTitle("Huérfanos a Caballo ")
                        .setMessage("Se recomineda: \n" +
                                "Minimo 5.\n" +
                                "Maximo 8")
                        .create();

                c.show();
            }
        });
        //guarda los valores en SharedPreferences
        guardPref.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
              minGS=Integer.parseInt(etMinGS.getText().toString());
              minS=Integer.parseInt(etMinS.getText().toString());
              minHP=Integer.parseInt(etMinHP.getText().toString());
              minHC=Integer.parseInt(etMinHC.getText().toString());
                maxGS=Integer.parseInt(etMaxGS.getText().toString());
                maxS=Integer.parseInt(etMaxS.getText().toString());
                maxHP=Integer.parseInt(etMaxHP.getText().toString());
                maxHC=Integer.parseInt(etMaxHC.getText().toString());
                SharedPreferences preferences= getContext().getSharedPreferences("Ajustes", Context.MODE_PRIVATE);
                SharedPreferences.Editor editor=preferences.edit();
                editor.putInt("minGS",minGS);
                editor.putInt("maxGS",maxGS);
                editor.putInt("minS",minS);
                editor.putInt("maxS",maxS);
                editor.putInt("minHP",minHP);
                editor.putInt("maxHP",maxHP);
                editor.putInt("minHC",minHC);
                editor.putInt("maxHC",maxHC);
                editor.commit();
                Toast.makeText(getActivity(),"ShareReferences guardadas",Toast.LENGTH_LONG).show();



            }
        });


        return view;
    }
}