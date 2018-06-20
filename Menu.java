package com.example.neuton.cadastrocliente;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;

public class Menu extends Activity{

    Button cadastrar_button, consultar_button, cadastrar_quarto_button, consultar_quarto_button;


    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.menu);

        cadastrar_button = (Button)findViewById(R.id.botao_cadastrar_menuCliente);
        consultar_button = (Button)findViewById(R.id.botao_consultar_menuCliente);
        cadastrar_quarto_button = (Button)findViewById(R.id.botao_cadastrarQuarto_menuCliente);
        consultar_quarto_button = (Button)findViewById(R.id.botao_consultarQuarto_menuCliente);

        cadastrar_button.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getApplicationContext(), ClienteCadastro.class));
            }
        });

        consultar_button.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getApplicationContext(), ClienteConsulta.class));
            }
        });

        cadastrar_quarto_button.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getApplicationContext(), QuartoCadastro.class));
            }
        });

        consultar_quarto_button.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getApplicationContext(), QuartoConsulta.class));
            }
        });

    }
}
