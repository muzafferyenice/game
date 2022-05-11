package game;

import java.util.Random;

public class Obstacle {
    private String name;
    private int damage,award,heald,maxNumber;

    public Obstacle() {
    }

    public Obstacle(String name, int damage,int heald, int award,  int maxNumber) {
        this.name = name;
        this.damage = damage;
        this.award = award;
        this.heald = heald;
        this.maxNumber = maxNumber;
    }
    public int count(){
        Random r=new Random();
        return r.nextInt(this.maxNumber)+1;
    }
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getDamage() {
        return damage;
    }

    public void setDamage(int damage) {
        this.damage = damage;
    }

    public int getAward() {
        return award;
    }

    public void setAward(int award) {
        this.award = award;
    }

    public int getHeald() {
        return heald;
    }

    public void setHeald(int heald) {
        this.heald = heald;
    }

    public int getMaxNumber() {
        return maxNumber;
    }

    public void setMaxNumber(int maxNumber) {
        this.maxNumber = maxNumber;
    }
}
