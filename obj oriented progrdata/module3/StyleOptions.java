import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.*;

import javax.swing.JCheckBox;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class StyleOptions extends JPanel {
    private JLabel saying;
    private JCheckBox bold, italic;

    public StyleOptions(){
        saying = new JLabel("The best revenge is not to be like your enemy");
        saying.setFont(new Font("Helvetica", Font.PLAIN, 32));

        bold = new JCheckBox("bold");
        bold.setBackground(Color.cyan);

        italic = new JCheckBox("Italic");
        italic.setBackground(Color.cyan);

        StyleListener l = new StyleListener();
        bold.addItemListener(l);
        italic.addItemListener(l);

        add(saying);
        add(bold);
        add(italic);

        setBackground(Color.cyan);
        setPreferredSize(new Dimension (350, 100));

                
            } 

            private class StyleListener implements ItemListener {

                @Override
                public void itemStateChanged(ItemEvent e) {
                    // TODO Auto-generated method stub
                    int style = Font.PLAIN; //font.plain = 0
        
                if (bold.isSelected() ){
                    style = Font.BOLD; // font.bold = 1
                } // no else because they both can be selected 
                if (italic.isSelected()){
                    style += Font.ITALIC; //font.italic = 2
                }
        
                saying.setFont(new Font("Helvetica", style, 32));
            }
        }


    }

    
