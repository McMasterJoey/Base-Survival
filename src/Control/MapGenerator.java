package Control;

import Model.MC;
import Model.MapData;

import java.util.Random;

public class MapGenerator {
    private MapData data;
    private Random rand;

    public MapGenerator(MapData data) {
        this.data = data;
        rand = new Random();

        GenerateMapTest();
    }

    public int getRandomInt() {
        return Math.abs(rand.nextInt());
    }

    public void GenerateMapDefault() {
        int h = data.getHeight();
        int w = data.getWidth();

        // Set the entire map to plains
        for(int x = 0; x < w; x++) {
            for(int y = 0; y < h; y++) {
                data.getTileAtPos(x,y).setTileType(MC.TILE_TYPE_PLANES);
            }
        }

        // Generate mountain regions.
        int gen_moutains = ((h * w) / 2143) + 1 + (getRandomInt() % 6);
        for(int i = 0; i < gen_moutains; i++) {
            int randomx = getRandomInt() % w;
            int randomy = getRandomInt() % h;
            int dir = getRandomInt() % 8;
            int thickness = (getRandomInt() % 3) + 1;
            int lenofrange = (getRandomInt() % (Math.max(w,h) - 6)) + 5;

            if (dir == 0) { // North/up
                
            }

        }


    }

    public void GenerateMapIslands() {
        int h = data.getHeight();
        int w = data.getWidth();

        // Flood the entire map in deep water.
        for(int x = 0; x < w; x++) {
            for(int y = 0; y < h; y++) {
                data.getTileAtPos(x,y).setTileType(MC.TILE_TYPE_WATER);
            }
        }

        // Decide how many islands to generate.
        int totalislands = ((h * w) / 3250) + 1 + (getRandomInt() % 3);

        for(int i = 0; i < totalislands; i++) {
            int originx = getRandomInt() % w;
            int originy = getRandomInt() % h;
            int reachmod = (getRandomInt() % 15) + 10;

            int northreach = getRandomInt() % reachmod - 1;
            int southreach = getRandomInt() % reachmod + 3;
            int eastreach = getRandomInt() % reachmod + 2;
            int westreach = getRandomInt() % reachmod - 2;

            int[][] points = new int[5][2];
            points[0][0] = originx;             points[0][1] = originy;
            points[1][0] = originx;             points[1][1] = originy - northreach;
            points[2][0] = originx + eastreach; points[2][1] = originy;
            points[3][0] = originx;             points[3][1] = originy + southreach;
            points[4][0] = originx - westreach; points[4][1] = originy;

            for(int x = 0; x < eastreach; x++) {
                
            }

        }

    }
    public void GenerateMapTest() {
        int h = data.getHeight();
        int w = data.getWidth();

        // Create a mountain range along the edge of the map.
        for(int x = 0; x < w; x++) {
            data.getTileAtPos(x,0).setTileType(MC.TILE_TYPE_MOUNTAIN);
            data.getTileAtPos(x,h - 1).setTileType(MC.TILE_TYPE_MOUNTAIN);
        }
        for(int y = 0; y < h; y++) {
            data.getTileAtPos(0,y).setTileType(MC.TILE_TYPE_MOUNTAIN);
            data.getTileAtPos(w - 1,y).setTileType(MC.TILE_TYPE_MOUNTAIN);
        }

        // Create a river that runs down the middle and a series of hills and coast between the river with randomness.
        for(int x = 1; x < (w - 1);x++) {
            int in1 = getRandomInt() % 2;
            int in2 = getRandomInt() % 2;
            if (in1 == 0) {
                data.getTileAtPos(x,h/4).setTileType(MC.TILE_TYPE_HILL);
            }
            if (in2 == 0) {
                data.getTileAtPos(x,((h/4) * 3)).setTileType(MC.TILE_TYPE_COAST);
            }
            data.getTileAtPos(x,h/2).setTileType(MC.TILE_TYPE_RIVER);
        }

        // Generate sectional compostion of the earth.

        for(int x = 0; x < w; x++) {
            for(int y = 0; y < h; y++) {
                int th = data.getTileAtPos(x,y).getTerrainHeight();
                for(int z = th; z < 5; z++) {
                    data.getTileAtPos(x,y).getSliceData(z).generateData();
                }
            }
        }

    }
}
