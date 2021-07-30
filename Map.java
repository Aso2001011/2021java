public class Map {
    private int[][] map;

    public Map(){
    }

    //creatmap
    public void init(int mapSize){
        map = new int[mapSize][mapSize];
        for(int i = 0; i < mapSize; i++){
            for(int j = 0; j < mapSize; j++){
                map[i][j] = 0;
            }
        }
    }

    
    public boolean deployShip(Ship ship){
        int x = ship.getPosX();
        int y = ship.getPosY();

        if( x >= map.length || y >= map.length){
            return false;
        }

        if( map[x][y] != 0){
            return false;
        }

        map[x][y] = 1;

        return true;
    }

    public void  clear(int x,int y){

        if( x >= map.length || y >= map.length){
            return;
        }

        map[x][y] = 0;
    }
}