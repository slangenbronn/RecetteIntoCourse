package com.example.eventorganisator.ui.Login;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import com.example.eventorganisator.R;
import com.example.eventorganisator.ui.Login.ui.login.LoginFragment;

public class LoginActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.login_activity);
        if (savedInstanceState == null) {
            getSupportFragmentManager().beginTransaction()
                    .replace(R.id.container, LoginFragment.newInstance())
                    .commitNow();
        }
    }
}
