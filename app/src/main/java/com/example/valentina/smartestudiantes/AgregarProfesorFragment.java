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
import android.widget.Toast;


/**
 * A simple {@link Fragment} subclass.
 */
public class AgregarProfesorFragment extends Fragment {

    private AlertDialog.Builder dialogo1;

    public AgregarProfesorFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view =  inflater.inflate(R.layout.fragment_agregar_profesor, container, false);
        Button bAgregar = (Button) view.findViewById(R.id.bNuevoprofe);
        Button bCancelar = (Button) view.findViewById(R.id.bCancelarP1);
        Button bFecha= (Button)view.findViewById(R.id.bFechaP);

        bCancelar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Fragment fragment = null;
                fragment = new ProfesoresFragment();
                FragmentManager fragmentManager = getActivity().getSupportFragmentManager();
                fragmentManager.beginTransaction().replace(R.id.contenedorFragment, fragment).commit();
            }
        });

        bAgregar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dialogo1 = new AlertDialog.Builder(getActivity());
                dialogo1.setTitle("Confirmación");
                dialogo1.setMessage(getResources().getString(R.string.AgrPr));
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
        Toast t=Toast.makeText(getActivity().getApplicationContext(),getResources().getString(R.string.guardoP), Toast.LENGTH_SHORT);
        t.show();
        Fragment fragment = null;
        fragment = new ProfesoresFragment();
        FragmentManager fragmentManager = getActivity().getSupportFragmentManager();
        fragmentManager.beginTransaction().replace(R.id.contenedorFragment, fragment).commit();

    }
    public void cancelar() {



    }
}
