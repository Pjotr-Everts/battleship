package battleship;
import java.util.Scanner;

public class Turn {

    public boolean turn(Battlefield battlefield, Hits hits, Scanner scanner) {
        Shoot shoot = new Shoot();
        Object[] shotResult = shoot.takeShot(battlefield, scanner);
        boolean hit = (boolean) shotResult[0];
        Coordinate shot = (Coordinate) shotResult[1];
        int y = shot.getY();
        int x = shot.getX();
        ShipTypes type = battlefield.checkShipType(y, x);
        int currentHits = 0;

        if (hit) {

            if (!battlefield.checkHitStatus(y, x)) {
                battlefield.setHitStatus(y, x); // sets the field 'hit' to true
            }

            if (type == ShipTypes.CARRIER && battlefield.checkHitStatus(y, x)) {
                currentHits = hits.getCarrierHits();
                hits.setCarrierHits(currentHits + 1);
            } else if (type == ShipTypes.BATTLESHIP && battlefield.checkHitStatus(y, x)) {
                currentHits = hits.getBattleshipHits();
                hits.setBattleshipHits(currentHits + 1);
            } else if (type == ShipTypes.SUBMARINE && battlefield.checkHitStatus(y, x)) {
                currentHits = hits.getSubmarineHits();
                hits.setSubmarineHits(currentHits + 1);
            } else if (type == ShipTypes.CRUISER && battlefield.checkHitStatus(y, x)) {
                currentHits = hits.getCruiserHits();
                hits.setCruiserHits(currentHits + 1);
            } else if (type == ShipTypes.DESTROYER && battlefield.checkHitStatus(y, x)) {
                currentHits = hits.getDestroyerHits();
                hits.setDestroyerHits(currentHits + 1);
            }

            if (hits.getTotalNrOfHits() == 16) {
                System.out.printf("%nYou sank the last ship. You won. Congratulations!%n");
                System.exit(0);
            } else if (hits.getCarrierHits() == 5 && hits.getTotalNrOfHits() != 17) {
                System.out.printf("%nYou sank a ship!%n");
                hits.setCarrierHits(0);
            } else if (hits.getBattleshipHits() == 4 && hits.getTotalNrOfHits() != 17) {
                System.out.printf("%nYou sank a ship!%n");
                hits.setBattleshipHits(0);
            } else if (hits.getSubmarineHits() == 3 && hits.getTotalNrOfHits() != 17) {
                System.out.printf("%nYou sank a ship!%n");
                hits.setSubmarineHits(0);
            } else if (hits.getCruiserHits() == 3 && hits.getTotalNrOfHits() != 17) {
                System.out.printf("%nYou sank a ship!%n");
                hits.setCruiserHits(0);
            } else if (hits.getDestroyerHits() == 2 && hits.getTotalNrOfHits() != 17) {
                System.out.printf("%nYou sank a ship!%n");
                hits.setDestroyerHits(0);
            } else if (hits.getTotalNrOfHits() != 17) {
                System.out.printf("%nYou hit a ship!%n");
            }

        } else {
            System.out.printf("%nYou missed.%n");
        }
    return hit;
    }

}
