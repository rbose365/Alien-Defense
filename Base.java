/**
* Makes an Base that has health and regen
* @author Rishav Bose
* @version 1.00
*/
public class Base {
    private String name;
    private int regen;
    private int health;
    private int maxHealth = 2000;
    private int score;
    /**
    * Makes the base object
    * @param name the name of the base
    * @param regen the amount to add to the base health
    * @param health the health of teh base
    * @param score the score of the base
    */
    public Base(String name, int regen, int health, int score) {
        this.name = name;
        this.regen = regen;
        this.health = health;
        this.score = score;
    }
    /**
    * Returns the name of the base
    * @return the name
    */
    public String getName() {
        return this.name;
    }
    /**
    * Sets the name
    * @param name the new name
    */
    public void setName(String name) {
        this.name = name;
    }
    /**
    * Gets the Regen amount
    * @return the regen
    */
    public int getRegen() {
        return this.regen;
    }
    /**
    * Sets the regen amount
    * @param regen the new regen amount
    */
    public void setRegen(int regen) {
        this.regen = regen;
    }
    /**
    * Adds health to the base
    */
    public void regen() {
        if (health < maxHealth) {
            if (health > maxHealth - regen) {
                health = maxHealth;
            } else {
                health += regen;
            }
        }
    }
    /**
    * Takes away from health of base
    * @param a the amount to take away
    */
    public void hurt(int a) {
        if (health < a) {
            health = 0;
        } else {
            health -= a;
        }
    }
    /**
    * Gets the current health
    * @return the current health
    */
    public int getHealth() {
        return this.health;
    }
    /**
    * Sets the health
    * @param health the new health
    */
    public void setHealth(int health) {
        this.health = health;
    }
    /**
    * Checks if base is alive
    * @return if health is not negative
    */
    public boolean isAlive() {
        return !(health == 0);
    }
    /**
    * Gets the max health
    * @return the max health
    */
    public int getMaxHealth() {
        return this.maxHealth;
    }
    /**
    * Sets the max health
    * @param maxHealth the new Maxhealth
    */
    public void setMaxHealth(int maxHealth) {
        this.maxHealth = maxHealth;
    }
    /**
    * Gets the score
    * @return the score
    */
    public int getScore() {
        return this.score;
    }
    /**
    * Sets the Score
    * @param score the new score
    */
    public void setScore(int score) {
        if (score >= 0) {
            this.score = score;
        }
    }
    /**
    * Subtracts from the score
    * @param sub the amount to subtract by
    */
    public void subtractScore(int sub) {
        this.setScore(this.getScore() - sub);
    }
}