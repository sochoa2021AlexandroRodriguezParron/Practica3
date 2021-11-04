package net.iessochoa.alexandrorodriguez.practica3;

import android.app.Activity;
import android.app.Instrumentation;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.activity.result.ActivityResult;
import androidx.activity.result.ActivityResultCallback;
import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.appcompat.app.AppCompatActivity;

import javax.xml.transform.Result;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private Button bNuevo;
    private Button bSalir;
    private TextView tv_Contactos;
    private String nuevoContacto;

    ActivityResultLauncher<Intent> mStartForResult = registerForActivityResult(new ActivityResultContracts.StartActivityForResult(),
            new ActivityResultCallback<ActivityResult>() {
                @Override
                public void onActivityResult(ActivityResult result) {
                    //si el usuario pulsa OK en la Activity que hemos llamado
                    if (result.getResultCode() == Activity.RESULT_OK) {
                        //recuperamos los dados
                        Intent intent = result.getData();
                        String resultado = intent.getStringExtra(NuevoContactoActivity.EXTRA);
                        nuevoContacto = tv_Contactos.getText().toString()+"\n"+resultado;
                        tv_Contactos.setText(nuevoContacto);
                    }
                }
            });

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        bNuevo = findViewById(R.id.bNuevo);
        bSalir = findViewById(R.id.bSalir);
        tv_Contactos = findViewById(R.id.tv_Contactos);



        bNuevo.setOnClickListener(this);
        bSalir.setOnClickListener(this);

    }

    @Override
    public void onClick(View v) {
        switch(v.getId()){
            case R.id.bNuevo:
                Intent i = new Intent(MainActivity.this, NuevoContactoActivity.class);
                mStartForResult.launch(i);
                break;
            case R.id.bSalir:
                finish();
                break;
        }
    }
}