import java.util.Scanner;

public class Player {

    Inventory inventory;
    Scanner in = new Scanner(System.in);

    public String name;
    public int damage;
    public int health;
    public int gold;
    public int maxHealth;
    public int armorClass;
    public String className;


    public Player(String name) {
        this.name = name;
        this.inventory = new Inventory();
    }

    public void selectChar() {

        switch (classMenu()) {
            case 1:
                setChar("Samurai", 5, 21, 15, 0);
                break;
            case 2:
                setChar("Ranger", 7, 18, 20, 0);
                break;
            case 3:
                setChar("Knight", 8, 24, 5, 0);
                break;
        }
        System.out.println("Character Name = " + name + "\n" + "Class = " + getClassName() + "\n" +
                "Damage = " + getDamage() + " " + "| HP = " + getHealth() + " | Gold = " + getGold());
    }

    public int classMenu() {

        System.out.println("1-Samurai \t Damage = 5 \t HP = 21 \t Gold = 15");
        System.out.println("2-Ranger \t Damage = 7 \t HP = 18 \t Gold = 20");
        System.out.println("3-Knight \t Damage = 8 \t HP = 24 \t Gold = 5");
        System.out.println("Pick a Class: ");
        int claID = in.nextInt();

        while (claID > 3 || claID < 1) {
            System.out.println("Invalid try\nPick a Class: ");
            claID = in.nextInt();
        }
        return claID;
    }

    private void setChar(String className, int damage, int health, int gold, int armorClass) {
        setArmorClass(armorClass);
        setClassName(className);
        setDamage(damage);
        setHealth(health);
        setGold(gold);
        setMaxHealth(getHealth());
    }

    public void playerInfo() {
        System.out.println("[Damage = " + getTotalDamage() + " " + "| HP = " + getHealth() + " | Gold = " + getGold() + " | AC = " + getArmorClass() + "]");
    }

    public int getTotalDamage() {
        return damage + inventory.getWeapon().getDamage();
    }

    public Inventory getInventory() {
        return inventory;
    }

    public void setInventory(Inventory inventory) {
        this.inventory = inventory;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getDamage() {
        return damage;
    }

    public void setDamage(int damage) {
        this.damage = damage;
    }

    public int getHealth() {
        return health;
    }

    public void setHealth(int health) {
        this.health = health;
    }

    public int getGold() {
        return gold;
    }

    public void setGold(int gold) {
        this.gold = gold;
    }

    public int getMaxHealth() {
        return maxHealth;
    }

    public void setMaxHealth(int maxHealth) {
        this.maxHealth = maxHealth;
    }

    public String getClassName() {
        return className;
    }

    public void setClassName(String className) {
        this.className = className;
    }

    public int getArmorClass() {
        return armorClass + inventory.getArmor().getAc();
    }

    public void setArmorClass(int armorClass) {
        this.armorClass = armorClass;
    }
}
