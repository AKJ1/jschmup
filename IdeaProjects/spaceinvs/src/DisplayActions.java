

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.*;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

public class DisplayActions extends JComponent {

    int xShip, yShip, moveSpeed, BulletTimer, attackSpeed, maxEnemies, difficulty, level, pause;
    boolean left, right, shoot;
    List<Enemy> enemies = new CopyOnWriteArrayList<Enemy>();
    List<Bullet> bullets = new CopyOnWriteArrayList<Bullet>();
    static DisplayActions actions = new DisplayActions();

    BufferedImage ship = getImage("Ship2"); // Add images by putting them in /res/.
    BufferedImage bullet = getImage("PBullet");

    InputHandler input = new InputHandler();
    static JFrame window = new JFrame(); // Creates a window
    Random rnd = new Random();

    public static void main(String[] Args){

    actions.setUpDisplay(); // Creates the window and sets the parameters in setUP;
    actions.setUpVariables();
        while (true) {
            try {
                actions.movement();
                actions.shoot();
                actions.repaint();
                actions.spawnEnemies();
                actions.moveEnemeies();
                actions.detectCollision();
                Thread.sleep(8);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

    }



    @Override
    protected void paintComponent(Graphics g) {
        g.setColor(Color.BLUE);
        g.drawImage(ship, xShip, yShip, ship.getWidth() / 3, ship.getHeight() / 3, null);
        for(Bullet b : bullets){
            g.drawImage(bullet, b.pointX,b.pointY,b.width,b.height, null);
        }
        for (Enemy e : enemies){
            g.drawImage(e.sprite, e.locX, e.locY, e.sprite.getWidth(), e.sprite.getHeight(), null);
        }
    }
    public void spawnEnemies() {
        if (enemies.isEmpty()) {
            for (int i = 0; i < difficulty; i++) {
                    System.out.println( difficulty);
                    Enemy e = new Enemy();
                    e.setEnemy(1);
                    enemies.add(e);
                }
            pause = 500; // 4 seconds
            difficulty += 3;
            level += 1;
            }
        }
    public void detectCollision(){
        for (Bullet b : bullets){
            for (Enemy e : enemies){
                if (b.pointX >= e.locX && b.pointX <= e.locX + e.sprite.getWidth() && b.pointY <= e.locY && b.pointY < e.locY + e.sprite.getHeight()){
                    e.health--;
                    bullets.remove(b);
                }
            }
        }
    }
    public void moveEnemeies(){
        for(Enemy e : enemies){
            e.directionSwitchX--;
            if (e.locX > e.sprite.getWidth() && e.locX < (window.getWidth() - e.sprite.getWidth())){
                e.locX += e.moveSpeedX * e.direction;
                e.locY += e.moveSpeedY * e.direction;
                e.directionSwitchX += rnd.nextInt(10)* e.direction;
            }
            if (e.locX < e.sprite.getWidth() + 10 || e.locX > getWidth() - e.sprite.getWidth() - 20){
                e.direction = -e.direction ;
            }
            if (e.health < 1){
                enemies.remove(e);
            }
        }
    }
    public void shoot(){

        if(shoot && BulletTimer == 0){
            Bullet b; // Creates a new bullet;
            b = Bullet.getBullet(6 +  xShip + ship.getWidth()/8, yShip - ship.getHeight()/9, 10, 20, 5, 1); // Sets bullet's Parameters
            bullets.add(b); // adds to array
            BulletTimer = attackSpeed; // Time between bullets is 32 * 8 ( thread.sleep) miliseconds = 256ms
        }else if(BulletTimer >= 1){
            BulletTimer--;
        }
        for (Bullet b : bullets ){
            if (b.isOutsideBounds(b)){
                bullets.remove(b);
            }
            else {
                b.pointY -= b.bulletSpeed;
            }

        }
    }
    public void movement() {
        left = input.getLeft();
        right = input.getRight();
        shoot = input.getShoot();

        if ( (xShip < (window.getWidth() - ship.getWidth()/3 - 5))){
            if (right) {
                xShip += moveSpeed;
            }
        }
        if (xShip >= 0 ){
            if (left) {
                xShip -= moveSpeed;
            }
        }
    }
    public void setUpVariables(){
        xShip = (window.getWidth()/2) - (ship.getWidth()/6);
        yShip = 600-ship.getHeight()/3;
        attackSpeed = 48; //lower is faster;
        moveSpeed = 5;
        difficulty = 3;
    }
    public void setUpDisplay(){

        window.setSize(480, 640);
        window.setTitle("Gaem");
        window.addKeyListener(input);
        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        window.add(actions);
        window.setVisible(true);
    }
    public static BufferedImage getImage(String str){
        File source = new File("res/" + str + ".png");
        BufferedImage in = null;
        try {
            in = ImageIO.read(source);

        } catch (IOException e) {
            e.printStackTrace();
        }
        return in;
    }

}
