/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package miscontroles;

import javafx.beans.property.ObjectProperty;
import javafx.beans.property.SimpleObjectProperty;
import javafx.event.EventHandler;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Region;

/**
 *
 * @author Angel 
 */
public class MiControl extends Region
{
    private ObjectProperty<EventHandler<MouseEvent>> propertyOnAction = new SimpleObjectProperty<EventHandler<MouseEvent>>();
    
    public MiControl()
    {
        super();
        // Marca la zona donde hacer click
        setStyle("-fx-border-color:red;");
        setPrefSize(100, 100);
        this.setOnMouseClicked(new EventHandler<MouseEvent>()
        {
            @Override
            public void handle(MouseEvent event) 
            {
                onActionProperty().get().handle(event);
            }
        });
    }
    
    // En este caso se utiliza MouseEvent solo porque llama desde onMouseClicked, se puede sustituir por cualquier tipo que se necesite
   
    
    public final ObjectProperty<EventHandler<MouseEvent>> onActionProperty() 
    {
        return propertyOnAction;
    }
    
    public final void setOnAction(EventHandler<MouseEvent> handler) 
    {
        propertyOnAction.set(handler);
    }
    
    public final EventHandler<MouseEvent> getOnAction() 
    {
        return propertyOnAction.get();
    }
    
    
    
    
    
    
    
    
}    
