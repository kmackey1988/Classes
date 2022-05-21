import javax.swing.JFrame;

class GraphicalInterface {
 
    public static void main(String[] args) {
        
        JFrame window = new JFrame("Push Counter");
        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        
        Practive panel = new Practive();
        window.getContentPane().add(panel);
        

        window.pack();
        window.setVisible(true);


    }
    
}