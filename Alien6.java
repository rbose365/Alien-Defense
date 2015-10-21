/**
* Makes an Alien that attacks the base
* @author Rishav Bose
* @version 1.00
*/
public class Alien6 extends Monster {
    /**
    * Makes an alien with health 200
    */
    public Alien6() {
        super(200, "provided/res/Pixel-Alien-6.png");
    }
    /**
    * Attacks the base with 300 attack
    * @param a the base to hurt
    */
    public void attack(Base a) {
        a.hurt(300);
    }
}