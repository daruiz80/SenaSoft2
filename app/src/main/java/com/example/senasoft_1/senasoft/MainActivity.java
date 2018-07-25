package com.example.senasoft_1.senasoft;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.example.senasoft_1.senasoft.Actividades.InfoPersonal;
import com.example.senasoft_1.senasoft.DBSQLite.DBSQLite;
import com.example.senasoft_1.senasoft.DBSQLite.SQLiteArtista;
import com.example.senasoft_1.senasoft.Fragments.ListFragment;
import com.example.senasoft_1.senasoft.Fragments.RegistroFragment;

public class MainActivity extends AppCompatActivity implements ListFragment.OnFragmentInteractionListener,
RegistroFragment.OnFragmentInteractionListener{

    SQLiteArtista miArtista=new SQLiteArtista(this,"adsi",null,1);
    Button cerrarApp;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


    }

    public void addFragment(android.support.v4.app.Fragment fragmentoL) {

        android.support.v4.app.FragmentTransaction fragmentTransaction = getSupportFragmentManager().beginTransaction();
        fragmentTransaction.replace(R.id.framHome, fragmentoL);
        fragmentTransaction.commit();

    }

    public void botones(View view) {
        switch (view.getId()) {

            case R.id.formuregistro:
                addFragment(RegistroFragment.newInstance());
                break;
            case R.id.escritor:
                addFragment(ListFragment.newInstance(0));
                break;
            case R.id.pintor:
                addFragment(ListFragment.newInstance(1));
                break;
            case R.id.escultor:
                addFragment(ListFragment.newInstance(2));
                break;
            case R.id.btnClose:
                Intent salida =new Intent(Intent.ACTION_MAIN);
                salida.addCategory(Intent.CATEGORY_HOME);
                salida.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                startActivity(salida);

                break;



        }
    }

    @Override
    public void onFragmentInteraction(String infouUsu) {
        Toast.makeText(this,"Artista: "+infouUsu,Toast.LENGTH_LONG).show();
        Intent datos=new Intent(this, InfoPersonal.class);
        datos.putExtra("infoUsu",infouUsu);
        startActivity(datos);

    }

    @Override
    public void onFragmentInteraction(DBSQLite artista) {
        miArtista.registrarArtista(artista);

    }
}

