package com.example.neuton.cadastrocliente;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import static com.example.neuton.cadastrocliente.BancoCliente.CLIENTE_ID;
import static com.example.neuton.cadastrocliente.BancoCliente.CLIENTE_TABLE;
import static com.example.neuton.cadastrocliente.BancoQuarto.QUARTO_ID;
import static com.example.neuton.cadastrocliente.BancoQuarto.QUARTO_TABLE;


public class BancoReserva extends SQLiteOpenHelper{
    public BancoReserva(Context context, Object name,
                       Object factory, int version) {
        // TODO Auto-generated constructor stub
        super(context,  DATABASE_NAME, null, DATABASE_VERSION);
    }

    // Database Version
    private static final int DATABASE_VERSION = 1;
    // Database Name
    private static final String DATABASE_NAME = "ReservaDataBase.db";

    // Contacts table name
    private static final String RESERVA_TABLE = "Reserva";
    public static final String RESERVA_ID = "id";
    public static final String ID_CLIENTE = "id_cliente";
    public static final String ID_QUARTO = "id_quarto";


    public static final String CREATE_TABLE = "CREATE TABLE " + RESERVA_TABLE + "("
            + RESERVA_ID + " INTEGER PRIMARY KEY,"
            + ID_CLIENTE + " INTEGER,"
            + ID_QUARTO + " INTEGER,"
            + "FOREIGN KEY ("+ID_CLIENTE+") REFERENCES " +CLIENTE_TABLE+ "("+CLIENTE_ID+"),"
            + "FOREIGN KEY ("+ID_QUARTO+") REFERENCES " +QUARTO_TABLE+ "("+QUARTO_ID+"))";

    @Override
    public void onCreate(SQLiteDatabase db) {
        // TODO Auto-generated method stub
        db.execSQL(CREATE_TABLE);
    }
    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        // TODO Auto-generated method stub
        // Drop older table if existed
        db.execSQL("DROP TABLE IF EXISTS " + RESERVA_TABLE);

        // Create tables again
        onCreate(db);
    }

    void addRegister(RegistroQuarto registerdata)
    // code to add the new register
    {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values = new ContentValues();

        // Inserting Row
        db.insert(RESERVA_TABLE, null, values);
        db.close(); // Closing database connection

    }

    //code to get the register
    String[] getRegister(String numero){
        SQLiteDatabase db = this.getReadableDatabase();
        //String selectquery="SELECT * FROM RESERVA_TABLE";
        Cursor cursor=db.query(RESERVA_TABLE,null,  RESERVA_ID+"=?",new String[]{numero},null, null, null, null);

        String[] dados = new String[]{"nao_existe"};

        if(cursor.getCount()<1){
            cursor.close();
            //return "Not Exist";
            return dados;
        }
        else if(cursor.getCount()>=1 && cursor.moveToFirst()){
            //password = cursor.getString(cursor.getColumnIndex(NOME));
            dados[0] = cursor.getString(cursor.getColumnIndex(RESERVA_ID));

            cursor.close();
        }
        return dados;
    }


    public String getDatabaseName() {
        return DATABASE_NAME;
    }

    public static String getKeyId() {
        return RESERVA_ID;
    }

    public static String getTableContacts() {
        return RESERVA_TABLE;
    }

    public static int getDatabaseVersion() {
        return DATABASE_VERSION;
    }

}
