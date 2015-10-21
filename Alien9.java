/**
* Makes an Alien that attacks the base
* @author Rishav Bose
* @version 1.00
*/
public class Alien9 extends Monster {
    /**
    * Makes an alien with health 50
    */
    public Alien9() {
        super(50, "provided/res/Pixel-Alien-9.png");
    }
    /**
    * Attacks the base with 450 attack
    * @param a the base to hurt
    */
    public void attack(Base a) {
        a.hurt(450);
    }
}