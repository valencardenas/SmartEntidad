package com.example.valentina.smartestudiantes;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ListView;


/**
 * A simple {@link Fragment} subclass.
 */
public class ClasesFragment extends Fragment {


    public ClasesFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view =  inflater.inflate(R.layout.fragment_clases, container, false);

        String[] valores = {getResources().getString(R.string.h1),getResources().getString(R.string.h2)
                ,getResources().getString(R.string.h3),getResources().getString(R.string.h4),
                getResources().getString(R.string.h5),getResources().getString(R.string.h6),
                getResources().getString(R.string.h7),getResources().getString(R.string.h8),
                getResources().getString(R.string.h9),getResources().getString(R.string.h10)};
        ArrayAdapter arrayAdapter = new ArrayAdapter(getActivity(),
                android.R.layout.simple_list_item_1, valores);
        ListView lhorarios = (ListView) view.findViewById(R.id.lhorarios);
        lhorarios.setAdapter(arrayAdapter);
        return view;
    }

}
