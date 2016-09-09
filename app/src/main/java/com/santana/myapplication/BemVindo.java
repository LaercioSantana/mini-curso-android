package com.santana.myapplication;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class BemVindo extends AppCompatActivity {
    Button mFazerPizzaBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.bem_vindo);

        mFazerPizzaBtn = (Button) findViewById(R.id.button);
        mFazerPizzaBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intencao = new Intent(v.getContext(), Pedido.class);
                startActivity(intencao);
            }
        });
    }
}
