package com.example.senasoft_1.senasoft.Fragments;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

import com.example.senasoft_1.senasoft.DBSQLite.DBSQLite;
import com.example.senasoft_1.senasoft.DBSQLite.SQLiteArtista;
import com.example.senasoft_1.senasoft.R;

import java.util.List;

/**
 * A simple {@link Fragment} subclass.
 * Activities that contain this fragment must implement the
 * {@link RegistroFragment.OnFragmentInteractionListener} interface
 * to handle interaction events.
 * Use the {@link RegistroFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class RegistroFragment extends Fragment {
    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    private OnFragmentInteractionListener mListener;

    RadioButton escritor,pintor,escultor;
    Button registrarArt;
    EditText nameArtis,biografiaC;
    RadioGroup radioGroup;
    int radioButton;
    SQLiteDatabase db=null;
    SQLiteArtista miArtista=new SQLiteArtista(getContext(),"adsi",null,1);
    public RegistroFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *


     * @return A new instance of fragment RegistroFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static RegistroFragment newInstance() {
        RegistroFragment fragment = new RegistroFragment();
        Bundle args = new Bundle();
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {

        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        final View view=inflater.inflate(R.layout.fragment_registro, container, false);

        addIds(view);






        registrarArt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                DBSQLite dbsqLite=new DBSQLite(radioGroup(),nameArtis.getText().toString(),biografiaC.getText().toString());
                mListener.onFragmentInteraction(dbsqLite);

                //miArtista.registrarArtista(dbsqLite);
            }
        });

            return view;
    }
    private void addIds(View view) {
        escritor =view.findViewById(R.id.escritor);
        pintor =view.findViewById(R.id.pintor);
        escultor =view.findViewById(R.id.escultor);
        registrarArt=view.findViewById(R.id.registrarArtist);
        nameArtis=view.findViewById(R.id.nameArtista);
        biografiaC=view.findViewById(R.id.biografiaC);
        radioGroup=view.findViewById(R.id.radioGroup);
    }

    public int radioGroup(){
        radioGroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                switch (checkedId){
                    case R.id.escritor:
                        radioButton=1;
                        break;
                    case R.id.pintor:
                        radioButton=2;
                        break;
                    case R.id.escultor:
                        radioButton=3;
                        break;
                    default:
                        Toast.makeText(getContext(),"Error!",Toast.LENGTH_LONG).show();
                            break;
                }
            }
        });

        return radioButton;
    }




    public void consultar(View v){

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
        void onFragmentInteraction(DBSQLite artista);
    }
}


