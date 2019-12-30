package com.example.ric.ui.Login;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;

import com.example.ric.R;
import com.example.ric.domain.DAOBase;

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
