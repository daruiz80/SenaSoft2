package com.example.senasoft_1.senasoft.DBSQLite;

import com.orm.SugarRecord;

/**
 * Created by SENASOFT-1 on 12/07/2018.
 */

public class DBSQLite{

    String nombre_artista,biografia;
    int tipo_artista,idAr;

    public DBSQLite() {
    }

    public DBSQLite(int tipo_artista,String nombre_artista, String biografia) {
        this.nombre_artista = nombre_artista;
        this.biografia = biografia;
        this.tipo_artista = tipo_artista;
        this.idAr = idAr;
    }

    public String getNombre_artista() {
        return nombre_artista;
    }

    public void setNombre_artista(String nombre_artista) {
        this.nombre_artista = nombre_artista;
    }

    public String getBiografia() {
        return biografia;
    }

    public void setBiografia(String biografia) {
        this.biografia = biografia;
    }

    public int getTipo_artista() {
        return tipo_artista;
    }

    public void setTipo_artista(int tipo_artista) {
        this.tipo_artista = tipo_artista;
    }

    public int getIdAr() {
        return idAr;
    }

    public void setIdAr(int idAr) {
        this.idAr = idAr;
    }
}
