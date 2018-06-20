package com.example.neuton.cadastrocliente;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;


public class BancoQuarto extends SQLiteOpenHelper{
    public BancoQuarto(Context context, Object name,
                        Object factory, int version) {
        // TODO Auto-generated constructor stub
        super(context,  DATABASE_NAME, null, DATABASE_VERSION);
    }

    // Database Version
    private static final int DATABASE_VERSION = 1;
    // Database Name
    private static final String DATABASE_NAME = "QuartoDataBase.db";

    // Contacts table name
    public static final String QUARTO_TABLE = "Quarto";
    public static final String QUARTO_ID = "id";
    public static final String NUMERO = "numero";


    public static final String CREATE_TABLE = "CREATE TABLE " + QUARTO_TABLE + "("
            + QUARTO_ID + " INTEGER PRIMARY KEY," + NUMERO + " TEXT " + ")";

    @Override
    public void onCreate(SQLiteDatabase db) {
        // TODO Auto-generated method stub
        db.execSQL(CREATE_TABLE);
    }
    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        // TODO Auto-generated method stub
        // Drop older table if existed
        db.execSQL("DROP TABLE IF EXISTS " + QUARTO_TABLE);

        // Create tables again
        onCreate(db);
    }

    void addRegister(RegistroQuarto registerdata)
    // code to add the new register
    {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put(NUMERO,registerdata.getNumero()); // register NOME

        // Inserting Row
        db.insert(QUARTO_TABLE, null, values);
        db.close(); // Closing database connection
    }

    //code to get the register
    String[] getRegister(String numero){
        SQLiteDatabase db = this.getReadableDatabase();
        //String selectquery="SELECT * FROM QUARTO_TABLE";
        Cursor cursor=db.query(QUARTO_TABLE,null,  NUMERO+"=?",new String[]{numero},null, null, null, null);

        String[] dados = new String[]{"nao_existe", "nao_existe"};

        if(cursor.getCount()<1){
            cursor.close();
            return dados;
        }
        else if(cursor.getCount()>=1 && cursor.moveToFirst()){

            String converter_id_para_string = Long.toString(cursor.getLong(cursor.getColumnIndex(QUARTO_ID)));

            dados[0] = converter_id_para_string;
            dados[1] = cursor.getString(cursor.getColumnIndex(NUMERO));

            cursor.close();
        }
        return dados;
    }


    public String getDatabaseName() {
        return DATABASE_NAME;
    }

    public static String getKeyId() {
        return QUARTO_ID;
    }

    public static String getTableContacts() {
        return QUARTO_TABLE;
    }

    public static int getDatabaseVersion() {
        return DATABASE_VERSION;
    }
}
