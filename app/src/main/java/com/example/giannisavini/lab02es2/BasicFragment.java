package com.example.giannisavini.lab02es2;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

/**
 * Created by gianni.savini on 09/03/2017.
 */
public class BasicFragment extends Fragment {

    private onBasicFragmentInteraction listener;

    public interface onBasicFragmentInteraction {
        void onButtonClick(final String message);

    }

    public static BasicFragment newIstance(final int count) {
        BasicFragment fragment = new BasicFragment();
        Bundle bundle = new Bundle();
        bundle.putInt("INTERO", count);
        fragment.setArguments(bundle);
        return fragment;
    }

    private Button btnReturn;
    private int countPassed;

    public BasicFragment() {

    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_basic, container, false);
        btnReturn = (Button) view.findViewById(R.id.btn_return);
        btnReturn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String message = "tornato";
                if(listener != null) {
                    listener.onButtonClick(message);
                }
            }
        });

        return view;
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Bundle bundle = getArguments();
        if( bundle != null) {
            countPassed = bundle.getInt("INTERO");
        }
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        if(context instanceof onBasicFragmentInteraction) {
            listener = (onBasicFragmentInteraction) context;
        }
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        listener = null;
    }
}
