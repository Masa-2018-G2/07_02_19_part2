package com.sheygam.masa_2018_g2_07_02_19_part2;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

public class WelcomeFragment extends Fragment implements View.OnClickListener {
    private TextView emailTxt, passwordTxt;
    private Button loginBtn;
    private WelcomeListener listener;

    public void setListener(WelcomeListener listener) {
        this.listener = listener;
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_welcome,container,false);
        emailTxt = view.findViewById(R.id.email_txt);
        passwordTxt = view.findViewById(R.id.password_txt);
        loginBtn = view.findViewById(R.id.login_btn);

        Bundle arguments = getArguments();
        if(arguments != null){
            emailTxt.setText(arguments.getString("EMAIL"));
            passwordTxt.setText(arguments.getString("PASSWORD"));
        }

        loginBtn.setOnClickListener(this);
        return view;
    }

    @Override
    public void onClick(View v) {
        if(v.getId() == R.id.login_btn){
            if(listener != null){
                listener.onLoginClick();
            }
        }
    }

    interface WelcomeListener{
        void onLoginClick();
    }
}
