package com.example.tamagotchi;

import androidx.annotation.NonNull;

public enum Geschlecht {
    MALE, FEMALE;

    public String getGeschlecht()
    {
        if(this == MALE)
            return "männlich";
        else
            return "weiblich";
    }
}
