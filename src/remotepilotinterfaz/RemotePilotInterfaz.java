/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMain.java to edit this template
 */
package remotepilotinterfaz;

import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.CornerRadii;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.layout.Region;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.stage.Stage;

/**
 *
 * @author Ricar
 */
public class RemotePilotInterfaz extends Application {
    
    @Override
    public void start(Stage primaryStage) {
        // Create the application scene
        primaryStage.setTitle("Remote Navigation Display");
        final Scene scene = new Scene(createContent());
        primaryStage.setScene(scene);
        primaryStage.show();
    }
 
//Label format functions
private String Format(String type, Label label) {
    switch (type) {
        case "A":
            label.setTextFill(Color.web("#00FF00"));
            label.setFont(new Font("Arial", 35)); 
            break;
        case "B":
            label.setTextFill(Color.web("#00FF00"));
            label.setFont(new Font("Arial", 30));
            break;
        case "C":
            label.setTextFill(Color.web("#FF00FF"));
            label.setFont(new Font("Arial", 30));
            break;
        case "D":
            label.setTextFill(Color.web("#FFFFFF"));
            label.setFont(new Font("Arial", 30));
            break;
        case "E":
            label.setTextFill(Color.web("#FFFFFF"));
            label.setFont(new Font("Arial", 35));
            break;
        case "F":
            label.setTextFill(Color.web("#FFFFFF"));
            label.setFont(new Font("Arial", 20));
            break;    
        case "G":
            label.setTextFill(Color.web("#00FFFF"));
            label.setFont(new Font("Arial", 15));
            break;
        case "H":
            label.setTextFill(Color.web("#00FF00"));
            label.setFont(new Font("Arial", 20));
            break;
        case "I":
            label.setTextFill(Color.web("#FFFFFF"));
            label.setFont(new Font("Arial", 15));
            break;
        case "J":
            label.setTextFill(Color.web("#00FFFF"));
            label.setFont(new Font("Arial", 18));
            break;    
        default:
            break;
    }
        return null;
}    
 
 private String sumValue(Label label, Label lastLabel, Integer i, Integer j) {
        label.setLayoutY(205);
        i = Integer.parseInt(lastLabel.getText());
        i = i + j;
        label.setText(""+i);
        return null;
}

 private String subtractValue(Label label, Label lastLabel, Integer i, Integer j) {
        label.setLayoutY(565);
        i = Integer.parseInt(lastLabel.getText());
        i = i - j;
        label.setText(""+i);
        return null;
        
}

private String concatenate(Integer l) {
        return "i = Integer.parseInt(values"+l+".getText());";
} 
 
