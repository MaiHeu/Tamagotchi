package com.example.tamagotchi;

public enum Geschlecht {
    MALE, FEMALE, DIVERSE;

    public String getGeschlecht()
    {
        if(this == MALE)
            return "männlich";
        else
            return "weiblich";
    }

}
