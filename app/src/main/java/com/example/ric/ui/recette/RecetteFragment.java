package com.example.ric.ui.recette;

import android.app.Notification;
import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.content.Context;
import android.content.res.Resources;
import android.os.Build;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.annotation.NonNull;
import androidx.core.app.NotificationCompat;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;

import com.example.ric.MyApplication;
import com.example.ric.R;
import com.example.ric.domain.Recette;
import com.example.ric.domain.RecetteDAO;
import com.example.ric.ui.home.HomeFragment;

public class RecetteFragment extends Fragment {

    private RecetteViewModel recetteViewModel;
    private NotificationCompat.Builder notBuilder;
    private static final int MY_NOTIFICATION_ID = 12345;

    private static final int MY_REQUEST_CODE = 100;

    public static RecetteFragment newInstance() {
        return new RecetteFragment();
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        this.notBuilder = new NotificationCompat.Builder(getContext());
    }

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        recetteViewModel =
                ViewModelProviders.of(this).get(RecetteViewModel.class);
        View root = inflater.inflate(R.layout.fragment_recette, container, false);
        final TextView textView = root.findViewById(R.id.text_gallery);
        recetteViewModel.getText().observe(this, new Observer<String>() {
            @Override
            public void onChanged(@Nullable String s) {
                textView.setText(s);
            }
        });

        return root;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        final EditText recetteName = getView().findViewById(R.id.RecetteName);
        final EditText ingredientList = getView().findViewById(R.id.IngredientsList);
        final EditText preparationTime = getView().findViewById(R.id.PreparationTime);
        final EditText steps = getView().findViewById(R.id.Step);
        final Button add = getView().findViewById(R.id.Addrecette);

        add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String nom = recetteName.getText().toString();
                String ingredients = ingredientList.getText().toString();
                String preparation = preparationTime.getText().toString();
                String etapes = steps.getText().toString();

                if(nom.isEmpty() || ingredients.isEmpty() || preparation.isEmpty() || etapes.isEmpty()){
                    Context context = getActivity().getApplicationContext();
                    String error_message = "Tous les champs doivent être renseignés";
                    int duration = Toast.LENGTH_LONG;

                    Toast toast = Toast.makeText(context, error_message, duration);
                    toast.show();
                }
                else{
                    Recette r = new Recette(1, nom, ingredients, preparation, etapes);
                    RecetteDAO rd = new RecetteDAO(MyApplication.getAppContext());
                    rd.open();
                    rd.ajouter(r);
                    rd.close();

                    NotificationCompat.Builder builder = new NotificationCompat.Builder(getContext(), "default");
                    builder.setSmallIcon(R.drawable.ic_launcher_background);
                    builder.setContentTitle("Nouvelle recette disponible");
                    builder.setContentText(r.getName());
                    NotificationManager
                            notificationManager = (NotificationManager) getActivity().getSystemService(Context.NOTIFICATION_SERVICE);
                    notificationManager.notify(MY_NOTIFICATION_ID, builder.build());
                }
            }
        });
    }
}