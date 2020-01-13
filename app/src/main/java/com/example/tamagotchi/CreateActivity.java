package com.example.tamagotchi;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
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
    short maximumHamster = 2;
    private EditText hamsterName;
    String hamsterdrawablename;
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
        if(view.getId() == R.id.imageButtonLeft){
            if(currentHamsterPosition == 0)
            {
                currentHamsterPosition=maximumHamster;
                hamsterdrawablename = "hamster0"+currentHamsterPosition+"_animation00_00";
                ImageView test = findViewById(R.id.imageViewHamster);
                test.setImageResource(getStringIdentifier(this, hamsterdrawablename));

            }else {

                currentHamsterPosition--;
                hamsterdrawablename = "hamster0"+currentHamsterPosition+"_animation00_00";
                ImageView test = findViewById(R.id.imageViewHamster);
                test.setImageResource(getStringIdentifier(this, hamsterdrawablename));;
            }
       System.out.println("Links!");
            System.out.println("CurrentHamsterPosition: "+currentHamsterPosition+" hamsterdrawablename "+hamsterdrawablename+" getStringIdentifier "+getStringIdentifier(this, hamsterdrawablename));
       }else{

            if(currentHamsterPosition == maximumHamster)
            {

                currentHamsterPosition=0;
                hamsterdrawablename = "hamster0"+currentHamsterPosition+"_animation00_00";
                ImageView test = findViewById(R.id.imageViewHamster);
                test.setImageResource(getStringIdentifier(this, hamsterdrawablename));
            }else {

                currentHamsterPosition++;
                hamsterdrawablename = "hamster0"+currentHamsterPosition+"_animation00_00";
                ImageView test = findViewById(R.id.imageViewHamster);
                test.setImageResource(getStringIdentifier(this, hamsterdrawablename.toString()));
            }
            System.out.println("Rechts!");
            System.out.println("CurrentHamsterPosition: "+currentHamsterPosition+" hamsterdrawablename "+hamsterdrawablename+" getStringIdentifier "+getStringIdentifier(this, hamsterdrawablename));
        }
    }

    public void onButtonCreateHamsterClick(View view){
        Geschlecht geschlecht = null;

        if(hamsterName.getText().toString().isEmpty()){
            Toast.makeText(this.getApplicationContext(), "Kein Name vergeben!",
                    Toast.LENGTH_SHORT).show();
            return;
        }

        if(genderSelector.getCheckedRadioButtonId() == -1){
            Toast.makeText(this.getApplicationContext(), "Kein Geschlecht vergeben!",
                    Toast.LENGTH_SHORT).show();
            return;
        } else if(genderSelector.getCheckedRadioButtonId() == 0)
        {
            geschlecht = geschlecht.MALE;
        }
        else{
            geschlecht = geschlecht.FEMALE;
        }
        //Finally we create a hamster
        System.out.println("HAMSTA");
        Intent intent = new Intent(CreateActivity.this, MainActivity.class);
        intent.putExtra("HamsterName", hamsterName.getText().toString());
        intent.putExtra("HamsterGeschlecht", geschlecht);
        intent.putExtra("HamsterId", currentHamsterPosition);
        startActivity(intent);
    }

    public static int getStringIdentifier(Context context, String name) {
        return context.getResources().getIdentifier(name, "drawable", context.getPackageName());
    }
}
