public class MistyWoods extends BattleLoc {


    public MistyWoods(Player player) {
        super(player, "Misty Woods", new Monster(1, "Undead", 3, 10, 4), "Deckard Cain's Book", 3);

        System.out.println();
        System.out.println("[You're in the " + this.getName() + "]");
        System.out.println("As far as you can remember, this woods is full of undead.\nAnd you hear the howls and grunts.");
    }

}
