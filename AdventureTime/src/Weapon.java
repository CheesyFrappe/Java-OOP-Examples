public class Weapon {

    private String name;
    private int id;
    private int price;
    private int damage;

    Weapon(String name, int id, int damage, int price) {
        this.name = name;
        this.id = id;
        this.price = price;
        this.damage = damage;
    }

    public static Weapon[] weapons() {
        Weapon[] weaponList = new Weapon[3];
        weaponList[0] = new Weapon("Revolver", 1, 2, 25);
        weaponList[1] = new Weapon("Short Sword", 2, 3, 35);
        weaponList[2] = new Weapon("Rusty Shotgun", 3, 7, 45);
        return weaponList;
    }

    //returns the selected weapon object
    public static Weapon getWeaponObj(int id) {
        for (Weapon w : Weapon.weapons()) {
            if (w.getId() == id)
                return w;
        }
        // default return statement
        return null;
    }


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public int getDamage() {
        return damage;
    }

    public void setDamage(int damage) {
        this.damage = damage;
    }
}
