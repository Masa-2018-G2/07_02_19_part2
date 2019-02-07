package com.sheygam.masa_2018_g2_07_02_19_part2;

import android.support.v4.app.FragmentManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class MainActivity extends AppCompatActivity implements WelcomeFragment.WelcomeListener, EmailFragment.EmailFragmentListener, PasswordFragment.PasswordFragmentListener {
    private WelcomeFragment fragment;
    private String currEmail = "";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        fragment = new WelcomeFragment();
        fragment.setListener(this);
        getSupportFragmentManager()
                .beginTransaction()
                .replace(R.id.container,fragment)
                .commit();
    }

    @Override
    public void onLoginClick() {
        EmailFragment emailFragment = new EmailFragment();
        emailFragment.setListener(this);
        getSupportFragmentManager()
                .beginTransaction()
                .replace(R.id.container,emailFragment)
                .addToBackStack("EMAIL")
                .commit();
    }

    @Override
    public void onEmailBackClick() {
        getSupportFragmentManager()
                .popBackStack();
    }

    @Override
    public void onEmailNextClick(String email) {
        currEmail = email;
        PasswordFragment passwordFragment = new PasswordFragment();
        passwordFragment.setListener(this);
        getSupportFragmentManager()
                .beginTransaction()
                .replace(R.id.container,passwordFragment)
                .addToBackStack(null)
                .commit();
    }

    @Override
    public void onPasswordBackClick() {
        getSupportFragmentManager().popBackStack();
    }

    @Override
    public void onPasswordOkClick(String password) {
        Bundle bundle = new Bundle();
        bundle.putString("EMAIL",currEmail);
        bundle.putString("PASSWORD",password);
        fragment.setArguments(bundle);
        getSupportFragmentManager().popBackStack("EMAIL", FragmentManager.POP_BACK_STACK_INCLUSIVE);
    }
}
