package battleship;

public enum ShipTypes {

    EMPTY ("", 0),
    CARRIER ("Aircraft Carrier", 5),
    BATTLESHIP ("Battleship", 4),
    SUBMARINE ("Submarine", 3),
    CRUISER ("Cruiser", 3),
    DESTROYER ("Destroyer", 2);

    private final String name;
    private final int length;

    ShipTypes(String name, int length) {
        this.name = name;
        this.length = length;
    }

    public String getName() {
        return name;
    }

    public int getLength() {
        return length;
    }
}
