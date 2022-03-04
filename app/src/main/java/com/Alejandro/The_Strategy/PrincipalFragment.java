package com.Alejandro.The_Strategy;

import android.content.Context;
import android.content.SharedPreferences;
import android.graphics.Color;
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
import android.widget.Toast;


public class PrincipalFragment extends Fragment {
    private EditText etRuleta;
    private Button introduce, guarda;
    private TextView tvGS,tvS,tvHP,tvHC;
    private RadioGroup radioGroup;
    private RadioButton radioBoton;
    //private RadioButton rbGS,rbS,rbHP,rbHC;
    private int numero,contGS=0,contS=0,contHP=0,contHC=0,aciertos,fallos;
    private int minGS,minS,minHP,minHC,maxGS,maxS,maxHP,maxHC;
    private String mensaje ;





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
        radioGroup=view.findViewById(R.id.radioGroup);

//        SharedPreferences preferences1= this.getActivity().getSharedPreferences("Ajustes",Context.MODE_PRIVATE);
//        minGS=Integer.parseInt(preferences1.getString("minGS","3"));
//        minS=Integer.parseInt(preferences1.getString("minS","4"));
//        minHP=Integer.parseInt(preferences1.getString("minHP","5"));
//        minHC=Integer.parseInt(preferences1.getString("minHC","5"));
//        maxGS=Integer.parseInt(preferences1.getString("maxGS","6"));
//        maxS=Integer.parseInt(preferences1.getString("maxS","7"));
//        maxHP=Integer.parseInt(preferences1.getString("maxHP","8"));
//        maxHC=Integer.parseInt(preferences1.getString("maxHC","8"));

        introduce.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                nuevoDato();
            }
        });



      return view;
    }
    public void nuevoDato(){

        numero=Integer.parseInt(etRuleta.getText().toString());

        if(numero==22 || numero==18 ||numero==29||numero==7||numero==28||numero==12||numero==35||numero==3||numero==26||numero==0||numero==32
                ||numero==15||numero==19||numero==4||numero==21||numero==2||numero==25){contGS=0;}
        else {contGS++;}
        if(numero==33||numero==16||numero==24||numero==5||numero==10||numero==23||numero==8||numero==30
                ||numero==11||numero==36||numero==13||numero==27){contS=0;}else{contS++;}
        if(numero==9||numero==31||numero==14||numero==20||numero==1){contHP=0;}else{contHP++;}
        if(numero==17||numero==34||numero==6){contHC=0;}else{contHC++;}
        //granSerie
        if(contGS<minGS){tvGS.setText(contGS); tvGS.setTextColor(Color.parseColor("#86C8E6"));}
        else if (contGS<maxGS && contGS>minGS ) { tvGS.setText(contGS); tvGS.setTextColor(Color.parseColor("#FF9800"));}
        else if(contGS>=maxGS){tvGS.setText(contGS); tvGS.setTextColor(Color.parseColor("#E12315"));}
        //serie
        if(contS<minS){tvS.setText(contS); tvS.setTextColor(Color.parseColor("#86C8E6"));}
        else if (contS<maxS && contS>minS ) { tvS.setText(contS); tvS.setTextColor(Color.parseColor("#FF9800"));}
        else if(contS>=maxS){tvS.setText(contS); tvS.setTextColor(Color.parseColor("#E12315"));}
        // huerfanos a plano
        if(contHP<minHP){tvHP.setText(contHP); tvHP.setTextColor(Color.parseColor("#86C8E6"));}
        else if (contHP<maxHP && contHP>minHP ) { tvHP.setText(contHP); tvHP.setTextColor(Color.parseColor("#FF9800"));}
        else if(contHP>=maxHP){tvHP.setText(contHP); tvHP.setTextColor(Color.parseColor("#E12315"));}
        //huerfanos a caballo
        if(contHC<minHC){tvHC.setText(contHC); tvHC.setTextColor(Color.parseColor("#86C8E6"));}
        else if (contHC<maxHC && contHC>minHC ) { tvHC.setText(contHC); tvHC.setTextColor(Color.parseColor("#FF9800"));}
        else if(contHC>=maxHC){tvHC.setText(contHC); tvHC.setTextColor(Color.parseColor("#E12315"));}

        //radiogruop

        int idSeleccionado = radioGroup.getCheckedRadioButtonId();
        if (idSeleccionado != -1) {
            radioBoton =getActivity().findViewById(idSeleccionado);
            mensaje= radioBoton.getText().toString();
            radioGroup.clearCheck ();
        }
        //gran serie
        if(mensaje.equals("Gran Serie") && contGS==0){aciertos++;
            Toast.makeText(this.getActivity(),"Has acertado",Toast.LENGTH_LONG).show();}
        if(mensaje.equals("Gran Serie") && contGS>0){fallos++;
            Toast.makeText(this.getActivity(),"Has fallado",Toast.LENGTH_LONG).show();}
        //serie
        if(mensaje.equals("Serie") && contS==0){aciertos++;
            Toast.makeText(this.getActivity(),"Has acertado",Toast.LENGTH_LONG).show();}
        if(mensaje.equals("Serie") && contS>0){fallos++;
            Toast.makeText(this.getActivity(),"Has fallado",Toast.LENGTH_LONG).show();}
        //Huerfanos a pleno
        if(mensaje.equals("Huérfanos a Pleno") && contHP==0){aciertos++;
            Toast.makeText(this.getActivity(),"Has acertado",Toast.LENGTH_LONG).show();}
        if(mensaje.equals("Huérfanos a Pleno") && contHP>0){fallos++;
            Toast.makeText(this.getActivity(),"Has fallado",Toast.LENGTH_LONG).show();}
        //huerfanos a caballo
        if(mensaje.equals("Huérfanos a Caballo") && contHC==0){aciertos++;
            Toast.makeText(this.getActivity(),"Has acertado",Toast.LENGTH_LONG).show();}
        if(mensaje.equals("Huérfanos a Caballo") && contHC>0){fallos++;
            Toast.makeText(this.getActivity(),"Has fallado",Toast.LENGTH_LONG).show();}
    }
}