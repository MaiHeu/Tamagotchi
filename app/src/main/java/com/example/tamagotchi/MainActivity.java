package com.example.tamagotchi;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

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
    }
}
