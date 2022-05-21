import java.awt.Color;
import java.awt.Dimension;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import java.awt.event.*;

//step 0 inheriet from JPanel (or sometimes another component)
public class FahrenheitPanel extends JPanel{
    //step 1 Determine needed GUI components
    private JLabel inputLabel, outputLabel, resultLabel;
    private JTextField fahrenheit;

    public FahrenheitPanel(){
        //step 2 instantiate components
        inputLabel = new JLabel("Enter Fahrenheit Tempertaure: " );
        outputLabel = new JLabel("Temperature in Celsius: ");
        resultLabel = new JLabel("-----");

        fahrenheit = new JTextField(5);
        // step 3 add any needed listeners
        fahrenheit.addActionListener(new TempListener());

        //4 add the components to ourselves (our custome JPanel, see step 0)
        add(inputLabel);
        add(fahrenheit);
        add(outputLabel);
        add(resultLabel);

        //step 5 set color, sizes, other attributes of this object (JPanel)
        setPreferredSize(new Dimension(300, 75));
        setBackground(Color.yellow);

    }
    //step 6 create the listener amd implement its methods
    private class TempListener implements ActionListener{

        @Override
        public void actionPerformed(ActionEvent e) {
            int fahrenheitTemp, celsiusTemp;

            //Interact with Jtextfield
            //were gettomg tje text that was typed onto it
            String text = fahrenheit.getText();

            //since its text, and not an int we have to convert
            fahrenheitTemp = Integer.parseInt(text);
            celsiusTemp = (fahrenheitTemp-32) * 5/9;

            //set the text of the resultlabel
            //but celciustemp is an int, we need a string
            //user integer tostring (or other .tostring method)
            resultLabel.setText(Integer.toString(celsiusTemp));
            
        }

        
    }


    
}
