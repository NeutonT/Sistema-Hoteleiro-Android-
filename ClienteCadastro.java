package com.example.neuton.cadastrocliente;

import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;


public class ClienteCadastro extends Activity {

    EditText nome_edit, dataNascimento_edit, cpf_edit;

    Button cadastrar_button, voltar_button;
    BancoCliente db;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.cliente_cadastrar);

        nome_edit=(EditText)findViewById(R.id.editText_nome_cliente);
        dataNascimento_edit=(EditText)findViewById(R.id.editText_data_de_nascimento);
        cpf_edit=(EditText)findViewById(R.id.editText_cpf);

        cadastrar_button = (Button)findViewById(R.id.botao_cadastrar_cliente);
        voltar_button = (Button)findViewById(R.id.botao_voltar_cadastrar_cliente);

        cadastrar_button.setOnClickListener(new OnClickListener() {

            @Override
            public void onClick(View arg0) {
                // TODO Auto-generated method stub

                String nome_aux = nome_edit.getText().toString();
                String dataNascimento_aux = dataNascimento_edit.getText().toString();
                String cpf_aux = cpf_edit.getText().toString();

                db = new BancoCliente(ClienteCadastro.this, null, null, 2);
                RegistroCliente reg = new RegistroCliente();

                reg.setNome(nome_aux);
                reg.setDataNascimento(dataNascimento_aux);
                reg.setCpf(cpf_aux);

                db.addregister(reg);

                Toast.makeText(getApplicationContext(), "Registrado", Toast.LENGTH_LONG).show();
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
