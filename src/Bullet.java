import java.awt.*;
import java.awt.image.BufferedImage;

/**
 * This is the class intended for bullets fired by the Player.
 * Created by Ace on 18.5.2014 г..
 */
public class Bullet {
    int  id, height, width, pointX, pointY, bulletSpeed, damage, direction, shotSpeed;
    boolean collides;
    BufferedImage sprite;

    public void setBullet(int id, int x, int y){
        switch (id) {
            case 1:{
                this.id = 1;
                this.pointX = x;
                this.pointY = y;
                this.bulletSpeed = 10;
                this.shotSpeed = 24;
                this.damage = 1;
                this.direction = -1; // player
                this.sprite = DisplayActions.getImage("EBullet1");
                this.width = sprite.getWidth();
                this.height = sprite.getHeight();
                this.collides = true;
                break;
            }
            case 2:{
                this.id = 2;
                this.pointX = x;
                this.pointY = y;
                this.bulletSpeed = 3;
                this.damage = 1;
                this.shotSpeed = 25;
                this.direction = -1;
                this.sprite = DisplayActions.getImage("PBullet2");
                this.width = this.sprite.getWidth();
                this.height = this.sprite.getHeight();
                break;
            }
            case 3:{

                this.id = 3;
                this.pointX = x;
                this.pointY = y;
                this.bulletSpeed = 3;
                this.damage = 1;
                this.shotSpeed = 128;
                this.direction = -1;
                this.sprite = DisplayActions.getImage("PBullet3");
                this.width = this.sprite.getWidth();
                this.height = this.sprite.getHeight();
                break;
            }
        }
    }

    public boolean isOutsideBounds(Bullet b){
        if( b.pointY > 640 || b.pointX > 480 || b.pointY < 0 ){
            return true;
        }
        else return false;
    }
}
