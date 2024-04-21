package battleship;

public class Hits {

    private int totalNrOfHits = 0;
    private int carrierHits = 0; // sunk at 5
    private int battleshipHits = 0; // sunk at 4
    private int submarineHits = 0; // sunk at 3
    private int cruiserHits = 0; // sunk at 3
    private int destroyerHits = 0; // sunk at 2

    public int getTotalNrOfHits() {
        return totalNrOfHits;
    }

    public void setTotalNrOfHits(int totalNrOfHits) {
        this.totalNrOfHits = totalNrOfHits;
    }

    public int getCarrierHits() {
        return carrierHits;
    }

    public void setCarrierHits(int carrierHits) {
        this.carrierHits = carrierHits;
    }

    public int getBattleshipHits() {
        return battleshipHits;
    }

    public void setBattleshipHits(int battleshipHits) {
        this.battleshipHits = battleshipHits;
    }

    public int getSubmarineHits() {
        return submarineHits;
    }

    public void setSubmarineHits(int submarineHits) {
        this.submarineHits = submarineHits;
    }

    public int getCruiserHits() {
        return cruiserHits;
    }

    public void setCruiserHits(int cruiserHits) {
        this.cruiserHits = cruiserHits;
    }

    public int getDestroyerHits() {
        return destroyerHits;
    }

    public void setDestroyerHits(int destroyerHits) {
        this.destroyerHits = destroyerHits;
    }

    public void totalNrOfHits() {

    }

}

