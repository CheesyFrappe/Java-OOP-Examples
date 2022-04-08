import java.util.Random;

public abstract class BattleLoc extends Location {

    private Monster monster;
    private String trophy;
    private int maxMonster;
    private boolean firstRun = false;


    public BattleLoc(Player player, String name, Monster monster, String trophy, int maxMonster) {
        super(player, name);
        this.monster = monster;
        this.trophy = trophy;
        this.maxMonster = maxMonster;
    }

    // returns true if the player is win the location
    // returns false if the player isn't in the location
    @Override
    public boolean onLocation() {

        int random = this.randomMonster();

        System.out.println("After a few steps, you've encountered with " + random + " " + this.monster.getName());
        System.out.println("<F>ight or <R>un");

        String selCase = in.next();
        selCase = selCase.toUpperCase();
        if (selCase.equals("F")) {
            if (combat(random) && firstRun) {
                System.out.println("<You've successfully cleared " + this.getName() + ">");
            }
        }
        if (!selCase.equals("F")) {
            System.out.println("[You ran off the area]");
        }
        if (this.getPlayer().getHealth() <= 0) {
            return false;
        }
        return true;
    }

    public boolean combat(int obsNumber) {
        playerInfo();
        monsterInfo();
        String selCase;
        int counter = 0; // counter for killed monsters

        for (int i = 1; i <= obsNumber; i++) {
            this.getMonster().setHealth(this.getMonster().getDefHealth());

            int whoFirst = (int) (Math.random() * 2);
            if (whoFirst == 1) {
                System.out.println("[" + i + "th " + this.getMonster().getName() + " hits you first]");

                int obsHit = this.getMonster().getDamage() - this.getPlayer().getArmorClass();
                if (obsHit < 0) {
                    obsHit = 0;
                }

                System.out.println(this.getMonster().getName() + " hits you " + obsHit);
                this.getPlayer().setHealth(this.getPlayer().getHealth() - obsHit);

                if (this.getPlayer().getHealth() <= 0) {
                    System.out.println("[You died]");
                    break;

                }

            }

            while (this.getPlayer().getHealth() > 0 && this.getMonster().getHealth() > 0) {
                afterHit(i);


                System.out.println("<F>ight or <R>un");
                selCase = in.next();
                selCase = selCase.toUpperCase();
                if (selCase.equals("F")) {
                    System.out.println("You hit " + this.getPlayer().getDamage() + " to the " + i + " th " + this.getMonster().getName());
                    monster.setHealth(this.monster.getHealth() - this.getPlayer().getTotalDamage());
                    afterHit(i);

                    if (this.getMonster().getHealth() > 0) {
                        int obsHit = this.getMonster().getDamage() - this.getPlayer().getArmorClass();
                        if (obsHit < 0) {
                            obsHit = 0;
                        }
                        System.out.println("======================================================================");
                        System.out.println(this.getMonster().getName() + " hits you " + obsHit);
                        this.getPlayer().setHealth(this.getPlayer().getHealth() - obsHit);

                        if (this.getPlayer().getHealth() <= 0) {
                            System.out.println("[You died]");
                            break;
                        }
                    } else {
                        player.setGold(this.player.getGold() + this.getMonster().getAward());

                        System.out.println("<You killed the " + i + "th " + this.getMonster().getName() + ">");
                        System.out.println("[You get " + this.getMonster().getAward() + " gold]");
                        System.out.println("======================================================================");
                        counter++; // increment
                    }

                } else {
                    System.out.println("[You ran off the area]");
                    return false;
                }
            }

            if (this.getPlayer().getHealth() < this.getMonster().getHealth()) {
                return false;
            }

            if (counter == obsNumber) {

                switch (this.getName()) {
                    case "Forgotten Graveyard" -> {
                        this.getPlayer().getInventory().setNecklace(true);
                        System.out.println("<After the tough fight you claimed the " + this.getTrophy() + " as a trophy>");
                    }
                    case "Misty Woods" -> {
                        this.getPlayer().getInventory().setBook(true);
                        System.out.println("<After the tough fight you claimed the " + this.getTrophy() + " as a trophy>");
                    }
                    case "Ash Lake" -> {
                        this.getPlayer().getInventory().setTooth(true);
                        System.out.println("<After the tough fight you claimed the " + this.getTrophy() + " as a trophy>");
                    }
                    case "Ruined Crypt" -> {
                        this.getPlayer().getInventory().setClaw(true);
                        System.out.println("<After the tough fight you claimed the " + this.getTrophy() + " as a trophy>");
                    }
                }

            }

        }
        return !firstRun;
    }

    public void playerInfo() {
        System.out.println();
        System.out.println("======================================================================");
        System.out.println("[Your Damage = " + this.getPlayer().getTotalDamage() + " " + "|Your HP = " + this.getPlayer().getHealth() + " |Your AC = " + this.getPlayer().getArmorClass() + "]");
    }

    // gives the current situation info
    public void afterHit(int i) {
        System.out.println("Your HP: " + this.getPlayer().getHealth() + "|" + i + "th " + this.monster.getName() + "'s HP: " + this.getMonster().getHealth());
    }

    public void monsterInfo() {
        System.out.println("[Monster HP = " + this.getMonster().getHealth() + "]");
    }

    public int randomMonster() {
        Random r = new Random();
        return r.nextInt(getMaxMonster()) + 1;
    }

    public int getMaxMonster() {
        return maxMonster;
    }

    public void setMaxMonster(int maxMonster) {
        this.maxMonster = maxMonster;
    }

    public Monster getMonster() {
        return monster;
    }

    public void setMonster(Monster monster) {
        this.monster = monster;
    }

    public String getTrophy() {
        return trophy;
    }

    public void setTrophy(String trophy) {
        this.trophy = trophy;
    }

}
