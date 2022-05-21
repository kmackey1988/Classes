import java.awt.Color;
import java.awt.Dimension;
import java.awt.event.*;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class PushCounterPanel extends JPanel {

    private int count;
    private JButton push;
    private JLabel label;

    public PushCounterPanel(){
        count = 0;

        push = new JButton("Click Me!");
        push.addActionListener(new ButtonListener());
        label = new JLabel("Clicks: "+ count);

        add(push);
        add(label);

        setBackground(Color.cyan);
        setPreferredSize(new Dimension (300, 400));



    }

    private class ButtonListener implements ActionListener{

        @Override
        public void actionPerformed(ActionEvent e) {
            // TODO Auto-generated method stub
            count++; //add one to the click counter
            label.setText("click: " + count);
        }

    }

}
