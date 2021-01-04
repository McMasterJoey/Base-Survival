package Model;

public class RenderSettings {
    private int tilesidelength;
    private int pos_x;
    private int pos_y;
    private int gridlinethickness;

    public RenderSettings(int tilesidelength, int gridlinethickness, int pos_x, int pos_y) {
        this.tilesidelength = tilesidelength;
        this.gridlinethickness = gridlinethickness;
        this.pos_x = pos_x;
        this.pos_y = pos_y;
    }
    public int getTileSideLength() {
        return this.tilesidelength;
    }
    public int getPosX() {
        return this.pos_x;
    }
    public int getPosY() {
        return this.pos_y;
    }
    public int getGridLineThickness() {
        return this.gridlinethickness;
    }
    public void setTileSideLength(int tilesidelength) { this.tilesidelength = tilesidelength; }
    public void setPosX(int pos_x) { this.pos_x = pos_x; }
    public void setPosY(int pos_y) { this.pos_y = pos_y; }
    public void setGridLineThickness(int gridlinethickness) { this.gridlinethickness = gridlinethickness; }
    public String toString() {
        return "Current Pos (" + pos_x + "," + pos_y + ")";
    }
}
