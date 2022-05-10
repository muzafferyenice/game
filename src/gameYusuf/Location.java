package gameYusuf;

import game.Player;

import java.util.Scanner;

public abstract class Location {
    Scanner sc=new Scanner(System.in);
    protected Player player;
    protected String name;

<<<<<<<< HEAD:src/gameYusuf/Location.java
    Location(Player player){
========
    protected Location(Player player){
>>>>>>>> 9a2d5a6 (Game 10/05/2022):src/game/Location.java
        this.player=player;
    }
    public abstract boolean getLocation();

    public Player getPlayer() {
        return player;
    }

    public void setPlayer(Player player) {
        this.player = player;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
