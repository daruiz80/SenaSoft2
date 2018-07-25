package com.example.senasoft_1.senasoft.Fragments;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Adapter;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.example.senasoft_1.senasoft.Adaptadores.AdaptadorLista;
import com.example.senasoft_1.senasoft.DBSQLite.DBSQLite;
import com.example.senasoft_1.senasoft.DBSQLite.SQLiteArtista;
import com.example.senasoft_1.senasoft.R;

import java.util.ArrayList;

/**
 * A simple {@link Fragment} subclass.
 * Activities that contain this fragment must implement the
 * {@link ListFragment.OnFragmentInteractionListener} interface
 * to handle interaction events.
 * Use the {@link ListFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class ListFragment extends Fragment {
    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    private OnFragmentInteractionListener mListener;

    ArrayList<DBSQLite>listU=new ArrayList<>();
    ArrayList<String>listInfo;
    SQLiteArtista conn=new SQLiteArtista(getContext(),"adsi",null,1);
    String datosArt[][]=new String[][] {{"Jose Luis","Jhojan Martinez","Jhon Sandoval"},
            {"Ariel Pipicano","Diego Lopez","Javinson Chito"},
            {"Edwin Benavidez","Alexis Añasco","Jose Botina"}};
    public ListFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.

     * @return A new instance of fragment ListFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static ListFragment newInstance(int param1) {
        ListFragment fragment = new ListFragment();
        Bundle args = new Bundle();
        args.putInt(ARG_PARAM1, param1);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //if (getArguments() != null) {
           // mParam1 = getArguments().getString(ARG_PARAM1);

        //}
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
       View view= inflater.inflate(R.layout.fragment_list, container, false);
        ListView listView=(ListView)view.findViewById(R.id.listview);

        switch (getArguments().getInt(ARG_PARAM1)){
            case 0:
                listU=conn.list();
                AdaptadorLista adapter=new AdaptadorLista(getContext(),listU);
                listView.setAdapter(adapter);
                adapter.notifyDataSetChanged();
                break;
            case 1:
                ArrayAdapter<String>adapterTwo=new ArrayAdapter<String>(getContext(),android.R.layout.simple_list_item_1,datosArt[1]);
                listView.setAdapter(adapterTwo);
                break;
            case 2:
                ArrayAdapter<String>adapterThree=new ArrayAdapter<String>(getContext(),android.R.layout.simple_list_item_1,datosArt[2]);
                listView.setAdapter(adapterThree);
                break;
            default:
        }

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                mListener.onFragmentInteraction(datosArt[getArguments().getInt(ARG_PARAM1)][position]);
            }
        });

        ArrayAdapter adapter=new ArrayAdapter(getContext(),android.R.layout.simple_list_item_1,listInfo);
        listView.setAdapter(adapter);

       return view;
    }



    // TODO: Rename method, update argument and hook method into UI event
    /*public void onButtonPressed(Uri uri) {
        if (mListener != null) {
            mListener.onFragmentInteraction(uri);
        }
    }*/

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        if (context instanceof OnFragmentInteractionListener) {
            mListener = (OnFragmentInteractionListener) context;
        } else {
            throw new RuntimeException(context.toString()
                    + " must implement OnFragmentInteractionListener");
        }
    }

    @Override
    public void onDetach() {
        super.onDetach();
        mListener = null;
    }

    /**
     * This interface must be implemented by activities that contain this
     * fragment to allow an interaction in this fragment to be communicated
     * to the activity and potentially other fragments contained in that
     * activity.
     * <p>
     * See the Android Training lesson <a href=
     * "http://developer.android.com/training/basics/fragments/communicating.html"
     * >Communicating with Other Fragments</a> for more information.
     */
    public interface OnFragmentInteractionListener {
        // TODO: Update argument type and name
        void onFragmentInteraction(String infouUsu);
    }
}
