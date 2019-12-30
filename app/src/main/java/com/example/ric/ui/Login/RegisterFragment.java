package com.example.ric.ui.Login;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;

import com.example.ric.domain.User;
import com.example.ric.R;
import com.example.ric.MyApplication;
import com.example.ric.domain.UserDAO;

public class RegisterFragment extends Fragment {

    public static RegisterFragment newInstance() {
        return new RegisterFragment();
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_register, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        final EditText nameEditText = getView().findViewById(R.id.nameEditText);
        final EditText passwordEditText = getView().findViewById(R.id.passwordEditText);
        final EditText emailEditText = getView().findViewById(R.id.emailEditText);
        final Button registerButton = getView().findViewById(R.id.registerButton);
        final TextView errorName = getView().findViewById(R.id.errorName);
        final TextView errorNameExist = getView().findViewById(R.id.errorNameExist);
        final TextView errorMail = getView().findViewById(R.id.errorEmail);
        final TextView errorPassword = getView().findViewById(R.id.errorPassword);
        final Button backButton = getView().findViewById(R.id.backButton);

        registerButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String username = nameEditText.getText().toString();
                String password = passwordEditText.getText().toString();
                String email = emailEditText.getText().toString();
                boolean allgood = true;

                if(username.isEmpty()){
                    errorName.setVisibility(View.VISIBLE);
                    allgood = false;
                }
                else{
                    errorName.setVisibility(View.INVISIBLE);
                }

                if(email.isEmpty()){
                    errorMail.setVisibility(View.VISIBLE);
                    allgood = false;
                }
                else{
                    errorMail.setVisibility(View.INVISIBLE);
                }

                if(password.length() <= 5){
                    errorPassword.setVisibility(View.VISIBLE);
                    allgood = false;
                }
                else{
                    errorPassword.setVisibility(View.INVISIBLE);
                }

                UserDAO ud = new UserDAO(MyApplication.getAppContext());
                ud.open();
                User userVerif = ud.selectionerUserName(username);
                ud.close();

                if(userVerif != null){
                    errorNameExist.setVisibility(View.VISIBLE);
                    allgood = false;
                }
                else{
                    errorNameExist.setVisibility(View.INVISIBLE);
                }

                if(allgood){
                    LoginFragment loginFragment = new LoginFragment();
                    FragmentManager fragmentManager = getFragmentManager();
                    fragmentManager.beginTransaction().replace(R.id.container, loginFragment, "ReplaceFragment").commit();

                    User u = new User(1, username, email, password);
                    ud.open();
                    ud.ajouter(u);
                    ud.close();
                }
            }
        });

        backButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                LoginFragment loginFragment = new LoginFragment();
                FragmentManager fragmentManager = getFragmentManager();
                fragmentManager.beginTransaction().replace(R.id.container, loginFragment, "ReplaceFragment").commit();
            }
        });
    }
}
