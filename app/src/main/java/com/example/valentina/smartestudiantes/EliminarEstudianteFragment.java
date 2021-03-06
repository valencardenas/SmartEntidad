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
public class EliminarEstudianteFragment extends Fragment {

    private AlertDialog.Builder dialogo;
    public EliminarEstudianteFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view =inflater.inflate(R.layout.fragment_eliminar_estudiante, container, false);
        Button bEliminar= (Button)view.findViewById(R.id.bEliminarE2);
        Button bCancelar = (Button) view.findViewById(R.id.bCancelarE3);

        bCancelar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Fragment fragment = null;
                fragment = new EstudiantesFragment();
                FragmentManager fragmentManager = getActivity().getSupportFragmentManager();
                fragmentManager.beginTransaction().replace(R.id.contenedorFragment, fragment).commit();
            }
        });

        bEliminar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dialogo = new AlertDialog.Builder(getActivity());
                dialogo.setTitle("Confirmación");
                dialogo.setMessage(getResources().getString(R.string.EliEs));
                dialogo.setCancelable(true);
                dialogo.setPositiveButton(getResources().getString(R.string.aceptar), new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialogo1, int id) {
                        aceptar();
                    }
                });
                dialogo.setNegativeButton(getResources().getString(R.string.cancelar), new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialogo1, int id) {
                        cancelar();
                    }
                });
                dialogo.show();

            }
        });
        return view;
    }
    public void aceptar() {
        Toast t=Toast.makeText(getActivity().getApplicationContext(),getResources().getString(R.string.eliminadoE), Toast.LENGTH_SHORT);
        t.show();
        Fragment fragment = null;
        fragment = new EstudiantesFragment();
        FragmentManager fragmentManager = getActivity().getSupportFragmentManager();
        fragmentManager.beginTransaction().replace(R.id.contenedorFragment, fragment).commit();

    }
    public void cancelar() {
    }
}
