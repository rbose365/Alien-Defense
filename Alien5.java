/**
* Makes an Alien that attacks the base
* @author Rishav Bose
* @version 1.00
*/
public class Alien5 extends Monster {
    /**
    * Makes an alien with health 300
    */
    public Alien5() {
        super(300, "provided/res/Pixel-Alien-5.png");
    }
    /**
    * Attacks the base with 70 attack
    * @param a the base to hurt
    */
    public void attack(Base a) {
        a.hurt(70);
    }
}