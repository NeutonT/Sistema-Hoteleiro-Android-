package com.example.neuton.cadastrocliente;

public class RegistroQuarto {

    //private variables
    int _id;
    String numero;

    // Empty constructor
    public RegistroQuarto(){

    }
    // constructor
    public RegistroQuarto(int id, String numero){
        this._id = id;
        this.numero = numero;
    }

    // getting ID
    public int getID(){
        return this._id;
    }
    // setting ID
    public void setID(int id){
        this._id = id;
    }


    public String getNumero() {
        // TODO Auto-generated method stub
        return numero;
    }
    // setting  nome
    public void setNumero(String numero){
        this.numero =numero;
    }

}
