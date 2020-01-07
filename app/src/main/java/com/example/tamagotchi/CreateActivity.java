package com.example.tamagotchi;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.view.View;
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
            }});
    }

    protected void onRadioButtonClick(int checkedId)
    {
        System.out.println("test");
        RadioButton maennlich = findViewById(R.id.radioButtonMännlich);
        RadioButton weiblich = findViewById(R.id.radioButtonWeiblich);
                switch (checkedId)
                {
                    case 0: //männlich
                        System.out.println("test männlich");
                        maennlich.setForeground(null);
                        weiblich.setForeground(Drawable.createFromPath("drawable/ic_female"));

                        break;
                    case 1:
                        weiblich.setForeground(null);
                        maennlich.setForeground(Drawable.createFromPath("drawable/ic_male"));
                        break;
                }
            }
        }
