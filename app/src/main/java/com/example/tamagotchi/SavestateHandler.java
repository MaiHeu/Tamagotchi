package com.example.tamagotchi;

import android.content.SharedPreferences;
import android.widget.Toast;

public class SavestateHandler {

    public static void saveHamsterData(Hamster hamster, MainActivity mainActivity)
    {
        SharedPreferences prefs = mainActivity.getSharedPreferences("label", 0);
        SharedPreferences.Editor mEditor = prefs.edit();

        //Speichern der eigentlichen Daten
        mEditor.putString("name", hamster.getName()).commit();

        String schnuppi = hamster.getGeschlecht().toString();
        if(hamster.getGeschlecht() == Geschlecht.MALE)
            mEditor.putString("geschlecht", "MALE");
        else
            mEditor.putString("geschlecht", "FEMALE");

        mEditor.putFloat("love", hamster.getStatLove()).commit();
        mEditor.putFloat("food", hamster.getStatFood()).commit();
        mEditor.putFloat("play", hamster.getStatPlay()).commit();
        mEditor.putFloat("alter", hamster.getAlter()).commit();
        mEditor.putLong("lastSeen", hamster.getLastSeenDatesec()).commit();

        Toast toast = Toast.makeText(mainActivity.getApplicationContext(),
                "Hamster gespeichert",
                Toast.LENGTH_SHORT);
        toast.show();
    }

    public static void loadHamsterData(Hamster hamster, MainActivity mainActivity)
    {
        SharedPreferences prefis = mainActivity.getSharedPreferences("label", 0);

        //Auslesen der eigentlichen Daten

        hamster.setName( prefis.getString("name", hamster.getName() ));
        hamster.setStatLove(prefis.getFloat("love", hamster.getStatLove()));
        hamster.setStatFood(prefis.getFloat("food", hamster.getStatFood()));
        hamster.setStatPlay(prefis.getFloat("play", hamster.getStatPlay()));
        hamster.setAlter(prefis.getFloat("alter", hamster.getAlter()));
        hamster.setLastSeenDatesec(prefis.getLong("lastSeen", hamster.getLastSeenDatesec()));
        if(prefis.getString("geschlecht", "FEMALE") == "MALE")
            hamster.setGeschlecht(Geschlecht.MALE);
        else
            hamster.setGeschlecht(Geschlecht.FEMALE);

        Toast toast = Toast.makeText(mainActivity.getApplicationContext(),
                hamster.getName() + " wurde geladen!",
                Toast.LENGTH_SHORT);
        toast.show();
    }

}
