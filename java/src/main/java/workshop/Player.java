package workshop;

public class Player {
    private final String name;
    private int place;
    private int coins;
    private boolean PenaltyStatus;

    public Player (String name, int place, int coins, boolean penaltyStatus) {
        this.name = name;
        this.place = place;
        this.coins = coins;
        this.PenaltyStatus = penaltyStatus;
    }

    public String name() {
        return name;
    }

    public int place() {
        return place;
    }

    public int coins() {
        return coins;
    }

    public boolean isInPenaltyBox() {
        return PenaltyStatus;
    }

    public void setPenaltyStatus(boolean penalty) {
        PenaltyStatus = penalty;
    }

    public void addCoin(int amount) {
        coins += amount;
    }

    public void move(int roll) {
        place += roll;
        if (place >= 12) {
            place -= 12;
        }
    }
}
