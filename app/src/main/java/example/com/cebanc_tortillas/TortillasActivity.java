package example.com.cebanc_tortillas;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.Spinner;
import android.widget.Toast;

import java.util.ArrayList;

public class TortillasActivity extends AppCompatActivity {

    String tipotortilla;
    String tamaño;
    String huevo;
    double preciotipo;
    Double suma=0.0;
    Double total=0.0;
    Double precio;

    int cant;

    String[] datos;
    ArrayList<String> list = new ArrayList<String>();
    private EditText cantidad;
    private Spinner cmbOpciones;
    private RadioButton rad1;
    private RadioButton rad2;
    private RadioButton rad3;
    private RadioButton rad4;
    private RadioButton rad5;
    private Button bSalir;
    private Button bSiguiente;
    private Button bAñadir;

    final String[] datosspinner = new String[]{"Patata - 1.30€","Verduras - 1.20€","Bacalao - 1.60€","Jamon Iberico - 1.80€","Queso Idiazabal - 2.20€","Hongos - 1.80€"};
    final String[] nombrespinner = new String[]{"patata","verdura","bacalao","jamon iberico","queso idiazabal","hongos"};
    final double[] preciospiiner = new double[]{1.30,1.20,1.60,1.80,2.20,1.80};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tortillas);
        Bundle extras = getIntent().getExtras();
        datos = extras.getStringArray("datos");

        cantidad=(EditText) findViewById(R.id.editText4);
        cmbOpciones = (Spinner) findViewById (R.id.spinner);
        ArrayAdapter<String> adaptador =new ArrayAdapter<String>(this,android.R.layout.simple_spinner_item, datosspinner);
        adaptador.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        cmbOpciones.setAdapter(adaptador);




        rad1=(RadioButton) findViewById(R.id.radioButton);
        rad2=(RadioButton) findViewById(R.id.radioButton2);
        rad3=(RadioButton) findViewById(R.id.radioButton3);
        rad4=(RadioButton) findViewById(R.id.radioButton4);
        rad5=(RadioButton) findViewById(R.id.radioButton5);

        bSalir=(Button) findViewById(R.id.button4);
        bSiguiente=(Button) findViewById(R.id.button5);
        bAñadir=(Button) findViewById(R.id.button);
        bAñadir.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                if(comprobar()==true) {
                    //2 x Tortilla de patata individual, huevos de granja (10.40€)
                    total=calcularTotal();
                    suma+=total;
                    String todo=(cant+" x Tortilla de "+tipotortilla+" "+tamaño+", huevos "+huevo+"-"+precio+"€");
                    Toast toast1 =Toast.makeText(getApplicationContext(),todo, Toast.LENGTH_SHORT);
                    toast1.show();
                    list.add(todo);
                }else{
                    Toast toast1 =Toast.makeText(getApplicationContext(),"Por favor rellene todos los datos", Toast.LENGTH_SHORT);
                    toast1.show();
                }


            }
        });
        bSalir.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                finish();

            }
        });
        cmbOpciones.setOnItemSelectedListener(
                new AdapterView.OnItemSelectedListener() {
                    public void onItemSelected(AdapterView<?> parent,android.view.View v, int position, long id) {
                        tipotortilla=nombrespinner[position];
                        preciotipo=preciospiiner[position];

                    }
                    public void onNothingSelected(AdapterView<?> parent) {
                    }
                });
        bSiguiente.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {

                if(list.size()>0){
                    lanzar(null);
                }
                else {
                    Toast toast1 =Toast.makeText(getApplicationContext(),"Por favor añada alguna tortilla", Toast.LENGTH_SHORT);
                    toast1.show();                }
            }
        });

    }
    public boolean comprobar() {
        boolean comp = false;
        if(rad1.isChecked() || rad2.isChecked()) {
            if(rad3.isChecked() || rad4.isChecked()|| rad5.isChecked()) {
                if(tipotortilla!=null) {
                    comp = true;
                    if (cantidad.getText().toString().equals("0") || cantidad.getText().toString().length() == 0) {
                        comp = false;
                    }
                }
            }

            }
        return comp;
    }
    public void lanzar(View view){
        Intent intent = new Intent(this,BebidasActivity.class);
        intent.putExtra("datos1",datos);
        intent.putExtra("datos2",list);
        intent.putExtra("totalTortillas",suma);

        startActivity(intent);
    }
    public double calcularTotal(){
        double devolver=0;
        cant = Integer.parseInt(cantidad.getText().toString());

        if(rad1.isChecked()){
            devolver+=3.50;
            tamaño="individual";
        }
        else if(rad2.isChecked())
            devolver+=6.00;
            tamaño="familiar";


        if(rad5.isChecked()){
            devolver+=0.80;
            huevo="de granja";
        }else if(rad4.isChecked()){
            devolver+=1.40;
            huevo="camperos";
        }else if(rad3.isChecked()){
            devolver+=2.25;
            huevo="ecologicos";
        }
        devolver+=preciotipo;

        precio=devolver;

        devolver*=cant;
        return devolver;
    }
}