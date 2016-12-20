package example.com.cebanc_tortillas;

import android.support.annotation.IntegerRes;
import android.support.v7.app.AppCompatActivity;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;


public class BebidasActivity extends AppCompatActivity {
    Button bMenosCola;
    Button bMasCola;
    Button bMenosLimon;
    Button bMasLimon;
    Button bMenosNaranja;
    Button bMasNaranja;
    Button bMenosNestea;
    Button bMasNestea;
    Button bMenosCerveza;
    Button bMasCerveza;
    Button bMenosAgua;
    Button bMasAgua;
    Button bSalir;
    Button bSiguiente;
    TextView textViewCola;
    TextView textViewLimon;
    TextView textViewNaranja;
    TextView textViewNestea;
    TextView textViewCerveza;
    TextView textViewAgua;

    String[] datos;
    ArrayList<String> list;
    ArrayList<String> list2= new ArrayList<String>();

    double totalTortillas=0.0;
    double totalBebidas=0.0;




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bebidas);
        Bundle extras = getIntent().getExtras();
        datos = extras.getStringArray("datos1");
        list = extras.getStringArrayList("datos2");
        totalTortillas= extras.getDouble("totalTortillas");


        bMenosCola=(Button) findViewById(R.id.btnMenosCola);
        bMasCola=(Button) findViewById(R.id.btnMasCola);
        bMenosLimon=(Button) findViewById(R.id.btnMenosLimon);
        bMasLimon=(Button) findViewById(R.id.btnMasLimon);
        bMenosNaranja=(Button) findViewById(R.id.btnMenosNaranja);
        bMasNaranja=(Button) findViewById(R.id.btnMasNaranja);
        bMenosNestea=(Button) findViewById(R.id.btnMenosNestea);
        bMasNestea=(Button) findViewById(R.id.btnMasNestea);
        bMenosCerveza=(Button) findViewById(R.id.btnMenosCerveza);
        bMasCerveza=(Button) findViewById(R.id.btnMasCerveza);
        bMenosAgua=(Button) findViewById(R.id.btnMenosAgua);
        bMasAgua=(Button) findViewById(R.id.btnMasAgua);
        textViewCola=(TextView) findViewById(R.id.textViewCola);
        textViewLimon=(TextView) findViewById(R.id.textViewLimon);
        textViewNaranja=(TextView) findViewById(R.id.textViewNaranja);
        textViewNestea=(TextView) findViewById(R.id.textViewNestea);
        textViewCerveza=(TextView) findViewById(R.id.textViewCerveza);
        textViewAgua=(TextView) findViewById(R.id.textViewAgua);


        bSalir=(Button) findViewById(R.id.button2);
        bSiguiente=(Button) findViewById(R.id.button3);
        bSalir.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                finish();
            }
        });
        bSiguiente.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                totalBebidas=rellenarArray();
                lanzar();
            }
        });

        bMasCola.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                calcular(true, textViewCola);
            }
        });
        bMenosCola.setOnClickListener(new View.OnClickListener()  {
            public void onClick(View view) {
                calcular(false, textViewCola);
            }
        });
        bMenosLimon.setOnClickListener(new View.OnClickListener()  {
            public void onClick(View view) {
                calcular(false, textViewLimon);
            }
        });
        bMasLimon.setOnClickListener(new View.OnClickListener()  {
            public void onClick(View view) {
                calcular(true, textViewLimon);
            }
        });
        bMenosNaranja.setOnClickListener(new View.OnClickListener()  {
            public void onClick(View view) {
                calcular(false, textViewNaranja);
            }
        });
        bMasNaranja.setOnClickListener(new View.OnClickListener()  {
            public void onClick(View view) {
                calcular(true, textViewNaranja);
            }
        });
        bMenosNestea.setOnClickListener(new View.OnClickListener()  {
            public void onClick(View view) {
                calcular(false, textViewNestea);
            }
        });
        bMasNestea.setOnClickListener(new View.OnClickListener()  {
            public void onClick(View view) {
                calcular(true, textViewNestea);
            }
        });
        bMenosCerveza.setOnClickListener(new View.OnClickListener()  {
            public void onClick(View view) {
                calcular(false, textViewCerveza);
            }
        });
        bMasCerveza.setOnClickListener(new View.OnClickListener()  {
            public void onClick(View view) {
                calcular(true, textViewCerveza);
            }
        });
        bMenosAgua.setOnClickListener(new View.OnClickListener()  {
            public void onClick(View view) {
                calcular(false, textViewAgua);
            }
        });
        bMasAgua.setOnClickListener(new View.OnClickListener()  {
            public void onClick(View view) {
                calcular(true, textViewAgua);
            }
        });
    }
    public void lanzar(){
        Intent intent = new Intent(this,TotalActivity.class);
        intent.putExtra("datos1",datos);
        intent.putExtra("datos2",list);
        intent.putExtra("datos3",list2);
        intent.putExtra("totalTortillas",totalTortillas);
        intent.putExtra("totalBebidas",totalBebidas);
        startActivity(intent);
    }
    public double rellenarArray(){
        double cant=0.0;

        if(Integer.parseInt(textViewCola.getText().toString())>0){
            cant =+(Double.parseDouble(textViewCola.getText().toString()) *1.95);
            list2.add(Integer.parseInt(textViewCola.getText().toString())+"x Bebida de cola - 1.95€");

        }

        if(Integer.parseInt(textViewLimon.getText().toString())>0){
            cant += Integer.parseInt(textViewLimon.getText().toString()) *1.90;
            list2.add(Integer.parseInt(textViewLimon.getText().toString())+"x Bebida de limon - 1.90€");
        }

        if(Integer.parseInt(textViewNaranja.getText().toString())>0){
            cant += Double.parseDouble(textViewNaranja.getText().toString()) *1.90;
            list2.add(Double.parseDouble(textViewNaranja.getText().toString())+"x Bebida de naranja - 1.90€");
        }

        if(Integer.parseInt(textViewNestea.getText().toString())>0){
            cant += Integer.parseInt(textViewNestea.getText().toString()) *1.50;
            list2.add(Integer.parseInt(textViewNestea.getText().toString())+"x Bebida de nestea - 1.50€");
        }

        if(Integer.parseInt(textViewCerveza.getText().toString())>0){
            cant += Integer.parseInt(textViewCerveza.getText().toString()) *1.65;
            list2.add(Integer.parseInt(textViewCerveza.getText().toString())+"x Bebida de cerveza - 1.65€");
        }

        if(Integer.parseInt(textViewAgua.getText().toString())>0){
            cant += Integer.parseInt(textViewAgua.getText().toString()) *1.00;
            list2.add(Integer.parseInt(textViewAgua.getText().toString())+"x Bebida de agua - 1.00€");
        }
        return cant;

    }

    public void calcular(boolean sumar,  TextView text){
        int cantidad =  Integer.parseInt(text.getText().toString());
        if(sumar==true)
            cantidad++;
        else{
            if(cantidad>0)
                cantidad--;
        }
        text.setText(cantidad+"");
    }
}