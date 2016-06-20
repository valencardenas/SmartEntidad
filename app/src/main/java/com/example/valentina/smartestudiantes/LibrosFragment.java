package com.example.valentina.smartestudiantes;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;


/**
 * A simple {@link Fragment} subclass.
 */
public class LibrosFragment extends Fragment {


    public LibrosFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view=inflater.inflate(R.layout.fragment_libros, container, false);


        String[] valores = {getResources().getString(R.string.l1),getResources().getString(R.string.l2)
                ,getResources().getString(R.string.l3),getResources().getString(R.string.l4)};
        ArrayAdapter arrayAdapter = new ArrayAdapter(getActivity(),
                android.R.layout.simple_list_item_1, valores);
        ListView lLibros = (ListView) view.findViewById(R.id.lLibros);
        lLibros.setAdapter(arrayAdapter);

       lLibros.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                int item=position;
                Fragment fragment = null;
                switch (item){
                    case 0:
                        fragment = new ClasesFragment();

                        break;
                    case 1:
                        fragment = new ClasesFragment();

                        break;
                    case 2:
                        fragment = new ClasesFragment();
                        break;
                    case 3:
                        fragment = new ClasesFragment();
                        break;

                }
                FragmentManager fragmentManager = getActivity().getSupportFragmentManager();
                fragmentManager.beginTransaction().replace(R.id.contenedorFragment, fragment).commit();
            }
        });
        return view;
    }

}
