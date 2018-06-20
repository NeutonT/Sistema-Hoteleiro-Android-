package com.example.neuton.cadastrocliente;

import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class QuartoCadastro extends Activity{

    EditText numero_edit;
    Button cadastrar_button, voltar_button;
    BancoQuarto db;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.quarto_cadastrar);


        numero_edit=(EditText)findViewById(R.id.editText_numero_numeroQuarto);

        cadastrar_button = (Button)findViewById(R.id.botao_cadastrar_cadastroQuarto);
        voltar_button = (Button)findViewById(R.id.botao_voltar_cadastrarQuarto);

        cadastrar_button.setOnClickListener(new OnClickListener() {

            @Override
            public void onClick(View arg0) {
                // TODO Auto-generated method stub

                String numero_aux = numero_edit.getText().toString();

                db = new BancoQuarto(QuartoCadastro.this, null, null, 2);
                RegistroQuarto reg = new RegistroQuarto();

                reg.setNumero(numero_aux);

                db.addRegister(reg);

                Toast.makeText(getApplicationContext(), "Registered", Toast.LENGTH_LONG).show();
                startActivity(new Intent(getApplicationContext(), Menu.class));
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
