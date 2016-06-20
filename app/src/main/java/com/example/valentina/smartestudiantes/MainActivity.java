package com.example.valentina.smartestudiantes;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.ActionBarDrawerToggle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

public class MainActivity extends AppCompatActivity {
    private String[] opciones;
    private ListView listView;
    private DrawerLayout drawerLayout;
    private ActionBarDrawerToggle drawerToggle;
    private CharSequence tituloSec;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Fragment fragment = null;
        fragment = new InicioFragment();
        FragmentManager fragmentManager = getSupportFragmentManager();
        fragmentManager.beginTransaction().replace(R.id.contenedorFragment, fragment).commit();

        opciones = new String[] {"Inicio","Notas","Información del personal","Configuración Cuenta","Salir"};

        drawerLayout = (DrawerLayout) findViewById(R.id.contenedorPrincipal);
        listView = (ListView) findViewById(R.id.menuIzq);

        listView.setAdapter(new ArrayAdapter<String>(getSupportActionBar().
                getThemedContext(), android.R.layout.simple_list_item_1, opciones));
        final ActionBar ab = getSupportActionBar();
        if (ab !=null) {
            ab.setHomeAsUpIndicator(R.drawable.ic_menu_white_24dp);
            ab.setDisplayHomeAsUpEnabled(true);
        }

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Fragment fragment = null;
                switch(position){
                    case 0: fragment = new InicioFragment();
                        FragmentManager fragmentManager = getSupportFragmentManager();
                        fragmentManager.beginTransaction().replace(R.id.contenedorFragment, fragment).commit();
                        break;
                    case 1: fragment =  new NotasFragment();
                        FragmentManager fragmentManager1 = getSupportFragmentManager();
                        fragmentManager1.beginTransaction().replace(R.id.contenedorFragment, fragment).commit();
                        break;
                    case 2: fragment = new InfoDePersoFragment();
                        FragmentManager fragmentManager2 = getSupportFragmentManager();
                        fragmentManager2.beginTransaction().replace(R.id.contenedorFragment, fragment).commit();
                        break;
                    case 3: fragment = new ConfigCuentaFragment();
                        FragmentManager fragmentManager3 = getSupportFragmentManager();
                        fragmentManager3.beginTransaction().replace(R.id.contenedorFragment, fragment).commit();
                        break;
                    case 4: Intent i =new Intent().setClass(MainActivity.this,LoginActivity.class);
                        startActivity(i);
                        break;


                }



                listView.setItemChecked(position, true);
                tituloSec = opciones[position];
                ab.setTitle(tituloSec);
                drawerLayout.closeDrawer(listView);
            }
        });
        drawerToggle = new ActionBarDrawerToggle(this, drawerLayout,
                R.drawable.ic_menu_white_24dp,R.string.abierto,R.string.cerrado);

        drawerLayout.setDrawerListener(drawerToggle);


    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()){
            case android.R.id.home:
                drawerLayout.openDrawer(GravityCompat.START);
                return true;
        }
        return super.onOptionsItemSelected(item);
    }
}
