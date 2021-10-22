package rpgcreature;

import java.util.Random;

public class Golem extends Monster {
    private final static int CRITICAL_HIT_RATE = 5;
    public Golem(){
        super("ゴーレム",100);
    }
    
    @Override
    public void attack(Creature opponent) {
        
        Random r = new Random();
        int damage = 0;
        System.out.printf("%sの攻撃！\n",getName());

        //クリティカルヒットかのチェック
        if( r.nextInt(100) < CRITICAL_HIT_RATE ){
            //クリティカルヒット
            damage = 30;
            System.out.printf("%sのクリティカルヒット！\n",getName());
        }else{
            damage = r.nextInt(10)+1;
            
        }
        opponent.damaged(damage);
        
        displayMessage(opponent,damage);
    }
    
}

