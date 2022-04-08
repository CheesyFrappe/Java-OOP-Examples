public class AshLake extends BattleLoc {

    public AshLake(Player player) {
        super(player, "Ash Lake", new Monster(3, "OwlBear", 7, 20, 12), "OwlBear Tooth", 3);
        System.out.println();
        System.out.println("[You're in the " + this.getName() + "]");
        System.out.println("The moment you saw the monster's footprints, you knew you were approaching its nest.\nyou move forward cautiously.");
    }

}
