/**
* Makes an Alien that attacks the base
* @author Rishav Bose
* @version 1.00
*/
public class Alien10 extends Monster {
    /**
    * Makes an alien with health 10
    */
    public Alien10() {
        super(10, "provided/res/Pixel-Alien-10.png");
    }
    /**
    * Attacks the base with 490 attack
    * @param a the base to hurt
    */
    public void attack(Base a) {
        a.hurt(490);
    }
}