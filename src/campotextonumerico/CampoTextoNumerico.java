/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package campotextonumerico;

import javafx.scene.control.Label;
import javafx.scene.control.TextField;


/**
 *
 * @author Angel Medina Cantos
 */

public class CampoTextoNumerico extends TextField
{
    final static Label label = new Label();
    
    public CampoTextoNumerico()
    {
        final TextField sum = new TextField() 
        {

            @Override
            public void replaceText(int start, int end, String text) 
            {
                if (!text.matches("[a-z, A-Z]")) 
                {
                    super.replaceText(start, end, text);   
                }
                label.setText("Enter a numeric value");
            }

            @Override
            public void replaceSelection(String text) 
            {
                if (!text.matches("[a-z, A-Z]")) 
                {
                    super.replaceSelection(text);
                }
            }
        };

     
    }    
}
