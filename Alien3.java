/**
* Makes an Alien that attacks the base
* @author Rishav Bose
* @version 1.00
*/
public class Alien3 extends Monster {
    /**
    * Makes an alien with health 350
    */
    public Alien3() {
        super(350, "provided/res/Pixel-Alien-3.png");
    }
    /**
    * Attacks the base with 150 attack
    * @param a the base to hurt
    */
    public void attack(Base a) {
        a.hurt(150);
    }
}