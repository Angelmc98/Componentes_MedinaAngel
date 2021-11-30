/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package temporizador;

import java.io.IOException;
import javafx.animation.KeyFrame;
import javafx.animation.KeyValue;
import javafx.animation.Timeline;
import javafx.beans.property.IntegerProperty;
import javafx.beans.property.ObjectProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleObjectProperty;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.Label;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.HBox;
import javafx.util.Duration;

/**
 * FXML Controller class
 *
 * @author Angel
 */
public class Temporizador extends HBox 
{
    @FXML
    private Label lbtiempo;
    private ObjectProperty<EventHandler<ActionEvent>> propertyOnAction = new SimpleObjectProperty<EventHandler<ActionEvent>>();
   
    
    public Temporizador()
    {
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("Temporizador.fxml"));
        fxmlLoader.setRoot(this);
        fxmlLoader.setController(this);

        try 
        {
            fxmlLoader.load();
        } catch (IOException exception) 
        {
            throw new RuntimeException(exception);
        }
        
        //Creamos el timeline
        final Timeline timeline = new Timeline();
        IntegerProperty tiempo = new SimpleIntegerProperty(10);
        EventHandler onFinished = new EventHandler<ActionEvent>(){
            @Override
            public void handle(ActionEvent event) {
                onActionProperty().get().handle(event);
                System.out.println("FIN");
                
            }   
        };
        KeyValue kv = new KeyValue(tiempo, 0);
        KeyFrame kf = new KeyFrame(Duration.millis(10000),onFinished, kv);
        timeline.getKeyFrames().add(kf);
        timeline.play();
        
        lbtiempo.textProperty().bind(tiempo.asString());         
        
    }
    
    public final ObjectProperty<EventHandler<ActionEvent>> onActionProperty() 
    {
        return propertyOnAction;
    }
    
    public final void setOnAction(EventHandler<ActionEvent> handler) 
    {
        propertyOnAction.set(handler);
    }
    
    public final EventHandler<ActionEvent> getOnAction() 
    {
        return propertyOnAction.get();
    }
    
}

