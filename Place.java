package battleship;

import java.util.Scanner;

public class Place {

    private final Battlefield battlefield;
    private final Scanner scanner;

    public Place(Battlefield battlefield, Scanner scanner) {
        this.battlefield = battlefield;
        this.scanner = scanner;
    }

    public void placeShip(ShipTypes constant) {
        String name = constant.getName();
        int length = constant.getLength();
        boolean correctLength = false;

        System.out.printf("%nEnter the coordinates of the %s (%d cells):%n%n", name, length);

        while (!correctLength) {

            // ask user for coordinates
            Coordinate c1 = new Coordinate(scanner.next());
            Coordinate c2 = new Coordinate(scanner.next());

            // initialize variables
            Coordinate start;
            Coordinate end;

            // check if coordinates are from left to right or right to left
            if (c1.getX() <= c2.getX() && c1.getY() <= c2.getY()) {
                start = c1;
                end = c2;
            } else {
                start = c2;
                end = c1;
            }

            if (diagonal(start, end)) {
                System.out.printf("%nError! Wrong ship location! Try again:%n%n");
                continue;
            }

            if (overlaps(start, end)) {
                System.out.printf("%nError! You placed it too close to another one. Try again:%n%n");
                continue;
            }

            int shipLength = Coordinate.distance(start, end);
            if (shipLength != length) {
                System.out.printf("%nError! Wrong length of the %s! Try again:%n%n", name);
                continue;
            }
            battlefield.placeShip(constant, start, end);

            correctLength = true;

        }
    }

    boolean diagonal(Coordinate start, Coordinate end) {
        return start.getY() != end.getY() && start.getX() != end.getX();
    }

    boolean overlaps(Coordinate start, Coordinate end) {
        for (int i = start.getX() - 1; i <= end.getX() + 1; i++) {
            for (int j = start.getY() - 1; j <= end.getY() + 1; j++) {

                if (battlefield.shipAt(i, j)) {
                    return true;
                }
            }
        }
        return false;
    }

}
