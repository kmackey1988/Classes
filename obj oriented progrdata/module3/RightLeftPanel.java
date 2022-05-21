import java.awt.Color;
import java.awt.Dimension;
import java.awt.event.*;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class RightLeftPanel extends JPanel {

    private JButton right, left;
    private JLabel label;
    private JPanel buttonPanel;

    public RightLeftPanel(){
        

        right = new JButton("Right");
        left = new JButton("left");
        ButtonListener l = new ButtonListener();
        right.addActionListener(l);
        left.addActionListener(l);
        label = new JLabel("Push a button");

        buttonPanel = new JPanel();
        buttonPanel.setPreferredSize(new Dimension (200, 40));
        buttonPanel.setBackground(Color.blue);
        buttonPanel.add(left);
        buttonPanel.add(right);



   

        setBackground(Color.cyan);
        setPreferredSize(new Dimension (200, 80));
        add(label);
        add(buttonPanel);



    }

    private class ButtonListener implements ActionListener{

        @Override
        public void actionPerformed(ActionEvent e) {
            if (e.getSource() == left){
                label.setText("Left");
            }else{
                label.setText("Right");

            }
            
        }

    }

}
