package com.example.tamagotchi;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.content.res.Resources;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

public class CreateActivity extends AppCompatActivity {

    RadioGroup genderSelector;
    short currentHamsterPosition = 0;
    private EditText hamsterName;
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
        hamsterName = findViewById(R.id.textBoxNameHamster);
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

    public void onButtonSwitchHamsterClick(View view){
        //if(view.getId() == R.id.imageButtonLeft)
        //{
            if(currentHamsterPosition == 0)
            {
                currentHamsterPosition++;
                ImageView test = findViewById(R.id.imageViewHamster);
                test.setImageResource(R.drawable.hamster00_animation00_00);
            }else {
                currentHamsterPosition--;
                ImageView test = findViewById(R.id.imageViewHamster);
                test.setImageResource(R.drawable.hamster01_animation00_00);
            }
            //System.out.println("Links!");
       // }else{
         /*   if(currentHamsterPosition == 1)
            {
                currentHamsterPosition--;
                ImageView test = findViewById(R.id.imageViewHamster);
                test.setImageResource(R.drawable.hamster01_animation00_00);
            }else {
                currentHamsterPosition++;
                ImageView test = findViewById(R.id.imageViewHamster);
                test.setImageResource(R.drawable.hamster00_animation00_00);
            }
            System.out.println("Rechts!");
        }*/
    }

    public void onButtonCreateHamsterClick(View view){

        if(hamsterName.getText().toString().isEmpty()){
            Toast.makeText(this.getApplicationContext(), "Kein Name vergeben!",
                    Toast.LENGTH_SHORT).show();
            return;
        }

        if(!genderSelector.isSelected()){
            Toast.makeText(this.getApplicationContext(), "Kein Geschlecht vergeben!",
                    Toast.LENGTH_SHORT).show();
            return;
        }
    }
}
