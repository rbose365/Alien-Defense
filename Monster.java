import javafx.scene.image.Image;
/**
* Makes an Monster that has health, image and movement
* @author Rishav Bose
* @version 1.00
*/
public abstract class Monster {
    private int health;
    private String name;
    private Image image;
    private boolean move;
    private int initHealth;
    /**
    * Makes the monster class
    * @param health the health
    * @param name the name
    * @param image the image
    * @param move the ability to move
    */
    public Monster(int health, String name, Image image, boolean move) {
        this.health = health;
        this.name = name;
        this.image = image;
        this.move = move;
        this.initHealth = health;
    }
    /**
    * Make a Monster Class
    * @param health the health
    * @param name the name
    */
    public Monster(int health, String name) {
        this.health = health;
        this.name = name;
        this.image = new Image(this.name);
        this.move = false;
        this.initHealth = health;
    }
    /**
    * Gets the health
    * @return the health
    */
    public int getHealth() {
        return this.health;
    }
    /**
    * Sets the health
    * @param health the new health
    */
    public void setHealth(int health) {
        if (health >= 0) {
            this.health = health;
        } else {
            this.health = 0;
        }
    }
    /**
    * Gets the health
    * @return the health
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
    * Takes away from health
    * @param a the value to subtract
    */
    public void hurt(int a) {
        setHealth(this.health - a);
    }
    /**
    * Sets the image
    * @param image the new image
    */
    public void setImage(Image image) {
        this.image = image;
    }
    /**
    * Gets the image
    * @return the image
    */
    public Image getImage() {
        return this.image;
    }
    /**
    * Turns Monster to a string
    * @return the string
    */
    public String toString() {
        return this.name;
    }
    /**
    * Gets if moveable
    * @return the ability to move
    */
    public boolean getMove() {
        return move;
    }
    /**
    * Sets the movement ability
    * @param move the ability to move
    */
    public void setMove(boolean move) {
        this.move = move;
    }
    /**
    * Gets the initial health
    * @return the initial health
    */
    public int getInitHealth() {
        return this.initHealth;
    }
    /**
    * Sets the inital health
    * @param initHealth the initial health
    */
    public void setInitHealth(int initHealth) {
        this.initHealth = initHealth;
    }
    /**
    * Attacks a base
    * @param a the base
    */
    public abstract void attack(Base a);
}