/**
* Makes an Alien that attacks the base
* @author Rishav Bose
* @version 1.00
*/
public class Alien4 extends Monster {
    /**
    * Makes an alien with health 400
    */
    public Alien4() {
        super(400, "provided/res/Pixel-Alien-4.png");
    }
    /**
    * Attacks the base with 100 attack
    * @param a the base to hurt
    */
    public void attack(Base a) {
        a.hurt(100);
    }
}