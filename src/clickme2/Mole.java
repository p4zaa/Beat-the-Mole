/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package clickme2;

import java.util.Random;
import javafx.animation.Animation;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.Cursor;
import javafx.scene.layout.HBox;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.util.Duration;

/**
 *
 * @author patom
 */
public class Mole {
    private int point;
    public static Integer score = 0;
    Timeline timeline;
    Timeline levelTimeline;
    KeyFrame randomAppear;
    Rectangle mole;
    Random rand;
    Duration duration;
    Text lbScore;
    HBox scoreBox;
    
    public Mole(){
        
    }
    
    public Mole(int point){
        this.point = point;
//        duration = Duration.seconds(1);
    }
    public int getPoint(){
        return point;
    }
    public void sumScore(){
        this.score = this.score + getPoint();
    }
    public int getSumScore(){
        Mole1 mole = new Mole1(1);
        Ghost ghost = new Ghost(2);
        return mole.getScore()+ghost.getScore();
    }
    public void move(){
        
    }
    void setEffect(){
        
    }
    public void resetPoint(){
        score = 0;
    }
    EventHandler fin = (EventHandler<ActionEvent>) (ActionEvent e)->{
        move();
    };
//    public void setDuration(Double sec){
//        this.duration = Duration.seconds(sec);
//    }
    
    //Default MODE----------
    public void randomAppear(){
        timeline = new Timeline();
        randomAppear = new KeyFrame(Duration.seconds(1.2),fin);
        timeline.setCycleCount(Timeline.INDEFINITE);        
        timeline.getKeyFrames().add(randomAppear);
    }
    //Selected MODE---------
    public void randomAppear(double speed){
        timeline = new Timeline(new KeyFrame(Duration.seconds(speed),fin));
        timeline.setCycleCount(Timeline.INDEFINITE);
    }
    

    public int getScore(){
        return this.score;
    }
    public Rectangle getMole(){
        mole = new Rectangle(0,0,100,100);
//        setImg("/clickme2/whack-a-mole.png");
        mole.setStroke(Color.TRANSPARENT);
        mole.setCursor(Cursor.CLOSED_HAND);
        mole.setOnMouseClicked(e->{
//            sumScore();
            move();
        });
        return mole;
    }
    public HBox displayScore(){
        scoreBox = new HBox();
        scoreBox.setStyle("-fx-background-color: aqua; -fx-border-color: black; -fx-border-width:3px; -fx-padding: 10px; -fx-padding: 10px; -fx-background-radius:10; -fx-border-radius:10;");
        scoreBox.setAlignment(Pos.TOP_CENTER);
        lbScore = new Text();
        lbScore.setFont(Font.font("Vernada", 20));
        lbScore.setStroke(Color.BLACK);
        Timeline refresh = new Timeline(new KeyFrame(new Duration(0.1),e -> {
            lbScore.setText("Score: " + getScore());            
        }));
        scoreBox.getChildren().addAll(lbScore);
        refresh.setCycleCount(Animation.INDEFINITE);
        refresh.play();
        return scoreBox;
    }


}
