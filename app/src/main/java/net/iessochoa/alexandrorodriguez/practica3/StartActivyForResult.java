package net.iessochoa.alexandrorodriguez.practica3;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class StartActivyForResult extends AppCompatActivity implements View.OnClickListener {



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
                pasarValores();
                break;
            case R.id.bCancelValores:
                setResult(RESULT_CANCELED);
                finish();
                break;
        }
    }

    private void pasarValores() {
        String valor = etValor.getText().toString();
        if(!valor.isEmpty()){
            Intent intent = new Intent(StartActivyForResult.this, NuevoContactoActivity.class);
            intent.putExtra(NuevoContactoActivity.EXTRA_DATOS, valor);
            startActivity(intent);
        }

    }
}