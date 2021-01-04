package Model.Entity;
import Model.MC;
import Model.MapCol;

public class Mine extends Harvester {
    public Mine(int pos_x, int pos_y, MapCol[] ground) {
        super(pos_x, pos_y, 2, "Mine", 10);
        UNIQUE_TYPE_ID = MC.OBJECT_ID_MINE;
    }
    public void onClick() {
        // TODO: Write me
        return;
    }
    public void upgrade() {

    }
    protected void buildUpgradeCostList() {

    }
    public void doAction() {
        if (this.level == 1) {

        }
    }
}
