package battleship;

public class Coordinate {

    private int y;
    private int x;

    public int getY() {
        return y;
    }

    public int getX() {
        return x;
    }

    Coordinate(String coordinates) {
        String coordUpper = coordinates.toUpperCase();
        y = coordUpper.charAt(0)-'A';
        if (coordUpper.length() <= 2) {
            x = coordUpper.charAt(1) - '1';
        } else {
            String str = String.valueOf(coordUpper.charAt(1)) + coordUpper.charAt(2);
            x = Integer.parseInt(str)-1;
        }
    }

    Coordinate(int y, int x) {
        this.y = y;
        this.x = x;
    }

    public static int distance(Coordinate from, Coordinate to) {
        return to.x - from.x + to.y - from.y + 1;
    }
}
