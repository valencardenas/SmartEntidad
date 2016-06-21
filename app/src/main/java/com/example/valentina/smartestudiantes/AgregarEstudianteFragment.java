package com.example.valentina.smartestudiantes;


import android.content.DialogInterface;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v7.app.AlertDialog;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.firebase.client.Firebase;


/**
 * A simple {@link Fragment} subclass.
 */
public class AgregarEstudianteFragment extends Fragment {


    private AlertDialog.Builder dialogo1;
    private static final String FIREBASE_URL="https://smartsearchapp.firebaseio.com/";
    private Firebase firebasedatos;

    EditText nombre, apellidos, identidad , correo , tel, cel, contrato ,fecha;
    Integer id=0;
    public AgregarEstudianteFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment

        final View view = inflater.inflate(R.layout.fragment_agregar_estudiante, container, false);
        Firebase.setAndroidContext(getActivity());
        firebasedatos= new Firebase(FIREBASE_URL);

        nombre=(EditText)view.findViewById(R.id.eNombreE);
        apellidos=(EditText)view.findViewById(R.id.eApellidosE);
        identidad=(EditText)view.findViewById(R.id.eIDE);
        correo=(EditText)view.findViewById(R.id.eCorreoE);
        tel=(EditText)view.findViewById(R.id.eTelE);
        cel=(EditText)view.findViewById(R.id.eCelE);
        contrato=(EditText)view.findViewById(R.id.eNcontratoE);
        fecha=(EditText)view.findViewById(R.id.eFecha);









        Button bAgregar1 = (Button) view.findViewById(R.id.bNuevoestudiante);
        Button bCancelar = (Button) view.findViewById(R.id.bCancelarE1);
        Button bFecha= (Button)view.findViewById(R.id.bFecha);

        bCancelar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Fragment fragment = null;
                fragment = new EstudiantesFragment();
                FragmentManager fragmentManager = getActivity().getSupportFragmentManager();
                fragmentManager.beginTransaction().replace(R.id.contenedorFragment, fragment).commit();
            }
        });

    bAgregar1.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View v) {

            String name = nombre.getText().toString();
            String apell = apellidos.getText().toString();
            String ident = identidad.getText().toString();
            String mail = correo.getText().toString();
            String tele = tel.getText().toString();
            String cell = cel.getText().toString();
            String contra = contrato.getText().toString();
            String fech = fecha.getText().toString();




            Firebase firebd = firebasedatos.child("estudiante " + id);
            EstudiantesClass Estudiante= new EstudiantesClass(String.valueOf(id),name,apell,ident,mail,tele,cell,contra,fech);
            firebd.setValue(Estudiante);
            id++;

            dialogo1 = new AlertDialog.Builder(getActivity());
            dialogo1.setTitle("Confirmación");
            dialogo1.setMessage(getResources().getString(R.string.AgrEs));
            dialogo1.setCancelable(true);
            dialogo1.setPositiveButton(getResources().getString(R.string.aceptar), new DialogInterface.OnClickListener() {
                public void onClick(DialogInterface dialogo1, int id) {
                    aceptar();
                }
            });
            dialogo1.setNegativeButton(getResources().getString(R.string.cancelar), new DialogInterface.OnClickListener() {
                public void onClick(DialogInterface dialogo1, int id) {
                    cancelar();
                }
            });
            dialogo1.show();

        }
    });



        return view;
    }

    public void aceptar() {
        Toast t=Toast.makeText(getActivity().getApplicationContext(),getResources().getString(R.string.guardoE), Toast.LENGTH_SHORT);
        t.show();
        Fragment fragment = null;
        fragment = new EstudiantesFragment();
        FragmentManager fragmentManager = getActivity().getSupportFragmentManager();
        fragmentManager.beginTransaction().replace(R.id.contenedorFragment, fragment).commit();

    }
    public void cancelar() {



    }
}

