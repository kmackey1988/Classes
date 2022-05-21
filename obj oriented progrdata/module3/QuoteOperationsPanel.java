import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.*;

import javax.swing.ButtonGroup;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;

public class QuoteOperationsPanel extends JPanel {
    //gui compoents widgets
    private JLabel quote;
    private JRadioButton comedy, philosophy, carpentry;
    private String comedyQuote, philosophyQuote, carpentryQuote;

    // contructor: set up the panel 
    public QuoteOperationsPanel(){
        comedyQuote = "Take my wife... Please";
        philosophyQuote = "I think therefor I think am";
        carpentryQuote = "Measure thrice, cut once";

        quote = new JLabel(comedyQuote);
        quote.setFont(new Font("Helvetica", Font.BOLD, 24));
        comedy = new JRadioButton("Comedy", true);
        comedy.setBackground(Color.green);
        philosophy = new JRadioButton("philosophy");
        philosophy.setBackground(Color.green);
        carpentry = new JRadioButton("Carpentry");
        carpentry.setBackground(Color.green);

        ButtonGroup group = new ButtonGroup();
        group.add(comedy);
        group.add(philosophy);
        group.add(carpentry);

        //listener code goes here
        QuoteListener ql = new QuoteListener();
        comedy.addActionListener(ql); 
        philosophy.addActionListener(ql);
        carpentry.addActionListener(ql);


        add(quote);
        add(comedy);
        add(philosophy);
        add(carpentry);

        setBackground(Color.green);
        setPreferredSize(new Dimension(300, 100));

    }

    private class QuoteListener implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            Object source = e.getSource();

            if (source == comedy){
                quote.setText(comedyQuote);
            }else if (source == philosophy){
                quote.setText(philosophyQuote);
            }else{
                quote.setText(carpentryQuote);
            } 
        }

    }
    
}
