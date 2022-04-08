public class Merchant extends NormalLoc {

    Merchant(Player player) {
        super(player, "Merchant");
    }

    @Override
    public boolean onLocation() {
        System.out.println("An old wise wizard greetings you. How may I help you?");
        System.out.println("1- Armor\n2- Weapon\n3- (Exit)");
        int selMenu = in.nextInt();

        while (selMenu < 1 || selMenu > 3) {
            System.out.println("'Seems like wizard didn't understand your words.'");
            selMenu = in.nextInt();
        }
        if (selMenu == 1) {
            printArmor();
            buyArmor();
        } else if (selMenu == 2) {
            printWeapon();
            buyWeapon();
        } else
            return true;
        return true;
    }

    private void printWeapon() {
        System.out.println("Your current gold: " + player.getGold());
        int list = 1;
        for (Weapon w : Weapon.weapons()) {
            System.out.println(list + " - " + w.getName() + " |Damage: " + w.getDamage() + "|Price: " + w.getPrice());
            list++;
        }
        System.out.println("4 - (Exit)");
    }

    private void buyWeapon() {
        int selWeapon = in.nextInt();
        while (selWeapon < 1 || selWeapon > Weapon.weapons().length + 1) {
            System.out.println("'Seems like wizard didn't understand your words.'");
            selWeapon = in.nextInt();
        }
        if (selWeapon == 4)
            onLocation();

        Weapon selectedWeapon = Weapon.getWeaponObj(selWeapon);

        if (selectedWeapon != null) {
            if (selectedWeapon.getPrice() > player.getGold()) {
                System.out.println("[You have not enough gold]");
                printWeapon();
                buyWeapon();

            } else {
                int balance = player.getGold() - selectedWeapon.getPrice();
                player.setGold(balance);
                player.getInventory().setWeapon(selectedWeapon);
                System.out.println("Your current gold: " + player.getGold());
                System.out.println("Your current weapon: " + player.getInventory().getWeapon().getName());
            }

        }
    }

    private void printArmor() {
        System.out.println("Your current gold: " + player.getGold());
        int list = 1;
        for (Armor a : Armor.armors()) {
            System.out.println(list + " - " + a.getName() + " |AC: " + a.getAc() + "|Price: " + a.getPrice());
            list++;
        }
        System.out.println("4 - <Exit>");
    }

    private void buyArmor() {

        int selArmor = in.nextInt();

        while (selArmor < 1 || selArmor > Armor.armors().length + 1) {
            System.out.println("'Seems like wizard didn't understand your words.'");
            selArmor = in.nextInt();
        }
        if (selArmor == 4)
            onLocation();

        Armor selectedArmor = Armor.getArmorObj(selArmor);

        if (selectedArmor != null) {
            if (selectedArmor.getPrice() > player.getGold()) {
                System.out.println("[You have not enough gold]");
                printArmor();
                buyArmor();
            } else {
                int balance = player.getGold() - selectedArmor.getPrice();
                player.setGold(balance);
                player.getInventory().setArmor(selectedArmor);
                System.out.println("[Your current gold: " + player.getGold() + "]");
                System.out.println("[Your current armor: " + player.getInventory().getArmor().getName() + "]");

            }

        }

    }

}
