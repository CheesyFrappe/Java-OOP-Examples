public class Inventory {

    Weapon weapon;
    Armor armor;
    boolean tooth;
    boolean book;
    boolean necklace;
    boolean claw;


    Inventory() {
        // player's default armor and weapon set
        this.weapon = new Weapon("Unarmed Strike", -1, 0, 0);
        this.armor = new Armor("Unarmored", -1, 0, 0);

        this.tooth = false;
        this.book = false;
        this.necklace = false;
        this.claw = false;

    }

    public Weapon getWeapon() {
        return weapon;
    }

    public void setWeapon(Weapon weapon) {
        this.weapon = weapon;
    }

    public Armor getArmor() {
        return armor;
    }

    public void setArmor(Armor armor) {
        this.armor = armor;
    }

    public boolean isTooth() {
        return tooth;
    }

    public void setTooth(boolean tooth) {
        this.tooth = tooth;
    }

    public boolean isBook() {
        return book;
    }

    public void setBook(boolean book) {
        this.book = book;
    }

    public boolean isNecklace() {
        return necklace;
    }

    public void setNecklace(boolean necklace) {
        this.necklace = necklace;
    }

    public boolean isClaw() {
        return claw;
    }

    public void setClaw(boolean claw) {
        this.claw = claw;
    }

    public boolean countTrophies() {
        return this.tooth && this.necklace && this.book && this.claw;
    }
}
