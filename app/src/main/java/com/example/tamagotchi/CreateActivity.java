package com.example.tamagotchi;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.drawable.Drawable;
import android.content.res.Resources;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.RadioGroup;

public class CreateActivity extends AppCompatActivity {

    RadioGroup genderSelector;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_create);

        genderSelector = findViewById(R.id.radioGroupGeschlecht);
        genderSelector.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override //checkedId is the RadioButtonSelected 0 = m | 1 = w
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                onRadioButtonClick(checkedId);
            }
        });
    }

    protected void onRadioButtonClick(int checkedId) {
        RadioButton male = findViewById(R.id.radioButtonMännlich);
        RadioButton female = findViewById(R.id.radioButtonWeiblich);
        if(male.isChecked()) {
            male.setForeground(null);
            female.setForeground(getResources().getDrawable(R.drawable.ic_female, getTheme()));
        }else{
            female.setForeground(null);
            male.setForeground(getResources().getDrawable(R.drawable.ic_male, getTheme()));
        }
    }
}
