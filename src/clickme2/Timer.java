/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package clickme2;

import javafx.animation.Animation;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.geometry.Pos;
import javafx.scene.control.Label;
import javafx.scene.layout.HBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.util.Duration;

/**
 *
 * @author patom
 */
public class Timer {
    private Integer seconds;
    private Integer startSec;
    Timeline timelineTimer;
    Duration duration;
    KeyFrame timer;
    HBox boxTime;

    public void setTime(int seconds){
        this.startSec = seconds;
        this.seconds = seconds;
        duration = Duration.seconds(startSec);
    }
    public Duration getDuration(){
        return duration;
    }
    public void setSeconds(){
        this.seconds = startSec;
    }
    public HBox getDisplayTime(){
        boxTime = new HBox();
        boxTime.setStyle("-fx-background-color: aqua; -fx-border-color: black; -fx-border-width:3px; -fx-padding: 10px;-fx-background-radius:10; -fx-border-radius:10;");
        boxTime.setAlignment(Pos.TOP_CENTER);
        final Text textTime = new Text();
        textTime.setFont(Font.font("Verdana", 20));
        textTime.setStroke(Color.BLACK);
        Label lb = new Label("Time: ");
        lb.setFont(Font.font("Verdana", FontWeight.BOLD, 20));
        boxTime.getChildren().addAll(lb,textTime);
        
        //Timeline displayTime
        timelineTimer = new Timeline(new KeyFrame(Duration.seconds(1),e -> {
            seconds--;            
            textTime.setText(seconds.toString() + " s");
        }));
        timelineTimer.setCycleCount(Animation.INDEFINITE);
        return boxTime;
    }
 
    }

