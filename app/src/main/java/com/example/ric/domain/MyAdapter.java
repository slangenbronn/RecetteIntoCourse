package com.example.ric.domain;

import android.app.AlertDialog;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import com.example.ric.R;

import java.util.ArrayList;

public class MyAdapter extends RecyclerView.Adapter<MyAdapter.MyViewHolder> {

    private ArrayList<Recette> recette;

    public MyAdapter(ArrayList<Recette> r) {
        recette = r;
    }

    @Override
    public int getItemCount() {
        return recette.size();
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        View view = inflater.inflate(R.layout.list_cell, parent, false);
        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(MyViewHolder holder, int position) {
        Recette pair = recette.get(position);
        holder.display(pair);
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {

        private final TextView name;
        private final TextView ingredient;
        private final TextView preparation;
        private final TextView etape;

        private Recette currentPair;

        public MyViewHolder(final View itemView) {
            super(itemView);

            name = ((TextView) itemView.findViewById(R.id.name));
            ingredient = ((TextView) itemView.findViewById(R.id.ingredients));
            preparation = itemView.findViewById(R.id.preparation);
            etape = itemView.findViewById(R.id.etape);

            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    new AlertDialog.Builder(itemView.getContext())
                            .setTitle(currentPair.getName())
                            .setMessage(currentPair.getPreparation())
                            .show();
                }
            });
        }

        public void display(Recette pair) {
            currentPair = pair;
            name.setText(pair.getName());
            ingredient.setText(pair.getIngredients());
            preparation.setText(pair.getPreparation());
            etape.setText(pair.getStep());
        }
    }

}