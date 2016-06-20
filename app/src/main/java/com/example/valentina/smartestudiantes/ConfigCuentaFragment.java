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
public class ConfigCuentaFragment extends Fragment {


    public ConfigCuentaFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_config_cuenta, container, false);
        /*Spinner spinner = (Spinner) view.findViewById(R.id.sIdioma);
        String[] valores = {getResources().getString(R.string.ingles),getResources().getString(R.string.espa)};
        spinner.setAdapter(new ArrayAdapter<String>(getActivity().getApplicationContext(), android.R.layout.simple_spinner_item, valores));
*/
        String[] valores = {getResources().getString(R.string.idioma),getResources().getString(R.string.cambioI),getResources().getString(R.string.cambio)};
        ArrayAdapter arrayAdapter = new ArrayAdapter(getActivity(),
                android.R.layout.simple_list_item_1, valores);
        ListView lConfig = (ListView) view.findViewById(R.id.lConfig);
        lConfig.setAdapter(arrayAdapter);

        return view ;
    }

}
