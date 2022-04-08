public class Armor {

    private String name;
    private int id;
    private int price;
    private int ac; // armor class

    Armor(String name, int id, int ac, int price) {
        this.name = name;
        this.id = id;
        this.price = price;
        this.ac = ac;
    }

    public static Armor[] armors() {
        Armor[] armorList = new Armor[3];
        armorList[0] = new Armor("Light Armor", 1, 1, 15);
        armorList[1] = new Armor("Medium Armor", 2, 3, 25);
        armorList[2] = new Armor("Heavy Armor", 3, 5, 40);
        return armorList;
    }

    //returns the selected armor object
    public static Armor getArmorObj(int id) {
        for (Armor a : Armor.armors()) {
            if (a.getId() == id)
                return a;
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

    public int getAc() {
        return ac;
    }

    public void setAc(int ac) {
        this.ac = ac;
    }
}
