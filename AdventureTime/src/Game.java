import java.util.Scanner;

public class Game {

    Player player;
    Location location;
    Scanner input = new Scanner(System.in);

    public void login() {

        System.out.println("Welcome to Adventure Time");
        System.out.println("Enter your name:");

        String name = input.nextLine();

        if (!isNameValid(name)) {
            while (!isNameValid(name)) {
                System.out.println("[Invalid Name]\nEnter your name:");
                name = input.nextLine();
            }
        }
        player = new Player(name);
        player.selectChar();

        System.out.println();
        System.out.println("======================================================================");
        System.out.println();
        System.out.println("You've been on the road for days maybe weeks. " +
                "You came to this land for a purpose. As far as you can remember, " +
                "your bounty is to kill various monster in this land. And gather trophies");
        System.out.println("Once you reach the gate, a soldier asks you\n" +
                "Where are you heading?");

        gameOn();
    }

    // checks if the name is valid
    public boolean isNameValid(String name) {
        int spaceCount = 0;
        for (int i = 0; i < name.length(); i++) {
            if (name.charAt(i) == ' ')
                spaceCount++;
        }
        return spaceCount <= 1 && name.charAt(0) != ' ';
    }

    public void gameOn() {

        input = new Scanner(System.in);

        while (true) {
            player.playerInfo();
            int i = 0;
            System.out.println("1- Tavern"); // check
            System.out.println("2- Forgotten Graveyard"); // check
            System.out.println("3- Misty Woods"); // check
            System.out.println("4- Ruined Crypt"); //check (it's okay now)
            System.out.println("5- Ash Lake"); // check
            System.out.println("6- Merchant"); // check
            System.out.println("0- [Exit Game]"); // check

            int selLoc = input.nextInt();
            i++;
            while (selLoc > 6 || selLoc < 0) {
                System.out.println("There is no place such that.\n" +
                        "Where are you heading?");
                selLoc = input.nextInt();
            }
            if (i != 1) {
                input.next();
            }
            if (selLoc == 1) {
                if (player.inventory.countTrophies()) {
                    System.out.println("After all the trophies were claimed, you've returned to the Tavern.");
                    System.out.println("The Bounty Hunter Guild's leader welcomes you.\nLooks like, this is the end of your adventure.");
                    break;
                }
                location = new Tavern(player);
            }
            if (selLoc == 2) {
                if (player.getInventory().isNecklace()) {
                    System.out.println("Looks like you cleared this area.");
                    continue;
                } else {
                    location = new ForgottenGraveyard(player);
                }
            }
            if (selLoc == 3) {
                if (player.getInventory().isBook()) {
                    System.out.println("Looks like you cleared this area.");
                    continue;
                } else {
                    location = new MistyWoods(player);
                }
            }
            if (selLoc == 4) {
                if (player.getInventory().isClaw()) {
                    System.out.println("Looks like you cleared this area.");
                    continue;
                } else {
                    location = new RuinedCrypt(player);
                }
            }
            if (selLoc == 5) {
                if (player.getInventory().isTooth()) {
                    System.out.println("Looks like you cleared this area.");
                    continue;
                } else {
                    location = new AshLake(player);
                }
            }

            if (selLoc == 6) {
                location = new Merchant(player);
            }

            if (selLoc == 0) {
                location = null;
            }

            if (location == null) {
                break;
            }
            if (!location.onLocation()) {
                break;
            }

        }
    }
}
