import javafx.application.Application;
import static javafx.application.Application.launch;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import javafx.scene.image.Image;
import javafx.scene.paint.Color;
import javafx.scene.image.ImageView;
import javafx.scene.shape.Rectangle;
import javafx.animation.AnimationTimer;
import java.util.Random;
import javafx.scene.Group;
import javafx.scene.image.PixelReader;
import javafx.scene.text.Text;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;

/**
* Sets up the scene
* @author Rishav Bose
* @version 1.00
*/
public class Scene1 extends Application {
    private int count1 = 10;
    private int count2 = 25;
    private int animatecount = 0;

    private Monster[] level1m = new Monster[count1];

    private ImageView[] level1i = new ImageView[count1];

    private Turret[] turrets = new Turret[0];
    private ImageView[] turretsi = new ImageView[0];

    private Group g1 = new Group();
    private Group g2 = new Group();
    private Group g3 = new Group();
    private Group g4 = new Group();

    private int wincount = 0;

    private Scene scene;
    private ImageView gameover = new ImageView(new Image("gameover.png"));
    private ImageView youwin = new ImageView(new Image("youwin.png"));
    private Base base = new Base("Home", 50, 1000, 20);

    private final Random random = new Random();

    /**
    * Makes the main method to run the program
    * @param args the arguments
    */
    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(final Stage stage) {
        level1m = initMArray(count1);
        level1i = initIArray(level1m);
        g1.getChildren().setAll(level1i);
        Group layout = new Group();
        ImageView back = new ImageView(
            new Image("/provided/res/MapCropped.png",
            1376, 736, false, true));
        ImageView backm = new ImageView(
            new Image("/provided/res/placeMapCroppedMinified.png",
            1376, 736, false, true));
        ImageView fore = new ImageView(
            new Image("/provided/res/MapCroppedForeground.png",
            1376, 736, false, true));
        PixelReader p = backm.getImage().getPixelReader();
        Text health = new Text(550, 50, "Health: " + base.getHealth());
        Text score = new Text(550, 100, "Score: " + base.getScore());
        Text nxtwave = new Text(550, 300, "");
        health.setFont(Font.font("Times New Roman", FontWeight.BOLD, 40));
        score.setFont(Font.font("Times New Roman", FontWeight.BOLD, 40));
        nxtwave.setFont(Font.font("Times New Roman", FontWeight.BOLD, 50));
        layout.getChildren().addAll(backm,
            back, g1, g2, g3, g4, fore, health, score, nxtwave);
        scene = new Scene(layout, 1376, 736);
        stage.setScene(scene);
        layout.setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override public void handle(MouseEvent event) {
                Color c = p.getColor((int) event.getX(), (int) event.getY());
                if (c.getGreen() == 1.0) {
                    if (base.getScore() >= 10) {
                        double x = event.getX() - 27;
                        double y = event.getY() - 27;
                        ImageView turret = new ImageView(
                            new Image("/provided/res/launcher.png"));
                        turret.setX(x);
                        turret.setY(y);
                        ImageView[] copyiv = new ImageView[turretsi.length + 1];
                        for (int tic = 0; tic < turretsi.length; tic++) {
                            copyiv[tic] = turretsi[tic];
                        }
                        copyiv[turretsi.length] = turret;
                        turretsi = copyiv;
                        Turret[] copytv = new Turret[turrets.length + 1];
                        for (int ttc = 0; ttc < turrets.length; ttc++) {
                            copytv[ttc] = turrets[ttc];
                        }
                        copytv[turrets.length] = new Turret(25, 300);
                        turrets = copytv;
                        g2.getChildren().setAll(turretsi);
                        base.subtractScore(10);
                        score.setText("Score: " + base.getScore());
                    }
                } else {
                    System.out.println("Cannot place here!");
                }
            }
        });
        stage.show();
        AnimationTimer level1 = new AnimationTimer() {
            @Override
            public void handle(long now) {
                g3.getChildren().setAll();
                Rectangle rectb = new Rectangle(930, 10, 400, 40);
                rectb.setFill(Color.RED);
                double aaa = base.getHealth();
                double bbb = base.getMaxHealth();
                Rectangle rectf = new Rectangle(930, 10,
                    (int) (400 * (aaa / bbb)), 40);
                rectf.setFill(Color.GREEN);
                g3.getChildren().addAll(rectb, rectf);
                if (random.nextInt(500) == 1) {
                    base.regen();
                }
                if (animatecount == 0) {
                    nxtwave.setText("");
                    for (int index = 0; index < level1i.length; index++) {
                        ImageView node = level1i[index];
                        if (level1m[index].getMove()) {
                            move(node, index);
                            for (int tl = 0; tl < turretsi.length; tl++) {
                                ImageView node1 = turretsi[tl];
                                Turret tur = turrets[tl];
                                int radius = (int) Math.sqrt((Math.pow(
                                    node.getX() - node1.getX(), 2)
                                    + Math.pow(node.getY() - node1.getY(), 2)));
                                if (radius <= tur.getRadius()) {
                                    if (random.nextInt(150) == 1) {
                                        tur.attack(level1m[index]);
                                    }
                                }
                            }
                            rectb = new Rectangle(node.getX()
                                - 8, node.getY() - 20, 75, 10);
                            rectb.setFill(Color.RED);
                            aaa = level1m[index].getHealth();
                            bbb = level1m[index].getInitHealth();
                            rectf = new Rectangle(node.getX() - 8,
                                node.getY() - 20, (int) (75 * (aaa / bbb)), 10);
                            rectf.setFill(Color.GREEN);
                            g3.getChildren().addAll(rectb, rectf);
                        } else {
                            if (random.nextInt(1000) == 1) {
                                level1m[index].setMove(true);
                                node.setX(15);
                                node.setY(370);
                            }
                        }
                        if (level1m[index].getHealth() == 0) {
                            level1i[index].setX(-100);
                            level1i[index].setY(-100);
                            level1m = remove(level1m, index);
                            level1i = remove(level1i, index);
                            base.subtractScore(-10);
                        }
                        if (level1m.length == 0) {
                            if (wincount == 1) {
                                VBox gobox = new VBox();
                                gobox.getChildren().addAll(youwin);
                                scene = new Scene(gobox);
                                stage.setScene(scene);
                                this.stop();
                            }
                            level1m = initMArray(count2);
                            level1i = initIArray(level1m);
                            turrets = new Turret[0];
                            turretsi = new ImageView[0];
                            g1.getChildren().setAll(level1i);
                            g2.getChildren().setAll(turretsi);
                            wincount = 1;
                            base.setScore(20);
                            animatecount = 500;
                        }
                        health.setText("Health: " + base.getHealth());
                        score.setText("Score: " + base.getScore());
                    }
                    if (!(base.isAlive())) {
                        VBox gobox = new VBox();
                        gobox.getChildren().addAll(gameover);
                        scene = new Scene(gobox);
                        stage.setScene(scene);
                        this.stop();
                    }
                } else {
                    animatecount--;
                    nxtwave.setText("Next wave in " + animatecount / 60);
                }
            }
        };
        level1.start();
    }
    /**
    * Moves the image along the path
    * @param iv1 the image to move
    * @param index the index
    */
    public void move(ImageView iv1, int index) {
        double transx = iv1.getX();
        double transy = iv1.getY();
        if (transx == 1090 && transy == 180) {
            iv1.setY(180);
            iv1.setX(1090);
            if (random.nextInt(100) == 1) {
                level1m[index].attack(base);
            }
        } else if (transx < 45 && transy == 370) {
            iv1.setX(transx + 1);
        } else if (transx == 45 && transy > 25) {
            iv1.setY(transy - 1);
        } else if (transx < 245 && transy == 25) {
            iv1.setX(transx + 1);
        } else if (transx == 245 && transy < 670) {
            iv1.setY(transy + 1);
        } else if (transx < 335 && transy == 670) {
            iv1.setX(transx + 1);
        } else if (transx == 335 && transy > 550) {
            iv1.setY(transy - 1);
        } else if (transx < 775 && transy == 550) {
            iv1.setX(transx + 1);
        } else if (transx == 775 && transy > 400) {
            iv1.setY(transy - 1);
        } else if (transx < 1090 && transy == 400) {
            iv1.setX(transx + 1);
        }  else if (transx == 1090 && transy > 180) {
            iv1.setY(transy - 1);
        }
    }
    /**
    * Initializes the Monster array
    * @param count the size of the array
    * @return the Monster array
    */
    public Monster[] initMArray(int count) {
        Monster[] leveltm = new Monster[count];
        for (int i = 0; i < count; i++) {
            int r = random.nextInt(12) + 1;
            if (r == 1) {
                leveltm[i] = new Alien1();
            } else if (r == 2) {
                leveltm[i] = new Alien2();
            } else if (r == 3) {
                leveltm[i] = new Alien3();
            } else if (r == 4) {
                leveltm[i] = new Alien4();
            } else if (r == 5) {
                leveltm[i] = new Alien5();
            } else if (r == 6) {
                leveltm[i] = new Alien6();
            } else if (r == 7) {
                leveltm[i] = new Alien7();
            } else if (r == 8) {
                leveltm[i] = new Alien8();
            } else if (r == 9) {
                leveltm[i] = new Alien9();
            } else if (r == 10) {
                leveltm[i] = new Alien10();
            } else if (r == 11) {
                leveltm[i] = new Alien11();
            } else if (r == 12) {
                leveltm[i] = new Alien12();
            }
        }
        return leveltm;
    }
    /**
    * Initializes the Imageview array
    * @param mArray the monster array to make
    * @return the ImageView array
    */
    public ImageView[] initIArray(Monster[] mArray) {
        int count = mArray.length;
        ImageView[] levelti = new ImageView[count];
        for (int i = 0; i < count; i++) {
            levelti[i] = new ImageView(mArray[i].getImage());
            levelti[i].setX(-100);
            levelti[i].setY(-100);
        }
        return levelti;
    }
    /**
    * Gives an array with the value removed
    * @param arr the imageview array
    * @param index the index of remove
    * @return the new ImageView array
    */
    public ImageView[] remove(ImageView[] arr, int index) {
        int length = arr.length;
        ImageView[] copy = new ImageView[length - 1];
        for (int i = 0; i < index; i++) {
            copy[i] = arr[i];
        }
        for (int j = index; j < length - 1; j++) {
            copy[j] = arr[j + 1];
        }
        return copy;
    }
    /**
    * Gives an array with the value removed
    * @param arr the Monster array
    * @param index the index of remove
    * @return the new Monster array
    */
    public Monster[] remove(Monster[] arr, int index) {
        int length = arr.length;
        Monster[] copy = new Monster[length - 1];
        for (int i = 0; i < index; i++) {
            copy[i] = arr[i];
        }
        for (int j = index; j < length - 1; j++) {
            copy[j] = arr[j + 1];
        }
        return copy;
    }
}
