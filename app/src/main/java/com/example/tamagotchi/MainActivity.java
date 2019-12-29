package com.example.tamagotchi;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private Hamster hamsi;
    private Button buttonPlay;

    public Button getButtonPlay() {
        return buttonPlay;
    }

    public void setButtonPlay(Button buttonPlay) {
        this.buttonPlay = buttonPlay;
    }

    private Button buttonPat;

    public Button getButtonPat() {
        return buttonPat;
    }

    public void setButtonPat(Button buttonPat) {
        this.buttonPat = buttonPat;
    }

    private Button buttonFeed;

    public Button getButtonFeed() {
        return buttonFeed;
    }

    public void setButtonFeed(Button buttonFeed) {
        this.buttonFeed = buttonFeed;
    }

    public void onClick_buttonPlay(View v)
    {
        Intent intent = new Intent(MainActivity.this, CreateActivity.class);
        startActivity(intent);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        System.out.println("Hallo Hamster");

        // startet den Background Service :3
        //startService(new Intent(getApplicationContext(),BackgroundService.class));

        buttonPlay = findViewById(R.id.buttonPlay);
        buttonPat = findViewById(R.id.buttonPat);
        buttonFeed = findViewById(R.id.buttonPlay);

        hamsi = new Hamster("Frank", Geschlecht.MALE, this);

        hamsi.setStatFood(55);
        hamsi.setStatLove(25);
        hamsi.setStatPlay(69);

        SavestateHandler.saveHamsterData(hamsi, this);

        //SavestateHandler.saveHamsterData(hamsi, this);
        SavestateHandler.loadHamsterData(hamsi, this);

    }

    @Override
    protected void onDestroy() {
        // Hier sollte man nochmal prüfen, ob saveHamsterData überhaupt ausgeführt wird
        SavestateHandler.saveHamsterData(hamsi, this);
        Toast toast = Toast.makeText(this.getApplicationContext(),
                hamsi.getName() + " legt sich für's erste schlafen.",
                Toast.LENGTH_SHORT);
        toast.show();
        super.onDestroy();
    }
}
