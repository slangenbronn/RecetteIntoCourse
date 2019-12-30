package com.example.ric.ui.Login;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;

import com.example.ric.MainActivity;
import com.example.ric.MyApplication;
import com.example.ric.R;
import com.example.ric.domain.User;
import com.example.ric.domain.UserDAO;

import java.util.List;

public class LoginFragment extends Fragment {

    public static LoginFragment newInstance() {
        return new LoginFragment();
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.login_fragment, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        final EditText usernameEditText = getView().findViewById(R.id.username);
        final EditText passwordEditText = getView().findViewById(R.id.password);
        final Button loginButton = getView().findViewById(R.id.login);
        final ProgressBar loadingProgressBar = getView().findViewById(R.id.loading);
        final Button registerButton = getView().findViewById(R.id.register_label);

        loginButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                boolean userFound = false;
                String username = usernameEditText.getText().toString();
                String password = passwordEditText.getText().toString();

                //List<User> userList = MyApplication.getUserList();
                if(username != "" && password != "" && password.length() > 5){
                    UserDAO ud = new UserDAO(MyApplication.getAppContext());
                    ud.open();
                    User u = ud.selectionerUserName(username);
                    ud.close();
                    if(u.getName().equals(username) && u.getPassword().equals(password)){
                        Intent intent = new Intent(getContext().getApplicationContext(), MainActivity.class);
                        startActivity(intent);
                        getActivity().finish();
                        userFound = true;
                    }

                    if(!userFound){
                        Context context = getActivity().getApplicationContext();
                        String error_message = "Combinaison login/mot de passe incorrect";
                        int duration = Toast.LENGTH_LONG;

                        Toast toast = Toast.makeText(context, error_message, duration);
                        toast.show();
                    }
                }
                else{
                    Context context = getActivity().getApplicationContext();
                    String error_message = "login/mot de passe incorrect (mot de passe > 5)";
                    int duration = Toast.LENGTH_LONG;

                    Toast toast = Toast.makeText(context, error_message, duration);
                    toast.show();
                }
            }
        });

        registerButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                RegisterFragment fragment2 = new RegisterFragment();
                FragmentManager fragmentManager = getFragmentManager();
                fragmentManager.beginTransaction().replace(R.id.container, fragment2, "ReplaceFragment").commit();
            }
        });
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
    }
}
