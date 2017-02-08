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
import android.widget.TextView;

/**
 * Created by rahul on 2/8/2017.
 */

public class FragmentTwo extends Fragment {

    Button b2,b3;
    EditText editTexttwo;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View v=inflater.inflate(R.layout.fragment_two,container,false);

        editTexttwo=(EditText) v.findViewById(R.id.et1);
        TextView textView=(TextView) v.findViewById(R.id.txt1);

        final String  val1 = getArguments().getString("Key");

        textView.setText(val1);


        b2=(Button) v.findViewById(R.id.bt2);
        b3=(Button) v.findViewById(R.id.btt);

        b2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                FragmentThree f3=new FragmentThree();
                String val2  = editTexttwo.getText().toString();



                FragmentManager fm=getFragmentManager();
                FragmentTransaction ft=fm.beginTransaction();

                Bundle bn=new Bundle();
                bn.putString("user",val1);
                bn.putString("password",val2);
                f3.setArguments(bn);



                ft.replace(R.id.fragment,f3);
                editTexttwo.setText("");
                ft.addToBackStack(null);
                ft.commit();
            }
        });

        b3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                getFragmentManager().popBackStack();
            }
        });
        return v;
    }
}
