/**
* Makes a turret that shoots
* @author Rishav Bose
* @version 1.00
*/
public class Turret {
    private int attack;
    private int radius;
    /**
    * Makes a Turret with an attack and radius
    * @param attack the attack fo the turret
    * @param radius the radius of attack
    */
    public Turret(int attack, int radius) {
        this.attack = attack;
        this.radius = radius;
    }
    /**
    * Attacks a given monster
    * @param a the monster to attack
    */
    public void attack(Monster a) {
        a.hurt(attack);
    }
    /**
    * Gets the attack of the turret
    * @return the attack
    */
    public int getAttack() {
        return this.attack;
    }
    /**
    * Sets the attack
    * @param attack the new attack
    */
    public void setAttack(int attack) {
        this.attack = attack;
    }
    /**
    * Gets the radius
    * @return the radius
    */
    public int getRadius() {
        return this.radius;
    }
    /**
    * Sets the radius
    * @param radius the new radius
    */
    public void setRadius(int radius) {
        this.radius = radius;
    }
    /**
    * Turns the turret to a string
    * @return the string form of the turret
    */
    public String toString() {
        return this.attack + "";
    }
}