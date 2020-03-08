package com.johnatadavi.etanois;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.app.AppCompatDelegate;

import android.content.res.ColorStateList;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.CompoundButton;
import android.widget.Switch;
import android.widget.TextView;

import com.google.android.material.textfield.TextInputEditText;

public class MainActivity extends AppCompatActivity {

    private TextInputEditText txtAlcohol, txtGasoline;
    private TextView result;
    private Switch darkMode;
    private ColorStateList oldColor;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        txtAlcohol = findViewById(R.id.txtAlcohol);
        txtGasoline = findViewById(R.id.txtGasoline);
        result = findViewById(R.id.textViewResult);
        darkMode = findViewById(R.id.switchDark);
        oldColor =  result.getTextColors();
        changeBackground();
    }

    public Boolean validateFields(String pAlcohol, String pGasoline) {
        Boolean validatedFields = true;

        if (pAlcohol == null || pAlcohol.isEmpty()) {
            validatedFields = false;
        } else if (pGasoline == null || pGasoline.isEmpty()) {
            validatedFields = false;
        }

        return validatedFields;
    }

    public void calculatePrice(View view) {
        String priceAlcohol = txtAlcohol.getText().toString();
        String priceGasoline = txtGasoline.getText().toString();

        Boolean validateFields = validateFields(priceAlcohol, priceAlcohol);
        if (validateFields) {
            result.setTextColor(oldColor);
            //calculate best price
            Double pAlcohol = Double.parseDouble(priceAlcohol);
            Double pGasoline = Double.parseDouble(priceGasoline);
            Double ratio = pAlcohol / pGasoline;
            if (ratio >= 0.7) {
                result.setText("Melhor utilizar gasolina!");
            } else {
                result.setText("Melhor utilizar gasolina!");
            }
        } else {
            result.setTextColor(Color.RED);
            result.setText("Preencha os preços primeiro!");
        }
    }


    private void changeBackground() {
        darkMode.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked) {
                    AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_YES);
                } else {
                    AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_NO);
                }
            }
        });
    }
}
