package Model;

import java.util.HashMap;

public class Items {
    private static Items instance;
    private HashMap<Integer, Item> data;

    /**
     * Gets the current instance of the Items.
     *
     * This object is a singleton to ensure that only a single resource that contains all item data is created.
     *
     * @return The current instance
     */
    public static Items getInstance() {
        if (instance == null) {
            instance = new Items();
        }
        return instance;
    }

    private Items() {
        data = new HashMap<Integer,Item>();

        Item MAT_FAR_PRO_BREAD = new Item(MC.MAT_FARM_PRO_BREAD,9999);
        data.put(MAT_FAR_PRO_BREAD.getId(),MAT_FAR_PRO_BREAD);



    }
    public int getItemMaxCap(int item_id) {
        if (data.containsKey(item_id)) {
            return data.get(item_id).getMaxCap();
        }
        throw new IllegalArgumentException("item_id = " + item_id + " not found in item list!");
    }

    private class Item {
        private int id;
        private int max_cap;
        public Item(int id, int max_cap) {
            this.id = id;
            this.max_cap = max_cap;
        }
        public int getId() {
            return id;
        }
        public int getMaxCap() {
            return max_cap;
        }
    }
}
