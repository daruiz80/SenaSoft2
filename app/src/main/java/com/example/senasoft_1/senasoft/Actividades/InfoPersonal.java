package com.example.senasoft_1.senasoft.Actividades;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.EditText;

import com.example.senasoft_1.senasoft.R;

public class InfoPersonal extends AppCompatActivity {

    EditText nombre;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.info_personal);

        nombre=findViewById(R.id.namearti);

        Bundle para=this.getIntent().getExtras();
        if (para!=null){
            String datos=para.getString("infoUsu");
            nombre.setText(datos);
        }
//Ariel fumetas
    }
}
