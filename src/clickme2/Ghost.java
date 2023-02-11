/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package clickme2;

import java.util.Random;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
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
public class Ghost extends Mole implements ThisIsMole {
 
    Duration duration;
    KeyFrame autoMove;
    Rectangle ghost;
    Random rand = new Random();
    Text lbScore;

    public Ghost(int point){
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
        ghost.setTranslateX(rand.nextInt(950));
        ghost.setTranslateY(rand.nextInt(650));
    }
//    EventHandler fin = (EventHandler<ActionEvent>) (ActionEvent e)->{
//        move();
//    };
//    public EventHandler autoMove(){
//        return fin;
//    }
    @Override
    public void setImg(String imgURL){
        Image img = new Image(imgURL);
        ghost.setFill(new ImagePattern(img));
    }
    @Override
    public Rectangle getMole(){
        ghost = new Rectangle(0,0,100,100);
        setImg("/clickme2/ghost.png");
        ghost.setStroke(Color.TRANSPARENT);
        ghost.setCursor(Cursor.CLOSED_HAND);
        ghost.setOnMouseClicked(e->{
            super.sumScore();
            move();
        });
        return ghost;
    }
     @Override
    public void setEffect(){
        ghost.setOnMouseEntered(e -> {
            ghost.setScaleX(1.1);
            ghost.setScaleY(1.1);
        });
        ghost.setOnMouseExited(e -> {
            ghost.setScaleX(1);
            ghost.setScaleY(1);
        });
        ghost.setOnMousePressed(e -> {
            setImg("/clickme2/bubble-chat.png");
        });
        ghost.setOnMouseReleased(e -> {
            setImg("/clickme2/ghost.png");
        });
    }
    @Override
    public void randomAppear(double speed){
        timeline = new Timeline();
        timeline.setCycleCount(Timeline.INDEFINITE); 
        randomAppear = new KeyFrame(Duration.seconds(speed),fin);
        timeline.getKeyFrames().add(randomAppear);
    }


}
