package net.iessochoa.alexandrorodriguez.practica3;

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

import androidx.appcompat.app.AppCompatActivity;

public class NuevoContactoActivity extends AppCompatActivity implements SeekBar.OnSeekBarChangeListener, View.OnClickListener {

    //Constantes EXTRA_
    //public final static String EXTRA_DATOS_RESULTADO="net.iessochoa.alexandrorodriguez.practica3.NuevoContactoActivity.class";

    //public final static String EXTRA_DATOS="net.iessochoa.alexandrorodriguez.practica3.NuevoContactoActivity.class";


    //Constantes
    //public final static int OPTION_REQUEST_NOMBRE=0;
    //public final static int OPTION_REQUEST_APELLIDOS=1;
    //public final static int OPTION_REQUEST_EMPRESA=2;

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
        //ImageView
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
        //Listener RadioGroup
        grbGrupo1.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                switch (checkedId){
                    case R.id.rbEmpresa:
                        iv_Emp_Par.setVisibility(View.VISIBLE);
                        //iv_Emp_Par.setImageResource(R.drawable.ic_empresa_foreground);
                        break;
                    case R.id.rbParticular:
                        iv_Emp_Par.setVisibility(View.VISIBLE);
                        //iv_Emp_Par.setImageResource(R.drawable.ic_particular_foreground);
                        break;
                }
            }
        });
        grbGrupo2.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                switch (checkedId){
                    case R.id.rbHombre:
                        iv_Hom_Muj.setVisibility(View.VISIBLE);
                        //iv_Hom_Muj.setImageResource(R.mipmap.ic_masculino_background);
                        break;
                    case R.id.rbMujer:
                        iv_Hom_Muj.setVisibility(View.VISIBLE);
                        //iv_Hom_Muj.setImageResource(R.mipmap.ic_femenino_background);
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
                    iv_llamar.setVisibility(View.VISIBLE);
                    //iv_llamar.setImageResource(R.drawable.ic_record_llamar_foreground);
                }else{
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
                    iv_Favor.setVisibility(View.VISIBLE);
                    //iv_Favor.setImageResource(R.drawable.ic_favoritos_foreground);
                }else{
                    iv_Favor.setVisibility(View.INVISIBLE);
                }
            }
        });

        /**----------------------------------------------------------*/
        //Listener SeekBar
        sbEdad.setOnSeekBarChangeListener(this);

    }

    /**----------------------------------------------------------*/

    /**----------------------------------------------------------*/



    /**----------------------------------------------------------*/
    //TextView funcionamiento
    @Override
    public void onClick(View v) {
        switch (v.getId()){
            //TextView
            case R.id.tv_NombreNueCont:
                cambiarActividadValores();
                break;
            case R.id.tv_ApellidosNueCon:
                cambiarActividadValores();
                break;
            case R.id.tv_EmpresaNueCon:
                cambiarActividadValores();
                break;
        }
    }

    public void cambiarActividadValores(){
        Intent intent = new Intent(NuevoContactoActivity.this, StartActivyForResult.class);
        startActivity(intent);
    }



    /**----------------------------------------------------------*/
    //SeekBar Funcionamiento
    @Override
    public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
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

    /**----------------------------------------------------------*/
}