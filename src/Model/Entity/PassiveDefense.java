package Model.Entity;

public class PassiveDefense extends Building {

    public PassiveDefense(int pos_x, int pos_y, int tile_size, String building_type, int max_levels) {
        super(pos_x, pos_y, tile_size, building_type, max_levels);
    }
    public String toString() {
        return "PassiveDefense: x = " + pos_x + " , y = " + pos_y;
    }
}
