/**
* Makes an Alien that attacks the base
* @author Rishav Bose
* @version 1.00
*/
public class Alien7 extends Monster {
    /**
    * Makes an alien with health 150
    */
    public Alien7() {
        super(150, "provided/res/Pixel-Alien-7.png");
    }
    /**
    * Attacks the base with 350 attack
    * @param a the base to hurt
    */
    public void attack(Base a) {
        a.hurt(350);
    }
}