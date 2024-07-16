package fr.afpa;



import javafx.application.Application;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.CheckBox;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.control.Slider;
import javafx.scene.control.TextField;
import javafx.scene.control.TitledPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.stage.Stage;

/**
 * JavaFX App
 */
public class App extends Application {
    public static void main(String[] args) {
        launch();
    };

    @Override
    public void start(Stage stage) {

        TextField textInput = new TextField();
        TextField textOutpout = new TextField();
        VBox vboxTextField = new VBox(textInput, textOutpout);

        Label settingLabel = new Label("Setting");
        CheckBox backgroundCheckBox = new CheckBox("Background");
        CheckBox characterCheckBox = new CheckBox("Character");
        CheckBox caseCheckBox = new CheckBox("Case");
        VBox settingVbox = new VBox(settingLabel, backgroundCheckBox, characterCheckBox,caseCheckBox);

        Label backgroundLabel = new Label("Bottom");
        RadioButton redRadioButton = new RadioButton("Red");
        RadioButton greenRadioButton = new RadioButton("Green");
        RadioButton blueRadioButton = new RadioButton("Blue");
        VBox bottomVBox = new VBox(backgroundLabel, redRadioButton, greenRadioButton, blueRadioButton);

        Label characterLabel = new Label("Character");
        Label redLabel = new Label("Red");
        Slider redSlider = new Slider(0, 255, 0);
        Label greenLabel = new Label("Green");
        Slider greenSlider = new Slider(0, 255, 0);
        Label blueLabel = new Label("Blue");
        Slider blueSlider = new Slider(0, 255, 0);

        VBox characterVBox = new VBox(characterLabel, redLabel, redSlider, greenLabel, greenSlider, blueLabel,
                blueSlider);

        RadioButton radioButtonUpperCase = new RadioButton("Majuscule");
        RadioButton radioButtonLowerCase = new RadioButton("Minuscule");
        VBox CharactereCaseRadioButton = new VBox(radioButtonUpperCase, radioButtonLowerCase);

    //   settingVbox.setAlignment(Pos.TOP_RIGHT);
    //   settingVbox.setStyle();
            // @Override
       

        redRadioButton.setOnAction(event->{
            textOutpout.setText(textInput.getText());
            textOutpout.setStyle("-fx-background-color: red;");
        });

        greenRadioButton.setOnAction(event->{
            textOutpout.setText(textInput.getText());
            textOutpout.setStyle("-fx-background-color: green;");
        });

        blueRadioButton.setOnAction(event->{
            textOutpout.setText(textInput.getText());
            textOutpout.setStyle("-fx-background-color: blue;");
        });

        redSlider.valueProperty().addListener(new ChangeListener<Number>() {
            public void changed(ObservableValue <?extends Number>observable, Number oldValue, Number newValue){
                textOutpout.setText(textInput.getText());
               
              
                
                int red =  redSlider.valueProperty().intValue(); 
                int green =  greenSlider.valueProperty().intValue();
                int blue = blueSlider.valueProperty().intValue();
                
                String hexa = ColorHelper.hexaColor(red,green,blue);
                textOutpout.setText(textInput.getText());

                

                textOutpout.setStyle("-fx-text-fill:" + hexa +";");
            } 
        });

        VBox displayBox = new VBox(settingVbox, vboxTextField, bottomVBox, characterVBox, CharactereCaseRadioButton);
        var scene = new Scene((displayBox), 640, 480);
        stage.setScene(scene);
        stage.show();
    }

}