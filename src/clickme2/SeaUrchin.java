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
public class SeaUrchin extends Mole implements ThisIsMole{

    Duration duration;
    KeyFrame autoMove;
    Rectangle urchin;
    Random rand = new Random();
    Text lbScore;

    public SeaUrchin(int point){
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
        urchin.setTranslateX(rand.nextInt(950));
        urchin.setTranslateY(rand.nextInt(650));
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
        urchin.setFill(new ImagePattern(img));
    }
    @Override
    public Rectangle getMole(){
        urchin = new Rectangle(0,0,100,100);
        setImg("/clickme2/sea-urchin.png");
        urchin.setStroke(Color.TRANSPARENT);
        urchin.setCursor(Cursor.CLOSED_HAND);
        urchin.setOnMouseClicked(e->{
            super.sumScore();
            move();
        });
        return urchin;
    }
     @Override
    public void setEffect(){
        urchin.setOnMouseEntered(e -> {
            urchin.setScaleX(1.1);
            urchin.setScaleY(1.1);
        });
        urchin.setOnMouseExited(e -> {
            urchin.setScaleX(1);
            urchin.setScaleY(1);
        });
        urchin.setOnMousePressed(e -> {
            setImg("/clickme2/explosion2.png");
        });
        urchin.setOnMouseReleased(e -> {
            setImg("/clickme2/sea-urchin.png");
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
