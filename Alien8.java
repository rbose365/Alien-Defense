/**
* Makes an Alien that attacks the base
* @author Rishav Bose
* @version 1.00
*/
public class Alien8 extends Monster {
    /**
    * Makes an alien with health 100
    */
    public Alien8() {
        super(100, "provided/res/Pixel-Alien-8.png");
    }
    /**
    * Attacks the base with 400 attack
    * @param a the base to hurt
    */
    public void attack(Base a) {
        a.hurt(400);
    }
}