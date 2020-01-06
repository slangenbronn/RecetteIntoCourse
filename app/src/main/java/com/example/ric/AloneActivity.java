package com.example.ric;

import android.content.Intent;
import android.os.Bundle;

import com.example.ric.domain.Liste;
import com.example.ric.domain.ListeDAO;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.view.View;
import android.widget.TextView;

public class AloneActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_alone);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        FloatingActionButton fab = findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });

        Intent i = getIntent();
        String text = i.getStringExtra("phrase");
        String liste_name = i.getStringExtra("liste_name");

        ListeDAO ld = new ListeDAO(MyApplication.getAppContext());
        ld.open();
        Liste newListe = ld.selectionerListeName(liste_name);
        ld.close();


        TextView phrase = findViewById(R.id.phrase_passe);
        phrase.setText("Le nom de la nouvelle liste est :\n" + newListe.getName());
//        phrase.setText(text);
    }

}
