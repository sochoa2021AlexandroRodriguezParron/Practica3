package net.iessochoa.alexandrorodriguez.practica3;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.SeekBar;
import android.widget.Switch;
import android.widget.TextView;

import androidx.activity.result.ActivityResult;
import androidx.activity.result.ActivityResultCallback;
import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.appcompat.app.AppCompatActivity;

public class NuevoContactoActivity extends AppCompatActivity implements SeekBar.OnSeekBarChangeListener, View.OnClickListener {

    //Constante para trasladar datos
    public final static String EXTRA="net.iessochoa.alexandrorodriguez.practica3.NuevoContactoActivity.extra";

    //Atributos
    //TextView
    private TextView tv_NombreNueCont;
    private TextView tv_ApellidosNueCon;
    private TextView tv_EmpresaNueCon;
    private TextView tv_Edad;

    //Editext
    private EditText etTelefono;

    //RadioGroup1 Y RadioButtons
    private RadioGroup grbGrupo1;
    private RadioButton rbEmpresa;
    private RadioButton rbParticular;

    //RadioGroup2 Y RadioButtons
    private RadioGroup grbGrupo2;
    private RadioButton rbHombre;
    private RadioButton rbMujer;

    //Switch
    private Switch sFavoritos;

    //CheckBox
    private CheckBox cb_RecorLlamar;

    //SeekBar
    private SeekBar sbEdad;

    //Button
    private Button bOK;
    private Button bCancel;

    //ImageView
    private ImageView iv_llamar;
    private ImageView iv_Emp_Par;
    private ImageView iv_Favor;
    private ImageView iv_Hom_Muj;

