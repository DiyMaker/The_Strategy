package com.Alejandro.The_Strategy;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;


public class PrincipalFragment extends Fragment {
    private EditText etRuleta;
    private Button introduce, guarda;
    private TextView tvGS,tvS,tvHP,tvHC;
    private RadioGroup RG;
    private RadioButton rbGS,rbS,rbHP,rbHC;
    private int numero,gs=0,s=0,hp=0,hc=0;
    private int GranSerie[]={22,18,29,7,28,12,35,3,26,0,32,15,19,4,21,2,25},
                Serie[]={33,16,24,5,10,23,8,30,11,36,13,27},
                HuefanosPleno[]={9,31,14,20,1},
                HuerfanoCaballo[]={17,34,6};




    public PrincipalFragment() {
        // Required empty public constructor
    }





    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view=inflater.inflate(R.layout.fragment_principal, container, false);


        //UI
        etRuleta=view.findViewById(R.id.etNumero);
        introduce=view.findViewById(R.id.btNumero);
        guarda=view.findViewById(R.id.btrc);
        tvGS=view.findViewById(R.id.tvGS);
        tvS=view.findViewById(R.id.tvS);
        tvHP=view.findViewById(R.id.tvHP);
        tvHC=view.findViewById(R.id.tvHC);
        RG=view.findViewById(R.id.radioGroup);

        //numero=Integer.parseInt(etRuleta.getText().toString());

        for(int a=0;a<GranSerie.length;a++){
            if(numero==GranSerie[a]){ gs=gs+1; }
        }
        for(int b=0;b<Serie.length;b++){
            if(numero==Serie[b]){ s=s+1; }
        }
        for(int c=0;c<HuefanosPleno.length;c++){
            if(numero==HuefanosPleno[c]){ hp=hp+1; }
        }
        for(int d=0;d<HuerfanoCaballo.length;d++){
            if(numero==HuefanosPleno[d]){ hc=hc+1; }
        }

        if(numero==0){}


      return view;
    }
}