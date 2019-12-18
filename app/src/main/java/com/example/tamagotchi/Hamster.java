package com.example.tamagotchi;

class Hamster {
    private String name;
    private Geschlecht geschlecht;
    private float statLove;
    private float statPlay;
    private float statFood;
    private float alter;

    public Hamster(String name, Geschlecht geschlecht) {
        this.name = name;
        this.geschlecht = geschlecht;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getGeschlecht() {return this.getGeschlecht();}

    public void setGeschlecht(Geschlecht geschlecht) {
        this.geschlecht = geschlecht;
    }

    public float getStatLove() {
        return statLove;
    }

    public void setStatLove(float statLove) {
        this.statLove = statLove;
    }

    public float getStatPlay() {
        return statPlay;
    }

    public void setStatPlay(float statPlay) {
        this.statPlay = statPlay;
    }

    public float getStatFood() {
        return statFood;
    }

    public void setStatFood(float statFood) {
        this.statFood = statFood;
    }

    public float getAlter() {
        return alter;
    }

    public void setAlter(float alter) {
        this.alter = alter;
    }
}
