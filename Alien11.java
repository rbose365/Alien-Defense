/**
* Makes an Alien that attacks the base
* @author Rishav Bose
* @version 1.00
*/
public class Alien11 extends Monster {
    /**
    * Makes an alien with health 490
    */
    public Alien11() {
        super(490, "provided/res/Pixel-Alien-11.png");
    }
    /**
    * Attacks the base with 10 attack
    * @param a the base to hurt
    */
    public void attack(Base a) {
        a.hurt(10);
    }
}