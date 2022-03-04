package com.Alejandro.The_Strategy;

import android.app.AlertDialog;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.text.SpannableString;
import android.text.method.LinkMovementMethod;
import android.text.util.Linkify;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.TextView;


public class StrategyFragment extends Fragment {


    private Button link;


    public StrategyFragment() {
        // Required empty public constructor
    }



    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view=inflater.inflate(R.layout.fragment_strategy, container, false);

        link=view.findViewById(R.id.btLink);
        link.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                final SpannableString s = new SpannableString(" PKM: \n https://www.youtube.com/watch?v=qqahMQj3Z2A \n\n" +
                        " Secretoas de Juan Sagaz: \n  https://www.youtube.com/watch?v=geqiOiPSjgY\n\n" +
                        " Jugador Ganador: \n https://www.youtube.com/watch?v=ptdDdJOnDNw \n\n" +
                        " El Profe: \n https://www.youtube.com/watch?v=ILk5buCxKRA \n\n" +
                        " LA FIEBRE DE LA RULETA: \n https://www.youtube.com/watch?v=m37o2MXGZ5s \n\n"

                );
                Linkify.addLinks(s, Linkify.ALL);

                final AlertDialog d = new AlertDialog.Builder(getActivity())
                        .setTitle("Nuestras referentes")
                        .setMessage(s)
                        .create();

                d.show();


                ((TextView) d.findViewById(android.R.id.message)).setMovementMethod(LinkMovementMethod.getInstance());
            }


        });

        return view;
    }
}