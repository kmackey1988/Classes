//kimberly mackey
//cit 272

/*
-A text field for entering a temperature to convert

-Two radio buttons that allow you to select which unit you are converting FROM (F or C)

-A Button that activates the conversion

-Three labels: Fahrenheit, Celsius and Kelvin

-Three labels that will display the equivalent temperatures in all three units.

*/



import java.io.*;
import java.security.acl.Group;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.event.*;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextField;

public class TempConverter extends JPanel {
    //step 1 Determine needed GUI components
    private JLabel inputLabel, celFah, foutputLabel, coutputLabel, koutputLabel, fresultLabel, cresultLabel, kresultLabel;
    private JRadioButton celcius, fahrenheit;
    private JTextField temp;
    private JButton enter;
    
    
    

    //step 2 instantiate components
    public TempConverter() {
        inputLabel = new JLabel("Enter a number Tempertaure: " );
        foutputLabel = new JLabel("Fahrenheit Tempertaure is: " );
        fresultLabel = new JLabel("-----");
        coutputLabel = new JLabel("Celsius tempertaure is: ");
        cresultLabel = new JLabel("---- ");
        koutputLabel = new JLabel("Kelvin Tempertaure is ");
        kresultLabel = new JLabel("---- ");

        temp = new JTextField(5);

        celFah = new JLabel("Celcius or Fahrenheit?");

        fahrenheit = new JRadioButton("fahrenheit", true);
        fahrenheit.setBackground(Color.blue);
        celcius = new JRadioButton("Celcius");
        celcius.setBackground(Color.blue);

        ButtonGroup radiogroup = new ButtonGroup();
        radiogroup.add(celcius);
        radiogroup.add(fahrenheit);

        enter = new JButton("Convert");

        //listener code goes here
        TemperatureListener l = new TemperatureListener();
        temp.addActionListener(l);
        enter.addActionListener(l);
        fahrenheit.addActionListener(l);
        celcius.addActionListener(l);
        



        //4 add the components to ourselves (our custome JPanel, see step 0)
        add(temp);
        add(inputLabel);
        add(celFah);
        add(celcius);
        add(fahrenheit);
        add(enter);
        add(foutputLabel);
        add(fresultLabel);
        add(coutputLabel);
        add(cresultLabel);
        add(koutputLabel);
        add(kresultLabel);
        

        //step 5 set color, sizes, other attributes of this object (JPanel)
        setPreferredSize(new Dimension(400, 200));
        setBackground(Color.blue);

    }
    //create event action listener
    private class TemperatureListener implements ActionListener{

        @Override
        public void actionPerformed(ActionEvent e) {
            Object source = e.getSource();
            double fahrenheitTemp, celsiusTemp, kelvinTemp;
            fahrenheitTemp = celsiusTemp = kelvinTemp = 0.0;

            

            //operation to perform when confirm is pressed
            if (source == enter){
                
                //checks radio button status and updates temperature calculations
                if (fahrenheit.isSelected())
                {   //get text from temp and give it number format for F radio button 
                    fahrenheitTemp = Double.parseDouble(temp.getText());
                    celsiusTemp = FtoC(fahrenheitTemp);
                    kelvinTemp = FtoK(fahrenheitTemp);
                }else if(celcius.isSelected()){
                    //get text from temp and give it number format for F radio button
                    celsiusTemp = Double.parseDouble(temp.getText());
                    fahrenheitTemp = CtoF(celsiusTemp); 
                    kelvinTemp = CtoK(celsiusTemp);
                }

                //displays calculations on screen
                fresultLabel.setText(String.valueOf(fahrenheitTemp));
                cresultLabel.setText(String.valueOf(celsiusTemp));
                kresultLabel.setText(String.valueOf(kelvinTemp));


            }
            
        }
        //calculations for each object 
        public double FtoC(double input){
            double output = (input - 32) * 5/9;
            return output;
        }

        public double CtoF(double input){
            double output = (input * 9/5) - 32;
            return output;
        }

        public double FtoK(double input){
            double output = FtoC(input)+273.15;
            return output;
        }

        public double CtoK(double input){
            double output = input + 273.15;
            return output;
        }

    }



    
}
