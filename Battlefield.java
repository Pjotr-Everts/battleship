package battleship;

public class Battlefield {

    Cell[][] battlefield;
    char[] rows = {'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I', 'J'};

    // fill battlefield with ~
    public Battlefield(int rows, int columns) {
        battlefield = new Cell[rows][columns];
        for (int i = 0; i < battlefield.length; i++) {
            for (int j = 0; j < battlefield[0].length; j++) {
                battlefield[i][j] = new Cell("~", i, j, ShipTypes.EMPTY, false);
            }
        }
    }

    // print battlefield
    public void printBattlefield() {
        System.out.print("  ");
        for (int i = 1; i < battlefield.length + 1; i++) {
            System.out.print(i + " ");
        }
        System.out.println();
        for (int i = 0; i < 10; i++) {
            System.out.print(rows[i] + " ");
            for (int j = 0; j < 10; j++) {
                System.out.print(battlefield[i][j].getVisual() + " ");
            }
            System.out.println();
        }
    }

    // print battlefield with fog of war
    public void printBattlefieldFogged() {
        System.out.print("  ");
        for (int i = 1; i < battlefield.length + 1; i++) {
            System.out.print(i + " ");
        }
        System.out.println();
        for (int i = 0; i < 10; i++) {
            System.out.print(rows[i] + " ");
            for (int j = 0; j < 10; j++) {
                if (battlefield[i][j].getVisual().equals("O")) {
                    System.out.print("~ ");
                } else {
                    System.out.print(battlefield[i][j].getVisual() + " ");
                }
            }
            System.out.println();
        }
    }

    public boolean shipAt(int x, int y) {
        if (x < 0 || y < 0) return false;
        if (x >= battlefield.length || y >= battlefield.length) return false;
        return battlefield[y][x].getConstant() != ShipTypes.EMPTY;
    }

    public void placeShip(ShipTypes ship, Coordinate from, Coordinate to) {
        for (int i = from.getX(); i <= to.getX(); i++) {
            for (int j = from.getY(); j <= to.getY() ; j++) {
                battlefield[j][i].setVisual("O");
                battlefield[j][i].setConstant(ship);
            }
        }
    }

    public boolean markShot(Coordinate coordinate) {
        int y = coordinate.getY();
        int x = coordinate.getX();
        if (battlefield[y][x].getConstant() != ShipTypes.EMPTY) {
            battlefield[y][x].setVisual("X");
            return true;
        } else {
            battlefield[y][x].setVisual("M");
            return false;
        }
    }

    public ShipTypes checkShipType(int y, int x) {
        return battlefield[y][x].getConstant();
    }

    public boolean checkHitStatus(int y, int x) {
        return battlefield[y][x].isHit();
    }

    public void setHitStatus(int y, int x) {
        battlefield[y][x].setHit(true);
    }

}
