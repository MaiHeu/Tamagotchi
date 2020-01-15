package com.example.tamagotchi;

public enum Geschlecht {
    MALE, FEMALE;

    private Geschlecht geschlecht;

    public String getGeschlecht()
    {
        if(this == MALE)
            return "männlich";
        else
            return "weiblich";
    }

    public void setGeschlecht(String geschlecht)
    {
        if(geschlecht.compareTo("MALE") == 0){
            this.geschlecht = MALE;
        }
        else{
            this.geschlecht = FEMALE;
        }
    }

}
