package com.example.neuton.cadastrocliente;

import android.content.Intent;
import android.os.Bundle;
import android.app.Activity;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class QuartoConsulta extends Activity{

    EditText digitar_numero_para_consultar_editText;
    TextView id_view,numero_view;
    Button consultar_button, voltar_button;
    BancoQuarto db;


    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.quarto_consultar);


        digitar_numero_para_consultar_editText = (EditText)findViewById(R.id.editText_consultar_quarto);

        id_view = (TextView)findViewById(R.id.ver_id_quarto_consultaQuarto);
        numero_view = (TextView)findViewById(R.id.ver_numero_quarto_consultarQuarto);

        consultar_button = (Button)findViewById(R.id.botao_consultar_quarto_consultarQuarto);
        voltar_button = (Button)findViewById(R.id.botao_voltar_consultarQuarto);


        consultar_button.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View arg0) {
                db=new BancoQuarto(QuartoConsulta.this, null, null, 2);
                String numero_procurado = digitar_numero_para_consultar_editText.getText().toString();
                //String nome_consultado = db.getregister("neu");
                String[] retorno_da_consulta = db.getRegister(numero_procurado);
                id_view.setText(retorno_da_consulta[0]);
                numero_view.setText(retorno_da_consulta[1]);
            }
        });

        voltar_button.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View arg0) {
                startActivity(new Intent(getApplicationContext(), Menu.class));
            }
        });
    }
}
