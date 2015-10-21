/**
* Makes an Alien that attacks the base
* @author Rishav Bose
* @version 1.00
*/
public class Alien1 extends Monster {
    /**
    * Makes an alien with health 450
    */
    public Alien1() {
        super(450, "provided/res/Pixel-Alien-1.png");
    }
    /**
    * Attacks the base with 50 attack
    * @param a the base to hurt
    */
    public void attack(Base a) {
        a.hurt(50);
    }
}