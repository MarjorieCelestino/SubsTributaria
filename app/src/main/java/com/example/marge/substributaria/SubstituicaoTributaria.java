package com.example.marge.substributaria;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import org.w3c.dom.Text;

public class SubstituicaoTributaria extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_substituicao_tributaria);

        final TextView resultado = (TextView) findViewById(R.id.resultado);
        Button calcular = (Button) findViewById(R.id.calcular);
        calcular.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                EditText ufOrigem = (EditText) findViewById(R.id.uf_origem);
                String origem = ufOrigem.getText().toString();
                EditText ufDestino = (EditText) findViewById(R.id.uf_destino);
                String destino = ufDestino.getText().toString();
                EditText valorProdutos = (EditText) findViewById(R.id.valor_produto);
                double produtos = Double.valueOf(valorProdutos.getText().toString());
                EditText freteSeguro = (EditText) findViewById(R.id.frete_seguro);
                double seguro = Double.valueOf(freteSeguro.getText().toString());
                EditText despesas = (EditText) findViewById(R.id.despesas_extra);
                double extra = Double.valueOf(despesas.getText().toString());

                double soma = produtos + seguro + extra;
                double IVA = 0.1 * soma;
                double BC_TC = soma + IVA;
                double ICMS_ST = BC_TC;

                resultado.setText("Total: " + ICMS_ST);

            }
        });

    }
}
