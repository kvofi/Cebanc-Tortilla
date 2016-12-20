package example.com.cebanc_tortillas;

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


public class TotalActivity extends AppCompatActivity {
    String[] personas;
    ArrayList<String> tortillas;
    ArrayList<String> bebidas;
    double totalTortillas;
    double totalBebidas;
    Button bSalir;
    Button bSiguiente;
    TextView nombre;
    //



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_total);

        Bundle extras = getIntent().getExtras();
        personas = extras.getStringArray("datos1");
        tortillas= extras.getStringArrayList("datos2");
        bebidas= extras.getStringArrayList("datos3");
        totalTortillas= extras.getDouble("totalTortillas");
        totalBebidas= extras.getDouble("totalBebidas");
        bSalir=(Button) findViewById(R.id.button10);
        bSiguiente=(Button) findViewById(R.id.button11);
        nombre= (TextView) findViewById(R.id.textView4) ;
        nombre.setText(personas[0]+","+personas[1]);
        bSalir.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                finish();
            }
        });
        bSiguiente.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                Toast toast1 =Toast.makeText(getApplicationContext(),totalBebidas+"/"+totalTortillas, Toast.LENGTH_SHORT);
                toast1.show();
            }
        });



    }

}