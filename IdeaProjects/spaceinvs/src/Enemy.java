import java.awt.image.BufferedImage;
import java.util.Random;

/**
 * Created by Ace on 18.5.2014 г..
 */
public class Enemy {
    int value, health, shotSpeed, shotFreqency, moveSpeedX, moveSpeedY, locX, locY, directionSwitchX, directionSwitchY, maxY, minY, direction;
    BufferedImage sprite;
    Random rng = new Random();


    public void setEnemy(int id){
        switch (id){
            case 1:{
                this.health = 4;
                this.value = 1;
                this.shotSpeed = 3;
                this.moveSpeedX = 2;
                this.moveSpeedY = 0;
                this.shotFreqency = 64; //Same as before X * Thread.sleep(8)
                this.locX = rng.nextInt(300) + 50;
                this.locY = rng.nextInt(200) + rng.nextInt(50) + rng.nextInt(25) + 50;
                this.direction = 1;
                this.directionSwitchX = rng.nextInt(40) + 10;
                this.sprite = DisplayActions.getImage("EShip1");
                break;
            }
            case 2:{

                this.health = 7;
                this.value = 3;
                this.shotSpeed = 3;
                this.moveSpeedX = 4;
                this.moveSpeedY = 2;
                this.shotFreqency = 24; //Same as before X * Thread.sleep(8)
                this.locX = rng.nextInt(300) + 50;
                this.locY = rng.nextInt(100) + 50;
                this.directionSwitchX = rng.nextInt(100) + 50;
                this.sprite = DisplayActions.getImage("EShip2");
                break;

            }
            case 3:{
                this.health = 20;
                this.value = 5;
                this.shotSpeed = 10;
                this.moveSpeedX = 6;
                this.moveSpeedY = 1;
                this.shotFreqency = 80;
                this.locX = rng.nextInt(300) + 50;
                this.locY = rng.nextInt(200) + 340;
                this.sprite = DisplayActions.getImage("EShip3");
                break;
            }
        }

    }
}
