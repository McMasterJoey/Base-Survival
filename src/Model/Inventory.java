package Model;

import java.util.HashMap;

public class Inventory {
    protected MapData mapdata;
    protected HashMap<Integer,Integer> inventory;
    protected int itemslots;
    protected int totalitemcapacity;
    protected int curitemslotsused;
    protected int totalitemsstored;

    public Inventory(int itemslots, int totalitemcapacity) {
        mapdata = MapData.getInstance();
        inventory =  new HashMap<Integer,Integer>();

        // Set to -1 to disable each part.
        this.itemslots = itemslots;
        this.totalitemcapacity = totalitemcapacity;
    }
    public boolean hasItem(int item_id) {
        if (inventory.containsKey(item_id)) {
            return inventory.get(item_id).intValue() > 0;
        }
        return false;
    }
    public int getNumOfItems(int item_id) {
        if (inventory.containsKey(item_id)) {
            return inventory.get(item_id).intValue();
        }
        throw new IllegalArgumentException("item_id = " + item_id + " not found in inventory");
    }
    public HashMap<Integer,Integer> getItems() {
        return inventory;
    }
    public boolean insert(int item_id, int num) {
        return adjustInventory(item_id,num);
    }
    public boolean remove(int item_id, int num) {
        return adjustInventory(item_id,num * -1);
    }

    public boolean adjustInventory(int item_id, int num) {
        boolean exceededcap = true;

        if (inventory.containsKey(item_id)) {
            int new_total = inventory.get(item_id) + num;
            if (new_total < 0) {
                throw new IllegalArgumentException("Inventory adjustment resulted in a negative value overall. (1)");
            }

            int limit = Items.getInstance().getItemMaxCap(item_id);
            if (new_total > limit) {
                new_total = limit;
                exceededcap = false;
            }
        } else {
            if (num < 0) {
                throw new IllegalArgumentException("Inventory adjustment resulted in a negative value overall. (2)");
            }
            int limit = Items.getInstance().getItemMaxCap(item_id);
            if (num > limit) {
                num = limit;
                exceededcap = false;
            }
            inventory.put(item_id,num);
        }
        return exceededcap;
    }
}
