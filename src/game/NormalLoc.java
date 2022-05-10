package game;

public abstract class NormalLoc extends Location{

    protected NormalLoc(Player player, String name) {
        super(player);
        this.name=name;
    }
    public boolean getLocation(){
        return true;
    }
}
