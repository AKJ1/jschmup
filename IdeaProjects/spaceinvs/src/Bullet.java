import java.awt.*;
import java.awt.image.BufferedImage;

/**
 * Created by Ace on 18.5.2014 г..
 */
public class Bullet {
    Rectangle rect = new Rectangle();
    int height, width, pointX, pointY, bulletSpeed, damage;
    public static Bullet getBullet( int pointX, int pointY, int width, int height, int bulletSpeed, int damage){
        Bullet b = new Bullet();
        b.bulletSpeed = bulletSpeed;
        b.damage = damage;
        b.width = width;
        b.height = height;
        b.pointX = pointX;
        b.pointY = pointY;
        return b;
    }

    public boolean isOutsideBounds(Bullet b){
        if( b.pointY > 640 || b.pointX > 480 || b.pointY < 0){
            return true;
        }
        else return false;
    }
}
