package com.example.tamagotchi;

class Hamster {
    private String name;
    private Geschlecht geschlecht;
    private short statLove;
    private short statPlay;
    private short statFood;
    private short alter;

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

    public Geschlecht getGeschlecht() {
        return this.getGeschlecht();
    }

    public void setGeschlecht(Geschlecht geschlecht) {
        this.geschlecht = geschlecht;
    }

    public short getStatLove() {
        return statLove;
    }

    public void setStatLove(short statLove) {
        this.statLove = statLove;
    }

    public short getStatPlay() {
        return statPlay;
    }

    public void setStatPlay(short statPlay) {
        this.statPlay = statPlay;
    }

    public short getStatFood() {
        return statFood;
    }

    public void setStatFood(short statFood) {
        this.statFood = statFood;
    }

    public short getAlter() {
        return alter;
    }

    public void setAlter(short alter) {
        this.alter = alter;
    }
}
