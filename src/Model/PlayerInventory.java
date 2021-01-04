package Model;

import Model.Entity.Building;

import java.util.HashMap;
import java.util.Iterator;

public class PlayerInventory extends Inventory {
    public PlayerInventory() {
        super(-1,-1);
    }
    public boolean buyBuilding(Building build) {
        boolean canbuy = canBuyBuilding(build);

        return canbuy;
    }
    public boolean canBuyBuilding(Building build) {
        HashMap<Integer,Integer> cost = build.getCostOf(1);
        Iterator<Integer> iter = cost.keySet().iterator();
        while(iter.hasNext()) {
            Integer item_type = iter.next();
            Integer item_amout = cost.get(item_type);
            if (inventory.get(item_type) == null) {
                return false;
            } else if (inventory.get(item_type) < item_amout) {
                return false;
            }
        }
        return true;
    }

}
