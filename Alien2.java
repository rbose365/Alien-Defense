/**
* Makes an Alien that attacks the base
* @author Rishav Bose
* @version 1.00
*/
public class Alien2 extends Monster {
    /**
    * Makes an alien with health 250
    */
    public Alien2() {
        super(250, "provided/res/Pixel-Alien-2.png");
    }
    /**
    * Attacks the base with 250 attack
    * @param a the base to hurt
    */
    public void attack(Base a) {
        a.hurt(250);
    }
}