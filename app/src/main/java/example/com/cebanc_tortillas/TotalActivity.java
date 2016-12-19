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



    }

}