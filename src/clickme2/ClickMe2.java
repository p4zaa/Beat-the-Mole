/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package clickme2;

import java.util.Random;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.BackgroundImage;
import javafx.scene.layout.BackgroundPosition;
import javafx.scene.layout.BackgroundRepeat;
import javafx.scene.layout.BackgroundSize;
import javafx.scene.layout.CornerRadii;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.paint.ImagePattern;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;

/**
 *
 * @author patom
 */
public class ClickMe2 extends Application {
    /**
     * @param args the command line arguments
     */
    Button playButton,restartButton,helpButton;
    KeyFrame timer;
    Timeline timelineTimer;
    GridPane grid = new GridPane();
    Timer timerClass = new Timer();
    Mode baby,normal,hard,hyper;
    HBox hbox;
    HowToScene help = new HowToScene();
    
    //add charecter
    Mole1 mole1 = new Mole1(1);
    Mole1 mole2 = new Mole1(1);
    Mole1 mole3,mole4,mole5,mole6;
    Ghost ghost = new Ghost(2);
    Ghost ghost2;
    SeaUrchin urchin = new SeaUrchin(-3);
    SeaUrchin urchin2;
    Voodoo voodoo,voodoo2,voodoo3;
   
    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws Exception{
        primaryStage.setTitle("Go Go MOLE!!");
        playButton = new Button("Play");
        playButton.setPrefSize(200,0);
        playButton.setPadding(new Insets(10));
        restartButton = new Button("Restart");
        restartButton.setDisable(true);
        restartButton.setPrefSize(200, 0);
        restartButton.setPadding(new Insets(10));
        
        //how to button
        helpButton = new Button("Help Center");
        helpButton.setPrefSize(200, 0);
        helpButton.setPadding(new Insets(10));
        
        //Action on help button
        helpButton.setOnAction(e -> {  
            help = new HowToScene();
            help.showHowTo();
        });
        
        //HBox หลัก
        hbox = new HBox();
        hbox.setBackground(new Background(new BackgroundFill(Color.rgb(204, 229, 255),CornerRadii.EMPTY,Insets.EMPTY)));
        hbox.setAlignment(Pos.CENTER_RIGHT);
        hbox.setPadding(new Insets(8));

        //VBox
        VBox vbox = new VBox();
        vbox.setAlignment(Pos.TOP_CENTER);
        vbox.setPadding(new Insets(20));
        vbox.setSpacing(15);
        vbox.setStyle("-fx-background-color: rgba(0,255,255,0.7); -fx-border-color: black; -fx-border-width:3px; -fx-padding: 10px; -fx-background-radius:40; -fx-border-radius:40;");
        
        //top image-------------------
        StackPane topImg = new StackPane();
        topImg.setPrefSize(128, 128);
        topImg.setPadding(new Insets(20));
        topImg.setAlignment(Pos.TOP_CENTER);
        Image top = new Image("/clickme2/swords2.png");
        Rectangle recTopImg = new Rectangle(0,0,128,128);
        recTopImg.setFill(new ImagePattern(top));
        topImg.getChildren().addAll(recTopImg);    
        
        //bottom image------------------------
        StackPane stack = new StackPane();
        stack.setAlignment(Pos.BOTTOM_CENTER);
        stack.prefHeightProperty().bind(vbox.heightProperty());
        Image img = new Image("/clickme2/img-gif.gif");
        Rectangle recImg = new Rectangle(0,0,270,145);
        recImg.setFill(new ImagePattern(img));
        stack.getChildren().addAll(recImg);
        
        //set map background
        Image mapBG = new Image("/clickme2/mapresize.png");
        BackgroundImage bgImg = new BackgroundImage(mapBG,
                                BackgroundRepeat.NO_REPEAT,
                                BackgroundRepeat.NO_REPEAT,
                                BackgroundPosition.DEFAULT,
                                BackgroundSize.DEFAULT);
        Background bg = new Background(bgImg);
        hbox.setBackground(bg);
           
        //Add MODE
        baby = new Mode("Baby");
        normal = new Mode("Normal");
        hard = new Mode("Hard");
        hyper = new Mode("Hyper");
        
        //เพิ่มลง vbox
        vbox.getChildren().addAll(topImg,new Mole(1).displayScore(),timerClass.getDisplayTime(),playButton,restartButton,Mode.box,helpButton,stack);  

        //GridPane
        grid.setGridLinesVisible(false);
        grid.setPadding(new Insets(20));
        grid.setAlignment(Pos.TOP_LEFT);
        grid.setPrefSize(1400, 800);
        grid.setHgap(10);
        grid.setVgap(10);
        
        //set ready
        mole3 = new Mole1(1);
        mole4 = new Mole1(1);
        mole5 = new Mole1(1);
        mole6 = new Mole1(1);
        urchin2 = new SeaUrchin(-3);
        voodoo = new Voodoo(-1);
        voodoo2 = new Voodoo(-1);
        voodoo3 = new Voodoo(-4);
        ghost2 = new Ghost(2);
        
        //เพิ่มลง GridPane
        justAdd(mole1);
        justAdd(mole2);
        justAdd(mole3);
        justAdd(mole4);
        justAdd(mole5);
        justAdd(mole6);
        justAdd(urchin);
        justAdd(ghost);
        justAdd(voodoo);
        justAdd(voodoo2);
        justAdd(ghost2);
        justAdd(urchin2);
        justAdd(voodoo3);
        grid.setVisible(false);
        grid.setDisable(true);
        
        //เพิ่ม box ลง HBox
        hbox.getChildren().addAll(grid,vbox);
        
        //set bind
        grid.prefHeightProperty().bind(hbox.heightProperty());
        grid.prefWidthProperty().bind(hbox.widthProperty());
        vbox.prefHeightProperty().bind(hbox.heightProperty());
        vbox.prefWidthProperty().bind(hbox.widthProperty().divide(2.5));
        

        //play --------------------------------------------
        playButton.setOnAction((ActionEvent e) -> {
            playMode(Mode.box.getValue());
            grid.setVisible(true);
            grid.setDisable(false);
            playButton.setDisable(true);
            restartButton.setDisable(false);
            Mode.box.setDisable(true);

            //Display Timer
            timerClass.setTime(60);
            timerClass.timelineTimer.play();            
            
            //Timer
             Timer t = new Timer();
             t.setTime(60);
             timelineTimer = new Timeline();
             timelineTimer.setCycleCount(0);
             timelineTimer.setAutoReverse(false);
             timer = new KeyFrame(t.getDuration(),restartButton.getOnAction());
             timelineTimer.getKeyFrames().add(timer);
             timelineTimer.play();

        });
        
        //restart --------------------------------------
        EventHandler<ActionEvent> restartClick = e ->{
            grid.setDisable(true);
            grid.setVisible(false);
            playButton.setDisable(false);
            restartButton.setDisable(true);
            timelineTimer.stop();
            timerClass.timelineTimer.stop();
            Mode.box.setDisable(false);
            
            justStop(mole1);
            justStop(mole2);
            justStop(mole3);
            justStop(urchin);
            justStop(urchin2);
            justStop(ghost);
            justStop(mole4);
            justStop(mole5);
            justStop(mole6);
            justStop(voodoo);
            justStop(ghost2);
            justStop(voodoo2);
            justStop(voodoo3);
        }; 
        restartButton.setOnAction(restartClick);
        
    
        
        Scene scene = new Scene(hbox, 1400, 800);
        primaryStage.setMinWidth(1450);
        primaryStage.setMinHeight(850);        
        primaryStage.setScene(scene);
        primaryStage.show();
    }
        
        
        //METHOD PLAY ALL MOLE1
        public void playAllMole1(double m1,double m2,double m3,double m4,double m5,double m6){
            justPlay(mole1,m1);
            justPlay(mole2,m2);
            justPlay(mole3,m3);
            justPlay(mole4,m4);
            justPlay(mole5,m5);
            justPlay(mole6,m6);
        }
        
