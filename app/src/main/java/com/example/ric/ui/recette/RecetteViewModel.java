package com.example.ric.ui.recette;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

public class RecetteViewModel extends ViewModel {

    private MutableLiveData<String> mText;

    public RecetteViewModel() {
        mText = new MutableLiveData<>();
        mText.setValue("Ajouter une recette");
    }

    public LiveData<String> getText() {
        return mText;
    }
}