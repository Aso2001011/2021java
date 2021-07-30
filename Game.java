import java.util.Scanner;

public class Game {
    private final int SHIPS = 3;
    private final int MAPSIZE = 5;
    private Ship[] ship = new Ship[SHIPS];
    private Map map = new Map();    


    public Game(){
        for(int i = 0; i < SHIPS; i++ ){
            ship[i] = new Ship();
        }
    }

    //map create
    public void init(){
        map.init(MAPSIZE);
        for(int i = 0; i < SHIPS; i++){
            do{
                ship[i].init(MAPSIZE);
            }while(!map.deployShip(ship[i]));
        }
    }

    //gamestart
    public void startGame(){
        int attackX;
        int attackY;

        Scanner scanner = new Scanner(System.in);
        int turn = 1;

        title();
        while(!AllSink()){
            System.out.println("------[ターン"+turn+"]------");
            displaySituation();
            System.out.println("爆弾のX座標を入力してください(1-"+MAPSIZE+")");
            attackX = scanner.nextInt();
            System.out.println("爆弾のY座標を入力してください(1-"+MAPSIZE+")");
            attackY = scanner.nextInt();

            for(int i = 0; i < SHIPS; i++ ){
                int result = ship[i].check(attackX-1, attackY-1);

                Result(ship[i],i+1,result);
            }
            turn++;
        }
        System.out.println("すべて撃沈！おめでとうございます");

        scanner.close();
    }

    //call title
    private void title(){
        System.out.println("*********************");
        System.out.println("      戦艦ゲーム　    ");
        System.out.println("*********************");
    }


    //船沈んだか
    private boolean AllSink(){
        boolean allSink = true;
        for(int i = 0; i < SHIPS; i++){
            if( ship[i].Alive()){
                allSink = false;
                break;
            }
        }

        return allSink;
    }

    //船の状況表示
    private void displaySituation(){
        for(int i = 0;i < SHIPS; i++){
            if( ship[i].Alive()){
                System.out.println("船"+(i+1)+":生きてる");
            }else{
                System.out.println("船"+(i+1)+":撃沈済み");
            }
        }
    }

    //船ＨＩＴ判定
    private void Result(Ship ship,int no,int result){
        if( result == Ship.NO_HIT){
            System.out.println("船"+no+":はずれ！");
        }else if( result == Ship.NEAR){
            System.out.println("船"+no+":波高し！");
        }else if( result == Ship.HIT){
            System.out.println("船"+no+":爆弾が当たった！しかし船はまだ沈まない！船は移動します");
            moveShip(ship);
        }else{
            System.out.println("船"+no+":爆弾が当たった！撃沈しました！");
            map.clear(ship.getPosX(), ship.getPosY());
        }
    }

    //ＨＩＴ時の船移動
    private void moveShip(Ship ship){

        map.clear(ship.getPosX(), ship.getPosY());
        do{
            ship.move(MAPSIZE);
        }while(!map.deployShip(ship));
    }
}