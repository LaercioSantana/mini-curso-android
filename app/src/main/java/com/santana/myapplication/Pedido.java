package com.santana.myapplication;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.Spinner;

public class Pedido extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.pedido);

        Spinner ingredientes1 = (Spinner) findViewById(R.id.ingredientes_spn_1);
        Spinner ingredientes2 = (Spinner) findViewById(R.id.ingredientes_spn_2);
        Spinner ingredientes3 = (Spinner) findViewById(R.id.ingredientes_spn_3);
        // Create an ArrayAdapter using the string array and a default spinner layout
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this, R.array.lista_ingredientes, android.R.layout.simple_spinner_item);
        // Specify the layout to use when the list of choices appears
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        // Apply the adapter to the spinner
        ingredientes1.setAdapter(adapter);
        ingredientes2.setAdapter(adapter);
        ingredientes3.setAdapter(adapter);
    }
}
