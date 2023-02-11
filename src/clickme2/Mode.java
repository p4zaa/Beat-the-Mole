/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package clickme2;

import javafx.collections.ObservableList;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.ComboBox;
import javafx.scene.layout.HBox;

/**
 *
 * @author patom
 */
public class Mode {
    ClickMe2 click = new ClickMe2();
    public static ComboBox<String> box = new ComboBox<>();
    private ObservableList<String> modeName;
    HBox hbox;
//    private ObservableList<String> modeName;
    public Mode(String modeName){
        box.getItems().add(modeName);
        box.getSelectionModel().select(1);
        box.setPadding(new Insets(4));
        box.setPrefWidth(200);
    }

//    public Mode() {
//        this("Normal",1.2);
//    }
    public HBox getBox(){
        hbox = new HBox();
        hbox.setAlignment(Pos.CENTER);
        hbox.getChildren().add(box);
        return hbox;
    }
//    public void modeSelect(){
//        box.setOnAction(e->{
//            playMode(box.getValue());
//        });
//    }
//    public void playMode(String mode){
//        switch(mode){
//            case "Baby" :   Mole1 mole1 = new Mole1(1);
//                            mole1.randomAppear(0.3);
//                            click.grid.add(mole1.getMole(), 0,0,1,1);
//                            mole1.timeline.play();
//                            mole1.move();
//    }
//}
}