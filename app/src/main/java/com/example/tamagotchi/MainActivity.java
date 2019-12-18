package com.example.tamagotchi;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private Button buttonPlay;

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

        Hamster hamsi = new Hamster("Frank", Geschlecht.MALE);

        //SavestateHandler.saveHamsterData(hamsi, this);
        SavestateHandler.loadHamsterData(hamsi, this);

    }

    @Override
    protected void onDestroy() {



        super.onDestroy();
    }
}