        //METHOD HIDE ALL MOLE
        public void hideAllMole1(){
            mole1.mole.setVisible(false);
            mole2.mole.setVisible(false);
            mole3.mole.setVisible(false);
            mole4.mole.setVisible(false);
            mole5.mole.setVisible(false);
            mole6.mole.setVisible(false);
        }
    
        //METHOD JUST - - - - - - - - - - - 
        public void justPlay(Mole mole,double speed){
            mole.randomAppear(speed);
            mole.move();
            mole.timeline.play();
            mole.resetPoint();
            mole.setEffect();
        }
        public void justStop(Mole mole){
            try{
            mole.timeline.stop();
            } catch(Exception e){
                
            }
        }
        public void justAdd(Mole mole){
            grid.add(mole.getMole(), 0,0,1,1);
        }
        
        //- - - - - - - - - - - - - - - - -
        //MODE SETTING - - - - - - - - - - 
        public void playMode(String mode){
        switch(mode){
            case "Baby" : 
                justPlay(mole1,2.1);
                justPlay(mole2,2.3);
                justPlay(mole3,2.4);
                justPlay(mole4,2.5);
                justPlay(mole5,2.2);
                justPlay(mole6,2.1);
                voodoo.voodoo.setVisible(false);
                voodoo2.voodoo.setVisible(false);
                voodoo3.voodoo.setVisible(false);
                mole6.mole.setVisible(true);
                ghost.ghost.setVisible(false);
                ghost2.ghost.setVisible(false);
                urchin.urchin.setVisible(false);
                urchin2.urchin.setVisible(false);    
                break;
        
            case "Normal" : 
                justPlay(mole1,1.5);
                justPlay(mole2,1.3);
                justPlay(mole3,1.6);
                justPlay(mole4,1.4);
                justPlay(mole5,1.5);
                justPlay(mole6,1.3);
                mole6.mole.setVisible(true);
                justPlay(urchin,new Random().nextInt(5));
                urchin.urchin.setVisible(true);
                urchin2.urchin.setVisible(false);
                ghost.ghost.setVisible(true);
                ghost2.ghost.setVisible(false);
                voodoo2.voodoo.setVisible(false);
                voodoo3.voodoo.setVisible(false);
                justPlay(ghost,0.8);
                justPlay(voodoo,5);
                break;
                
            case "Hard" :
                justPlay(mole1,1.1);
                justPlay(mole2,0.8);
                justPlay(mole3,0.9);
                mole4.mole.setVisible(false);
                mole5.mole.setVisible(false);
                mole6.mole.setVisible(false);
                urchin.urchin.setVisible(false);
                urchin.urchin.setVisible(false);
                voodoo2.voodoo.setVisible(true);
                voodoo3.voodoo.setVisible(false);
                justPlay(ghost,0.5);
                justPlay(ghost2,0.6);
                justPlay(voodoo,3);
                justPlay(voodoo2,5);
                break;
                
            case "Hyper" :
                playAllMole1(1.0,0.7,0.6,1.0,0.9,0.8);
                ghost2.ghost.setVisible(false);
                ghost.ghost.setVisible(true);
                mole4.mole.setVisible(true);
                mole5.mole.setVisible(true);
                mole6.mole.setVisible(true);
                urchin.urchin.setVisible(true);
                urchin2.urchin.setVisible(true);
                voodoo.voodoo.setVisible(true);
                voodoo2.voodoo.setVisible(true);
                voodoo3.voodoo.setVisible(true);
                justPlay(ghost,0.3);
                justPlay(urchin,0.2);
                justPlay(urchin2,0.1);
                justPlay(voodoo,0.2);
                justPlay(voodoo2,0.3);
                justPlay(voodoo3,0.1);
                break;
}
        //- - - - - - - - - - - - - - - - - - - - -
}
}

