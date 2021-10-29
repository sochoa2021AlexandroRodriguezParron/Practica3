package net.iessochoa.alexandrorodriguez.practica3;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private Button bNuevo;
    private Button bSalir;
    private EditText etm_Contactos;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        bNuevo = findViewById(R.id.bNuevo);
        bSalir = findViewById(R.id.bSalir);
        etm_Contactos = findViewById(R.id.etm_Contactos);

        bNuevo.setOnClickListener(this);
        bSalir.setOnClickListener(this);

    }

    @Override
    public void onClick(View v) {
        switch(v.getId()){
            case R.id.bNuevo:
                Intent intent = new Intent(MainActivity.this, NuevoContactoActivity.class);
                startActivity(intent);
                break;
            case R.id.bSalir:
                finish();
                break;
        }
    }
}