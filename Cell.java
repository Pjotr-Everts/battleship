package battleship;

public class Cell {

    private String visual;
    private int x;
    private int y;
    private ShipTypes constant;
    private boolean hit;

    public Cell(String visual, int x, int y, ShipTypes constant, boolean hit) {
        this.visual = visual;
        this.x = x;
        this.y = y;
        this.constant = constant;
        this.hit = hit;
    }

    public String getVisual() {
        return visual;
    }

    public void setVisual(String visual) {
        this.visual = visual;
    }

    public ShipTypes getConstant() {
        return constant;
    }

    public void setConstant(ShipTypes constant) {
        this.constant = constant;
    }

    public boolean isHit() {
        return hit;
    }

    public void setHit(boolean hit) {
        this.hit = hit;
    }
}
