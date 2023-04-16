package com.example.business_times.config;

import android.widget.EditText;

public class CheckText {
    public boolean textEmpty(EditText[]editTexts){
    for (EditText editText:editTexts){
        if (editText.getText().toString().equals("")){
            return true;
        }
    }
    return false;
    }

    public void selectError(EditText[] editTexts){
        for(EditText editText:editTexts){
            if(editText.getText().toString().equals("")){
                editText.setError("Este campo es obligatorio");
                editText.requestFocus();
            }
        }
    }
}