    //ActivityResultLauncher
    private ActivityResultLauncher<Intent> mStartForResultNombre;
    private ActivityResultLauncher<Intent> mStartForResultApellidos;
    private ActivityResultLauncher<Intent> mStartForResultEmpresa;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_nuevo_contacto);

        //Damos referencia cada atributo con cada elemento del layout
        //TextView
        tv_NombreNueCont = findViewById(R.id.tv_NombreNueCont);
        tv_ApellidosNueCon = findViewById(R.id.tv_ApellidosNueCon);
        tv_EmpresaNueCon = findViewById(R.id.tv_EmpresaNueCon);
        tv_Edad = findViewById(R.id.tv_Edad);
        //EditText
        etTelefono = findViewById(R.id.etTelefono);
        //RadioGroup1 y RadioButton
        grbGrupo1 = findViewById(R.id.grbGrupo1);
        rbEmpresa = findViewById(R.id.rbEmpresa);
        rbParticular = findViewById(R.id.rbParticular);
        //RadioGroup2 y RadioButton
        grbGrupo2 = findViewById(R.id.grbGrupo2);
        rbHombre = findViewById(R.id.rbHombre);
        rbMujer = findViewById(R.id.rbMujer);
        //Switch
        sFavoritos = findViewById(R.id.sFavoritos);
        //CheckBox
        cb_RecorLlamar = findViewById(R.id.cb_RecorLlamar);
        //SeekBar
        sbEdad = findViewById(R.id.sbEdad);
        //Button
        bOK = findViewById(R.id.bOK);
        bCancel = findViewById(R.id.bCancel);
        //ImageView y establecer invisible
        iv_llamar = findViewById(R.id.iv_llamar);
        iv_llamar.setVisibility(View.INVISIBLE);
        iv_Emp_Par = findViewById(R.id.iv_Emp_Par);
        iv_Emp_Par.setVisibility(View.INVISIBLE);
        iv_Favor = findViewById(R.id.iv_Favor);
        iv_Favor.setVisibility(View.INVISIBLE);
        iv_Hom_Muj = findViewById(R.id.iv_Hom_Muj);
        iv_Hom_Muj.setVisibility(View.INVISIBLE);

        /**----------------------------------------------------------*/

        //Listener TextView
        tv_NombreNueCont.setOnClickListener(this);
        tv_ApellidosNueCon.setOnClickListener(this);
        tv_EmpresaNueCon.setOnClickListener(this);
        /**----------------------------------------------------------*/
        //Listener Botones
        bOK.setOnClickListener(this);
        bCancel.setOnClickListener(this);


        /**----------------------------------------------------------*/
        //Listener RadioGroup
        grbGrupo1.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                switch (checkedId){
                    case R.id.rbEmpresa:
                        //Radio Button Empresa, establece el icono y lo pone visible
                        iv_Emp_Par.setVisibility(View.VISIBLE);
                        iv_Emp_Par.setImageResource(R.drawable.ic_empresa_foreground);
                        break;
                    case R.id.rbParticular:
                        //Radio Button Particular, establece el icono y lo pone visible
                        iv_Emp_Par.setVisibility(View.VISIBLE);
                        iv_Emp_Par.setImageResource(R.drawable.ic_particular_foreground);
                        break;
                }
            }
        });
        grbGrupo2.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                switch (checkedId){
                    case R.id.rbHombre:
                        //Radio Button Hombre, establece el icono y lo pone visible
                        iv_Hom_Muj.setVisibility(View.VISIBLE);
                        iv_Hom_Muj.setImageResource(R.drawable.ic_hombre_foreground);
                        break;
                    case R.id.rbMujer:
                        //Radio Button Empresa, establece el icono y lo pone visible
                        iv_Hom_Muj.setVisibility(View.VISIBLE);
                        iv_Hom_Muj.setImageResource(R.drawable.ic_mujer_foreground);
                        break;
                }
            }
        });
        /**----------------------------------------------------------*/
        //Listener CheckBox
        cb_RecorLlamar.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if(isChecked){
                    //Check Box Recordar Llamar, establece el icono y lo pone visible
                    iv_llamar.setVisibility(View.VISIBLE);
                    iv_llamar.setImageResource(R.drawable.ic_llamar_foreground);
                }else{
                    //Si no lo pone invisible
                    iv_llamar.setVisibility(View.INVISIBLE);
                }
            }
        });
        /**----------------------------------------------------------*/
        //Listener Switch
        sFavoritos.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if(isChecked){
                    //Switch Favorito, establece el icono y lo pone visible
                    iv_Favor.setVisibility(View.VISIBLE);
                    iv_Favor.setImageResource(R.drawable.ic_favorito_foreground);
                }else{
                    //Si no lo pone invisible
                    iv_Favor.setVisibility(View.INVISIBLE);
                }
            }
        });

        /**----------------------------------------------------------*/
        //Listener SeekBar
        sbEdad.setOnSeekBarChangeListener(this);

        /**----------------------------------------------------------*/
        //ActivityLancher, cada atributo obtiene un valor distinto de la clase Datos Activity.
        mStartForResultNombre = activityLauncher(tv_NombreNueCont);
        mStartForResultApellidos = activityLauncher(tv_ApellidosNueCon);
        mStartForResultEmpresa = activityLauncher(tv_EmpresaNueCon);
    }

    /**----------------------------------------------------------*/
    //TextView y Button funcionamiento
    @Override
    public void onClick(View v) {
        switch (v.getId()){
            /**TextView*/
            case R.id.tv_NombreNueCont:
                llamarDatos(mStartForResultNombre, tv_NombreNueCont);
                break;
            case R.id.tv_ApellidosNueCon:
                llamarDatos(mStartForResultApellidos, tv_ApellidosNueCon);
                break;
            case R.id.tv_EmpresaNueCon:
                llamarDatos(mStartForResultEmpresa, tv_EmpresaNueCon);
                break;
            /**Buttons*/
            case R.id.bOK:
                String nombre = tv_NombreNueCont.getText().toString();
                String apellido = tv_ApellidosNueCon.getText().toString();
                long telefono = Long.parseLong(etTelefono.getText().toString());
                //Guardamos las variables en un String que se pasará a la clase MainActivity
                String infoGuardar = nombre + " " + apellido + ": " + telefono;
                //Lo pasamos al MainActivity
                Intent intent = getIntent();
                intent.putExtra(EXTRA, infoGuardar);
                setResult(RESULT_OK, intent);
                finish();
                break;
            case R.id.bCancel:
                //Cancela y termina esta actividad
                setResult(RESULT_CANCELED);
                finish();
                break;
        }
    }

    //Método que nos ayudará a pasar los datos de DatosActivity al TextView indicado
    public ActivityResultLauncher<Intent> activityLauncher(TextView textView){
        ActivityResultLauncher<Intent> mStartForResult = registerForActivityResult(new ActivityResultContracts.StartActivityForResult(),
                new ActivityResultCallback<ActivityResult>() {
                    @Override
                    public void onActivityResult(ActivityResult result) {
                        //si el usuario pulsa OK en la Activity que hemos llamado
                        if (result.getResultCode() == Activity.RESULT_OK) {
                            //recuperamos los dados
                            Intent intent = result.getData();
                            String resultado = intent.getStringExtra(DatosActivity.EXTRA_DATOS_RESULTADO);
                            textView.setText(resultado);
                        }
                    }
                });
        return mStartForResult;
    }

    //Iniciamos la actividad DatosActivity y mandamos los datos de esta actividad a aquella para que se muestre en su EditText
    public void llamarDatos(ActivityResultLauncher<Intent> mStartForResult, TextView textView){
        Intent i=new Intent(this, DatosActivity.class);
        i.putExtra(DatosActivity.EXTRA_DATOS,textView.getText().toString());
        mStartForResult.launch(i);
    }




    /**----------------------------------------------------------*/
    //SeekBar Funcionamiento
    @Override
    public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
        //Obtenemos el valor del SeekBar y lo establecemos en un textView
        String recurso = getResources().getString(R.string.edad_Formateada);
        String edad = String.format(recurso, progress);
        tv_Edad.setText(edad);
    }

    @Override
    public void onStartTrackingTouch(SeekBar seekBar) {

    }
    @Override
    public void onStopTrackingTouch(SeekBar seekBar) {

    }
}