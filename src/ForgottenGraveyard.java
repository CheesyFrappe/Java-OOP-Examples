public class ForgottenGraveyard extends BattleLoc {

    public boolean isClaimed = false;

    public ForgottenGraveyard(Player player) {
        super(player, "Forgotten Graveyard", new Monster(2, "Vampire Spawn", 4, 14, 7), "Vampire's Necklace", 3);
        System.out.println();
        System.out.println("[You're in the " + this.getName() + "]");
        System.out.println("This place reminds you of the dark places told by Deckard Cain.\nThe smell of the rotten blood burns your throat.");
    }

}
