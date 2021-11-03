package net.iessochoa.alexandrorodriguez.practica3;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import androidx.appcompat.app.AppCompatActivity;

public class DatosActivity extends AppCompatActivity implements View.OnClickListener {

    //Constantes EXTRA_
    public final static String EXTRA_DATOS_RESULTADO="net.iessochoa.alexandrorodriguez.practica3.DatosActivity.resultado";
    public final static String EXTRA_DATOS="net.iessochoa.alexandrorodriguez.practica3.DatosActivity.datos";

    //Atributos
    private EditText etValor;

    //Botones
    private Button bOKValores;
    private Button bCancelValores;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_datos);

        etValor = findViewById(R.id.etValor);
        bOKValores = findViewById(R.id.bOKValores);
        bCancelValores = findViewById(R.id.bCancelValores);

        bOKValores.setOnClickListener(this);
        bCancelValores.setOnClickListener(this);

        //obtenemos el valor de la actividad llamadora y lo mostraremos
        etValor.setText(getIntent().getStringExtra(EXTRA_DATOS));



    }

    /**
     * Este método implementa el evento de los botones ok y cancel
     */
    @Override
    public void onClick(View v) {
        switch(v.getId()){
            case R.id.bOKValores:
                // Si el EditText no está vacío enviamos el resultado
                if(etValor.getText().length()!=0) {
                    //guardamos el resultado en el Intent que llamó la actividad, aunque
                    //podríamos crear uno nuevo
                    Intent iBack = getIntent();

                    iBack.putExtra(EXTRA_DATOS_RESULTADO,etValor.getText().toString());
                    //indicamos que se ha pulsado aceptar y enviamos el Intent
                    setResult(RESULT_OK,iBack);
                    //cerramos la actividad
                    finish();
                }

                break;
            case R.id.bCancelValores:
                //indicamos que se ha pulsado cancelar y cerramos la actividad
                setResult(RESULT_CANCELED);
                finish();
                break;
        }
    }

}