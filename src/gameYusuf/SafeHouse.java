package gameYusuf;

import game.NormalLoc;
import game.Player;

public class SafeHouse extends NormalLoc {
    SafeHouse(Player player) {
        super(player,"Güvenli Ev");
    }
    public boolean getLocation(){
        player.setHealtly(player.getrHeatly());
        System.out.println("İyileştiniz .....\nŞuan Güvenli Evdesiniz.....");
        return true;
    }
}
