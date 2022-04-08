public class RuinedCrypt extends BattleLoc {

    public RuinedCrypt(Player player) {
        super(player, "Ruined Crypt", new Monster(4, "Lamia", 6, 12, 10), "Golden Claw", 5);

        System.out.println();
        System.out.println("[You're in the " + this.getName() + "]");
        System.out.println("When you step into the crypt, your footsteps echo.\nCold, humid air welcomes you.");
    }

}
