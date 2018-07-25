package com.example.senasoft_1.senasoft.Adaptadores;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;

import com.example.senasoft_1.senasoft.DBSQLite.DBSQLite;

import java.util.ArrayList;

public class AdaptadorLista extends ArrayAdapter<DBSQLite> {

    Context context;
    ArrayList<DBSQLite>list=new ArrayList<DBSQLite>();

    public AdaptadorLista(Context context, ArrayList<DBSQLite> list) {
        super(context,list.size());
        this.context = context;
        this.list = list;

    }


    @Override
    public int getCount() {
        return list.size();
    }

    @Override
    public DBSQLite getItem(int position) {
        return list.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        return null;
    }
}
