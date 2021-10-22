package rpgcreature;

import java.util.Random;

/**
 * 魔法使いクラス
 */
public class Wizard extends Monster{
    private final static int MAGIC_RATE = 70;
    /**
     * 魔法使いのコンストラクタ
     */
    public Wizard(){
        super("魔法使い",30);
    }

    /**
     * 攻撃メソッド
     * @param opponent：攻撃相手
     */
    @Override
    public void attack(Creature opponent) {
        
        Random r = new Random();
        int damage = 0;
        if( r.nextInt(100) < MAGIC_RATE){
            System.out.printf("%sは魔法を唱えた！\n",getName());
            damage = r.nextInt(10)+5;
        }else{
            System.out.printf("%sの攻撃！\n",getName());
            damage = r.nextInt(5)+1;
        }
        opponent.damaged(damage);
        
        displayMessage(opponent,damage);
        
    }
}
