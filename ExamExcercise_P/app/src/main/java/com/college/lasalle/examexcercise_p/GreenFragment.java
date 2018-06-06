package com.college.lasalle.examexcercise_p;


import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;


/**
 * A simple {@link Fragment} subclass.
 */
public class GreenFragment extends Fragment {

    private int count;
    private final String FILNAME = "ParneetExample";

    public GreenFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {


        View rootView = inflater.inflate(R.layout.fragment_green,container, false);
        rootView.findViewById(R.id.btnMinus).setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {

                UpdateCount(count - 1);
            }
        });


        rootView.findViewById(R.id.btnAdd).setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {

                UpdateCount(count + 1);
            }
        });

        return rootView;
    }

    @Override
    public void onPause() {
        super.onPause();

        SharedPreferences sharedPref = getActivity().getPreferences(Context.MODE_PRIVATE);
        sharedPref.edit().putInt("count", count).commit();
    }

    @Override
    public void onResume() {
        super.onResume();

        SharedPreferences sharedPref = getActivity().getPreferences(Context.MODE_PRIVATE);
        count = sharedPref.getInt("count", 0);
        UpdateCount(count);
    }



    //Create a method to update count
        public void UpdateCount(int nbr){
            count = nbr;
            TextView textView = getView().findViewById(R.id.textViewNbr);
            textView.setText(Integer.toString(count));


        }

    }
