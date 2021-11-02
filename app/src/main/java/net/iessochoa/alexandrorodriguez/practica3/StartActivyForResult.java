package net.iessochoa.alexandrorodriguez.practica3;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class StartActivyForResult extends AppCompatActivity implements View.OnClickListener {

    //Constantes EXTRA_
    public final static String EXTRA_DATOS_RESULTADO="net.iessochoa.alexandrorodriguez.practica3.StartActivyForResult.datos";
    public final static String EXTRA_DATOS="net.iessochoa.alexandrorodriguez.practica3.StartActivyForResult.datos";


    //Atributos
    private EditText etValor;
    //Botones
    private Button bOKValores;
    private Button bCancelValores;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_start_activy_for_result);

        etValor = findViewById(R.id.etValor);
        bOKValores = findViewById(R.id.bOKValores);
        bCancelValores = findViewById(R.id.bCancelValores);

        bOKValores.setOnClickListener(this);
        bCancelValores.setOnClickListener(this);

    }

    @Override
    public void onClick(View v) {
        switch(v.getId()){
            case R.id.bOKValores:

                break;
            case R.id.bCancelValores:
                setResult(RESULT_CANCELED);
                finish();
                break;
        }
    }

}