package workshop;

public class Player {
    private final String name;
    private int place;
    private int purse;

    public Player (String name, int place, int purse) {
        this.name = name;
        this.place = place;
        this.purse = purse;
    }

    public String name() {
        return name;
    }

    public int place() {
        return place;
    }

    public int purse() {
        return purse;
    }

    public void addToPurse (int amount) {
        purse += amount;
    }

    public void move(int roll) {
        place += roll;
        if (place >= 12) {
            place -= 12;
        }
    }
}
