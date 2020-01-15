package com.example.tamagotchi;

import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.graphics.Point;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.os.Bundle;
import android.os.Handler;
import android.view.Display;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements SensorEventListener {

    private Hamster hamsi;
    private Button buttonPlay;
    private ImageView speechBubble;
    private ImageView imageHamster;

    private Display display;
    private int screen_width;

    private SensorManager sensorManager = null;
    private Sensor accelerometer;
    private int x;

    private boolean isThereASpeechBubble;

    private Button buttonPat;
    private Button buttonFeed;


    public Button getButtonPlay() {
        return buttonPlay;
    }
    public void setButtonPlay(Button buttonPlay) {
        this.buttonPlay = buttonPlay;
    }
    public Button getButtonPat() {
        return buttonPat;
    }
    public void setButtonPat(Button buttonPat) {
        this.buttonPat = buttonPat;
    }
    public Button getButtonFeed() {
        return buttonFeed;
    }
    public void setButtonFeed(Button buttonFeed) {
        this.buttonFeed = buttonFeed;
    }

    public void onClick_buttonPat(View v)
    {
        if(hamsi.getStatLove() > 95)
        {
            Toast toast = Toast.makeText(this.getApplicationContext(),
                    hamsi.getName() + " fühlt sich genug geliebt!",
                    Toast.LENGTH_SHORT);
            toast.show();
            //showSpeechBubble(R.drawable.speechbubble_nolove, 1000);
            showSpeechBubble(getResources().getIdentifier("speechbubble_nolove", "drawable", getPackageName()), 1000);
        }
        else
        {
            hamsi.setStatLove( hamsi.getStatLove() + 5 );
            showSpeechBubble(R.drawable.speechbubble_love, 1000);
        }
    }

    public void onClick_buttonPlay(View v)
    {
        Intent intent = new Intent(MainActivity.this, CreateActivity.class);
        startActivity(intent);
    }

    public void onClick_buttonFeed(View v)
    {
        if(hamsi.getStatFood() > 95)
        {
            Toast toast = Toast.makeText(this.getApplicationContext(),
                    hamsi.getName() + " ist satt!",
                    Toast.LENGTH_SHORT);
            toast.show();
            showSpeechBubble(R.drawable.speechbubble_nosalad, 1000);
        }
        else
        {
            hamsi.setStatFood( hamsi.getStatFood() + 5 );
            showSpeechBubble(R.drawable.speechbubble_salad, 1000);
        }
    }

    public void showSpeechBubble( int imageResourceId, int time )
    {
        if(!isThereASpeechBubble)
        {
            isThereASpeechBubble = true;
            speechBubble.setImageResource(imageResourceId);
            speechBubble.setVisibility(View.VISIBLE);
            Handler handler = new Handler();
            handler.postDelayed(new Runnable() {
                @Override
                public void run() {
                    speechBubble.setVisibility(View.INVISIBLE);
                }
            }, time);
            isThereASpeechBubble = false;
        }
    }



    @Override
    public void onSensorChanged(SensorEvent sensorEvent)
    {
        if (sensorEvent.sensor.getType() == Sensor.TYPE_ACCELEROMETER)
        {
            float values[] = sensorEvent.values.clone();
            x -= (int) values[0];

            if(x < 0)
                x = 0;
            else if(x > screen_width-imageHamster.getWidth())
                x = screen_width-imageHamster.getWidth();

            imageHamster.setX(x);

        }
    }

    @Override
    public void onAccuracyChanged(Sensor sensor, int accuracy) {

    }

    protected void onResume() {
        super.onResume();
        sensorManager.registerListener(this, accelerometer, SensorManager.SENSOR_DELAY_NORMAL);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        System.out.println("Hallo Hamster");
        sensorManager = (SensorManager) getSystemService(SENSOR_SERVICE);
        accelerometer = sensorManager.getDefaultSensor(Sensor.TYPE_ACCELEROMETER);

        // startet den Background Service :3
        //startService(new Intent(getApplicationContext(),BackgroundService.class));

        buttonPlay = findViewById(R.id.buttonPlay);
        buttonPat = findViewById(R.id.buttonPat);
        buttonFeed = findViewById(R.id.buttonPlay);
        speechBubble = findViewById(R.id.imageBubble);
        imageHamster = findViewById(R.id.imageHamster);

        display = getWindowManager().getDefaultDisplay();
        Point size = new Point();
        display.getSize(size);
        screen_width = size.x;

        //TODO: Hamster erstellen
        Geschlecht test = null;
        test.setGeschlecht(getIntent().getStringExtra("HamsterGeschlecht"));
        hamsi = new Hamster(getIntent().getStringExtra("HamsterName"), test, this);
        System.out.println("Hamster Geschlecht:" + getIntent().getStringExtra("HamsterGeschlecht"));
        //hamsi = new Hamster("Frank", Geschlecht.MALE, this);

        /*
        hamsi.setStatFood(55);
        hamsi.setStatLove(25);
        hamsi.setStatPlay(69);
        SavestateHandler.saveHamsterData(hamsi, this);
        */

        SavestateHandler.loadHamsterData(hamsi, this);

    }

    @Override
    protected void onPause() {
        // Hier sollte man nochmal prüfen, ob saveHamsterData überhaupt ausgeführt wird
        SavestateHandler.saveHamsterData(hamsi, this);
/*        Toast toast = Toast.makeText(this.getApplicationContext(),
                hamsi.getName() + " legt sich für's erste schlafen.",
                Toast.LENGTH_SHORT);
        toast.show();
*/        super.onPause();
    }
}
