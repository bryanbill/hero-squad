package com.minty.models;

public class Hero {

    private int id;
    private String heroName;
    private String power;
    private String weakness;
    private int squadId;

    public Hero(int id, String name, String power, String weakness, int squadId) {
        this.id = id;
        this.heroName = name;
        this.power = power;
        this.weakness = weakness;
        this.squadId = squadId;
    }


    public int getId() {
        return id;
    }

    public String getName() {
        return heroName;
    }

    public String getPower() {
        return power;
    }

    public String getWeakness() {
        return weakness;
    }

    public int getSquadId() {
        return squadId;
    }
}
