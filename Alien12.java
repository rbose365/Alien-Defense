/**
* Makes an Alien that attacks the base
* @author Rishav Bose
* @version 1.00
*/
public class Alien12 extends Monster {
    /**
    * Makes an alien with health 800
    */
    public Alien12() {
        super(800, "provided/res/Pixel-Alien-12.png");
    }
    /**
    * Attacks the base with 2 attack
    * @param a the base to hurt
    */
    public void attack(Base a) {
        a.hurt(2);
    }
}