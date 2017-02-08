package com.fragment.rahul.fragmentvalue;

import android.app.Fragment;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

/**
 * Created by rahul on 2/8/2017.
 */

public class FragmentThree extends Fragment {

    Button b3;
    TextView textView1,textView2;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View v1=inflater.inflate(R.layout.fragment_three,container,false);
        textView1=(TextView) v1.findViewById(R.id.txtthree1);
        textView2=(TextView) v1.findViewById(R.id.txtthree2);

        b3=(Button) v1.findViewById(R.id.bt3);

        String st1 = getArguments().getString("user");
        String st2 = getArguments().getString("password");

        textView1.setText(st1);
        textView2.setText(st2);

        b3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                getFragmentManager().popBackStack();

              /*  FragmentManager fm=getFragmentManager();
                FragmentTransaction ft=fm.beginTransaction();
                FragmentTwo f2=new FragmentTwo();
                ft.replace(R.id.activity_main,f2);
                ft.addToBackStack("");


                ft.commit();*/

            }
        });
        return v1;
    }
}
