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

public class PasswordFragment extends Fragment implements View.OnClickListener {
    private EditText inputPassword;
    private Button backBtn, okBtn;

    private PasswordFragmentListener listener;

    public void setListener(PasswordFragmentListener listener) {
        this.listener = listener;
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fregment_password,container,false);
        inputPassword = view.findViewById(R.id.input_password);
        backBtn = view.findViewById(R.id.back_btn);
        okBtn = view.findViewById(R.id.ok_btn);
        backBtn.setOnClickListener(this);
        okBtn.setOnClickListener(this);
        return view;
    }

    @Override
    public void onClick(View v) {
        if(v.getId() == R.id.back_btn){
            if(listener!=null){
                listener.onPasswordBackClick();
            }
        }else if(v.getId() == R.id.ok_btn){
            if(listener!=null){
                listener.onPasswordOkClick(inputPassword.getText().toString());
            }
        }
    }

    interface PasswordFragmentListener{
        void onPasswordBackClick();
        void onPasswordOkClick(String password);
    }
}
