package battleship;
import java.util.Scanner;

public class Shoot {

    public Object[] takeShot(Battlefield battlefield, Scanner scanner) {
        boolean correctCoordinate = false;
        boolean hit = false;
        Coordinate shotCoordinate = new Coordinate(0, 0);

        while (!correctCoordinate) {
            Coordinate shot = new Coordinate(scanner.next());
            int y = shot.getY();
            int x = shot.getX();

            if (y < 0 || y > 9 || x < 0 || x > 9) {
                System.out.printf("%nError! You entered the wrong coordinates! Try again:%n%n");
            } else if (battlefield.markShot(shot)) {
                correctCoordinate = true;
                hit = true;
                shotCoordinate = shot;
            } else {
                correctCoordinate = true;
            }
        }
        return new Object[]{hit, shotCoordinate};
    }
}
