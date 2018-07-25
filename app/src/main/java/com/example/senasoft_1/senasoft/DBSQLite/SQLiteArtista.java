package com.example.senasoft_1.senasoft.DBSQLite;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.view.View;

import java.util.ArrayList;

/**
 * Created by SENASOFT-1 on 17/07/2018.
 */

public class SQLiteArtista extends SQLiteOpenHelper {

    public static final String NAMEDB="adsi";

    public static final int VERSION=2;
    public final String ID="id_artista";
    public final String NAMETABLA="artistas";
    public final String TIPOARTISTA="tipo_artista";
    public final String NAMEARTISTA="nombre_artista";
    public final String BIOGRAFIA="biografia";

    SQLiteDatabase sqLiteDatabase;

    public static final String CREATE_TABLE="CREATE TABLE artistas (id_artista INTEGER PRIMARY KEY AUTOINCREMENT," +
            "tipo_artista TEXT, nombre_artista TEXT, biografia TEXT)";




    public SQLiteArtista(Context context, String name, SQLiteDatabase.CursorFactory factory, int version) {
        super(context, NAMEDB, factory, VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(CREATE_TABLE);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }



    public void abrir(boolean write){
        if (write){
            sqLiteDatabase = this.getWritableDatabase();
        }else {
            sqLiteDatabase = this.getReadableDatabase();
        }
    }

    public void cerrrar(){sqLiteDatabase.close();}

    public long registrarArtista(DBSQLite dbsqLite){
        sqLiteDatabase=this.getWritableDatabase();
        ContentValues values=new ContentValues();
        values.put(TIPOARTISTA,dbsqLite.getTipo_artista());
        values.put(NAMEARTISTA,dbsqLite.getNombre_artista());
        values.put(BIOGRAFIA,dbsqLite.getBiografia());

        Long retur=sqLiteDatabase.insert(NAMETABLA,null,values);
        cerrrar();
        return retur;

    }

    public ArrayList<DBSQLite>list(){
        abrir(true);
        String select="SELECT * FROM "+NAMETABLA;
        String nameArtista,biografia;
        int tipoArtista;

        ArrayList<DBSQLite>arrayArti=new ArrayList<>();
        DBSQLite c;

        Cursor datos=sqLiteDatabase.rawQuery(select,null);
        if (datos!=null && datos.moveToFirst()){
            do {
                tipoArtista=datos.getInt(0);
                nameArtista=datos.getString(1);
                biografia=datos.getString(2);

                c=new DBSQLite(tipoArtista,nameArtista,biografia);
                arrayArti.add(c);
            }while (datos.moveToNext());

        }
        cerrrar();
        return arrayArti;
    }
}
