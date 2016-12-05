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

                if(origem == null || destino == null || produtos == 0 || seguro == 0 || despesas == 0){
                    resultado.setText("Algum campo esta faltando");
                }
                else{
                    origem = origem.toUpperCase();
                    destino = destino.toUpperCase();

                    if(aliquotaPorUf(origem)==0 || aliquotaPorUf(destino)==0){
                        resultado.setText("Origem ou Destino não é uma UF");
                    }
                    else{
                        double soma = produtos + seguro + extra;
                        double aliquota;
                        if(origem =! destino){
                            aliquota = aliquotaPorUf(origem);
                        }
                        else{
                            aliquota = 17;
                        }
                        aliquota = aliquota/100;

                        double MVA = (1+0.35) * (1-0.17) / (1-aliquota);
                        double BC_TC = soma * MVA;

                        double ICMS_ST = BC_TC * aliquota;
                        resultado.setText("Total: " + ICMS_ST);
                    }
                }
            }
        });

    }

    protected int aliquotaPorUf(String uf){
        int aliquota = 0;
        switch (uf){
            case "AC":
                aliquota = 12;
                break;
            case "AL":
                aliquota = 12;
                break;
            case "AM":
                aliquota = 12;
                break;
            case "AP":
                aliquota = 12;
                break;
            case "BA":
                aliquota = 12;
                break;
            case "CE":
                aliquota = 12;
                break;
            case "DF":
                aliquota = 12;
                break;
            case "ES":
                aliquota = 12;
                break;
            case "GO":
                aliquota = 12;
                break;
            case "MA":
                aliquota = 12;
                break;
            case "MT":
                aliquota = 12;
                break;
            case "MS":
                aliquota = 12;
                break;
            case "MG":
                aliquota = 7;
                break;
            case "PA":
                aliquota = 12;
                break;
            case "PB":
                aliquota = 12;
                break;
            case "PR":
                aliquota = 7;
                break;
            case "PE":
                aliquota = 12;
                break;
            case "PI":
                aliquota = 12;
                break;
            case "RN":
                aliquota = 12;
                break;
            case "RS":
                aliquota = 7;
                break;
            case "RJ":
                aliquota = 7;
                break;
            case "RO":
                aliquota = 12;
                break;
            case "RR":
                aliquota = 12;
                break;
            case "SC":
                aliquota = 7;
                break;
            case "SP":
                aliquota = 7;
                break;
            case "SE":
                aliquota = 12;
                break;
            case "TO":
                aliquota = 12;
                break;
            default:
                aliquota = 0;
        }
    }
}
