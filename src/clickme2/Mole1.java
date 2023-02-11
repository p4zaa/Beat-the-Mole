/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package clickme2;


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
public class Mole1 extends Mole implements ThisIsMole{
    Timeline timeline;
    Duration duration;
    KeyFrame autoMove;
    Rectangle mole;
    Random rand = new Random();
    Text lbScore;

    public Mole1(int point){
        super(point);
    }
    public void setDuration(double i){
        duration = Duration.seconds(i);
    }
    @Override
    public void sumScore(){
        score = score + super.getPoint();
    }
    @Override
    public int getScore(){
        return score;
    }

    @Override
    public void move(){
        mole.setTranslateX(rand.nextInt(960));
        mole.setTranslateY(rand.nextInt(650));
    }
//    EventHandler fin = (EventHandler<ActionEvent>) (ActionEvent e)->{
//        move();
//    };
    public EventHandler autoMove(){
        return fin;
    }
    @Override
    public void setImg(String imgURL){
        Image img = new Image(imgURL);
        mole.setFill(new ImagePattern(img));
    }
    @Override
    public Rectangle getMole(){
        mole = new Rectangle(0,0,100,100);
        setImg("/clickme2/mole.png");
        mole.setStroke(Color.TRANSPARENT);
        mole.setCursor(Cursor.CLOSED_HAND);
        mole.setOnMouseClicked(e->{
            super.sumScore();
            move();
        });
        return mole;
    }

    @Override
    public void setEffect(){
        mole.setOnMouseEntered(e -> {
            mole.setScaleX(1.1);
            mole.setScaleY(1.1);
        });
        mole.setOnMouseExited(e -> {
            mole.setScaleX(1);
            mole.setScaleY(1);
        });
        mole.setOnMousePressed(e -> {
            setImg("/clickme2/bubble-chat2.png");
        });
        mole.setOnMouseReleased(e -> {
            setImg("/clickme2/mole.png");
        });
    }

}
