package workshop;

public class Player {
    private final String name;
    private int place;

    public Player (String name, int place) {
        this.name = name;
        this.place = place;
    }

    public String name() {
        return name;
    }

    public int place() {
        return place;
    }

    public void move(int roll) {
        place += roll;
        if (place >= 12) {
            place -= 12;
        }
    }
}
