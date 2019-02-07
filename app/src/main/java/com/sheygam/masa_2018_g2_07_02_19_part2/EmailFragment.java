package com.sheygam.masa_2018_g2_07_02_19_part2;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;

public class EmailFragment extends Fragment implements View.OnClickListener {
    private EditText inputEmail;
    private Button backBtn, nextBtn;
    private EmailFragmentListener listener;

    public void setListener(EmailFragmentListener listener) {
        this.listener = listener;
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_email,container,false);
        inputEmail = view.findViewById(R.id.input_email);
        backBtn = view.findViewById(R.id.back_btn);
        nextBtn = view.findViewById(R.id.next_btn);
        backBtn.setOnClickListener(this);
        nextBtn.setOnClickListener(this);
        return view;
    }

    @Override
    public void onClick(View v) {
        if(v.getId() == R.id.back_btn){
            if(listener!=null){
                listener.onEmailBackClick();
            }
        }else if(v.getId() == R.id.next_btn){
            if (listener!=null){
                listener.onEmailNextClick(inputEmail.getText().toString());
            }
        }
    }

    interface EmailFragmentListener{
        void onEmailBackClick();
        void onEmailNextClick(String email);
    }
}
