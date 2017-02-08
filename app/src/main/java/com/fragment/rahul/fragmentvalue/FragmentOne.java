package com.fragment.rahul.fragmentvalue;

import android.app.Fragment;
import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;

import java.util.jar.Attributes;

/**
 * Created by rahul on 2/8/2017.
 */

public class FragmentOne extends Fragment {

    Button b1;
    EditText editText;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view=inflater.inflate(R.layout.fragment_one,container,false);
        b1=(Button) view.findViewById(R.id.bt1);
        editText=(EditText) view.findViewById(R.id.e1);


        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                FragmentTwo fragmentTwo=new FragmentTwo();
                String data = editText.getText().toString();

                FragmentManager fm=getFragmentManager();
                FragmentTransaction ft=fm.beginTransaction();



                Bundle bundle=new Bundle();
                bundle.putString("Key",data);
                fragmentTwo.setArguments(bundle);

                ft.replace(R.id.fragment,fragmentTwo);
                editText.setText("");
                ft.addToBackStack(null);
                ft.commit();
            }
        });



        return view;
    }
}
