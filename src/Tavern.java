public class Tavern extends NormalLoc {

    Tavern(Player player) {
        super(player, "Tavern");
    }

    @Override
    public boolean onLocation() { // sets the player's health at max
        player.setHealth(player.getMaxHealth());
        System.out.println("You have rested in the tavern. And your health is " + player.getHealth());
        return true;
    }
}