 private Pane createContent(){    
        //Loading resources--------------------------------------------------------------------------------------------------------------------------------------
        Image bgCompass = new Image("file:resources/compass.png");
        Image bgAirplane = new Image("file:resources/airplane.png");
        Image bgWindArrow = new Image("file:resources/windArrow.png");
        
        //Region definition--------------------------------------------------------------------------------------------------------------------------------------
        Region airSpeed = new Region();
        airSpeed.setStyle("-fx-background-color: empty; -fx-border-style: solid; -fx-border-width: 1; -fx-border-color: white; -fx-min-width: 130; -fx-min-height:400; -fx-max-width:130; -fx-max-height: 400;");
        Region altimeter = new Region();
        altimeter.setStyle("-fx-background-color: empty; -fx-border-style: solid; -fx-border-width: 1; -fx-border-color: white; -fx-min-width: 130; -fx-min-height:400; -fx-max-width:130; -fx-max-height: 400;");
        Region showData = new Region();
        showData.setStyle("-fx-background-color: empty; -fx-border-style: solid; -fx-border-width: 1; -fx-border-color: white; -fx-min-width: 490; -fx-min-height:140; -fx-max-width:490; -fx-max-height: 140;");
        Region fms = new Region();
        fms.setStyle("-fx-background-color: empty; -fx-border-style: solid; -fx-border-width: 1; -fx-border-color: white; -fx-min-width: 460; -fx-min-height:140; -fx-max-width:460; -fx-max-height: 140;");
        
        //SpeedBox--------------------------------------------------------------------------------------------------------------------------------------
        Label gsAtas = new Label("GS 257 TAS 286");
        Format("A",gsAtas);
        Label windSpeed = new Label("120/25");
        Format("B",windSpeed);
        ImageView ivWindDir = new ImageView();
        ivWindDir.setImage(bgWindArrow);
        ivWindDir.setFitHeight(50);
        ivWindDir.setFitWidth(50);
        ivWindDir.setRotate(ivWindDir.getRotate() + 300);
        Label targetSpeed = new Label("139");
        Format("C",targetSpeed);

        VBox speedVbox = new VBox(gsAtas, windSpeed, ivWindDir, targetSpeed);
        speedVbox.setSpacing(10);
        
        //BeaconBox--------------------------------------------------------------------------------------------------------------------------------------
        Label beaconInfo = new Label("TIRET 340°");
        Format("A",beaconInfo);
        Label beaconDis = new Label("46 NM");
        Format("B",beaconDis);
        Label beaconTime = new Label("11:07:54");
        Format("B",beaconTime);
        Label beaconExtra = new Label("");
        Format("F",beaconExtra);
        Label targetAltitude = new Label("2500");
        Format("C",targetAltitude);
        
        VBox AltitudeVbox = new VBox(beaconInfo, beaconDis, beaconTime, targetAltitude);
        AltitudeVbox.setAlignment(Pos.CENTER_RIGHT);
        AltitudeVbox.setSpacing(15);
        
        //InfoBox--------------------------------------------------------------------------------------------------------------------------------------
        Label idFlight = new Label("AAF312Q");
        Format("E",idFlight);
        Label flight = new Label("4996");
        Format("D",flight);
        Label aircraft = new Label("A319");
        Format("F",aircraft);
        VBox infoFlight = new VBox(idFlight, flight, aircraft);
        
        Label labSquawk = new Label("SQUAWK");
        Format("G",labSquawk);
        Label squawk = new Label("5146");
        Format("F",squawk);
        Label labLastFix = new Label("LAST FIX");
        Format("G",labLastFix);
        Label lastFix = new Label("NAV1 2336/866");
        Format("F",lastFix);
        Label labRealtFix = new Label("REAL FIX");
        Format("G",labRealtFix);
        Label realFix = new Label("NAV1 2369/929");
        Format("F",realFix);
        VBox infoPosition = new VBox(labSquawk, squawk, labLastFix, lastFix, labRealtFix, realFix);
        
        Label route = new Label("AMB   ➔   STR");
        Format("F",route);
        Label timeRoute = new Label("11:02:18   11:49:14");
        Format("H",timeRoute);
        Label realTime = new Label("11:20:02");
        Format("A",realTime);
        VBox infoRoute = new VBox(route, timeRoute, realTime);
        infoRoute.setAlignment(Pos.CENTER);
        
        HBox infoHBox = new HBox(infoFlight, infoPosition, infoRoute);
        infoHBox.setBackground(new Background(new BackgroundFill(Color.BLACK, CornerRadii.EMPTY, Insets.EMPTY)));
        infoHBox.setSpacing(5);
        
        //StripBox--------------------------------------------------------------------------------------------------------------------------------------     
        Label labMid00 = new Label("MID00");
        Format("G",labMid00);
        Label dataMid00 = new Label("AMB 255");
        Format("I",dataMid00);
        Label timeMid00 = new Label("11:03:54");
        Format("H",timeMid00);
        Label labMid05 = new Label("MID05");
        Format("G",labMid05);
        Label dataMid05 = new Label("POGOL 240");
        Format("I",dataMid05);
        Label timeMid05 = new Label("11:32:34");
        Format("H",timeMid05);
        VBox infoBeacons01 = new VBox(labMid00, dataMid00, timeMid00, labMid05, dataMid05, timeMid05);
        infoBeacons01.setAlignment(Pos.CENTER);
        infoBeacons01.setSpacing(2);
        
        Label labMid01 = new Label("MID01");
        Format("G",labMid01);
        Label dataMid01 = new Label("TIRET 240");
        Format("I",dataMid01);
        Label timeMid01 = new Label("11:07:54");
        Format("H",timeMid01);
        Label labMid06 = new Label("MID06");
        Format("G",labMid06);
        Label dataMid06 = new Label("SOREM 240");
        Format("I",dataMid06);
        Label timeMid06 = new Label("11:34:10");
        Format("H",timeMid06);
        VBox infoBeacons02 = new VBox(labMid01, dataMid01, timeMid01, labMid06, dataMid06, timeMid06);
        infoBeacons02.setAlignment(Pos.CENTER);
        infoBeacons02.setSpacing(2);
        
        Label labMid02 = new Label("MID02");
        Format("G",labMid02);
        Label dataMid02 = new Label("POLLY 240");
        Format("I",dataMid02);
        Label timeMid02 = new Label("11:13:06");
        Format("H",timeMid02);
        Label labMid07 = new Label("MID07");
        Format("G",labMid07);
        Label dataMid07 = new Label("STR 240");
        Format("I",dataMid07);
        Label timeMid07 = new Label("11:36:50");
        Format("H",timeMid07);
        VBox infoBeacons03 = new VBox(labMid02, dataMid02, timeMid02, labMid07, dataMid07, timeMid07);
        infoBeacons03.setAlignment(Pos.CENTER);
        infoBeacons03.setSpacing(2);
        
        Label labMid03 = new Label("MID03");
        Format("G",labMid03);
        Label dataMid03 = new Label("LUREN 240");
        Format("I",dataMid03);
        Label timeMid03 = new Label("11:18:42");
        Format("H",timeMid03);
        Label labMid08 = new Label("MID08");
        Format("G",labMid08);
        Label dataMid08 = new Label("");
        Format("I",dataMid08);
        Label timeMid08 = new Label("");
        Format("H",timeMid08);
        VBox infoBeacons04 = new VBox(labMid03, dataMid03, timeMid03, labMid08, dataMid08, timeMid08);
        infoBeacons04.setAlignment(Pos.CENTER);
        infoBeacons04.setSpacing(2);
        
        Label labMid04 = new Label("MID04");
        Format("G",labMid04);
        Label dataMid04 = new Label("EPL 240");
        Format("I",dataMid04);
        Label timeMid04 = new Label("11:29:22");
        Format("H",timeMid04);
        Label dataMid09 = new Label("");
        Format("I",dataMid09);
        Label timeMid09 = new Label("");
        Format("H",timeMid09);
        Label labExit = new Label("EXIT");
        Format("G",labExit);
        VBox infoBeacons05 = new VBox(labMid04, dataMid04, timeMid04, dataMid09, labExit, timeMid09);
        infoBeacons05.setAlignment(Pos.CENTER);
        infoBeacons05.setSpacing(2);
        
        HBox infoHBeacons = new HBox(infoBeacons01, infoBeacons02, infoBeacons03, infoBeacons04, infoBeacons05);
        infoHBeacons.setBackground(new Background(new BackgroundFill(Color.BLACK, CornerRadii.EMPTY, Insets.EMPTY)));
        infoHBeacons.setSpacing(19);
        
        route.setOnMouseClicked((MouseEvent mouseEvent) -> {
           infoHBox.setVisible(false);
           infoHBeacons.setVisible(true);
        });
        
        labExit.setOnMouseClicked((MouseEvent mouseEvent) -> {
           infoHBox.setVisible(true);
           infoHBeacons.setVisible(false);
        });
        
        //FMSModel--------------------------------------------------------------------------------------------------------------------------------------
        Button buttonL0 = new Button("—");
        Button buttonL1 = new Button("—");
        Button buttonL2 = new Button("—");
        VBox buttonsLeft = new VBox(buttonL0, buttonL1, buttonL2);
        buttonsLeft.setSpacing(17);
        
        Label labOptL1 = new Label("DIR TO");
        Format("I",labOptL1);
        TextField valueOptL1 = new TextField("[                   ]");
        valueOptL1.setStyle("-fx-background-color: #000000; -fx-text-fill: #00FFFF; -fx-font-size: 18;");
        valueOptL1.setMaxWidth(177);
        Label labOptL2 = new Label("");
        Format("I",labOptL2);
        TextField valueOptL2 = new TextField("");
        valueOptL2.setStyle("-fx-background-color: #000000; -fx-text-fill: #00FFFF; -fx-font-size: 18;");
        valueOptL2.setMaxWidth(177);
        Label labOptL3 = new Label("A/C NOTIFICATION");
        Format("I",labOptL3);
        VBox menuLeft = new VBox(labOptL1, valueOptL1, labOptL2, valueOptL2, labOptL3);
        
        Label labOptR1 = new Label("FL/ALT");
        Format("I",labOptR1);
        TextField valueOptR1 = new TextField("[                   ]");
        valueOptR1.setStyle("-fx-background-color: #000000; -fx-text-fill: #00FFFF; -fx-font-size: 18;");
        valueOptR1.setMaxWidth(177);
        valueOptR1.setAlignment(Pos.CENTER_RIGHT);
        Label labOptR2 = new Label("SPD/MACH");
        Format("I",labOptR2);
        TextField valueOptR2 = new TextField("[                  ]");
        valueOptR2.setStyle("-fx-background-color: #000000; -fx-text-fill: #00FFFF; -fx-font-size: 18;");
        valueOptR2.setMaxWidth(177);
        valueOptR2.setAlignment(Pos.CENTER_RIGHT);
        Label labOptR3 = new Label("FREE TEXT");
        Format("I",labOptR3);
        VBox menuRight = new VBox(labOptR1, valueOptR1, labOptR2, valueOptR2, labOptR3);
        menuRight.setAlignment(Pos.CENTER_RIGHT);
          
        Button buttonR0 = new Button("—");
        Button buttonR1 = new Button("—");
        Button buttonR2 = new Button("—");
        VBox buttonsRight = new VBox(buttonR0, buttonR1, buttonR2);
        buttonsRight.setSpacing(17);
                
        HBox menuFMS = new HBox(buttonsLeft, menuLeft, menuRight, buttonsRight);
        menuFMS.setSpacing(5);
            
        Label labOptTextFree = new Label("QUICK REQUEST                                              SEND");
        Format("I",labOptTextFree);
        TextArea textFree = new TextArea();
        textFree.setText("REPORT BACK ON ROUTE");
        textFree.setStyle("-fx-highlight-fill: #00FFFF; -fx-highlight-text-fill: #000000; -fx-font-size: 15px;");
        textFree.setPrefWidth(360);
        textFree.setPrefHeight(110); 
        VBox freeText = new VBox(labOptTextFree, textFree);
        freeText.setBackground(new Background(new BackgroundFill(Color.BLACK, CornerRadii.EMPTY, Insets.EMPTY)));
        freeText.setVisible(false);
        
        Label labOptNotification = new Label("QUICK REQUEST                                            CLEAN");
        Format("I",labOptNotification);
        Label labNot00 = new Label("REQUEST FL139 COMPLETED");
        Format("J",labNot00);
        Label labNot01 = new Label("REQUEST SPD3100 COMPLETED");
        Format("J",labNot01);
        Label labNot02 = new Label("REQUEST DIR TO LUREN COMPLETED");
        Format("J",labNot02);
        VBox notification = new VBox(labOptNotification, labNot00, labNot01, labNot02);
        notification.setBackground(new Background(new BackgroundFill(Color.BLACK, CornerRadii.EMPTY, Insets.EMPTY)));
        notification.setSpacing(10);
        notification.setVisible(false);
        
        buttonL0.setOnAction((ActionEvent e) -> {
            freeText.setVisible(false);
            notification.setVisible(false);
            menuLeft.setVisible(true);
            menuRight.setVisible(true);
            valueOptL1.setText("[                   ]");
        });
        
        buttonL2.setOnAction((ActionEvent e) -> {
            freeText.setVisible(false);
            notification.setVisible(true);
            menuLeft.setVisible(false);
            menuRight.setVisible(false);
        });
        
        buttonR0.setOnAction((ActionEvent e) -> {
            labNot00.setText("");
            labNot01.setText("");
            labNot02.setText("");
            valueOptR1.setText("[                   ]");
        });
        
        buttonR1.setOnAction((ActionEvent e) -> {
            targetSpeed.setText(valueOptR2.getText());
            valueOptR2.setText("[                   ]");
        });
        
        buttonR2.setOnAction((ActionEvent e) -> {
            freeText.setVisible(true);
            notification.setVisible(false);
            menuLeft.setVisible(false);
            menuRight.setVisible(false);
        });     
        
        //Airspeed indicator--------------------------------------------------------------------------------------------------------------------------------------
        Label[] speedValues = new Label[5];
        //speedValues[0].setText(String.valueOf(260));     
        //speedValues[0].setText("260");
        //Integer q = 260;
        //speedValues[0].setText(q.toString());
        
        Label valueS1 = new Label("260");
        Format("D",valueS1);
        Label valueS2 = new Label("250");
        Format("D",valueS2);
        Label valueS3 = new Label("240");
        Format("D",valueS3);
        Label valueS4 = new Label("230");
        Format("D",valueS4);
        Label valueS5 = new Label("220");
        Format("D",valueS5);
        Label valueS6 = new Label("210");
        Format("D",valueS6);

        Button btnUpAirspeed = new Button("▲");
        btnUpAirspeed.setPrefSize(130,40);
        btnUpAirspeed.setOnAction((ActionEvent event) -> {
//            TimeUnit.SECONDS.sleep(1);
            if(valueS1.getLayoutY()>205){
                valueS1.setLayoutY(valueS1.getLayoutY()-10);
                valueS2.setLayoutY(valueS2.getLayoutY()-10);
                valueS3.setLayoutY(valueS3.getLayoutY()-10);
                valueS4.setLayoutY(valueS4.getLayoutY()-10);
                valueS5.setLayoutY(valueS5.getLayoutY()-10);
                valueS6.setLayoutY(valueS6.getLayoutY()-10);
                if(valueS1.getLayoutY()==205){subtractValue(valueS1, valueS6, 0, 10);}
                if(valueS2.getLayoutY()==205){subtractValue(valueS2, valueS1, 0, 10);}
                if(valueS3.getLayoutY()==205){subtractValue(valueS3, valueS2, 0, 10);}
                if(valueS4.getLayoutY()==205){subtractValue(valueS4, valueS3, 0, 10);}
                if(valueS5.getLayoutY()==205){subtractValue(valueS5, valueS4, 0, 10);}
                if(valueS6.getLayoutY()==205){subtractValue(valueS6, valueS1, 0, 10);}
                
            }
        });
         
        Button btnDownAirspeed = new Button("▼");
        btnDownAirspeed.setPrefSize(130,40);
        btnDownAirspeed.setOnAction((ActionEvent event) -> {
            if(valueS1.getLayoutY()<565){
                valueS1.setLayoutY(valueS1.getLayoutY()+10);
                valueS2.setLayoutY(valueS2.getLayoutY()+10);
                valueS3.setLayoutY(valueS3.getLayoutY()+10);
                valueS4.setLayoutY(valueS4.getLayoutY()+10);
                valueS5.setLayoutY(valueS5.getLayoutY()+10);
                valueS6.setLayoutY(valueS6.getLayoutY()+10);
                if(valueS1.getLayoutY()==565){sumValue(valueS1, valueS6, 0, 10);}
                if(valueS2.getLayoutY()==565){sumValue(valueS2, valueS1, 0, 10);}
                if(valueS3.getLayoutY()==565){sumValue(valueS3, valueS2, 0, 10);}
                if(valueS4.getLayoutY()==565){sumValue(valueS4, valueS3, 0, 10);}
                if(valueS5.getLayoutY()==565){sumValue(valueS5, valueS4, 0, 10);}
                if(valueS6.getLayoutY()==565){sumValue(valueS6, valueS5, 0, 10);}
            }
        });
        
//        int k = 3;
//        int i = Integer.parseInt(valueS3.getText());
//        while(i!=Integer.parseInt(targetSpeed.getText())){  
//            for (int j = 0; j < 6; i++){
//                if(i>Integer.parseInt(targetSpeed.getText())){
//                    if(valueS1.getLayoutY()>205){
//                        valueS1.setLayoutY(valueS1.getLayoutY()-10);
//                        valueS2.setLayoutY(valueS2.getLayoutY()-10);
//                        valueS3.setLayoutY(valueS3.getLayoutY()-10);
//                        valueS4.setLayoutY(valueS4.getLayoutY()-10);
//                        valueS5.setLayoutY(valueS5.getLayoutY()-10);
//                        valueS6.setLayoutY(valueS6.getLayoutY()-10);
//                        if(valueS1.getLayoutY()==205){subtractValue(valueS1, valueS6, 0, 10);}
//                        if(valueS2.getLayoutY()==205){subtractValue(valueS2, valueS1, 0, 10);}
//                        if(valueS3.getLayoutY()==205){subtractValue(valueS3, valueS2, 0, 10);}
//                        if(valueS4.getLayoutY()==205){subtractValue(valueS4, valueS3, 0, 10);}
//                        if(valueS5.getLayoutY()==205){subtractValue(valueS5, valueS4, 0, 10);}
//                        if(valueS6.getLayoutY()==205){subtractValue(valueS6, valueS1, 0, 10);}
//                }
//                if(i<Integer.parseInt(targetSpeed.getText())){
//                    if(value1.getLayoutY()>205){
//                        valueS1.setLayoutY(valueS1.getLayoutY()+10);
//                        valueS2.setLayoutY(valueS2.getLayoutY()+10);
//                        valueS3.setLayoutY(valueS3.getLayoutY()+10);
//                        valueS4.setLayoutY(valueS4.getLayoutY()+10);
//                        valueS5.setLayoutY(value5S.getLayoutY()+10);
//                        valueS6.setLayoutY(valueS6.getLayoutY()+10);
//                        if(valueS1.getLayoutY()==565){sumValue(valueS1, valueS6, 0, 10);}
//                        if(valueS2.getLayoutY()==565){sumValue(valueS2, valueS1, 0, 10);}
//                        if(valueS3.getLayoutY()==565){sumValue(valueS3, valueS2, 0, 10);}
//                        if(valueS4.getLayoutY()==565){sumValue(valueS4, valueS3, 0, 10);}
//                        if(valueS5.getLayoutY()==565){sumValue(valueS5, valueS4, 0, 10);}
//                        if(valueS6.getLayoutY()==565){sumValue(valueS6, valueS5, 0, 10);}
//                }                  
//                try {Thread.sleep(1000);} catch (InterruptedException ex) {
//                    Logger.getLogger(RemotePilotInterfaz.class.getName()).log(Level.SEVERE, null, ex);
//                }
//                j++;
//            }
//            if(k == 6){k = 1;}
//            else{k = k + 1;}
//            concatenate(k);  
//        }
        //Altitud indicator--------------------------------------------------------------------------------------------------------------------------------------
        Label valueA1 = new Label("3000");
        Format("D",valueA1);
        //Label valueA2 = new Label("2500");
        //Format("D",valueA2);
        Label valueA3 = new Label("2500");
        Format("D",valueA3);
        //Label valueA4 = new Label("230");
        //Format("D",valueA4);
        Label valueA5 = new Label("2000");
        Format("D",valueA5);
        //Label valueA6 = new Label("210");
        //Format("D",valueA6);

        Button btnUpAltitude = new Button("▲");
        btnUpAltitude.setPrefSize(130,40);
        btnUpAltitude.setOnAction((ActionEvent event) -> {
//            TimeUnit.SECONDS.sleep(1);
            if(valueA1.getLayoutY()>205){
                valueA1.setLayoutY(valueA1.getLayoutY()-10);
                //valueA2.setLayoutY(valueA2.getLayoutY()-10);
                valueA3.setLayoutY(valueA3.getLayoutY()-10);
                //valueA4.setLayoutY(valueA4.getLayoutY()-10);
                valueA5.setLayoutY(valueA5.getLayoutY()-10);
                //valueA6.setLayoutY(valueA6.getLayoutY()-10);
                if(valueA1.getLayoutY()==205){subtractValue(valueA1, valueA5, 0, 500);}
                //if(valueA2.getLayoutY()==205){subtractValue(valueA2, valueA1, 0, 500);}
                if(valueA3.getLayoutY()==205){subtractValue(valueA3, valueA1, 0, 500);}
                //if(valueA4.getLayoutY()==205){subtractValue(valueA4, valueA3, 0, 500);}
                if(valueA5.getLayoutY()==205){subtractValue(valueA5, valueA3, 0, 500);}
                //if(valueA6.getLayoutY()==205){subtractValue(valueA6, valueA1, 0);}
                
            }
        });
         
        Button btnDownAltitude = new Button("▼");
        btnDownAltitude.setPrefSize(130,40);
        btnDownAltitude.setOnAction((ActionEvent event) -> {
            if(valueA1.getLayoutY()<565){
                valueA1.setLayoutY(valueA1.getLayoutY()+10);
                //valueA2.setLayoutY(valueA2.getLayoutY()+10);
                valueA3.setLayoutY(valueA3.getLayoutY()+10);
                //valueA4.setLayoutY(valueA4.getLayoutY()+10);
                valueA5.setLayoutY(valueA5.getLayoutY()+10);
                //valueA6.setLayoutY(valueA6.getLayoutY()+10);
                if(valueA1.getLayoutY()==565){sumValue(valueA1, valueA5, 0, 500);}
                //if(valueA2.getLayoutY()==565){sumValue(valueA2, valueA1, 0, 500);}
                if(valueA3.getLayoutY()==565){sumValue(valueA3, valueA1, 0, 500);}
                //if(valueA4.getLayoutY()==565){sumValue(valueA4, valueA3, 0, 500);}
                if(valueA5.getLayoutY()==565){sumValue(valueA5, valueA3, 0, 500);}
                //if(valueA6.getLayoutY()==565){sumValue(valueA6, valueA5, 0, 500);}
            }
        });
        //ImageViews--------------------------------------------------------------------------------------------------------------------------------------
        ImageView compass = new ImageView();
        compass.setImage(bgCompass);
        compass.setFitHeight(650);
        compass.setFitWidth(650);
        
        ImageView airplane = new ImageView();
        airplane.setImage(bgAirplane);
        airplane.setFitHeight(50);
        airplane.setFitWidth(50);
        compass.setRotate(20);
        airplane.addEventHandler(MouseEvent.MOUSE_CLICKED, (MouseEvent event) -> {
            compass.setRotate(compass.getRotate() + 10);
            event.consume();
        });
                                
        //Local layout--------------------------------------------------------------------------------------------------------------------------------------
        Pane root = new Pane(airSpeed, altimeter, showData, fms, compass, airplane, speedVbox, AltitudeVbox, valueS1, valueS2, valueS3, 
             valueS4, valueS5, valueS6, btnUpAirspeed, btnDownAirspeed, valueA1, valueA3, valueA5, btnUpAltitude, 
             btnDownAltitude, infoHBeacons, infoHBox, notification, freeText, menuFMS);
        root.setStyle("-fx-background-color: black;");
        root.setPrefSize(1000, 800);
        
        //Coordinates setting--------------------------------------------------------------------------------------------------------------------------------------
        compass.setLayoutX(180);
        compass.setLayoutY(0);
        
        airplane.setLayoutX(480);
        airplane.setLayoutY(300);
        
        speedVbox.setLayoutX(20);
        speedVbox.setLayoutY(10); 
        airSpeed.setLayoutX(20);
        airSpeed.setLayoutY(210);
        valueS1.setLayoutX(40);
        valueS1.setLayoutY(215);
        valueS2.setLayoutX(40);
        valueS2.setLayoutY(275);
        valueS3.setLayoutX(40);
        valueS3.setLayoutY(335);         
        valueS4.setLayoutX(40);
        valueS4.setLayoutY(395);
        valueS5.setLayoutX(40);
        valueS5.setLayoutY(455);
        valueS6.setLayoutX(40);
        valueS6.setLayoutY(515);
        btnUpAirspeed.setLayoutX(20);
        btnUpAirspeed.setLayoutY(210); 
        btnDownAirspeed.setLayoutX(20);
        btnDownAirspeed.setLayoutY(570); 
        
        AltitudeVbox.setLayoutX(800);
        AltitudeVbox.setLayoutY(10);
        altimeter.setLayoutX(850);
        altimeter.setLayoutY(210);
        valueA1.setLayoutX(890);
        valueA1.setLayoutY(215);
        //valueA2.setLayoutX(140);
        //valueA2.setLayoutY(275);
        valueA3.setLayoutX(890);
        valueA3.setLayoutY(335);         
        //valueA4.setLayoutX(140);
        //valueA4.setLayoutY(395);
        valueA5.setLayoutX(890);
        valueA5.setLayoutY(455);
        //valueA6.setLayoutX(140);
        //valueA6.setLayoutY(515);
        btnUpAltitude.setLayoutX(850);
        btnUpAltitude.setLayoutY(210); 
        btnDownAltitude.setLayoutX(850);
        btnDownAltitude.setLayoutY(570);
        
        showData.setLayoutX(20);
        showData.setLayoutY(645);
        infoHBeacons.setLayoutX(25);
        infoHBeacons.setLayoutY(655);
        infoHBox.setLayoutX(25);
        infoHBox.setLayoutY(655);
        
        fms.setLayoutX(520);
        fms.setLayoutY(645);
        menuFMS.setLayoutX(530);
        menuFMS.setLayoutY(651);
        freeText.setLayoutX(570);
        freeText.setLayoutY(650);
        notification.setLayoutX(570);
        notification.setLayoutY(650);   
        
        return root;
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }
    
}
