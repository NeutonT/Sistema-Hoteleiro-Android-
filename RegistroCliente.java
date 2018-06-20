package com.example.neuton.cadastrocliente;

public class RegistroCliente {


    //private variables
    int _id;
    String nome;
    String dataNascimento;
    String cpf;


    // Empty constructor
    public RegistroCliente(){

    }
    // constructor
    public RegistroCliente(int id, String nome, String  dataNascimento,String cpf){
        this._id = id;
        this.nome = nome;
        this.dataNascimento = dataNascimento;
        this.cpf=cpf;
    }

    // getting ID
    public int getID(){
        return this._id;
    }
    // setting id
    public void setID(int id){
        this._id = id;
    }

    public String getNome() {
        // TODO Auto-generated method stub
        return nome;
    }
    // setting  nome
    public void setNome(String nome){
        this.nome =nome;
    }


    public String getDataNascimento() {
        // TODO Auto-generated method stub
        return dataNascimento;
    }
    public void setDataNascimento(String dataNascimento){
        this.dataNascimento = dataNascimento;
    }


    public String getCpf() {
        // TODO Auto-generated method stub
        return cpf;
    }
    public void setCpf(String cpf){
        this.cpf =cpf;
    }

}


