package com.example.tamagotchi;

import android.graphics.drawable.Drawable;

class Hamster {
    private String name;
    private Geschlecht geschlecht;
    private float statLove;
    private float statPlay;
    private float statFood;
    private float alter;
    private Drawable image;
    private MainActivity mainActivity;
    private int imageID;
    private short hamsterID;
    private long lastSeenDatesec;

    public Hamster(String name, Geschlecht geschlecht, MainActivity mainActivity) {
        this.name = name;
        this.geschlecht = geschlecht;
        this.mainActivity = mainActivity;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Geschlecht getGeschlecht() { return this.geschlecht; }

    public void setGeschlecht(Geschlecht geschlecht) {
        this.geschlecht = geschlecht;
    }

    public float getStatLove() {
        return statLove;
    }

    public void setStatLove(float statLove) {
        this.statLove = statLove;
        mainActivity.getButtonPat().setText( String.valueOf(statLove) );
    }

    public long getLastSeenDatesec() {
        return lastSeenDatesec;
    }

    public void setLastSeenDatesec(long lastSeenDatesec) {
        this.lastSeenDatesec = lastSeenDatesec;
    }

    public float getStatPlay() {
        return statPlay;
    }

    public void setStatPlay(float statPlay) {
        this.statPlay = statPlay;
        mainActivity.getButtonPlay().setText( String.valueOf(statPlay) );
    }

    public float getStatFood() {
        return statFood;
    }

    public void setStatFood(float statFood) {
        this.statFood = statFood;
        mainActivity.getButtonFeed().setText( String.valueOf(statFood) );
    }

    public float getAlter() {
        return alter;
    }

    public void setAlter(float alter) {
        this.alter = alter;
    }

    public void blink()
    {

    }


}
