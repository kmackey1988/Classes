import java.awt.Color;
import java.awt.Dimension;
import java.awt.event.*;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextField;

public class Practive extends JPanel {
    //step 1 Determine needed GUI components
    private JLabel inputLabel, celFah, foutputLabel, coutputLabel, koutputLabel, fresultLabel, cresultLabel, kresultLabel;
    private JRadioButton celcius, fahrenheit;
    private JTextField temp;
    private JButton enter;
    
    
    

    //step 2 instantiate components
    public Practive() {
        inputLabel = new JLabel("Enter a number Tempertaure: " );
        foutputLabel = new JLabel("Fahrenheit Tempertaure is: " );
        fresultLabel = new JLabel("-----" );
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

        ButtonGroup group = new ButtonGroup();
        group.add(celcius);
        group.add(fahrenheit);

        enter = new JButton("Convert");

        //listener code goes here
        TemperatureListener l = new TemperatureListener();
        temp.addActionListener(l);
        enter.addActionListener(l);
        fahrenheit.addActionListener(l);
        celcius.addActionListener(l);
        



        //4 add the components to ourselves (our custome JPanel, see step 0)
        add(inputLabel);
        add(temp);
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
        setPreferredSize(new Dimension(400, 400));
        setBackground(Color.blue);

    }

    private class TemperatureListener implements ActionListener{

        @Override
        public void actionPerformed(ActionEvent e) {
            Object source = e.getSource();
            Double fahrenheitTemp, celsiusTemp, kelvinTemp;
            String text = temp.getText();

            if (source == fahrenheit){
                fahrenheitTemp = Double.parseDouble(text);
                celsiusTemp = (Double.parseDouble(text)-32) * 5/9;
                kelvinTemp = (Double.parseDouble(text)-32) + 273 * 5/9;
                foutputLabel.setText(Double.toString(fahrenheitTemp));
                coutputLabel.setText(Double.toString(celsiusTemp));
                koutputLabel.setText(Double.toString(kelvinTemp));

                

            }else if (source == celcius){
                celsiusTemp = Double.parseDouble(text);
                fahrenheitTemp = Double.parseDouble(text) * 5/9 + 32;
                kelvinTemp = Double.parseDouble(text) + 273;
                fresultLabel.setText(Double.toString(fahrenheitTemp));
                cresultLabel.setText(Double.toString(celsiusTemp));
                kresultLabel.setText(Double.toString(kelvinTemp));
                


            }
            
        }

    }



    
}
