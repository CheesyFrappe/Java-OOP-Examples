public abstract class NormalLoc extends Location {

    public NormalLoc(Player player, String name) {
        super(player, name);

    }

    // returns true if the player is in the location
    // returns false if the player isn't in the location
    public boolean onLocation() {
        return true;
    }
}
