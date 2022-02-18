package workshop;

public class Player {
    private final String name;
    private int place;
    private int purse;
    private boolean PenaltyStatus;

    public Player (String name, int place, int purse, boolean penaltyStatus) {
        this.name = name;
        this.place = place;
        this.purse = purse;
        this.PenaltyStatus = penaltyStatus;
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

    public boolean PenaltyStatus() {
        return PenaltyStatus;
    }

    public void setPenaltyStatus(boolean penalty) {
        PenaltyStatus = penalty;
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
