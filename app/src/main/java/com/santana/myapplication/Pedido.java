package com.santana.myapplication;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioGroup;
import android.widget.Spinner;
import android.widget.TextView;

public class Pedido extends AppCompatActivity implements RadioGroup.OnCheckedChangeListener, TextWatcher, AdapterView.OnItemSelectedListener {
    Spinner ingredientes1, ingredientes2, ingredientes3;
    RadioGroup tipoMassa;
    EditText quantFatias;
    Button pedir;
    TextView preco;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.pedido);

        ingredientes1 = (Spinner) findViewById(R.id.ingredientes_spn_1);
        ingredientes2 = (Spinner) findViewById(R.id.ingredientes_spn_2);
        ingredientes3 = (Spinner) findViewById(R.id.ingredientes_spn_3);
        // Create an ArrayAdapter using the string array and a default spinner layout
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this, R.array.lista_ingredientes, android.R.layout.simple_spinner_item);
        // Specify the layout to use when the list of choices appears
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        // Apply the adapter to the spinner
        ingredientes1.setAdapter(adapter);
        ingredientes2.setAdapter(adapter);
        ingredientes3.setAdapter(adapter);

        tipoMassa = (RadioGroup) findViewById(R.id.tipo_massa);
        quantFatias = (EditText) findViewById(R.id.quant_fatias_et);
        pedir = (Button) findViewById(R.id.pedir_btn);

        tipoMassa.setOnCheckedChangeListener(this);
        quantFatias.addTextChangedListener(this);
        ingredientes1.setOnItemSelectedListener(this);
        ingredientes2.setOnItemSelectedListener(this);
        ingredientes3.setOnItemSelectedListener(this);

        preco = (TextView) findViewById(R.id.preco_tv);
    }
    private void atualizarPreco(){
        double preco = 0;

        if ( tipoMassa.getCheckedRadioButtonId() == R.id.fina_rb)
            preco += 2;
        else
            preco +=3;

        preco += ingredientes1.getSelectedItemPosition() * 0.7;
        preco += ingredientes2.getSelectedItemPosition() * 0.7;
        preco += ingredientes3.getSelectedItemPosition() * 0.7;

        String fatias = quantFatias.getText().toString();

        if(fatias != null && !fatias.equals(""))
            preco *= Integer.parseInt(fatias);
        else
            preco = 0;

        this.preco.setText("Preço: "+ String.format("%.2f", preco) );
    }

    @Override
    public void onCheckedChanged(RadioGroup group, int checkedId) {
        atualizarPreco();
    }

    @Override
    public void beforeTextChanged(CharSequence s, int start, int count, int after) {
    }

    @Override
    public void onTextChanged(CharSequence s, int start, int before, int count) {
    }

    @Override
    public void afterTextChanged(Editable s) {
        atualizarPreco();
    }

    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
        atualizarPreco();
    }

    @Override
    public void onNothingSelected(AdapterView<?> parent) {

    }
}
