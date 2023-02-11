/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package clickme2;

import static clickme2.Mole.score;
import java.util.Random;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.event.EventHandler;
import javafx.scene.Cursor;
import javafx.scene.image.Image;
import javafx.scene.paint.Color;
import javafx.scene.paint.ImagePattern;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Text;
import javafx.util.Duration;

/**
 *
 * @author patom
 */
public class Voodoo extends Mole implements ThisIsMole {
 
    Timeline timelineVoodoo;
    Duration duration;
    KeyFrame prisoning;
    KeyFrame autoMove;
    Rectangle voodoo;
    Random rand = new Random();
    Text lbScore;

    public Voodoo(int point){
        super(point);
    }
    public void setDuration(double i){
        duration = Duration.seconds(i);
    }
//        @Override
//    public void sumScore(){
//        timelineVoodoo = new Timeline(new KeyFrame(Duration.seconds(1),e -> {
//        score--;   
//        System.out.println("-1");
//        }));
//        timelineVoodoo.setCycleCount(0);
//
//        
//    }

    @Override
    public int getScore(){
        return score;
    }

    @Override
    public void move(){
        voodoo.setTranslateX(rand.nextInt(960));
        voodoo.setTranslateY(rand.nextInt(650));
    }

    public EventHandler autoMove(){
        return fin;
    }
    @Override
    public void setImg(String imgURL){
        Image img = new Image(imgURL);
        voodoo.setFill(new ImagePattern(img));
    }
    public void voodooPrison(){
       timelineVoodoo = new Timeline();
       timelineVoodoo.setCycleCount(5);
       timelineVoodoo.setAutoReverse(false);
       prisoning = new KeyFrame(Duration.seconds(1),e -> {
            score--;
       }); 
       timelineVoodoo.getKeyFrames().add(prisoning);
       timelineVoodoo.play();
    }
    public void voodooCoolDown(){
        Timeline cooldown = new Timeline(new KeyFrame(Duration.seconds(5),e -> {
            voodoo.setDisable(false);
            setImg("/clickme2/voodoo.png");
        }));
        cooldown.setCycleCount(1);
        cooldown.play();
        setImg("/clickme2/source.gif");
    }
    
    @Override
    public Rectangle getMole(){
        voodoo = new Rectangle(0,0,100,100);
        setImg("/clickme2/voodoo.png");
        voodoo.setStroke(Color.TRANSPARENT);
        voodoo.setCursor(Cursor.CLOSED_HAND);
        voodoo.setOnMouseClicked(e->{
            voodooPrison();
            voodoo.setDisable(true);
            voodooCoolDown();
        });
        return voodoo;
    }
 
    
    @Override
    public void setEffect(){
        voodoo.setOnMouseEntered(e -> {
            voodoo.setScaleX(1.1);
            voodoo.setScaleY(1.1);
        });
        voodoo.setOnMouseExited(e -> {
            voodoo.setScaleX(1);
            voodoo.setScaleY(1);
        });
        voodoo.setOnMousePressed(e -> {
            setImg("/clickme2/voodoo.png");
        });
        voodoo.setOnMouseReleased(e -> {
            setImg("/clickme2/voodoo.png");
        });
    }
}
