/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package clickme2;

import javafx.animation.Timeline;
import javafx.geometry.Insets;
import javafx.scene.Cursor;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.paint.ImagePattern;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.stage.Stage;

/**
 *
 * @author patom
 */
public class HowToScene {
    static Scene splash;
    VBox vbox;
    Rectangle moleImg;
    Timeline mouse;
    
    //Method setImg
    public Image getImg(String imgURL){
    Image img = new Image(imgURL);
    return img;
    }
    
    
    //Blank Pane
    public Pane getBlank(){
        Pane blank = new Pane();
        Rectangle blankRec = new Rectangle(40,30);
        blankRec.setFill(Color.TRANSPARENT);
        blank.getChildren().addAll(blankRec);
        return blank;
    }
    
    public HowToScene(){
        //Main vbox
        vbox = new VBox();
        vbox.setPadding(new Insets(10));

        //each hbox/vbox in main vbox
        //vbox1 [how to play]
        VBox vbox1 = new VBox();
        Label howtoplayTitle = new Label("How to play?");
        howtoplayTitle.setFont(Font.font("Verdana", FontWeight.EXTRA_BOLD, 20));
        Label howtoplayLabel = new Label("JUST CLICK ^^");
        howtoplayLabel.setFont(Font.font("Verdana", FontWeight.EXTRA_LIGHT,18));
        
        
        //hbox [all character]
        //hbox mole
        HBox hbox1 = new HBox();
        Rectangle moleImg = new Rectangle(0,0,70,70);
        moleImg.setFill(new ImagePattern(getImg("/clickme2/mole.png")));
        Text detail = new Text("Friendly Mole" + "\n" + "Point: +1" + "\n" + "Attack: 0" + "\n"+ "Cooldown: 0 s" + "\n" + "A friendly mole, try to click this as much as you can.");
        moleImg.setCursor(Cursor.CLOSED_HAND);
        moleImg.setOnMousePressed(e ->{
            moleImg.setFill(new ImagePattern(getImg("/clickme2/bubble-chat2.png")));
        });
        moleImg.setOnMouseReleased(e ->{
            moleImg.setFill(new ImagePattern(getImg("/clickme2/mole.png")));
        });
        
        //hbox ghost
        HBox hbox2 = new HBox();
        Rectangle ghostImg = new Rectangle(0,0,70,70);
        ghostImg.setFill(new ImagePattern(getImg("/clickme2/ghost.png")));
        Text detail2 = new Text("Friendly Ghost" + "\n" + "Points: +2" + "\n" + "Attack: 0" +"\n"+ "Cooldown: 0 s" + "\n" + "A friendly ghost, click to get +2 points but it move so fast!");
        ghostImg.setCursor(Cursor.CLOSED_HAND);
        ghostImg.setOnMousePressed(e ->{
        ghostImg.setFill(new ImagePattern(getImg("/clickme2/bubble-chat.png")));
        });
        ghostImg.setOnMouseReleased(e ->{
        ghostImg.setFill(new ImagePattern(getImg("/clickme2/ghost.png")));
        });
        
        //hbox sea urchin
        HBox hbox3 = new HBox();
        Rectangle urchinImg = new Rectangle(0,0,70,70);
        urchinImg.setFill(new ImagePattern(getImg("/clickme2/sea-urchin.png")));
        Text detail3 = new Text("Sea Urchin" + "\n" + "Points: 0" + "\n" + "Attack: -3" +"\n"+ "Cooldown: 0 s"+ "\n" + "Avoid clicking on this, it can hurt you.");
        urchinImg.setCursor(Cursor.CLOSED_HAND);
        urchinImg.setOnMousePressed(e ->{
        urchinImg.setFill(new ImagePattern(getImg("/clickme2/explosion2.png")));
        });
        urchinImg.setOnMouseReleased(e ->{
        urchinImg.setFill(new ImagePattern(getImg("/clickme2/sea-urchin.png")));
        });
        
        //hbox Voodoo
        HBox hbox4 = new HBox();
        Rectangle voodooImg = new Rectangle(0,0,70,70);
        voodooImg.setFill(new ImagePattern(getImg("/clickme2/voodoo.png")));
        Text detail4 = new Text("Voodoo doll" + "\n" + "Points: 0" + "\n" + "Attack: -1 every 1 second" +"\n"+ "Cooldown: 5 s"+"\n" + "Don't even try to click this Voodoo doll," + " it will let you get prisoned 5 seconds." + "\n" + "Beware of Voodoo doll in HYPER mode, it has one that attack power: -4");
        voodooImg.setCursor(Cursor.CLOSED_HAND);
        voodooImg.setOnMouseEntered(e -> {
            voodooImg.setFill(new ImagePattern(getImg("/clickme2/source.gif")));  
        });
        voodooImg.setOnMouseExited(e -> {
            voodooImg.setFill(new ImagePattern(getImg("/clickme2/voodoo.png")));  
        });

        
        //Add charecter here
        hbox1.getChildren().addAll(moleImg,getBlank(),detail);
        hbox2.getChildren().addAll(ghostImg,getBlank(),detail2);
        hbox3.getChildren().addAll(urchinImg,getBlank(),detail3);
        hbox4.getChildren().addAll(voodooImg,getBlank(),detail4);
        
        //Add to vbox1
        vbox1.getChildren().addAll(howtoplayTitle,howtoplayLabel);
        
        //Add to vbox
        vbox.getChildren().addAll(vbox1,getBlank(),hbox1,getBlank(),hbox2,getBlank(),hbox3,getBlank(),hbox4);
        
    }
    public void showHowTo(){
        Stage hStage = new Stage();
        splash = new Scene(vbox, 700, 650);
        hStage.setResizable(false);
        hStage.setTitle("Help Center");
        hStage.setScene(splash);
        hStage.show();
    }
}

        

//        primaryStage.setMinWidth(1450);
//        primaryStage.setMinHeight(850);        
//        primaryStage.show();

    
