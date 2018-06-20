package com.example.neuton.cadastrocliente;

        import android.content.ContentValues;
        import android.content.Context;
        import android.database.Cursor;
        import android.database.sqlite.SQLiteDatabase;
        import android.database.sqlite.SQLiteOpenHelper;

public class BancoCliente extends SQLiteOpenHelper {

    public BancoCliente(Context context, Object name,
                           Object factory, int version) {
        // TODO Auto-generated constructor stub
        super(context,  DATABASE_NAME, null, DATABASE_VERSION);
    }

    // Database Version
    private static final int DATABASE_VERSION = 1;
    // Database Name
    private static final String DATABASE_NAME = "ClienteDatabase.db";

    // Contacts table name
    public static final String CLIENTE_TABLE= "Cliente";
    public static final String CLIENTE_ID = "id";
    public static final String NOME = "nome";
    public static final String DATA_NASCIMENTO = "data_nascimento";
    public static final String CPF = "cpf";


    public static final String CREATE_TABLE="CREATE TABLE " + CLIENTE_TABLE + "("
            + CLIENTE_ID + " INTEGER PRIMARY KEY," + NOME + " TEXT," + DATA_NASCIMENTO + " TEXT,"+ CPF + " TEXT" + ")";

    @Override
    public void onCreate(SQLiteDatabase db) {
        // TODO Auto-generated method stub
        db.execSQL(CREATE_TABLE);
    }
    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        // TODO Auto-generated method stub
        // Drop older table if existed
        db.execSQL("DROP TABLE IF EXISTS " + CLIENTE_TABLE);

        // Create tables again
        onCreate(db);
    }

    void addregister(RegistroCliente registerdata)
    // code to add the new register
    {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put(NOME,registerdata.getNome()); // register NOME
        values.put(DATA_NASCIMENTO,registerdata.getDataNascimento()); // register DATA_NASCIMENTO
        values.put(CPF,registerdata.getCpf()); // register CPF


        // Inserting Row
        db.insert(CLIENTE_TABLE, null, values);
        db.close(); // Closing database connection

    }

    //code to get the register
    String[] getregister(String username){
        SQLiteDatabase db = this.getReadableDatabase();
        //String selectquery="SELECT * FROM CLIENTE_TABLE";
        Cursor cursor=db.query(CLIENTE_TABLE,null,  NOME+"=?",new String[]{username},null, null, null, null);

        String[] dados = new String[]{"nao_existe", "nao_existe", "nao_existe", "nao_existe"};

        if(cursor.getCount()<1){
            cursor.close();
            return dados;
        }
        else if(cursor.getCount()>=1 && cursor.moveToFirst()){

            String converter_id_para_string = Long.toString(cursor.getLong(cursor.getColumnIndex(CLIENTE_ID)));

            dados[0] = converter_id_para_string;
            dados[1] = cursor.getString(cursor.getColumnIndex(NOME));
            dados[2] = cursor.getString(cursor.getColumnIndex(DATA_NASCIMENTO));
            dados[3] = cursor.getString(cursor.getColumnIndex(CPF));

            cursor.close();

        }
        return dados;
        //return dados;
    }


    public String getDatabaseName() {
        return DATABASE_NAME;
    }

    public static String getKeyId() {
        return CLIENTE_ID;
    }

    public static String getTableContacts() {
        return CLIENTE_TABLE;
    }

    public static int getDatabaseVersion() {
        return DATABASE_VERSION;
    }

}
