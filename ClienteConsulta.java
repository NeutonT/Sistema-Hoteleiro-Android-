package com.example.neuton.cadastrocliente;

import android.content.Intent;
import android.os.Bundle;
import android.app.Activity;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;


public class ClienteConsulta extends Activity{

    EditText digitar_nome_para_consultar_editText;
    TextView nome_view, dataNascimento_view, cpf_view, id_view;
    Button consultar_button, voltar_button;
    BancoCliente db;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.cliente_consultar);

        digitar_nome_para_consultar_editText = (EditText)findViewById(R.id.editText_consultar_cliente);

        id_view = (TextView)findViewById(R.id.ver_id_consultar_cliente);
        nome_view = (TextView)findViewById(R.id.ver_nome_consultar_cliente);
        dataNascimento_view = (TextView)findViewById(R.id.ver_data_de_nascimento_consultar_cliente);
        cpf_view = (TextView)findViewById(R.id.ver_cpf_consultar_cliente);

        consultar_button = (Button)findViewById(R.id.botao_consultar_cliente);
        voltar_button = (Button)findViewById(R.id.botao_voltar_consultar_cliente);

        consultar_button.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View arg0) {
                db=new BancoCliente(ClienteConsulta.this, null, null, 2);
                String nome_procurado = digitar_nome_para_consultar_editText.getText().toString();

                String[] retorno_da_consulta = db.getregister(nome_procurado);

                id_view.setText(retorno_da_consulta[0]);
                nome_view.setText(retorno_da_consulta[1]);
                dataNascimento_view.setText(retorno_da_consulta[2]);
                cpf_view.setText(retorno_da_consulta[3]);
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
